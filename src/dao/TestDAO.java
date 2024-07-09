package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Test;

public class TestDAO extends DAO {
    private String baseSql; // SQL文
    // 学生を全件取得する studentAll メソッド
    public List<Test> get(School school, String cd) throws Exception {
        List<Test> test = new ArrayList<>();

        Connection con = getConnection();
        // SQL文
        baseSql = "SELECT * WHERE SCHOOL_CD = ? AND SUBJECT_CD = ?";
        PreparedStatement st = con.prepareStatement(baseSql);
        st.setString(1, school.getSchoolCd());  // SQL文に学校コードをセット
        st.setString(2, cd);                    // SQL文に科目コードをセット
        ResultSet rs = st.executeQuery();       // SQL実行

        while (rs.next()) {
            Test t = new Test();
            t.setStudentno(rs.getString("STUDENT_NO"));
            t.setSubjectCd(rs.getString("SUBJECT_CD"));
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
        // SQL文
        baseSql = "SELECT test.STUDENT_NO,test.SUBJECT_CD,"
                + "test.SCHOOL_CD,test.NO,test.POINT,subject.name, "
                + "student.name from test "
                + "join student on student.no=test.student_no "
                + "join subject on subject.cd=test.subject_cd "
                + "WHERE STUDENT_NO=?";
        PreparedStatement st = con.prepareStatement(baseSql);
        st.setString(1, studentCd);         // SQL文に学生コードをセット
        ResultSet rs = st.executeQuery();   // SQl実行

        while (rs.next()) {
            Test test = new Test();
            test.setStudentname(rs.getString("student.name"));
            test.setStudentno(rs.getString("STUDENT_NO"));
            test.setSubjectCd(rs.getString("SUBJECT_CD"));
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
        baseSql = "SELECT distinct subject.name as subjectname,test.subject_cd,student.ent_year,test.class_num,student.name as studentname ,student.no as student_no ,test.point, (select point as point2 from test where no=2 and subject_cd=(select cd from subject where name=? ))   as point2 from test join subject on subject.cd=test.subject_cd join student on student.class_num=test.class_num left join (select point as point2,student_no,subject_cd from test where no=2)  as A on student.no=A.student_no  where student.ent_year=? and subject.name=? and test.class_num=? and test.no=1 ";
        PreparedStatement st = con.prepareStatement(baseSql);
        st.setString(1, subject_name);
        st.setInt(2, ent_year);         // SQL文に入学年度をセット
        st.setString(3, subject_name);  // SQL文に科目名をセット
        st.setString(4, class_num);     // SQL文にクラス番号をセット
        ResultSet rs = st.executeQuery();   // SQL実行

        while (rs.next()) {
            Test test = new Test();
            test.setSubjectname(rs.getString("subject.name"));
            test.setStudentno(rs.getString("student.no"));
            test.setStudentname(rs.getString("student.name"));
            test.setTestNo(rs.getInt("NO"));
            test.setPoint(rs.getInt("POINT"));
            test.setPoint2(rs.getInt("POINT2"));


            ListSubject.add(test);
        }
        return ListSubject;
    }



    public List<Test> Listregist(int ent_year,String class_num,String subject_name,int no) throws Exception {
        List<Test> Listregist = new ArrayList<>();
        Connection con = getConnection();
        baseSql = "SELECT student.no, student.name, test.subject_cd, test.point, subject.name AS subject_name FROM student LEFT JOIN test ON student.no = test.student_no AND (test.no = ? OR test.no IS NULL) LEFT JOIN subject ON test.subject_cd = subject.cd WHERE student.ent_year = ? AND student.class_num = ? AND (subject.name = ? OR subject.name IS NULL)";
        PreparedStatement st = con.prepareStatement(baseSql);
        st.setInt(1, no);
        st.setInt(2, ent_year);         // SQL文に入学年度をセット
        st.setString(3, class_num);     // SQL文にクラス番号をセット
        st.setString(4, subject_name);  // SQL文に科目名をセット


        ResultSet rs = st.executeQuery();   // SQL実行

        while (rs.next()) {
            Test test = new Test();
            test.setStudentno(rs.getString("student.no"));
            test.setStudentname(rs.getString("student.name"));
            test.setPoint(rs.getInt("POINT"));
            test.setSubjectCd(rs.getString("test.subject_cd"));

            Listregist.add(test);
        }
        System.out.println(Listregist);
        return Listregist;
    }


    public List<Test> get(String studentNo, String subjectCd, String schoolCd, int no
    ) throws Exception {
    	List<Test> tests = new ArrayList<>();
        Connection con = getConnection();
        // SQL文
        baseSql = "SELECT STUDENT_NO,SUBJECT_CD,SCHOOL_CD,NO. "
                + "POINT,CLASS_NUM "
                + "FROM TEST "
                + "WHERE STUDENT_NO = ? AND SUBJECT_CD = ? "
                + "AND SCHOOL_CD = ? AND NO = ?";
        PreparedStatement st = con.prepareStatement(baseSql);
        st.setString(1, studentNo); // SQL文に学生番号をセット
        st.setString(2, subjectCd); // SQL文に科目コードをセット
        st.setString(3, schoolCd);  // SQL文に学校コードをセット
        st.setInt(4, no);           // SQL文に回数をセット
        ResultSet rs = st.executeQuery();   // SQL実行

        while (rs.next()) {
            Test test = new Test();
            test.setPoint(rs.getInt("POINT"));

            tests.add(test);
        }
        System.out.println(tests);
        return tests;
    }

    // insert文
    public boolean Insert(String classNum, String subjectname, int no, String schoolCd,String studentno,int point) throws Exception {
        Connection con = getConnection();
     // SQL文
        System.out.println(subjectname);
        baseSql = "insert into test (student_no,subject_cd,school_cd,no,point,class_num)  values (?,(select cd from subject where name=?),?,?,?,?)";
        PreparedStatement st = con.prepareStatement(baseSql);

        st.setString(1, studentno); // SQL文に学生番号をセット
        st.setString(2, subjectname); // SQL文に科目名をセット
        st.setString(3, schoolCd);  // SQL文に学校コードをセット
        st.setInt(4, no);            // SQL文に回数をセット
        st.setInt(5, point);		//点数をセット
        st.setString(6, classNum);  // SQL文にクラス番号をセット
        st.executeUpdate(); // SQL実行

        st.close();
        con.close();
        return true;

    }

    // update文
    public boolean Update(String classNum, String subjectCd, int no, String schoolCd,String studentno,int point) throws Exception {
        Connection con = getConnection();
    	// SQL文
        baseSql = "UPDATE TEST SET "
                + "point=? where "
                + "SUBJECT_CD=? and "
                + "SCHOOL_CD=? and "
                + "student_no=? and "
                + "NO=? and "
                + "CLASS_NUM=? ";
        PreparedStatement st = con.prepareStatement(baseSql);

        st.setInt(1, point);
        st.setString(2, subjectCd); // SQL文に科目コードをセット
        st.setString(3, schoolCd);  // SQL文に学校コードをセット
        st.setString(4, studentno); // SQL文に学生番号をセット
        st.setInt(5, no);            // SQL文に回数をセット
        st.setString(6, classNum);  // SQL文にクラス番号をセット
        st.executeUpdate(); // SQL実行

        st.close();
        con.close();

        return true;
    }

}
