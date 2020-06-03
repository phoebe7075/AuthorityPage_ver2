package Controller;

import persistance.AuthorityDAO;
import persistance.AuthorityDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AuthorityView")
public class AuthorityController  extends HttpServlet {
    private AuthorityDAO authorityDAO = new AuthorityDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<AuthorityDTO> authorityDto;
        authorityDto = authorityDAO.select();
        req.setAttribute("authorityDto",authorityDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/AuthorityView.jsp");
        dispatcher.forward(req,resp);
    }
}
