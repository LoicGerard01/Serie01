package be.condorcet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/ResponseHandler")
public class ResponseHandler extends HttpServlet {
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
           String message = request.getParameter("message");

           
           if(message.equals("Bienvenue")) {
        	   out.println("<h2>Bienvenue " + username + ", nous sommes ravis de vous voir </h2>");
           }
           if(message.equals("Encouragement")) {
        	   out.println("<h2>Continuez comme ça, " + username + ", vous êtes sur la bonne voie ! </h2>");
           }
           if(message.equals("Remerciement")) {
        	   out.println("<h2>Merci " + username + " d'avoir utilisé nos services </h2>");
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
