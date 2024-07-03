package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // リクエストパラメータを受け取る
        String subjectCd = request.getParameter("subjectCd");
        String subjectName = request.getParameter("subjectName");

        // Subjectオブジェクトの生成と設定
        Subject subject = new Subject();
        subject.setSubjectCd(subjectCd);
        subject.setSubjectName(subjectName);

        // SubjectDAOの生成
        SubjectDAO dao = new SubjectDAO();

        boolean success = dao.update(subject);

        // 結果に応じてメッセージを設定
        if (success) {
            request.setAttribute("message", "更新に成功しました");

        } else {
            request.setAttribute("message", "更新に失敗しました");
        }

        // 結果を表示するJSPページを返す
        return "subject_update_done.jsp";
    }
}

