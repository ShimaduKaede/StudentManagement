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

        // SubjectDAOインスタンスを生成
        SubjectDAO dao = new SubjectDAO();

        // SubjectDAOのsaveメソッドを実行してデータベースに登録
        boolean success = dao.save(subject);

        // 登録成功かどうかでメッセージを設定
        if (success) {
            request.setAttribute("message", "登録しました");
        } else {
            request.setAttribute("message", "登録に失敗しました");
        }

        // 遷移先のJSPを返す
        return "subject_create_done.jsp";
    }
}



