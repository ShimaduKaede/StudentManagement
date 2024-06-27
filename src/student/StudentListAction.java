package student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import bean.School;
import bean.Student;
import bean.Teacher;
import tool.Action;
import tool.Utl;

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
		boolean flg = true;	// 在学中フラグをONで設定（仮）

		List<Student> studentlist=new ArrayList<>();    // 戻り値で使用するstudentlistを作成
		studentlist=dao.filter3(s,flg);

		// student_list.jsp側ではstudentlistという名前で受け取ることができます
		request.setAttribute("studentlist", studentlist);
		// セッションから引っ張ってきたユーザデータを変数userに登録
		request.setAttribute("user", t);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}

