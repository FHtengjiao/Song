package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserFilter", urlPatterns = "/")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if ("/login.do".equals(request.getServletPath()) || "/loginPrompt".equals(request.getServletPath())) {
            chain.doFilter(request, response);
        } else if (null != request.getSession().getAttribute("username")) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/loginPrompt").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
