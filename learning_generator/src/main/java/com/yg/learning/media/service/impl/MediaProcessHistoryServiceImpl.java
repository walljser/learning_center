package com.yg.learning.media.service.impl;

import com.yg.learning.media.model.pojo.MediaProcessHistory;
import com.yg.learning.media.mapper.MediaProcessHistoryMapper;
import com.yg.learning.media.service.MediaProcessHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yg
 */
@Slf4j
@Service
public class MediaProcessHistoryServiceImpl extends ServiceImpl<MediaProcessHistoryMapper, MediaProcessHistory> implements MediaProcessHistoryService {

}
