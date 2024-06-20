package account ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// このURLパターンはhttp://localhost:8080/kouka2で実行される
@WebServlet(urlPatterns={"/account/"})
public class LoginAction extends HttpServlet {
    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            // login.jspへフォワードするだけ
            request.getRequestDispatcher("/account/login.jsp")
                .forward(request, response);
        }catch(Exception e){
         // エラーメッセージを設定してエラーページに遷移
           request.setAttribute("message", "エラーが発生しました。");
           request.getRequestDispatcher("/student/error.jsp")
            .forward(request, response);

    }
    }
}