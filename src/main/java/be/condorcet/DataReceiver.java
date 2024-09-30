package be.condorcet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/DataReceiver")
public class DataReceiver extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	String parameterName = null;
    	String[] parameterValues = null;
    	Iterator<String> iterator;
    	
    	try {
    		out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lecture de param�tres</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<hr>");
            
            // get unique parameters by their name
            out.println("nom : ");
            out.println(request.getParameter("nom"));
            out.println("<br>");
            out.println("prenom : ");
            out.println(request.getParameter("prenom"));
            out.println("<br>");
            out.println("description : ");
            out.println(request.getParameter("description"));
            out.println("<br>");
           
    	}
    	finally {
    		out.close();
    	}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
    
    
}
