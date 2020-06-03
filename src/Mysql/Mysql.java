package Mysql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

@WebServlet("/")
public class Mysql extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String preInsert = "INSERT INTO Authority(Authority_ID,Authority_Name,Authority_Specification) VALUES (?,?,?)";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/객소모델?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pw = "apdlvmf1";


        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pw);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
