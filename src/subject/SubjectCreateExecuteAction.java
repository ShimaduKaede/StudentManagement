package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ユーザーからの入力値を受け取る
        String subjectCd = request.getParameter("SubjectCd");
        String subjectName = request.getParameter("SubjectName");

        // Schoolオブジェクトを作成して設定
        School school = new School();
        school.setSchoolCd("oom");
        school.setSchoolName("大分校");

        // Subjectオブジェクトを作成して設定
        Subject subject = new Subject();
        subject.setSchool(school);
        subject.setSubjectCd(subjectCd);
        subject.setSubjectName(subjectName);

        // エラーチェック
        String[] errorMessages = {
            (subjectCd.length() > 3) ? "科目コードは3文字で入力してください。" : null,
            (subjectCd.length() < 3) ? "科目コードは3文字で入力してください。" : null
        };

        // エラーメッセージを設定する
        for (String errorMessage : errorMessages) {
            if (errorMessage != null) {
                request.setAttribute("error_message", errorMessage);
                return "subject_create.jsp";
            }
        }

        // SubjectDAOインスタンスを生成
        SubjectDAO dao = new SubjectDAO();

        // SubjectDAOのsaveメソッドを実行してデータベースに登録
        boolean success = dao.save(subject);

        // 登録成功かどうかでメッセージを設定
        if (success) {
            request.setAttribute("message", "登録しました");
            return "subject_create_done.jsp";
        } else {
            request.setAttribute("error_message", "科目コードが重複しています。");
            return "subject_create.jsp";
        }
    }
}
