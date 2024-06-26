package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class TestListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		String studentNo = request.getParameter("f4");

		if (studentNo!=null){
			int ent_year = Integer.parseInt(request.getParameter("f1"));
			String class_num = request.getParameter("f2");
			String subject_name = request.getParameter("f3");
		}

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_update.jsp";
	}
}
