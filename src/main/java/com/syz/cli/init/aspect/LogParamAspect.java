package com.syz.cli.init.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

/**
 * AOP 参数打印
 * @author syz
 */
@Component
@Aspect
@Order(-1)
@Slf4j
public class LogParamAspect {

    /**
     * 定义一个切入点.
     * 解释下：
     * <p>
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在controller包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Pointcut(value = "execution(public * com.syz..*.controller..*.*(..))")
    public void webLog() {
    }
    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            HttpServletRequest request = attributes.getRequest();
            // 记录下请求内容
            String url = "";
            StringBuilder logStr = new StringBuilder();
            url = request.getRequestURL().toString();
            if ("get".equalsIgnoreCase(request.getMethod())) {
                url = url+ ((request.getQueryString() == null) ? "" : ("?" + request.getQueryString()));
            }
            // joinPoint获取参数值
            Object[] args = joinPoint.getArgs();
            // 打印请求参数
            Stream.of(args).forEach(logStr::append);
            log.info("Url -> {}", url);
            log.info("params -> {}",logStr.toString());
        } catch (Throwable e) {
            log.error("LogParamAspect error.", e);
        }

    }
}