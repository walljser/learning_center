package com.yg.learning.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yg.learning.system.model.pojo.Dictionary;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author yg
 * @since 2024-01-12
 */
public interface DictionaryService extends IService<Dictionary> {

    List<Dictionary> queryAll();
}
