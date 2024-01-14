package com.yg.learning.media.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yg.learning.media.mapper.MediaFilesMapper;
import com.yg.learning.media.model.pojo.MediaFiles;
import com.yg.learning.media.service.MediaFilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 媒资信息 服务实现类
 * </p>
 *
 * @author yg
 */
@Slf4j
@Service
public class MediaFilesServiceImpl extends ServiceImpl<MediaFilesMapper, MediaFiles> implements MediaFilesService {

}
