package test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Test;
import dao.TestDAO;
import tool.Action;

public class TestListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
			int ent_year = Integer.parseInt(request.getParameter("f1"));
			String class_num = request.getParameter("f2");
			String subject_name = request.getParameter("f3");
			int no = Integer.parseInt(request.getParameter("f4"));

			HttpSession session=request.getSession();
			String school=(String) session.getAttribute("school");
			TestDAO dao=new TestDAO();
			List<Test> testlist=new ArrayList<>();
			testlist=dao.filter(class_num,subject_name,no,school,ent_year);



		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_update.jsp";
	}
}
