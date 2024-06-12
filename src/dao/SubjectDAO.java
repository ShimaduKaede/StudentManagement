package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;

public class SubjectDAO {

    // 科目の詳細データを取得するメソッド
    // 引数：cd,school
    // 戻り値：subject
	public Subject get(String subject_cd, School school) {
		String schoolCd = school.getSchoolCd(); // 学校コードを変数schoolCdに設定

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"SELECT SCHOOL_CD,CD,NAME FROM SUBJECT WHERE SCHOOL_CD = schoolCd AND CD = subject_cd");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			//科目Beanをインスタンス化して情報をセット
			Subject subject=new Subject();
			subject.setSchoolCd(rs.getStriing("SCHOOL_CD"));
			subject.setSubjectCd(rs.getString("CD"));
			subject.setSubjectName(rs.getString("NAME"));

		}

		st.close();
		con.close();

		return subject;

    }

	// セッションのユーザーデータ(学校情報)から
	// ユーザーが所属している学校の科目一覧用データを取得するメソッド
    // 引数：school
    // 戻り値：subject型のList
	public List<Subject> filter(School school) throws Exception {
		List<Subject> subjectList=new ArrayList<>();	// 戻り値で使用する空Listを作成
		String schoolCd = school.getSchoolCd();			// 学校コードを変数schoolCdに設定

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"SELECT SCHOOL_CD,CD,NAME FROM SUBJECT WHERE SCHOOL_CD = schoolCd");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			//科目Beanをインスタンス化して情報をセット
			Subject subject=new Subject();
			subject.setSchoolCd(rs.getStriing("SCHOOL_CD"));
			subject.setSubjectCd(rs.getString("CD"));
			subject.setSubjectName(rs.getString("NAME"));

            subjectList.add(subject);
		}

		st.close();
		con.close();

		return subjectList;

	}

    // 入力された値をDBに保存するメソッド
    // 引数：subject
    // 戻り値：boolen(True or False)
	public boolean save(Subject subject) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"INSERT INTO subject VALUES(?,?,?)");
		st.setString(1, subject.getSchoolCd());
		st.setString(2, subject.getSubjectCd());
		st.setString(3, subject.getSubjectName());
		// insertしたレコード件数が返ってくる
		int line = st.executeUpdate();
        boolean bool;   // 戻り値：保存が成功or失敗(True or False)
        if (line > 0) {
            bool = true;
        } else {
            bool = false;
        }

		st.close();
		con.close();

		return bool;
	}

    // DBから科目を削除するメソッド
    // 引数：subject
    // 戻り値：boolen(True or False)
	public boolean delete(Subject subject) throws Exception {
		Connection con=getConnection();
		String schoolCd = subject.getSchoolCd();			// 学校コードを変数schoolCdに設定
		String subjectCd = subject.getSubjectCd();			// 学校コードを変数schoolCdに設定

		PreparedStatement st=con.prepareStatement(
			"DELETE FROM subject WHERE SCHOOL_CD = schoolCd AND CD = subjectCd");
		// deleteしたレコード件数が返ってくる
		int line = st.executeUpdate();
        boolean bool;   // 戻り値：保存が成功or失敗(True or False)
        if (line > 0) {
            bool = true;
        } else {
            bool = false;
        }

		st.close();
		con.close();

		return bool;
	}

}
