package student;

import javax.servlet.htttp.HttpSession;
import javax.servlet.http.HttpServletRequest;

import bean.Student;
import bean.Teacher;
import tool.Action;
import tool.Utl;
import dao.StudentDAO;

public class StudentListAction extends Action {
	public String execute( HttpServletRequest request
	) throws Exception {	
		// セッションからユーザデータを取得
		Teacher t=new Teacher();
		Utl tool = new Utl();
		t = tool.getUser(request);

		// セッションのユーザーデータから、ユーザーが所属している学校の生徒一覧用データを取得
		School s=new School();
		s.setSchoolCd(t.getSchoolCd());
		boolean flg = true;
		// ????----ここらへんから--------------
		filter3(s,flg);



		// セッションから引っ張ってきたユーザデータを変数userに登録
		request.setAttribute("user", t);
		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}

