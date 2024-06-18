package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubjectDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // リクエストパラメータから必要な情報を取得
        String subjectCd = request.getParameter("cd");
        String schoolCd = request.getParameter("schoolCd");

        // School オブジェクトの生成または取得
        School school = new School();
        school.setCd(schoolCd);

        // Subject オブジェクトの生成
        Subject subject = new Subject();
        subject.setCd(subjectCd);
        subject.setSchool(school);

        // SubjectDaoを使用してSubjectを削除
        SubjectDao subjectDao = new SubjectDao();
        boolean isDeleted = subjectDao.delete(subject);

        // 削除結果に応じたレスポンスの設定
        try {
            if (isDeleted) {
                response.getWriter().write("Subject deleted successfully");
            } else {
                response.getWriter().write("Failed to delete subject");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

