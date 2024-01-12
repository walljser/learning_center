package com.yg.learning.system.service.impl;

import com.yg.learning.system.model.pojo.Dictionary;
import com.yg.learning.system.mapper.DictionaryMapper;
import com.yg.learning.system.service.DictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author yg
 */
@Slf4j
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

}
