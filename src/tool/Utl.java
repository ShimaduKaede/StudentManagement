package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import bean.Teacher;

public class Utl extends HttpServlet {
    // ログインしたユーザー情報をセションから取得する(Teacher型)メソッド
    public Teacher getUser(HttpServletRequest request
	) throws ServletException, IOException {
        // 格納用のTeacher型のtをインスタンス化
	    Teacher t=new Teacher();

        // // ログインが出来たので、戻しました。ログインでのセッション情報確保します
        // // 以下でセッション情報を変数tにセット
        // t.setTeacherId(session.getAttribute("teacherId"));
        // t.setTeacherPassword(sessiion.getAttribute("password"));
        // t.setTeacherName(session.getAttribute("teacherName"));
        // t.setSchool("schoolCd");

        // ログインが出来るまで、ひとまず、サンプルデータを仮入力してます
        // 以下でセッション情報を変数tにセット
        t.setTeacherId("admin");
        t.setTeacherPassword("password");
        t.setTeacherName("大原花子");
        t.setSchoolCd("oom");

        return t;   // 変数t:Teacher型の情報を返す
    }
    // クラス番号情報をセッションにセットする
    public void setClassNumSet(HttpServletRequest request
    ) throws ServletException, IOException {
        // 以下でセッション情報にセット
        session.setAttribute("schoolCd",request.schoolCd);
        session.setAttribute("classNum",request.classNum);
    }
    // 入学年度をセッションにセットする
    public void setEntYearSet(HttpServletRequest request
	) throws ServletException, IOException {
        // 以下でセッション情報にセット
        session.setAttribute("entYear",request.entYear);
    }
    // 科目情報をセッションにセットする
    public void setSubjects(HttpServletRequest request
	) throws ServletException, IOException {
        // 以下でセッション情報にセット
        session.setAttribute("subjectCd",request.subjectCd);
        session.setAttribute("subjectName",request.subjectName);
        session.setAttribute("school",request.school);
    }
    // クラス番号をセッションにセットする
    public void setNumSet(HttpServletRequest request
	) throws ServletException, IOException {
        // 以下でセッション情報にセット
        session.setAttribute("classNum",request.classNum);

    }

}
