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
            "SELECT STUDENT_NO,STUDENT_NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD FROM STUDENT WHERE SCHOOL_CD = schoolCd;");
        ResultSet rs=st.executeQuery();

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getStriing("STUDENT_NO"));
			student.setSchoolName(rs.getStriing("STUDENT_NAME"));
			student.setEntYear(rs.getStriing("ENT_YEAR"));
			student.setClassNum(rs.getStriing("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getStriing("SCHOOL_CO"));

            studentlist.add(student);
		}

        st.close(); 
		con.close();    // DB切断

		return studentlist;
    }

    // filter1メソッド
    // 引数：School型のschool,int型のentYear,String型のclassNum,boolean型のisAttend
    // 戻り値：List<Student>
    public List<Student> filter1(School school,int entYear,String classNum,boolean isAttend
    ) throws Exception {
		List<Student> studentlist=new ArrayList<>();    // 戻り値で使用するstudentlistを作成
		String schoolCd = school.getSchoolCd();			// 学校コードを変数schoolCdに設定
        
        Connection con=getConnection(); // DBへの接続
        PreparedStatement st=con.prepareStatement(
            "SELECT STUDENT_NO,STUDENT_NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD "
            + "FROM STUDENT "
            + "WHERE SCHOOL_CD = schoolCd "
            + "AND ENT_YEAR = entYear "
            + "AND CLASS_NUM = classNum "
            + "AND IS_ATTEND = isAttend;");
        ResultSet rs=st.executeQuery();

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getStriing("STUDENT_NO"));
			student.setSchoolName(rs.getStriing("STUDENT_NAME"));
			student.setEntYear(rs.getStriing("ENT_YEAR"));
			student.setClassNum(rs.getStriing("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getStriing("SCHOOL_CO"));

            studentlist.add(student);
		}

        st.close(); 
		con.close();    // DB切断

		return studentlist;
    }




    // filter2メソッド
    // 引数：School型のschool,int型のentYear,boolean型のisAttend
    // 戻り値：List<Student>
    public List<Student> filter2(School school,int entYear,boolean isAttend
    ) throws Exception {
		List<Student> studentlist=new ArrayList<>();    // 戻り値で使用するstudentlistを作成
		String schoolCd = school.getSchoolCd();			// 学校コードを変数schoolCdに設定
        
        Connection con=getConnection(); // DBへの接続
        PreparedStatement st=con.prepareStatement(
            "SELECT STUDENT_NO,STUDENT_NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD "
            + "FROM STUDENT "
            + "WHERE SCHOOL_CD = schoolCd "
            + "AND ENT_YEAR = entYear "
            + "AND IS_ATTEND = isAttend;");
        ResultSet rs=st.executeQuery();

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getStriing("STUDENT_NO"));
			student.setSchoolName(rs.getStriing("STUDENT_NAME"));
			student.setEntYear(rs.getStriing("ENT_YEAR"));
			student.setClassNum(rs.getStriing("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getStriing("SCHOOL_CO"));

            studentlist.add(student);
		}

        st.close(); 
		con.close();    // DB切断

		return studentlist;
    }

    // filter3メソッド
    // 学生IDを取得 → 学生の詳細データを取得
    // 引数：School型のschool,boolean型のisAttend
    // 戻り値：List<Student>
    public List<Student> filter3(School school,boolean isAttend
    ) throws Exception {
		List<Student> studentlist=new ArrayList<>();    // 戻り値で使用するstudentlistを作成
		String schoolCd = school.getSchoolCd();			// 学校コードを変数schoolCdに設定
        
        Connection con=getConnection(); // DBへの接続
        PreparedStatement st=con.prepareStatement(
            "SELECT STUDENT_NO,STUDENT_NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD "
            + "FROM STUDENT "
            + "WHERE SCHOOL_CD = schoolCd "
            + "AND IS_ATTEND = isAttend;");
        ResultSet rs=st.executeQuery();

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getStriing("STUDENT_NO"));
			student.setSchoolName(rs.getStriing("STUDENT_NAME"));
			student.setEntYear(rs.getStriing("ENT_YEAR"));
			student.setClassNum(rs.getStriing("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getStriing("SCHOOL_CO"));

            studentlist.add(student);
		}

        st.close(); 
		con.close();    // DB切断

		return studentlist;
    }

    // saveメソッド
    // 入力された値をDBに保存する
    // 引数：Student型のstudent
    // 戻り値：boolean
    // 学生を保存(追加)するメソッド
    public boolean save(Stuent student) throws Exception {
        
        Connection con=getConnection(); // DBへの接続
        PreparedStatement st=con.prepareStatement(
            "INSERT INTO STUDENT "
            + "(STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) "
            + "VALUES (?, ?, ?, ?, ?, ?);");

        st.setString(1, student.getStudentNo());
        st.setString(2, student.getStudentName());
		st.setInt(3, student.getEntYear());
        st.setString(4, student.getClassNum());
        st.setBoolean(5, student.getIsAttend());
        st.setString(6, student.getSchoolCd());
		// insertしたレコード件数が返ってくる
		int line = st.executeUpdate();

        boolean flg = false;
        if (line > 0){
            flg = true;
        } else {
            flg = false;
        }
        
        st.close(); 
        con.close();    // DB切断

        return flg;
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

 
}