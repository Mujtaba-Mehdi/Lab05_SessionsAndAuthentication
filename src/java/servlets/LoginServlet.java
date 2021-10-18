package servlets;

import models.User;
import services.AccountService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession http = request.getSession();
        
        if (request.getParameter("logout") != null) {
            http.invalidate();
            request.setAttribute("message", "You have logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } 
        else if (http.getAttribute("username") != null) {
            response.sendRedirect("home.jsp");
        } 
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession http = request.getSession();

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        request.setAttribute("username", name);
        request.setAttribute("password", pass);
           
        AccountService service = new AccountService();
        User user = service.login(name, pass);
      
        if (!name.equals("") && !pass.equals("")) {
   
            if (user != null) {
                http.setAttribute("username", name);
                response.sendRedirect("home");
            } 
            else {
                request.setAttribute("message", "The wrong username or password have been entered.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
           
        } else {
            request.setAttribute("message", "Please make sure to enter both username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
