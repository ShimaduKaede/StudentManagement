package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.SubjectDAO;
import dao.TestDAO;
import tool.Action;
import tool.Utl;

public class TestRegistAction extends Action {

    public String execute(
        HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try{
    		HttpSession session = request.getSession();

    		Utl utl = new Utl();
    		// getUserメソッドを呼び出してユーザー情報を取得
    		Teacher teacher = utl.getUser(request);
    		// TeacherオブジェクトからSchoolオブジェクトを取得
    		School school = teacher.getSchool();

    		boolean isAttend = true;//在学フラグ

    	;	SubjectDAO subjectdao = new SubjectDAO();
    		List<Subject> subjectList = subjectdao.filter(school);
    		session.setAttribute("subject", subjectList);
    		TestDAO testdao = new TestDAO();
    		List<Test> testList = testdao.filter(no);

    		    String ent_year = request.getParameter("f1");
                String class_num = request.getParameter("f2");
                String subject_name = request.getParameter("f3");
                String num = request.getParameter("f4");

                    int entYear = Integer.parseInt(ent_year);
                    String classNum = class_num;
                    String name = subject_name;
                    int no = Integer.parseInt(num);

                    setTestListStudent(request, response);

            return "/test/test_regist.jsp"; // ログイン成功時のリダイレクト先
    	}catch(Exception e){
    		 // エラーメッセージを設定してエラーページに遷移
            request.setAttribute("message", "エラーが発生しました。");
            return "/student/error.jsp";

    	}

    }


private void setTestListStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Utl utl = new Utl();
        // リクエストパラメータの取得
		Teacher teacher = utl.getUser(request);
		// TeacherオブジェクトからSchoolオブジェクトを取得
        int entYear = Integer.parseInt(request.getParameter("f1"));
        String classNum = request.getParameter("f2");
        String name = request.getParameter("f3");
        int num = Integer.parseInt(request.getParameter("f4"));
        Test test = new Test();
        test.setTestNo(num);
        Subject subject = new Subject();
        subject.setSubjectName(name);
        Student student = new Student();


        // 学生情報の取得
        TestDAO dao = new TestDAO();
        List<Test> list = dao.filter(classNum,subject, num, school, ent_year);

     // テストリストをリクエストに設定
        request.setAttribute("testList", list);

}
}
