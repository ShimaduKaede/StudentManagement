package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;
import tool.Utl;

public class StudentListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		// セッションからユーザデータを取得
		Utl utl = new Utl();
		Teacher teacher=new Teacher();
		teacher = utl.getUser(request);


		// ①ClassNumDAOを生成
		ClassNumDAO classNumDAO = new ClassNumDAO();

		// ②Schoolビーンを生成 （ClassNumDAOの引数で必要）
		School school2 = new School();

		// ③SchoolのschoolCdにユーザーの所属学校を設定
		school2.setSchoolCd(teacher.getSchoolCd());

		// ④ClassNumDAOのfilter(school)を呼び出してクラス一覧List<String> classesを取得
		List<String> classes = classNumDAO.filter(school2);

        // Schoolがnullの場合の処理
        if (teacher.getSchoolCd() == null) {
            // 適切なエラーメッセージを設定してエラーページにリダイレクト
            request.setAttribute("error", "学校情報が見つかりません。再度ログインしてください。");
            return "error.jsp";
        }

		// セッションのユーザーデータから、ユーザーが所属している学校の生徒一覧用データを取得
        // Schoolをインスタンス化
        School school = new School();
        school.setSchoolCd(teacher.getSchoolCd());

		// StudentDAOの生成
        StudentDAO dao = new StudentDAO();
		List<Student> studentList = dao.searchAll(teacher.getSchoolCd());

		//出るかどうか！ 検索結果の件数をログ出力して確認
        System.out.println("検索結果の件数: " + studentList.size());

		// セッションから引っ張ってきたユーザデータを変数userに登録
		request.setAttribute("user", teacher);
        // "studentList"という名前でsubjectListリストをセット
		request.setAttribute("studentList", studentList);
		// 検索結果の件数をセット
        request.setAttribute("resultCount", studentList.size());
        // ⑤setSttributeでclassesにクラス一覧を設定
        request.setAttribute("classes", classes);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}
