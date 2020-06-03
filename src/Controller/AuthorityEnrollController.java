package Controller;

import persistance.AuthorityDAO;
import persistance.AuthorityDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Enroll")
public class AuthorityEnrollController extends HttpServlet {
    private AuthorityDAO authorityDAO = new AuthorityDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id_text");
        String name = req.getParameter("authority");
        AuthorityDTO dto = new AuthorityDTO(id,name);
        authorityDAO.insert(dto);
    }
}


