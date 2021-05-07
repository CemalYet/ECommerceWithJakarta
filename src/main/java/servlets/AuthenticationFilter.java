package servlets;

import jakarta.faces.application.ResourceHandler;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(value ="/index/AuthenticationFilterFilter")
public class AuthenticationFilter implements Filter {
    private ServletContext context;
    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res =(HttpServletResponse)response;
        HttpSession session = req.getSession(false);
        String loginUri =req.getContextPath()+"/login.xhtml";
        String indexUri=req.getContextPath()+"/index.xhtml";

        this.context.log("Requested Resource::"+loginUri);
        boolean loggedIn = (session != null) && (session.getAttribute("user") != null);
        boolean indexRequest=req.getRequestURI().equals(indexUri);
        boolean loginRequest = req.getRequestURI().equals(loginUri);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(request, response);
        }else{
            this.context.log("Unauthorized access request");
            res.sendRedirect("login.xhtml");
        }

    }
    public void destroy() {
    }

}
