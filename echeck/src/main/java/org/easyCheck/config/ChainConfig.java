package org.easyCheck.config;

import org.easyCheck.handlers.FirstHandler;
import org.easyCheck.Handler;
import org.easyCheck.handlers.SecondHandler;
import org.easyCheck.handlers.ThirdHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 责任链配置管理中心
 */
@Configuration
public class ChainConfig {

    @Bean
    public Handler chain() {
        FirstHandler firstHandler = new FirstHandler();
        SecondHandler secondHandler = new SecondHandler();
        ThirdHandler thirdHandler = new ThirdHandler();
        //这里填写顺序没有强制要求
        firstHandler.setNextHandler(secondHandler);
        secondHandler.setNextHandler(thirdHandler);

        return firstHandler;
    }
}
