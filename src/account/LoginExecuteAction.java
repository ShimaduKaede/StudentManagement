package account;
 
import java.util.List;
 
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
        try{
 
            HttpSession session = request.getSession();
 
            String teacherId = request.getParameter("teacherId");
            String teacherPassword = request.getParameter("teacherPassword");
 
            TeacherDAO dao = new TeacherDAO();
            List<Teacher> customer = dao.login(teacherId, teacherPassword); // ログインIDとパスワードを使って検証する
 
            if (customer != null) {
                Teacher teacher = customer.get(0);
                session.setAttribute("teacher", teacher);
 
                return "/student/menu.jsp"; // ログイン成功時のリダイレクト先
            }
 
            
        }catch(Exception e){
         // エラーメッセージを設定してエラーページに遷移
           request.setAttribute("message", "エラーが発生しました。");
           return "student/error.jsp";
 
    }
    }
}