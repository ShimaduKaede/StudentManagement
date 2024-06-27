package search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;
import tool.Utl;

public class SearchAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        Utl utl = new Utl();
        // セッションから学校情報を取得
        Teacher teacher = utl.getUser(request);

        // Schoolがnullの場合の処理
        if (teacher.getSchoolCd() == null) {
            // 適切なエラーメッセージを設定してエラーページにリダイレクト
            request.setAttribute("error", "学校情報が見つかりません。再度ログインしてください。");
            return "error.jsp";
        }

        // Schoolをインスタンス化
        School school = new School();
        school.setSchoolCd(teacher.getSchoolCd());

        // 初期情報を表示
        displayInitialInformation(request);

        // 入力された検索条件を取得
        String enrollmentYear = request.getParameter("enrollmentYear");
        String className = request.getParameter("class");
        String subjectName = request.getParameter("subject");
        String occurrence = request.getParameter("occurrence");

        // 検索条件を使用してフィルター
        SubjectDAO dao = new SubjectDAO();
        List<Subject> filteredSubjects = dao.filter(school, enrollmentYear, className, subjectName, occurrence);

        // デバッグログを追加
        System.out.println("Filtered subjects: " + filteredSubjects);

        // 検索結果をセット
        request.setAttribute("filteredSubjects", filteredSubjects);

        // FrontControllerを使用しているためreturn文でフォワードできる
        return "search_results.jsp";
    }

    private void displayInitialInformation(HttpServletRequest request) {
        // 初期表示する情報を設定
        request.setAttribute("initialMessage", "検索条件を入力してください。");
        // 例としていくつかのデフォルト情報をセット
        request.setAttribute("defaultEnrollmentYear", "2021");
        request.setAttribute("defaultClass", "1A");
        request.setAttribute("defaultSubject", "数学");
        request.setAttribute("defaultOccurrence", "1");
    }
}
