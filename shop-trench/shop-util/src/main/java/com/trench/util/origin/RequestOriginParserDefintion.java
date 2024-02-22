package com.trench.util.origin;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**授权规则*/
@Component
public class RequestOriginParserDefintion implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String type=httpServletRequest.getParameter("type");
        return type;
    }
}
