package servlets;

import ejb.GetHits;
import ejb.DataServicesBean;
import ejb.ShoppingCartBean;
import entities.*;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import static entities.CategoryEnum.Fitness;

@WebServlet(name = "MyHelloServlet", urlPatterns = "/hello")
public class MyHelloServlet extends HttpServlet {
    @Inject
    DataServicesBean dataServicesBean;
    @Inject
    ShoppingCartBean shoppingCart;

    @Inject
    GetHits comment;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("message is sent");
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html><head><title>DA demo</title></head>\n<body>");
        writer.println("<h1>Hello</h1>");
        writer.println("<p>The result of 15 + 32 ="+ dataServicesBean.findUserById(1)+"</p>");
       // dataServicesBean.createProduct("Jsonproduct",123.45,"Trying Json product",5,Fitness,2);
        dataServicesBean.createUserByFields("Cemal","cemalyetismis@gmail.com","123456789","yetismis","kesseldallaan","Leuven",3010);

        //writer.println("<p>The result of 15 + 32 ="+ shoppingcart.addCart(dataServicesBean.findByProductId(1))+"</p>");
        //UserEntity user1=dataServices.findUserById(1);
        //ProductEntity product1=dataServices.findByProductId(1);
        // dataServicesBean.createComment(1,2,3,"anlamiyorum");
       // dataServices.createProduct("Bamboo Watch",237.67,"secondhand",12,Accessories,VERY_GOOD);

        request.getParameter("id");

        writer.println("<ul>");
        for (CommentEntity comment: dataServicesBean.findUserById(1).getComments()
        ) {
            writer.println("<li>"+comment.getComment()+"</li>");
        }
        for (CommentEntity comment: dataServicesBean.findByProductId(3).getComments()
        ) {
            writer.println("<li>"+comment.getComment()+"</li>");
        }
        for (ProductEntity product: shoppingCart.getShoppingCart()
        ) {
            writer.println("<li>"+product.getName()+"</li>");
        }


        writer.println("</ul>");
        writer.println("<body>\n</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
