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
		// student_create.jspから送られてきたデータを受け取る jsp側のname属性で指定された名前で受け取る
		// String name = request.getAttribute("kayano");
		String name = request.getParameter("name"); // 氏名
        int entYear = Integer.parseInt(request.getParameter("ent_year")); // 入学年度
        String studentNo = request.getParameter("no"); // 学生番号
        String classNum = request.getParameter("class_num"); // クラス番号

		// 受け取ったデータをStudentDAOのsaveメソッドで渡すためにStudentビーンをインスタンス化
		// Studentのセッターメソッドを使用して、送られてきたデータをビーンにセット
        Student student = new Student();
        
        student.setStudentName(name);
        student.setEntYear(entYear);
        student.setStudentNo(studentNo);
        student.setClassNum(classNum);

		// 受け取ったデータを登録するためにStudentDAOを呼び出す
        StudentDAO dao = new StudentDAO();

		// StudentDAOのsave(Student)メソッドで登録する
        dao.save(student);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_create_done.jsp";
	}
}
