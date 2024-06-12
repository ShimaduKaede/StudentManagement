package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
public class TestListStudentDAO {

    private String baseSql: // ?不明

    // postFilterメソッド
    // 引数：rSetのResultSet型
    // 戻り値：List<TestListStudent型？>
	public List<TestListStudent> postFilter(ResultSet rSet) throws Exception {
        // ひとまず適当
		List<TestListStudent> TestListstudentList=new ArrayList<>();	// 戻り値で使用する空Listを作成
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
		// ここにSQLが入る！
		ResultSet rs=st.executeQuery();

		// while (rs.next()) {
		// 	//科目Beanをインスタンス化して情報をセット
		// 	Student student=new Student();
		// 	student.setSchoolCd(rs.getStriing("SCHOOL_CD"));
		// 	student.setSubjectCd(rs.getString("CD"));
		// 	student.setSubjectName(rs.getString("NAME"));

        //     studentList.add(subject);
		// }

		st.close();
		con.close();

		return TestListstudentList;

	}

    // filterメソッド
    // 引数：int型のentYear String型のclassNum Student型のstudent 
    // 戻り値：List<TestListSubject型？>
	public List<TestListStudent> filter( Student student) throws Exception {
        // ひとまず適当
		List<TestListStudent> TestListstudentList=new ArrayList<>();	// 戻り値で使用する空Listを作成
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
		// ここにSQLが入る！
		ResultSet rs=st.executeQuery();

		// while (rs.next()) {
		// 	//科目Beanをインスタンス化して情報をセット
		// 	Student student=new Student();
		// 	student.setSchoolCd(rs.getString("SCHOOL_CD"));
		// 	student.setStudentCd(rs.getString("CD"));
		// 	student.setStudentName(rs.getString("NAME"));

        //     studentList.add(studet);
		// }

		st.close();
		con.close();

		return TestListstudentList;

    }
}
