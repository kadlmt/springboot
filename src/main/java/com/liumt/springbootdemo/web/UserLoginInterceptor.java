package com.liumt.springbootdemo.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/27 11:14
 * @description：自定义拦截器
 * @modified By：
 * @version: 1.1
 */
public class UserLoginInterceptor implements HandlerInterceptor {
    //请求处理前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Boolean result = Boolean.valueOf(httpServletRequest.getParameter("_login"));
        return result;
    }

    //视图渲染前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //请求完成后
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
