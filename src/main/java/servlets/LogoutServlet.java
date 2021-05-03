package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie:cookies
                 ) {
                if (cookie.getName().equals("JSESSIONID")){
                    System.out.println("JSESSIONID="+cookie.getValue());
                    break;
                }
            }

        }
        //invalidate the session if exists
        HttpSession session =request.getSession(false);
        System.out.println("User="+session.getAttribute("user"));
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.html");
    }
}
