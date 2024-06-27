package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// リクエストパラメータから名前,クラス,在学中を取得
		int entYear=Integer.parseInt(request.getParameter("ent_year"));
		String name=request.getParameter("name");
		String class_num=request.getParameter("class_num");
		boolean is_attend=Boolean.parseBoolean(request.getParameter("is_attend"));

		// Studentbeansを生成して更新用の情報をセット
		Student student=new Student();
		student.setEntYear(entYear);
		student.setStudentName(name);
		student.setClassNum(class_num);
		student.setIsAttend(is_attend);

		// DAOの生成
		StudentDAO dao=new StudentDAO();
		// updateメソッドを使ってidに対応するMemoを更新
		dao.update(student);

		// 更新後はトップページへ遷移するためにルートのアドレスにリダイレクト
		// ルートのアドレスではindex.javaがヒットするため挿入後のメモも含めて全件取得して
		// index.jspへフォワードされて表示される。
		return "student_create_done.jsp";
	}
}
