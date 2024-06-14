// 仕様がまだ少しあいまいなので、適当に作成
package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  // Sessionを使用するためインポート

import bean.Teacher;
import bean.ClassNum;
import bean.School;
import bean.Student;
import bean.Subject;

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

    public void setSubjects(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        Subject s=new Subject();
        s.setSubjectCd(getSubjectCd());
        s.setSubjectName(getSubjectName());
        s.setSchool(school);
    }

    public void setNumSet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        ClassNum c=new ClassNum();
        c.setClassNum(getClassNum());
    }


}


