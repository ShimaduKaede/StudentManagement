package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentCreateExecuteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		int ent_year=Integer.parseInt(request.getParameter("ent_year"));
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String class_num=request.getParameter("class_num");

		// DAOの生成
		StudentDAO dao=new StudentDAO();
		// DAOにわたす用のMemoBeanを生成
		Student student=new Student();
		student.setEntYear(ent_year);
		student.setStudentNo(no);
		student.setStudentName(name);
		student.setClassNum(class_num);
		dao.save(student);

		// 挿入後はトップページへ遷移するためにルートのアドレスにリダイレクト
		// ルートのアドレスではindex.javaがヒットするため挿入後のメモも含めて全件取得して
		// index.jspへフォワードされて表示される。
		return "menu.jsp";
	}
}
