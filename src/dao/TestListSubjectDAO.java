package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
public class TestListSubjectDAO {

    private String baseSql: // ?不明

    // postFilterメソッド
    // 引数：rSetのResultSet型
    // 戻り値：List<TestListSubject型？>
	public List<TestListSubject> postFilter(ResultSet rSet) throws Exception {
        // ひとまず適当
		List<TestListSubject> TestListsubjectList=new ArrayList<>();	// 戻り値で使用する空Listを作成
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
		// ここにSQLが入る！
		ResultSet rs=st.executeQuery();

		// while (rs.next()) {
		// 	//科目Beanをインスタンス化して情報をセット
		// 	Subject subject=new Subject();
		// 	subject.setSchoolCd(rs.getStriing("SCHOOL_CD"));
		// 	subject.setSubjectCd(rs.getString("CD"));
		// 	subject.setSubjectName(rs.getString("NAME"));

        //     subjectList.add(subject);
		// }

		st.close();
		con.close();

		return TestListsubjectList;

	}

    // filterメソッド
    // 引数：int型のentYear String型のclassNum Subject型のsubject School型のschool
    // 戻り値：List<TestListSubject型？>
	public List<TestListSubject> filter(int entYear,String classNum,Subject subject, School school) throws Exception {
        // ひとまず適当
		List<TestListSubject> TestListsubjectList=new ArrayList<>();	// 戻り値で使用する空Listを作成
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
		// ここにSQLが入る！
		ResultSet rs=st.executeQuery();

		// while (rs.next()) {
		// 	//科目Beanをインスタンス化して情報をセット
		// 	Subject subject=new Subject();
		// 	subject.setSchoolCd(rs.getStriing("SCHOOL_CD"));
		// 	subject.setSubjectCd(rs.getString("CD"));
		// 	subject.setSubjectName(rs.getString("NAME"));

        //     subjectList.add(subject);
		// }

		st.close();
		con.close();

		return TestListsubjectList;

    }
}
