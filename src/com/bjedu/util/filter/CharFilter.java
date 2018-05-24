package com.bjedu.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {
	private String characterEncoding;
    private boolean enabled;
    public void destroy() {
        // TODO Auto-generated method stub
        characterEncoding = null;//销毁时清空资源
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        if(enabled || characterEncoding != null){//如果启用该Filter
            request.setCharacterEncoding("UTF-8");//设置reques编码
            response.setCharacterEncoding("UTF-8");//设置response编码
        }
        chain.doFilter(request,response );//doFilter,执行下一个Filter或者Servlet
    }

    public void init(FilterConfig config) throws ServletException {//初始化时加载参数
        // TODO Auto-generated method stub
        characterEncoding = config.getInitParameter(characterEncoding);//编码方式
        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled").trim());//启用
    }
}
