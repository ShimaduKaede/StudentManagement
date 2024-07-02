package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;


public class StudentDAO extends DAO {
    private String baseSql; // SQL文を確保する変数

    // getメソッド
    // 引数：sutudentNo
    // 戻り値：Student
    // 学生をIDで取得するメソッド
    public Student get(String studentNo) throws  Exception {

        Connection con=getConnection(); // DBへの接続
        // SQL文
        baseSql = "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD FROM STUDENT WHERE NO = ?";
        PreparedStatement st=con.prepareStatement(baseSql);
        st.setString(1,studentNo);		// SQLに変数studentNoの値をセット
        ResultSet rs=st.executeQuery();	// SQL実行

		//StudentBeanをインスタンス化して情報をセット
		Student student=new Student();

        while (rs.next()) {
			student.setStudentNo(rs.getString("NO"));
			student.setStudentName(rs.getString("NAME"));
			student.setEntYear(rs.getInt("ENT_YEAR"));
			student.setClassNum(rs.getString("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getString("SCHOOL_CD"));
		}

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
        String schoolCd = school.getSchoolCd();

        Connection con=getConnection(); // DBへの接続
        // SQL文
        baseSql = "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD FROM STUDENT WHERE SCHOOL_CD = ?;";
        PreparedStatement st=con.prepareStatement(baseSql);
        st.setString(1,schoolCd);		// SQLに変数schoolCdの値をセット
        ResultSet rs=st.executeQuery();	// SQL実行

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getString("NO"));
			student.setStudentName(rs.getString("NAME"));
			student.setEntYear(rs.getInt("ENT_YEAR"));
			student.setClassNum(rs.getString("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getString("SCHOOL_CD"));

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
        String schoolCd = school.getSchoolCd();

        Connection con=getConnection(); // DBへの接続
        // SQL文
        baseSql = "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD "
                + "FROM STUDENT "
                + "WHERE SCHOOL_CD = ? "
                + "AND ENT_YEAR = ? "
                + "AND CLASS_NUM = ? "
                + "AND IS_ATTEND = ?;";
        PreparedStatement st=con.prepareStatement(baseSql);
        st.setString(1, schoolCd);	// SQLに変数schoolCdの値をセット
        st.setInt(2,entYear);		// SQLに変数entYearの値をセット
        st.setString(3, classNum);	// SQLに変数classNumの値をセット
        st.setBoolean(4, isAttend);	// SQLに変数isAttendの値をセット
        ResultSet rs=st.executeQuery();	// SQL実行

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getString("NO"));
			student.setStudentName(rs.getString("NAME"));
			student.setEntYear(rs.getInt("ENT_YEAR"));
			student.setClassNum(rs.getString("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getString("SCHOOL_CD"));

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
        String schoolCd = school.getSchoolCd();

        Connection con=getConnection(); // DBへの接続
        // SQL文
        baseSql = "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD "
                + "FROM STUDENT "
                + "WHERE SCHOOL_CD = ? "
                + "AND ENT_YEAR = ? "
                + "AND IS_ATTEND = ?;";
        PreparedStatement st=con.prepareStatement(baseSql);
        st.setString(1, schoolCd);	// SQLに変数schoolCdの値をセット
        st.setInt(2,entYear);		// SQLに変数entYearの値をセット
        st.setBoolean(3, isAttend);	// SQLに変数isAttendの値をセット
        ResultSet rs=st.executeQuery();	// SQL実行

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getString("NO"));
			student.setStudentName(rs.getString("NAME"));
			student.setEntYear(rs.getInt("ENT_YEAR"));
			student.setClassNum(rs.getString("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getString("SCHOOL_CD"));

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
        String schoolCd = school.getSchoolCd();

        Connection con=getConnection(); // DBへの接続
        // SQL文
        baseSql = "SELECT NO,NAME,ENT_YEAR,CLASS_NUM,IS_ATTEND,SCHOOL_CD "
            + "FROM STUDENT "
            + "WHERE SCHOOL_CD = ? "
            + "AND IS_ATTEND = ?;";
        PreparedStatement st=con.prepareStatement(baseSql);
        st.setString(1, schoolCd);	// SQLに変数schoolCdの値をセット
        st.setBoolean(2, isAttend);	// SQLに変数isAttendの値をセット
        ResultSet rs=st.executeQuery();	// SQL実行

        while (rs.next()) {
			//StudentBeanをインスタンス化して情報をセット
			Student student=new Student();
			student.setStudentNo(rs.getString("NO"));
			student.setStudentName(rs.getString("NAME"));
			student.setEntYear(rs.getInt("ENT_YEAR"));
			student.setClassNum(rs.getString("CLASS_NUM"));
			student.setIsAttend(rs.getBoolean("IS_ATTEND"));
			student.setSchoolCd(rs.getString("SCHOOL_CD"));

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
    public boolean save(Student student) throws Exception {

        Connection con=getConnection(); // DBへの接続
        // SQL文
        baseSql = "INSERT INTO STUDENT "
                + "(NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) "
                + "VALUES (?, ?, ?, ?, TRUE, ?);";
        PreparedStatement st=con.prepareStatement(baseSql);
        st.setString(1, student.getStudentNo());
        st.setString(2, student.getStudentName());
		st.setInt(3, student.getEntYear());
        st.setString(4, student.getClassNum());
        st.setString(5, student.getSchoolCd());

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
    	Connection con = null;
		try {
			con = getConnection();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} // DBへの接続
        String sql = "UPDATE STUDENT SET NAME = ?, ENT_YEAR = ?, CLASS_NUM = ?, IS_ATTEND = ?, SCHOOL_CD = ? WHERE NO = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, student.getStudentName());
            stmt.setInt(2, student.getEntYear());
            stmt.setString(3, student.getClassNum());
            stmt.setBoolean(4, student.getIsAttend());
            stmt.setString(5, student.getSchoolCd());
            stmt.setString(6, student.getStudentNo());
            return stmt.executeUpdate() > 0;

    }

    // 学生を削除するメソッド
    public boolean delete(String studentNo) throws SQLException {
        String sql = "DELETE FROM STUDENT WHERE NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNo);
            return stmt.executeUpdate() > 0;
        }
    }

}