package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Teacher;
import dao.ClassNumDAO;
import tool.Action;
import tool.Utl;

public class StudentCreateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// Utlを使うためにインスタンス化
		Utl utl = new Utl();
		// セッションデータからログインしているユーザーデータを取得（A中学校という情報を取得）
		Teacher teacher = utl.getUser(request);

		// フォワード先のクラスのSELECTボックスで使用するために
		// classテーブルからユーザーが所属している学校のクラス一覧を取得（A中学校で検索）
		ClassNumDAO dao = new ClassNumDAO(); // ClassNumDAOを呼び出す
		School school = new School();
		school.setSchoolCd(teacher.getSchoolCd());
		List<String> classes = dao.filter(school);
		System.out.println(classes);
		// 取得したクラス一覧をjsp側に渡すためにセットする 第1引数にjspで使うときの名前を設定　第2引数に渡すデータを指定
		request.setAttribute("classes", classes);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_create.jsp";
	}
}
