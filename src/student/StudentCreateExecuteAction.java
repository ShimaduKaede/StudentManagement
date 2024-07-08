package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;
import tool.Utl;

public class StudentCreateExecuteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// Utlを呼び出す
		Utl utl = new Utl();

		// UtlのgetUser()でログインユーザーを呼び出す
		Teacher user = utl.getUser(request);

		// student_create.jspから送られてきたデータを受け取る jsp側のname属性で指定された名前で受け取る
		// String name = request.getAttribute("kayano");
		String name = request.getParameter("name"); // 氏名
        int entYear = Integer.parseInt(request.getParameter("ent_year")); // 入学年度
        String studentNo = request.getParameter("no"); // 学生番号
        String classNum = request.getParameter("class_num"); // クラス番号
        System.out.println("entYear:"+entYear);

        // if文でentYearが空値かを確認する
        if (entYear == 0 ) {
        	request.setAttribute("message", "入学年度を選択してください");
        	request.setAttribute("name", name);
        	request.setAttribute("no", studentNo);
        	request.setAttribute("class_num", classNum);
        	ClassNumDAO dao = new ClassNumDAO();
        	School school = new School();
    		school.setSchoolCd(user.getSchoolCd());
    		List<String> classes = dao.filter(school);
    		request.setAttribute("classes", classes);
        	return "student_create.jsp";

        }
		// 受け取ったデータをStudentDAOのsaveメソッドで渡すためにStudentビーンをインスタンス化
		// Studentのセッターメソッドを使用して、送られてきたデータをビーンにセット
        Student student = new Student();

        student.setStudentName(name);
        student.setEntYear(entYear);
        student.setStudentNo(studentNo);
        student.setClassNum(classNum);

        // student.schoolCdにログインユーザーのschoolCdをセット
        student.setSchoolCd(user.getSchoolCd());

		// 受け取ったデータを登録するためにStudentDAOを呼び出す
        StudentDAO dao = new StudentDAO();

		// StudentDAOのsave(Student)メソッドで登録する
        dao.save(student);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_create_done.jsp";
	}
}
