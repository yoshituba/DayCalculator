package daycalculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DateCalculateInterceptor implements HandlerInterceptor{
    private static final Logger logger = LoggerFactory.getLogger(DateCalculateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj){
        logger.info("---- controller ---");
        logger.info("URL: " + request.getRequestURL());
        System.out.println("hogehogehogehogehogehogehogehogehogehoge");
        return true;
    }
}
