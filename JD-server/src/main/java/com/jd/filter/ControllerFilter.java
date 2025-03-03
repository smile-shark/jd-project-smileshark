package com.jd.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
@WebFilter("/*")
@Component
public class ControllerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURL().toString());
        filterChain.doFilter(request, servletResponse);
    }
}
