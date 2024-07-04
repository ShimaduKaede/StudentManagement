package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
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
String schoolcd =teacher.getSchoolCd();

// StudentDAOの生成
StudentDAO dao = new StudentDAO();
List<Student> studentList = dao.searchAll(schoolcd);

// セッションから引っ張ってきたユーザデータを変数userに登録
request.setAttribute("user", teacher);
// "studentList"という名前でsubjectListリストをセット
request.setAttribute("studentList", studentList);
// SubjectDAOの生成
SubjectDAO dao2 = new SubjectDAO();
// SubjectDAOのfilterメソッドで学科を全件取得する
List<Subject> subjectList = dao2.filter(school);
// "studentList"という名前でsubjectListリストをセット
request.setAttribute("subjectList", subjectList);


// ClassNumDAOの生成
ClassNumDAO c_dao = new ClassNumDAO();
List<String> classNumList = c_dao.filter(school);

request.setAttribute("classNumList", classNumList);

try{
int ent_year = Integer.parseInt(request.getParameter("f1"));
String class_num = request.getParameter("f2");
String subject_name = request.getParameter("f3");
int no = Integer.parseInt(request.getParameter("f4"));

if (ent_year==0){
	List<Test> testregistList = null;
	request.setAttribute("testregistList", testregistList);
	return "test_regist.jsp";
}
else{
	request.setAttribute("ent_year", ent_year);
	request.setAttribute("class_num", class_num);
	request.setAttribute("subject_name", subject_name);
	request.setAttribute("no", no);

	TestDAO dao1 = new TestDAO();
	List<Test> testregistList = dao1.Listregist(ent_year,class_num,subject_name,no);
	request.setAttribute("testregistList", testregistList);
	return "test_regist.jsp";
}
}
catch(Exception e){
	System.out.println(e);
	return "test_regist.jsp";
}

}

}