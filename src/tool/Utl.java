// 仕様がまだ少しあいまいなので、適当に作成
package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClassNum;
import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;

public class Utl extends HttpServlet {

    public Teacher getUser(
		HttpServletRequest request
	) throws ServletException, IOException {

		HttpSession session=request.getSession();	// セッションの開始

	    Teacher t=new Teacher();
        t.setTeacherId("admin");
        t.setTeacherPassword("password");
        t.setTeacherName("大原花子");
        School school = new School();
        school.setSchoolCd("oom");
        school.setSchoolName("大宮校");
        t.setSchool(school);

		System.out.println("sessionID："+session.getId());	// セッションID出力

        return t;
    }

    public void setClassNumSet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
        ClassNum c=new ClassNum();
        c.setSchoolCd(c.getSchoolId());
        c.setClassNum(c.getClassNum());
    }

    public void setEntYearSet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        Student s=new Student();
        s.setEntYear(s.getEntYear());
    }

    public void setSubjects(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        Subject s=new Subject();
        s.setSubjectCd(s.getSubjectCd());
        s.setSubjectName(s.getSubjectName());
        s.setSchool(s.school);
    }

    public void setNumSet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        ClassNum c=new ClassNum();
        c.setClassNum(c.getClassNum());
    }


}


