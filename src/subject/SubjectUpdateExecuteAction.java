package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import bean.Teacher; // ユーザー情報を取得するために必要なインポート
import dao.SubjectDAO;
import tool.Action;
import tool.Utl; // ユーザー情報を取得するために必要なインポート

public class SubjectUpdateExecuteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Utlを使ってログインユーザーを取得
        Utl utl = new Utl();
        Teacher user = utl.getUser(request);

        // リクエストパラメータを受け取る
        String subjectCd = request.getParameter("cd");
        String subjectName = request.getParameter("name");

        // 受け取れているかをチェック
        System.out.println("subjectCd: " + subjectCd);
        System.out.println("subjectName: " + subjectName);
        System.out.println("schoolCd: " + user.getSchoolCd());

        // Subjectオブジェクトの生成と設定
        Subject subject = new Subject();
        subject.setSubjectCd(subjectCd);
        subject.setSubjectName(subjectName);
        subject.setSchoolCd(user.getSchoolCd());

        // SubjectDAOの生成
        SubjectDAO dao = new SubjectDAO();

        // updateメソッドを使ってsubjectを更新
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
