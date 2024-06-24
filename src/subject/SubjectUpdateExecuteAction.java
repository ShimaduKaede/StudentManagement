package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		// リクエストパラメータから名前,クラス,在学中を取得
		String SubjectName=request.getParameter("name");

		// Studentbeansを生成して更新用の情報をセット
		Subject subject=new Subject();
		subject.setSubjectName(SubjectName);

		// DAOの生成
		SubjectDAO dao=new SubjectDAO();
		dao.update(subject);

		//更新完了ページに遷移
		return "subject_update_done.jsp";
	}
}
