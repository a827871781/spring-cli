package com.syz.cli.init.config;


import com.syz.cli.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

/**
 * 全局异常拦截类
 * @author syz
 * @date 2019/4/12 0012
 */

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    /**
     * 未被捕获的异常处理
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult<String > errorHandler(HttpServletRequest req, Exception e)  {
        log(e, req);
        return ResponseResult.error("服务不可用");
    }

    /**
     * BindException参数校验失败拦截
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class )
    @ResponseBody
    public ResponseResult<String > BindExceptionHandler(HttpServletRequest req, BindException e)  {
        String msg = msgConvertor(e);
        log(e, req);
        return ResponseResult.error(msg);
    }

    /**
     * ConstraintViolationException参数校验失败拦截
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =  ConstraintViolationException.class )
    @ResponseBody
    public ResponseResult<String > constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException e)  {

        String msg =msgConvertor( e.getConstraintViolations()) ;
        log(e, req);
        return ResponseResult.error(msg);
    }

    /**
     * 实体字段校验未通过
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult<String > methodArgumentNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e)  {
        String msg = msgConvertor(e.getBindingResult());
        log(e, req);
        return ResponseResult.error(msg);
    }

    /**
     * 获取校验message
     * @param bindingResult
     * @return
     */
    public  String msgConvertor(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        fieldErrors.get(0).getDefaultMessage();
        fieldErrors.forEach(fieldError -> sb.append(fieldError.getDefaultMessage()).append(","));
        return sb.deleteCharAt(sb.length() - 1).toString().toLowerCase() ;
    }

    /**
     * 实体校验msg
     * @param constraintViolations
     * @return
     */
    private String msgConvertor(Set<ConstraintViolation<?>> constraintViolations) {
        StringBuilder sb = new StringBuilder();
        constraintViolations.forEach(violation -> sb.append(violation.getMessage()).append(","));
        return sb.deleteCharAt(sb.length() - 1).toString().toLowerCase();
    }


    private void log(Exception ex, HttpServletRequest request) {
        log.error("{}:",ex.getClass().getName(),ex);
        log.error("请求地址：\t{}", request.getRequestURL());
        Enumeration enumeration = request.getParameterNames();

        List<String> list = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            list.add(name + "=" + request.getParameter(name)) ;
        }
        log.error("请求参数：\t{}",list);
    }


}