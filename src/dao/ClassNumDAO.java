package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
public class ClassNumDAO {

	// セッションのユーザーデータ(学校情報)から
	// 所属している学校のクラスデータ(学校コード,クラス番号)を取得するメソッド
	public List<String> filter(School school) throws Exception {
		List<String> classNumList=new ArrayList<>();	// 戻り値で使用する空Listを作成
		String schoolCd = school.getSchoolCd();			// 学校コードを変数schoolCdに設定

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"SELECT SCHOOL_CD,CLASS_NUM FROM CLASS_NUM WHERE SCHOOL_CD = schoolCd");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			classNumList.add(rs.getString("SCHOOL_CD"));
			classNumList.add(rs.getString("CLASS_NUM"));
		}

		st.close();
		con.close();

		return classNumList;
	}

}
