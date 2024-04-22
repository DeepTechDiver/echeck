package org.easyCheck;

/**责任链节点的接口
 */
public interface Handler  {
    /**
     * 节点处理请求接口
     * @param request
     */
    void handleRequest(HandlerRequest request);

    /**
     * 设置下一个节点处理者
     * @param nextHandler
     */
    void setNextHandler(Handler nextHandler);
}
