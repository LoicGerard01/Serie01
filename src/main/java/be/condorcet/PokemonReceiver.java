package be.condorcet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/PokemonReceiver")
public class PokemonReceiver extends HttpServlet {
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
            out.println("<h1>Vous avez choisi :</h1>");

            String[] pokemons = request.getParameterValues("pokemon");

            
           out.println("<ul>");
           for (String pokemon : pokemons) {
           out.println("<li>" + pokemon + "</li>");
           }
           out.println("</ul>");
           
           out.println("<p> Merci pour votre choix ! <br> Amusez-vous bien avec vos Pokémon ! </p>");
            
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
