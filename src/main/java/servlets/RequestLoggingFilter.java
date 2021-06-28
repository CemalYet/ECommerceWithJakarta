package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/index/RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {
    private ServletContext context;
    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req =(HttpServletRequest) request;
        Enumeration<String> params=req.getParameterNames();
        while (params.hasMoreElements()){
            String name = params.nextElement();
            String value = request.getParameter(name);
            //this.context.log(req.getRemoteAddr()+"::Request Params::{"+name+"="+value+"}");
            Cookie [] cookies =req.getCookies();
            if (cookies != null) {
                for (Cookie cookie:cookies
                     ) {
                   // this.context.log(req.getRemoteAddr()+"::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
                }
            }
        }
        chain.doFilter(request, response);
    }
    public void destroy() {
    }
}
