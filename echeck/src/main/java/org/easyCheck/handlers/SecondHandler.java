package org.easyCheck.handlers;

import lombok.extern.slf4j.Slf4j;
import org.easyCheck.Handler;
import org.easyCheck.HandlerRequest;

import java.util.Objects;

@Slf4j
public class SecondHandler implements Handler {
    private Handler handler;
    @Override
    public void handleRequest(HandlerRequest request) {
        //自身业务处理
        log.info("second handler");
        if (request.getCount() > 2) {
            request.setContent(request.getCount() + 1);
        }
        //判断是否有下一处理节点
        if (Objects.nonNull(handler)){
            log.info("next handler");
            handler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.handler = nextHandler;
    }
}
