package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;
import tool.Utl;

public class TestRegistAction extends Action {
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
School school = new School();
school.setSchoolCd(teacher.getSchoolCd());

// ClassNumDAOの生成
ClassNumDAO c_dao = new ClassNumDAO();
List<String> classNumList = c_dao.filter(school);

// SubjectDAOの生成
SubjectDAO s_dao = new SubjectDAO();
List<Subject> subjectList = s_dao.filter(school);

request.setAttribute("classNumList", classNumList);
request.setAttribute("subjectList", subjectList);

// FrontControllerを使用しているためreturn文でフォワードできる
return "test_regist.jsp";
}

}