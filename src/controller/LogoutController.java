package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("islogout") != null) {
            if (request.getParameter("islogout").equals("ok")) {
                // huy session
                request.removeAttribute("username");
                // chuyen sang sang login
                response.sendRedirect("login.jsp");
            }
        }
    }
}