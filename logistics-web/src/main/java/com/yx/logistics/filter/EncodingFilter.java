package com.yx.logistics.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * author : Guo LiXiao
 * date : 2017-6-5  14:08
 */

public class EncodingFilter implements Filter {

    @Override
    public String getContextPath() {
        return "/";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
