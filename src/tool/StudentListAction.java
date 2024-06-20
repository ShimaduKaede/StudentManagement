package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import tool.Action;
import tool.Utl;

public class StudentListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		Teacher t=new Teacher();
		Utl tool = new Utl();
		t = tool.getUser(request);

		System.out.println(t.getTeacherId());	// getUser classで受け取ってる（ここまでOK！）

		request.setAttribute("user", t);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}




