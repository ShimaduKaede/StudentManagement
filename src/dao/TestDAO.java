package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Test;

public class TestDAO extends DAO {
String basesql ;
    // 学生を全件取得する studentAll メソッド
    public List<Test> get(School school, String cd) throws Exception {
        List<Test> test = new ArrayList<>();

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT * WHERE SCHOOL_CD = ? AND SUBJECT_CD = ?"
        );
        st.setString(1, school.getSchoolCd());
        st.setString(2, cd);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test t = new Test();
            t.setStudent(rs.getString("STUDENT_NO"));
            t.setSubject(rs.getString("SUBJECT_CD"));
            t.setTestNo(rs.getInt("NO"));
            t.setPoint(rs.getInt("POINT"));

            test.add(t);
        }

        rs.close();
        st.close();
        con.close();

        return test;
    }


    public List<Test> ListStudent(String studentCd) throws Exception {
        List<Test> ListStudent = new ArrayList<>();

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT test.STUDENT_NO,test.SUBJECT_CD,test.SCHOOL_CD,test.NO,test.POINT,subject.name,student.name from test join student on student.no=test.student_no join subject on subject.cd=test.subject_cd  WHERE STUDENT_NO=?"
        );
        st.setString(1, studentCd);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
            test.setStudentname(rs.getString("student.name"));
            test.setStudent(rs.getString("STUDENT_NO"));
            test.setSubject(rs.getString("SUBJECT_CD"));
            test.setTestNo(rs.getInt("NO"));
            test.setPoint(rs.getInt("POINT"));
            test.setSubjectname(rs.getString("subject.name"));

            ListStudent.add(test);
        }


        return ListStudent;
    }



    public List<Test> ListSubject(int ent_year,String class_num,String subject_name) throws Exception {
        List<Test> ListSubject = new ArrayList<>();

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT subject.name as subjectname,test.subject_cd,student.ent_year,test.class_num,student.name as studentname ,student.no as student_no ,test.no,test.point from test join subject on subject.cd=test.subject_cd join student on student.class_num=test.class_num where student.ent_year=? and subject.name='?' and test.class_num='?'"
        );
        st.setInt(1, ent_year);
        st.setString(2, subject_name);
        st.setString(3, class_num);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
            test.setSubjectname(rs.getString("subject.name"));
            test.setStudent(rs.getString("student.no"));
            test.setStudentname(rs.getString("student.name"));
            test.setTestNo(rs.getInt("NO"));
            test.setPoint(rs.getInt("POINT"));

            ListSubject.add(test);
        	}
        	return ListSubject;
        }

    public List<Test> get(String student, String subject, String school, int no) throws Exception {
    	List<Test> tests = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT * FROM TEST WHERE STUDENT_NO = ? AND SUBJECT_CD = ? AND SCHOOL_CD = ? AND NO = ?"
        );
        st.setString(1, student);
        st.setString(2, subject);
        st.setString(3, school);
        st.setInt(4, no);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
                rs.getString("STUDENT_NO");
                rs.getString("SUBJECT_CD");
                rs.getString("SCHOOL_CD");
                rs.getInt("CLASS_NUM");
                rs.getObject("POINT", Integer.class);
                rs.getInt("NO");
            tests.add(test);
        }

        rs.close();
        st.close();
        con.close();

        return tests;
    }


    public List<Test> filter(String classNum, String subject, int num, String school,int ent_year) throws Exception {
        List<Test> tests = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT * FROM TEST join student on test.student_no=student.no WHERE test.CLASS_NUM = ? AND test.SUBJECT_CD = ? AND test.NO = ? AND test.SCHOOL_CD = ? and student.ent_year=?"
        );
        st.setString(1, classNum);
        st.setString(2, subject);
        st.setInt(3, num);
        st.setString(4, school);
        st.setInt(5,ent_year);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Test test = new Test();
                rs.getString("STUDENT_NO");
                rs.getString("SUBJECT_CD");
                rs.getString("SCHOOL_CD");
                rs.getInt("CLASS_NUM");
                rs.getObject("POINT", Integer.class);
                rs.getInt("NO");
            tests.add(test);
        }

        rs.close();
        st.close();
        con.close();

        return tests;
    }

    public boolean save(List<Test> list) throws Exception {
        for (Test test : list) {
            save(test);
        }
        return true;
    }

    public boolean save(Test test) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "INSERT INTO TEST (STUDENT_NO, SUBJECT_CD, SCHOOL_CD, NO, POINT, CLASS_NUM) VALUES (?, ?, ?, ?, ?, ?)"
        );
        st.setString(1, test.getStudent());
        st.setString(2, test.getSubject());
        st.setString(3, test.getSchool());
        st.setInt(4, test.getTestNo());
        st.setObject(5, test.getPoint(), java.sql.Types.INTEGER);
        st.setString(6, test.getClassNum());
        st.executeUpdate();

        st.close();
        con.close();

        return true;
    }

    public boolean delete(List<Test> list) throws Exception {
        for (Test test : list) {
            delete(test);
        }
        return true;
    }

    public boolean delete(Test test) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "DELETE FROM TEST WHERE STUDENT_NO = ? AND SUBJECT_CD = ? AND SCHOOL_CD = ? AND NO = ?"
        );
        st.setString(1, test.getStudent());
        st.setString(2, test.getSubject());
        st.setString(3, test.getSchool());
        st.setInt(4, test.getTestNo());
        st.executeUpdate();

        st.close();
        con.close();

        return true;
    }

    }
