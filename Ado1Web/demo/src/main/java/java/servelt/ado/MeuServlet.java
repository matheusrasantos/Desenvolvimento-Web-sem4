package java.servelt.ado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carros")
public class MeuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    private static final List<Carro> carros = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        String json = gson.toJson(carros);

        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String cor = request.getParameter("cor");

        if (nome != null && cor != null && !nome.isEmpty() && !cor.isEmpty()) {
            Carro carro = new Carro(nome, cor);
            synchronized (carros) {
                carros.add(carro);
            }
        }

        
        response.sendRedirect("index.html");
    }
}
