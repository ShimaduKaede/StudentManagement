package subject;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectListAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        // セッションから学校情報を取得
        HttpSession session = request.getSession();
        School school = (School) session.getAttribute("school");

        // Schoolがnullの場合の処理
        if (school == null) {
            // 適切なエラーメッセージを設定してエラーページにリダイレクト
            request.setAttribute("error", "学校情報が見つかりません。再度ログインしてください。");
            return "error.jsp";
        }

        // SubjectDAOの生成
        SubjectDAO dao = new SubjectDAO();
        // SubjectDAOのfilterメソッドで学科を全件取得する
        List<Subject> subjectList = dao.filter(school);

        // "subjectList"という名前でsubjectListリストをセット
        // subject_list.jsp側ではsubjectListという名前で受け取ることができます
        request.setAttribute("subjectList", subjectList);

        // FrontControllerを使用しているためreturn文でフォワードできる
        return "subject_list.jsp";
    }
}
