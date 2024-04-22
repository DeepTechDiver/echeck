package org.example.flow.example.handlers;

import org.check.ChannelHandler;
import org.check.ChannelHandlerContext;
import org.example.flow.example.ArticleTitleModifyCmd;
import org.example.flow.example.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于修改文章的标题
 */
public class ArticleModifyTitleHandler implements ChannelHandler {

    private Logger logger = LoggerFactory.getLogger(ArticleModifyTitleHandler.class);

    @Override
    public void channelProcess(ChannelHandlerContext ctx,
                               Object in,
                               Object out) throws Exception {

        logger.info("修改标题:进入修改标题的Handler");

        ArticleTitleModifyCmd cmd = (ArticleTitleModifyCmd) in;

        String title = cmd.getTitle();
        //修改标题的业务逻辑
        logger.info("修改标题:title={}", title);

        logger.info("修改标题:执行完成,即将进入下一个Handler");
        ctx.fireChannelProcess(in, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {
        logger.error("修改标题:异常处理逻辑");
        Result re = (Result) out;
        re.setCode(1501);
        re.setMsg("修改标题发生异常");
    }
}
