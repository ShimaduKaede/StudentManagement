package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Teacher;
import dao.ClassNumDAO;
import tool.Action;
// import tool.Utl;

public class StudentCreateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		// セッションデータからログインしているユーザーデータを取得（A中学校という情報を取得）
		// Teacher teacher = Utl.getUser();
		Teacher teacher = new Teacher(); //Teacherビーンをインスタンス化
		teacher.setTeacherId("1");
		teacher.setTeacherName("kayano");
		teacher.setTeacherPassword("1234");
		School school = new School();
		school.setSchoolCd("ooi");
		school.setSchoolName("大分校");
		teacher.setSchool(school);

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
