package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.School;
public class StudentDao extends Dao {
    String baseSql; // おそらくSQL文を確保する変数

    // getメソッド
    // 引数：sutudentNo
    // 戻り値：Student
    // 学生をIDで取得するメソッド
    public Student get(String studentNo) throws  Exception {
        student=new Student();	// 戻り値で使用するstudentを作成
    
        Connection con=getConnection(); // DBへの接続
        PreparedStatement st=con.prepareStatement(
            "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD FROM STUDENT WHERE SCHOOL_CD = schoolCd");
        ResultSet rs=st.executeQuery();

        st.close(); 
		con.close();    // DB切断

        return student;
    }

    // postFilterメソッド
    // セッションのユーザーデータから、
    // ユーザが所属している学校の生徒一覧用データを取得
    // 引数：ResultSet型のrSet,School型のschool
    // 戻り値：List<Student>
    public List<Student> postFilter(ResultSet rSet,School school) throws Exception {
		List<Student> studentlist=new ArrayList<>();    // 戻り値で使用するstudentlistを作成
		String schoolCd = school.getSchoolCd();			// 学校コードを変数schoolCdに設定
        
        Connection con=getConnection(); // DBへの接続
        PreparedStatement st=con.prepareStatement(
            "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD FROM STUDENT WHERE SCHOOL_CD = schoolCd");
        ResultSet rs=st.executeQuery();
// -------------------- ここまで --------------------
		while (rs.next()) {
			//科目Beanをインスタンス化して情報をセット
			Subject subject=new Subject();
			subject.setSchoolCd(rs.getStriing("SCHOOL_CD"));
			subject.setSubjectCd(rs.getString("CD"));
			subject.setSubjectName(rs.getString("NAME"));

            subjectList.add(subject);
		}

        st.close(); 
		con.close();    // DB切断

		return subjectList;
    }

    // filter1メソッド
    // 引数：School型のschool,int型のentYear,String型のclassNum,boolean型のisAttend
    // 戻り値：List<Student>

    // filter2メソッド
    // 引数：School型のschool,int型のentYear,boolean型のisAttend
    // 戻り値：List<Student>

    // filter3メソッド
    // 学生IDを取得 → 学生の詳細データを取得
    // 引数：School型のschool,boolean型のisAttend
    // 戻り値：List<Student>

    // saveメソッド
    // 入力された値をDBに保存する
    // 引数：Student型のstudent
    // 戻り値：boolean






    // 学生をIDで取得するメソッド
    public Student get(String studentNo) throws SQLException {
        Student student = null;
        String sql = "SELECT STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM STUDENT WHERE STUDENT_NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setStudentNo(rs.getString("STUDENT_NO"));
                    student.setStudentName(rs.getString("STUDENT_NAME"));
                    student.setEntYear(rs.getInt("ENT_YEAR"));
                    student.setClassNum(rs.getString("CLASS_NUM"));
                    student.setAttend(rs.getBoolean("IS_ATTEND"));
                    student.setSchool(new School(rs.getString("SCHOOL_CD")));
                }
            }
        }
        return student;
    }

    // 学生リストを取得するメソッド
    public List<Student> getAllStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM STUDENT";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentNo(rs.getString("STUDENT_NO"));
                student.setStudentName(rs.getString("STUDENT_NAME"));
                student.setEntYear(rs.getInt("ENT_YEAR"));
                student.setClassNum(rs.getString("CLASS_NUM"));
                student.setAttend(rs.getBoolean("IS_ATTEND"));
                student.setSchool(new School(rs.getString("SCHOOL_CD")));
                studentList.add(student);
            }
        }
        return studentList;
    }

    // 学生を追加するメソッド
    public boolean save(Student student) throws SQLException {
        String sql = "INSERT INTO STUDENT (STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentNo());
            stmt.setString(2, student.getStudentName());
            stmt.setInt(3, student.getEntYear());
            stmt.setString(4, student.getClassNum());
            stmt.setBoolean(5, student.isAttend());
            stmt.setString(6, student.getSchool().getCd());
            return stmt.executeUpdate() > 0;
        }
    }

    // 学生を更新するメソッド
    public boolean update(Student student) throws SQLException {
        String sql = "UPDATE STUDENT SET STUDENT_NAME = ?, ENT_YEAR = ?, CLASS_NUM = ?, IS_ATTEND = ?, SCHOOL_CD = ? WHERE STUDENT_NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentName());
            stmt.setInt(2, student.getEntYear());
            stmt.setString(3, student.getClassNum());
            stmt.setBoolean(4, student.isAttend());
            stmt.setString(5, student.getSchool().getCd());
            stmt.setString(6, student.getStudentNo());
            return stmt.executeUpdate() > 0;
        }
    }

    // 学生を削除するメソッド
    public boolean delete(String studentNo) throws SQLException {
        String sql = "DELETE FROM STUDENT WHERE STUDENT_NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNo);
            return stmt.executeUpdate() > 0;
        }
    }

    // 学校フィルタで学生リストを取得するメソッド
    public List<Student> filter(School school, boolean isAttend) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM STUDENT WHERE SCHOOL_CD = ? AND IS_ATTEND = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getCd());
            stmt.setBoolean(2, isAttend);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setStudentNo(rs.getString("STUDENT_NO"));
                    student.setStudentName(rs.getString("STUDENT_NAME"));
                    student.setEntYear(rs.getInt("ENT_YEAR"));
                    student.setClassNum(rs.getString("CLASS_NUM"));
                    student.setAttend(rs.getBoolean("IS_ATTEND"));
                    student.setSchool(school);
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }
}