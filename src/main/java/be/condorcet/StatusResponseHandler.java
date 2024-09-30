package be.condorcet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/StatusResponseHandler")
public class StatusResponseHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>confirmation</title>");
            out.println("</head>");
            out.println("<body>");        
           
           String username = request.getParameter("username");

           
           if(username.isEmpty()) {
        	   out.println("<h2>400 Bad Request : Identifiant d'utilisateur requis </h2>");
        	   return;
           }
           int i = Integer.parseInt(username);
           if(i>=0) {
        	   out.println("<h2>Bienvenue " + username + ", nous sommes ravis de vous voir </h2>");
           }
           else {
        	   out.println("<h2>Bienvenue " + username + ", nous sommes ravis de vous voir </h2>");
           }
           
           
           
           out.println("</body>");
           out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
