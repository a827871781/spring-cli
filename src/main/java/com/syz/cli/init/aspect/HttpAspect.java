package com.syz.cli.init.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class HttpAspect {

    //这里就定义了一个总的匹配规则，以后拦截的时候直接拦截log()方法即可，无须去重复写execution表达式
    @Pointcut("execution(* com.syz.cli.controller.*.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore( JoinPoint  point) {
        Object[] args = point.getArgs();
        StringBuffer sb = new StringBuffer();
        for (Object arg : args) {
            sb.append(arg);
        }
        System.out.println("******拦截前的逻辑******");
        System.out.println(sb.toString());
    }

    @After("log()")
    public void doAfter() {
        System.out.println("******拦截后的逻辑******");
    }


}
