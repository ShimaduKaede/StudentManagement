package subject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;
import tool.Utl;

public class SubjectListAction extends Action {
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
        // SubjectDAOの生成
        SubjectDAO dao = new SubjectDAO();
        // SubjectDAOのfilterメソッドで学科を全件取得する
        List<Subject> subjectList = dao.filter(school);

        // デバッグログを追加
        System.out.println("Fetched subjects: " + subjectList);

        // "subjectList"という名前でsubjectListリストをセット
        request.setAttribute("subjectList", subjectList);

        // FrontControllerを使用しているためreturn文でフォワードできる
        return "subject_list.jsp";
    }
}

