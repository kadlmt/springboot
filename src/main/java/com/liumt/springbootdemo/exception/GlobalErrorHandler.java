package com.liumt.springbootdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/27 11:45
 * @description：全局异常处理
 * @modified By：
 * @version: 1.1
 */
@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest request, Exception e){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setData("自定义全局异常处理");
        return errorInfo;
    }
}
