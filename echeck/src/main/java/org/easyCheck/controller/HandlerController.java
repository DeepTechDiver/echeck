package org.easyCheck.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.easyCheck.Handler;
import org.easyCheck.HandlerRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 责任链测试接口
 */
@Slf4j
@RestController
@RequestMapping("/responsibility")
public class HandlerController {

    @Resource
    private Handler handler;
    @GetMapping("/test")
    public void handleRequest(){
        HandlerRequest request = new HandlerRequest(1);
        handler.handleRequest(request);
        log.info("success , count : "+request.getCount());
    }
}
