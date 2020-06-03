package Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import persistance.AuthorityDAO;
import persistance.AuthorityDTO;

@WebServlet("/Delete")
public class AuthorityDeleteController extends  HttpServlet {
    private AuthorityDAO authorityDAO = new AuthorityDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        AuthorityDTO dto = new AuthorityDTO(id, name);
        authorityDAO.delete(dto);
    }
}
