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
// teacherから学校コードを取り出す
School school = new School();
school.setSchoolCd(teacher.getSchoolCd());
String schoolcd =teacher.getSchoolCd();

// StudentDAOの生成
StudentDAO dao1 = new StudentDAO();
List<Student> studentListclass = dao1.searchclass_num(schoolcd);

List<Student> studentListyear = dao1.searchentyear(schoolcd);


//以下searchプルダウンの生成

// セッションから引っ張ってきたユーザデータを変数userに登録
request.setAttribute("user", teacher);
// "studentList"という名前でsubjectListリストをセット
request.setAttribute("studentListclass", studentListclass);
request.setAttribute("studentListyear", studentListyear);

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

// プルダウンから入力された入力情報の取得
try{
String ent_year = request.getParameter("f1");
String class_num = request.getParameter("f2");
String subject_name = request.getParameter("f3");
int no = Integer.parseInt(request.getParameter("f4"));

	int ent_year1=Integer.parseInt(ent_year);
	request.setAttribute("ent_year", ent_year1);
	request.setAttribute("class_num", class_num);
	request.setAttribute("subject_name", subject_name);
	request.setAttribute("no", no);

	// 入力された情報から検索(studentテーブル全て出されるようにする)
	TestDAO dao2_ = new TestDAO();
	List<Test> testregistList = dao2_.Listregist(ent_year1,class_num,subject_name,no);
	if (testregistList.size()==0){
		throw new NullPointerException();
	}
	request.setAttribute("testregistList", testregistList);
	return "test_regist.jsp";

}
catch(NullPointerException e){
	request.setAttribute("errorMessage", "入学年度とクラスと科目と回数を選択してください");
	return "test_regist.jsp";
}

catch(Exception e){
	System.out.println(e);
	return "test_regist.jsp";
}



}

}