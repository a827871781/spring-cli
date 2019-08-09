package com.syz.cli.init.config;
 
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
/**
 * 日志拦截器
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(request);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}