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

/*
 모둘 설계자 : 김인환

 검토자 : 박성용, 김주현
 검토 날짜: 06/05

 수정 일자: 06/05
 수정 내용: 쓸데없는 코드 삭제

 */




@WebServlet("/")
public class Mysql extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
