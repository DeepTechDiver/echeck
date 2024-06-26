package org.example.flow.example;


import org.check.OutboundFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 出参工厂
 */
public class ResultFactory implements OutboundFactory {

    private Logger logger = LoggerFactory.getLogger(ResultFactory.class);

    @Override
    public Object newInstance() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        return result;
    }
}