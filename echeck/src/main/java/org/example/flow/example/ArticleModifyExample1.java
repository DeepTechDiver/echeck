package org.example.flow.example;


import org.check.BootStrap;
import org.example.flow.example.handlers.ArticleModifyContentHandler;
import org.example.flow.example.handlers.ArticleModifyTitleHandler;
import org.example.flow.example.handlers.CheckParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleModifyExample1 {

    private final static Logger logger = LoggerFactory.getLogger(ArticleModifyExample1.class);

    public static void main(String[] args) {
        //入参
        ArticleTitleModifyCmd dto = new ArticleTitleModifyCmd();
        dto.setArticleId("articleId_001");
        dto.setTitle("articleId_001_title");
        dto.setContent("articleId_001_content");
        //创建引导类
        BootStrap bootStrap = new BootStrap();

        Result result = (Result) bootStrap
                .inboundParameter(dto)//入参
                .outboundFactory(new ResultFactory())//出参工厂
                .channel(new ArticleModifyChannel())//自定义channel
                .addChannelHandlerAtLast("checkParameter", new CheckParameterHandler())//第一个handler
                .addChannelHandlerAtLast("modifyTitle", new ArticleModifyTitleHandler())//第二个handler
                .addChannelHandlerAtLast("modifyContent", new ArticleModifyContentHandler())//第三个handler
                .process();//执行
        //result为执行结果
        logger.info("result:code={},msg={}", result.getCode(),result.getMsg());
    }
}