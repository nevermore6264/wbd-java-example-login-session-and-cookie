package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        // tạo Session
        HttpSession session = request.getSession();
        if (username.equals("admin") && password.equals("admin")) {
            // key = username; value = admin
            session.setAttribute("username", "admin");
            // chuyen tiep sang trang index.jsp
            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            dis.forward(request, response);
        } else {
            // đăng nhập lỗi, gán chuỗi “username and password invalid vào error
            request.setAttribute("error", "Username and Password invalid !");
            // chuyen lai chinh trang login.jsp
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        }
        if (username.equals("admin") && password.equals("admin")) {

            // tao Cookie lay thong tin cua nguoi dung de nho lai
            Cookie user = new Cookie("user", "admin");
            Cookie pass = new Cookie("pass", "admin");
            if (request.getParameter("chkRemember") != null) {
                user.setMaxAge(60 * 60 * 24);
                pass.setMaxAge(60 * 60 * 24);
            } else {
                user.setMaxAge(0);
                pass.setMaxAge(0);
            }
            response.addCookie(user);
            response.addCookie(pass);

            // luu vao session
            session.setAttribute("username", "admin");

            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            dis.forward(request, response);
        } else {
            request.setAttribute("error", "Username and Password invalid !");
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        }
    }
}