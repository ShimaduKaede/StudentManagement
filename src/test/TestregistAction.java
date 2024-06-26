package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.ClassNumDAO;
import tool.Action;
import tool.Utl;

public class TestRegistAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// Utlクラスをインスタンス化
		Utl utl = new Utl();
		// ログインしているTeacherをセッション情報から取得する
		Teacher teacher = utl.getUser(request);

		// フォワード先のクラスのSELECTボックスで使用するために
		// classテーブルからユーザーが所属している学校のクラス一覧を取得（A中学校で検索）
		ClassNumDAO dao = new ClassNumDAO(); // ClassNumDAOを呼び出す
		List<String> classes = dao.filter(teacher.getSchool());
		System.out.println(classes);
		// 取得したクラス一覧をjsp側に渡すためにセットする 第1引数にjspで使うときの名前を設定 第2引数に渡すデータを指定
		request.setAttribute("classes", classes);
		
		// フォワード先の科目のSELECTボックスで使用するために
		// subjectテーブルからユーザーが所属している学校のクラス一覧を取得 
		SubjectDAO dao = new SubjectDAO();
		List<String> subjects = dao.filter(teacher.getSchool());
		System.out.println(subjects);
		// 取得した科目一覧をjsp側に渡すためにセットする 第一引数にjspで使うときの名前を設定 第二引数に渡すデータを指定
		request.setAttribute("subjects", subjects);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return ".jsp";
	}
}
