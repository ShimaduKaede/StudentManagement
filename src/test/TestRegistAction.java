package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import tool.Action;
import tool.Util;

public class TestRegistAction extends Action {

    public String execute(
        HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try{
    		HttpSession session = request.getSession();

    		// getUserメソッドを呼び出してユーザー情報を取得
    		Teacher teacher = Util.getUser(request);
    		// TeacherオブジェクトからSchoolオブジェクトを取得
    		School school = teacher.getSchool();

    		boolean isAttend = true;//在学フラグ

    	;	SubjectDAO subjectdao = new SubjectDAO();
    		List<Subject> subjectList = subjectdao.filter(school);
    		StudentDao studentdao = new StudentDao();
    		List<Student> studentList = studentdao.filter(school, isAttend);
    		session.setAttribute("student", studentList);
    		session.setAttribute("subject", subjectList);

    		    String ent_year = request.getParameter("f1");
                String class_num = request.getParameter("f2");
                String subject_name = request.getParameter("f3");
                String no = request.getParameter("f4");

                    int entYear = Integer.parseInt(ent_year);
                    String classNum = class_num;
                    String name = subject_name;
                    int num = Integer.parseInt(no);

                    setTestListStudent(request, response);

            return "/test/test_regist.jsp"; // ログイン成功時のリダイレクト先
    	}catch(Exception e){
    		 // エラーメッセージを設定してエラーページに遷移
            request.setAttribute("message", "エラーが発生しました。");
            return "/student/error.jsp";

    	}

    }


private void setTestListStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // リクエストパラメータの取得
		Teacher teacher = Util.getUser(request);
	// TeacherオブジェクトからSchoolオブジェクトを取得
		School school = teacher.getSchool();
        int entYear = Integer.parseInt(request.getParameter("f1"));
        String classNum = request.getParameter("f2");
        String name = request.getParameter("f3");
        int num = Integer.parseInt(request.getParameter("f4"));
        Test test = new Test();
        test.setNo(num);
        Subject subject = new Subject();
        subject.setName(name);
        Student student = new Student();
 
 
        // 学生情報の取得
        TestDao dao = new TestDao();
        List<Test> list = dao.filter(test, entYear, classNum, subject, num, student);

     // テストリストをリクエストに設定
        request.setAttribute("testList", list);
 
}
}
 