package student;

import javax.servlet.htttp.HttpSession;

import tool.Action;
import tool.Utl;
public class StudentListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		// Sessionの開始
		HttpSession session=request.getSession();
        // sessionデータを取得
		session.getAttribute("")
        // セッションからユーザーデータを取得

		// getParameterメソッドででえーたを受け取る
		// name属性で指定した名前で受け取る
		String data1=request.getParameter("data1");
		String data2=request.getParameter("data2");

		// data1を加工
        // sessionデータを渡す
        // セションのユーザーデータから、ユーザーが所属している学校の生徒一覧用データを取得

		// setAttributeメソッドでホールスタッフにデータを渡す
		// 第１引数にjspで受け取るときの名前
		// 第２引数にjspに渡すデータを指定する
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}

