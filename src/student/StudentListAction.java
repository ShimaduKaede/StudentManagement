package student;

import javax.servlet.htttp.HttpSession;

import tool.Action;
import tool.Utl;
public class StudentListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		Teacher t=new Teacher();
		Utl tool = new Utl();
		t = tool.getUser(request);

		request.setAttribute("user", t);
		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}

