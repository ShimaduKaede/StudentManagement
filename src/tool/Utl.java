package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  // Sessionを使用するためインポート

import bean.Teacher;
import bean.School;

public class Utl extends HttpServlet {
    HttpSession session=request.getSession();   // Sessionの開始

    public Teacher getUser(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        Teacher t=new Teacher();
        t.setTeacherId(getTeacherId());
        t.setTeacherPassword(getTeacherPassword());
        t.setTeacherName(getTeacherName());
        t.setSchool(getSchool());

        return t;
    }

    public void setClassNumSet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        ClassNum c=new ClassNum();
        c.setSchoolCd(getSchoolId());
        c.setClassNum(getClassNum());
    }

    public void setEntYearSet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        Student s=new Student();
        s.setEntYear(getEntYear());
    }
    ////------------------ ここまで ---------------
    public void setClassNum(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        ClassNum c=new ClassNum();
        c.setSchoolCd(getSchoolId());
        c.setClassNum(getClassNum());
    }
    public void setClassNum(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        ClassNum c=new ClassNum();
        c.setSchoolCd(getSchoolId());
        c.setClassNum(getClassNum());
    }


}


