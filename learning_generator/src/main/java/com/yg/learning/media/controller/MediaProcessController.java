package com.yg.learning.media.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yg.learning.media.service.MediaProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yg
 */
@Slf4j
@RestController
@RequestMapping("mediaProcess")
public class MediaProcessController {

    @Autowired
    private MediaProcessService  mediaProcessService;
}
