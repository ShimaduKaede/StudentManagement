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
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import tool.Action;
import tool.Utl;
// test_regist.jsp(成績管理一覧画面)でTestRegistExecuteAction起動
// TestRegistExecuteActionでやること↓
// ・入力値のチェック
//  alt【0～200で無い数値が入力されていた場合】
//  正しくない数値が入力されていた入力欄に
// 「0～100の範囲で入力してください」とメッセージを表示する(test_regist.jspに)
// 入力された値をDBに保存する(TestDAOを使ってTestBeanへ保存：登録)
// 表示する

public class TestRegistExecuteAction extends Action {

    public String execute(
        HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try{
    		HttpSession session = request.getSession();

    		// getUserメソッドを呼び出してユーザー情報を取得
    		Teacher teacher = Utl.getUser(request);
    		// TeacherオブジェクトからSchoolオブジェクトを取得
    		School school = teacher.getSchool();

    		boolean isAttend = true;//在学フラグ

    	;	SubjectDAO subjectdao = new SubjectDAO();
    		List<Subject> subjectList = subjectdao.filter(school);
    		TestDao dao = new TestDao();
            List<Test> list = dao.filter(no);
    		session.setAttribute("subject", subjectList);

    		    String ent_year = request.getParameter("f1");
                String class_num = request.getParameter("f2");
                String subject_name = request.getParameter("f3");
                String no = request.getParameter("f4");

                    int entYear = Integer.parseInt(ent_year);
                    String classNum = class_num;
                    String name = subject_name;
                    int no = Integer.parseInt(no);

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
		Teacher teacher = Utl.getUser(request);
	// TeacherオブジェクトからSchoolオブジェクトを取得
		School school = teacher.getSchool();
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
        TestDao dao = new TestDao();
        List<Test> list = dao.filter(test, entYear, classNum, subject, num, student);

     // テストリストをリクエストに設定
        request.setAttribute("testList", list);
 
}
}
 