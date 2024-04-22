package org.easyCheck;

/**
 * 请求参数实体
 */
public class HandlerRequest {
    private Integer count;

    public HandlerRequest(Integer count) {
        this.count = count;
    }

    public HandlerRequest() {
    }

    public Integer getCount() {
        return count;
    }

    public void setContent(Integer count) {
        this.count = count;
    }
}
