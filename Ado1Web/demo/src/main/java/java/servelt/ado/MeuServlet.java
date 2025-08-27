import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
public class MeuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura os parâmetros do formulário
        String nome = request.getParameter("carName");
        String cor = request.getParameter("carColor");
        // Cria um JSON com os dados recebidos
        JSONObject json = new JSONObject();
        json.put("nome", nome);
        json.put("cor", cor);
        // Configura a resposta
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
    }
}