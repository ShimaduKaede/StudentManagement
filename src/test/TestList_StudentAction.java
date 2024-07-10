package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import tool.Action;
import tool.Utl;

public class TestList_StudentAction extends Action {
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

        String student_no = request.getParameter("f4");
        // SubjectDAOの生成
        TestDAO dao = new TestDAO();
        // SubjectDAOのfilterメソッドで学科を全件取得する
        List<Test> testlist = dao.ListStudent(student_no);
        String studentName=null;
        String studentNo=null;
        for (Test t: testlist){
        studentName=t.getStudentname();
        studentNo=t.getStudentno();}


        // "subjectList"という名前でsubjectListリストをセット
        request.setAttribute("testList", testlist);
        request.setAttribute("studentName", studentName);
        request.setAttribute("studentNo", studentNo);



        String schoolcd =teacher.getSchoolCd();

		// StudentDAOの生成
        StudentDAO dao1 = new StudentDAO();
		List<Student> studentListclass = dao1.searchclass_num(schoolcd);

		List<Student> studentListyear = dao1.searchentyear(schoolcd);


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

        // FrontControllerを使用しているためreturn文でフォワードできる
        return "test_list_student.jsp";
    }
}

