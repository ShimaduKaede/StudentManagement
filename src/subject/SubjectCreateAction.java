package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectCreateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		// ユーザーからの入力値を受け取る
		int subjectcd=Integer.parseInt(request.getParameter("SubjectCd"));
		String name=request.getParameter("SubjectName");
		int courseid=Integer.parseInt(request.getParameter("CourseId"));

		// Subjectビーンに設定
		Subject subject=new Subject();
		subject.setSubjectCd(subjectcd);
		subject.setSubjectName(name);
		subject.setCourseId(courseid);
		// SubjectDAOインスタンスを生成
		SubjectDAO dao=new SubjectDAO();
		// SubjectDAOのstudentInsertメソッドを実行してデータベースに登録
		int line = dao.Subject(subject);

		// lineが0でなければ登録成功
		if (line != 0) {
			request.setAttribute("message", "登録しました");
		} else {
			request.setAttribute("message", "登録に失敗しました");
		}
		return "subject_create.jsp";
	}
}
