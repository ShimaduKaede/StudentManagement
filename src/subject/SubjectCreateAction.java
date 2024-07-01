package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class SubjectCreateAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 遷移先のJSPを返す
        return "subject_create.jsp";
    }
}



