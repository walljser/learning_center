package com.yg.learning.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;

public class MediaCodeGenerator {
    private static final String SERVICE_NAME = "media";
    private static final String DATA_SOURCE_USER_NAME = "root";
        private static final String DATA_SOURCE_PASSWORD = "mysql";
//    private static final String DATA_SOURCE_PASSWORD = "walljs111";
    private static final String[] TABLE_NAMES = new String[]{
            "media_files",
            "media_process",
            "media_process_history",
    };
    // TODO 默认生成entity，需要生成DTO修改此变量
    // 一般情况下要先生成DTO类 然后修改次参数再生成 PO 类
    private static final Boolean IS_DTO = false;

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(true);
        gc.setOutputDir(System.getProperty("user.dir") + "/learning_generator/src/main/java");
        gc.setAuthor("yg");
        gc.setOpen(false);
        gc.setSwagger2(false);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);

        if (IS_DTO) {
            gc.setSwagger2(true);
            gc.setEntityName("%sDTO");
        }
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        System.out.println(SERVICE_NAME);
        dsc.setUrl("jdbc:mysql://192.168.101.65:3306/db_learning_" + SERVICE_NAME
//        dsc.setUrl("jdbc:mysql://localhost:3306/db_learning_" + SERVICE_NAME
                + "?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(DATA_SOURCE_USER_NAME);
        dsc.setPassword(DATA_SOURCE_PASSWORD);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(SERVICE_NAME);
        pc.setParent("com.yg.learning");

        pc.setServiceImpl("service.impl");
        pc.setXml("mapper");
        pc.setEntity("model.pojo");
        mpg.setPackageInfo(pc);

        TemplateConfig tc = new TemplateConfig();
        mpg.setTemplate(tc);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setInclude(TABLE_NAMES);
        strategyConfig.setControllerMappingHyphenStyle(true);
//        strategyConfig.setTablePrefix(pc.getModuleName() + "_");
        // Boolean类型字段是否移除is前缀处理
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);
        strategyConfig.setRestControllerStyle(true);

        strategyConfig.setTableFillList((Arrays.asList(
                new TableFill("create_date", FieldFill.INSERT),
                new TableFill("change_date", FieldFill.INSERT_UPDATE),
                new TableFill("modify_date", FieldFill.UPDATE)
        )));
        mpg.setStrategy(strategyConfig);

        mpg.execute();
    }
}
