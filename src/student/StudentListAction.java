package student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Student;
import bean.Teacher;
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

		boolean flg = true;	// 在学中フラグをONで設定（仮）


		// StudentDAOの生成
        StudentDAO dao = new StudentDAO();
		List<Student> studentList = dao.filter3(school,flg);


		// セッションから引っ張ってきたユーザデータを変数userに登録
		request.setAttribute("user", teacher);
        // "studentList"という名前でsubjectListリストをセット
		request.setAttribute("studentList", studentList);

		// FrontControllerを使用しているためreturn文でフォワードできる
		return "student_list.jsp";
	}
}
