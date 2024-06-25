package subject ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectUpdateAction extends HttpServlet {
    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            // login.jspへフォワードするだけ
            request.getRequestDispatcher("/account/subject_update.jsp")
                .forward(request, response);
        }catch(Exception e){
         // エラーメッセージを設定してエラーページに遷移
           request.setAttribute("message", "エラーが発生しました。");
           request.getRequestDispatcher("/student/error.jsp")
            .forward(request, response);

    }
    }
}