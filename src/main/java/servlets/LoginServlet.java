package servlets;

import ejb.MessageProducerBean;
import ejb.MySessionBean;
import entities.UserEntity;
import entities.UserNameEntity;
import jakarta.inject.Inject;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {



    @Inject
    MySessionBean loginEjb;
    @Inject
    MessageProducerBean messageProducer;
    private static final long serialVersionUID = 1L;

    private Optional<UserEntity> currentUser;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        UserNameEntity inputUser=loginEjb.findOnePersonByName(user);
        if (inputUser != null) {
            if(inputUser.getName().equals(user) && inputUser.getEmail().equals(pwd)){
                HttpSession session = request.getSession();
                session.setAttribute("user", loginEjb.findOnePersonByName(user).getName());
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("user", loginEjb.findOnePersonByName(user).getName());
                userName.setMaxAge(30*60);
                response.addCookie(userName);
                //message send to MDB
                try{
                    messageProducer.sendJMSMessageToOrderDest(user);
                } catch (Exception e) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE,null,e);
                }
                response.sendRedirect("LoginSuccess.jsp");
            }
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }


    }



}
