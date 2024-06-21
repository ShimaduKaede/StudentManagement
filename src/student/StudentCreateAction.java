package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassNumDAO;
import tool.Action;

public class StudentCreateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {




		// フォワード先のクラスのSELECTボックスで使用するために
		// classテーブルからユーザーが所属している学校のクラス一覧を取得（A中学校で検索）
		ClassNumDAO dao = new ClassNumDAO(); // ClassNumDAOを呼び出す
		List<String> classes = dao.filter(teacher.getSchool());
		System.out.println(classes);
		// 取得したクラス一覧をjsp側に渡すためにセットする 第1引数にjspで使うときの名前を設定　第2引数に渡すデータを指定
		request.setAttribute("classes", classes);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_create.jsp";
	}
}
