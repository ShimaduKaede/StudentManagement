package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // リクエストから科目コードを取得
        String subjectCd = request.getParameter("subjectCd");
        String subjectName = request.getParameter("subjectName");
        // セッションから学校情報を取得
        School school = (School) request.getSession().getAttribute("School");

        // Subjectオブジェクトを作成して設定
        Subject subject = new Subject();
        subject.setSchool(school);
        subject.setSubjectCd(subjectCd);
        subject.setSubjectName(subjectName);
        // SubjectDAOインスタンスを生成
        SubjectDAO dao = new SubjectDAO();

        // 科目を削除
        boolean success = dao.delete(subject);

        // 結果に応じてメッセージを設定
        if (success) {
            request.setAttribute("message", "削除に成功しました");

        } else {
            request.setAttribute("message", "削除に失敗しました");
        }

        // 結果を表示するJSPページを返す
        return "subject_delete_done.jsp";
    }
}



