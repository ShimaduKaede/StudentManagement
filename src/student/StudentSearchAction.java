package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import tool.Action;
import tool.Utl;

public class StudentSearchAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// Utlを呼び出す
		Utl utl = new Utl();

		// UtlのgetUser()でログインユーザーを呼び出す
		Teacher user = utl.getUser(request);

		// Schoolビーンを生成
		School school = new School();

		// Schoolビーンにuserの学校コードをセット
		school.setSchoolCd(user.getSchoolCd());

		// student_list.jspから送られてきたデータを受け取る ①入学年度（int型）②クラス③在学フラグ（boolean型）
		int entYear = Integer.parseInt(request.getParameter("f1"));
        String classNum = request.getParameter("f2");
        boolean isAttend = Boolean.parseBoolean(request.getParameter("f3"));

		// StudentDAOを呼び出す
        StudentDAO studentDAO = new StudentDAO();

		// StudentDAOのfilter1メソッドを呼び出して対象の学生リストを取得 filter1(School school,int entYear,String classNum,boolean isAttend)
        List<Student> studentList = studentDAO.filter1(school, entYear, classNum, isAttend);

		// student_list.jspではstudentListで受け取っているのでsetAttributeで渡す
        request.setAttribute("studentList", studentList);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}
