package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
public class ClassNumDAO {

	// セッションのユーザーデータ(学校コード)から
	// 所属している学校のクラスデータ(学校コード,クラス番号)を取得するメソッド
	public List<String> filter(String schoolCd) throws Exception {
		List<String> classNumList=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"SELECT * FROM CLASS_NUM WHERE SCHOOL_CD = schoolCd");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			classNumList.add(rs.getString("school_cd"));
			classNumList.add(rs.getString("class_num"));
		}

		st.close();
		con.close();

		return classNumList;
	}




}
