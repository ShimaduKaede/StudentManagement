package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class SubjectUpdateAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String subjectCd = request.getParameter("cd");
    	String subjectName = request.getParameter("name");

    	request.setAttribute("subjectCd", subjectCd);
    	request.setAttribute("subjectName", subjectName);


        // 遷移先のJSPを返す
        return "subject_update.jsp";
    }
}
