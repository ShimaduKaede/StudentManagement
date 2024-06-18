package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

public class LoginExecuteAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        try {
            HttpSession session = request.getSession();

            String teacherId = request.getParameter("teacherId");
            String teacherPassword = request.getParameter("teacherPassword");

            TeacherDAO dao = new TeacherDAO();
            Teacher teacher = dao.login(teacherId, teacherPassword); // ログインIDとパスワードを使って検証する

            if (teacher != null) {
                session.setAttribute("teacher", teacher);
                return "/student/menu.jsp"; // ログイン成功時のリダイレクト先
            } else {
                request.setAttribute("message", "ログインIDまたはパスワードが違います。");
                return "/student/login.jsp"; // ログイン失敗時のリダイレクト先
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "エラーが発生しました。");
            return "/student/error.jsp"; // エラーページに遷移
        }
    }
}
