package org.example.flow.example.handlers;

import org.check.ChannelHandler;
import org.check.ChannelHandlerContext;
import org.example.flow.example.ArticleTitleModifyCmd;
import org.example.flow.example.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于修改文章的正文
 */
public class ArticleModifyContentHandler implements ChannelHandler {

    private Logger logger = LoggerFactory.getLogger(ArticleModifyContentHandler.class);

    @Override
    public void channelProcess(ChannelHandlerContext ctx,
                               Object in,
                               Object out) throws Exception {

        logger.info("修改正文:进入修改正文的Handler");
        ArticleTitleModifyCmd cmd = (ArticleTitleModifyCmd) in;
        logger.info("修改正文,content={}", cmd.getContent());
        logger.info("修改正文:执行完成,即将进入下一个Handler");
        ctx.fireChannelProcess(in, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {

        logger.error("修改标题:异常处理逻辑");

        Result re = (Result) out;
        re.setCode(1502);
        re.setMsg("修改正文发生异常");
    }
}