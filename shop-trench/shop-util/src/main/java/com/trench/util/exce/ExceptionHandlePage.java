package com.trench.util.exce;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.trench.util.ResultData;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * sentinel全局异常处理
 *
 * */
@Component
public class ExceptionHandlePage implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        ResultData data=null;
        if (e instanceof FlowException) {
            data = new ResultData(-1, "The interface is restricted");
        }else if (e instanceof DegradeException){
            data = new ResultData(-2, "The interface has been downgraded");
        }else if (e instanceof ParamFlowException){
            data = new ResultData(-3, "Parameter current limit exception");
        }else if (e instanceof AuthorityException){
            data = new ResultData(-4, "Authorization exception");
        }else if (e instanceof SystemBlockException){
            data = new ResultData(-5, "The interface is SystemBlockException");
        }
        response.getWriter().write(JSON.toJSONString(data));
    }
}
