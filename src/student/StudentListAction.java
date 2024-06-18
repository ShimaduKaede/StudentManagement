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
		String data1=session.getId()
        // セッションからユーザーデータを取得

        // sessionデータを渡す
        // セションのユーザーデータから、ユーザーが所属している学校の生徒一覧用データを取得

		// setAttributeメソッドでホールスタッフにデータを渡す
		// 第１引数にjspで受け取るときの名前
		// 第２引数にjspに渡すデータを指定する
		request.setAttribute("data1", data1);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}

