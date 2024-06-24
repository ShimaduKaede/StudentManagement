package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// student_list.jspから変更学生の学番が送られてくるので受け取る
		String studentNo = request.getParameter("studentNo");

		// 変更するための学生を取得するためにStudentDAOを呼び出す
		StudentDAO studentDAO = new StudentDAO();

		// SutdentDAOのfilterメソッドで対象学生を検索
		Student student = studentDAO.get(studentNo);

		// 取得した学生をjsp側に渡すためにセットする
		request.setAttribute("student", student);

		// 変更するためのクラスSELECTボックスを作成するためにClassNumDAOを呼び出す
		ClassNumDAO classNumDAO = new ClassNumDAO();

		// ClassNumDAOのfilterメソッドでユーザーが所属している学校のクラス一覧を取得
		List<String> classes = classNumDAO.filter(student.getSchool());

		// 取得したクラス一覧をjsp側に渡すためにセットする 第1引数にjspで使うときの名前を設定　第2引数に渡すデータを指定
		request.setAttribute("classes", classes);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_update.jsp";
	}
}
