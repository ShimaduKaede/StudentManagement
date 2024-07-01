package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {
	private String baseSql; // SQL文を確保する変数
    // 科目の詳細データを取得するメソッド
    // 引数：cd, school
    // 戻り値：subject
    public Subject get(String subject_cd, School school) throws Exception {
        String schoolCd = school.getSchoolCd(); // 学校コードを変数schoolCdに設定

        Connection con = getConnection();
     // SQL文
        baseSql = "SELECT SCHOOL_CD, CD, NAME FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?";
        PreparedStatement st = con.prepareStatement(baseSql);
        st.setString(1, schoolCd);
        st.setString(2, subject_cd);

        ResultSet rs = st.executeQuery();

        // 科目Beanをインスタンス化して情報をセット
        Subject subject = new Subject();
        while (rs.next()) {
            subject.setSchoolCd(rs.getString("SCHOOL_CD"));
            subject.setSubjectCd(rs.getString("CD"));
            subject.setSubjectName(rs.getString("NAME"));
        }

        rs.close(); // リソースをクローズ
        st.close();
        con.close();

        return subject;
    }

    // セッションのユーザーデータ(学校情報)から
    // ユーザーが所属している学校の科目一覧用データを取得するメソッド
    // 引数：school
    // 戻り値：subject型のList
    public List<Subject> filter(School school) throws Exception {
        List<Subject> subjectList = new ArrayList<>(); // 戻り値で使用する空Listを作成
        String schoolCd = school.getSchoolCd(); // 学校コードを変数schoolCdに設定

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT SCHOOL_CD, CD, NAME FROM SUBJECT WHERE SCHOOL_CD = ?");
        st.setString(1, schoolCd);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            // 科目Beanをインスタンス化して情報をセット
            Subject subject = new Subject();
            subject.setSchoolCd(rs.getString("SCHOOL_CD"));
            subject.setSubjectCd(rs.getString("CD"));
            subject.setSubjectName(rs.getString("NAME"));

            subjectList.add(subject);
        }

        rs.close(); // リソースをクローズ
        st.close();
        con.close();

        return subjectList;
    }

    // 入力された値をDBに保存するメソッド
    // 引数：subject
    // 戻り値：boolean (True or False)
    public boolean save(Subject subject) throws Exception {
        Connection con = getConnection();
        //SQL文
        baseSql = "INSERT INTO SUBJECT(SCHOOL_CD, CD, NAME) VALUES(?,?,?)";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(baseSql);
            st.setString(1, subject.getSchool().getSchoolCd());
            st.setString(2, subject.getSubjectCd());
            st.setString(3, subject.getSubjectName());

            // insertしたレコード件数が返ってくる
            int line = st.executeUpdate();
            return line > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (st != null) st.close();
            con.close();
        }
    }

    // DBから科目を削除するメソッド
    // 引数：subject
    // 戻り値：boolean (True or False)
    public boolean delete(Subject subject) throws Exception {
        Connection con = getConnection();
        baseSql =  "DELETE FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(baseSql);
            st.setString(1, subject.getSchool().getSchoolCd());
            st.setString(2, subject.getSubjectCd());

            // deleteしたレコード件数が返ってくる
            int line = st.executeUpdate();
            return line > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (st != null) st.close();
            con.close();
        }
    }


    // 科目を更新するメソッド
    public boolean update(Subject subject) throws Exception {
        String sql = "UPDATE SUBJECT SET NAME = ? WHERE SCHOOL_CD = ? and CD = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, subject.getSubjectName());
            stmt.setString(2, subject.getSchoolCd());
            stmt.setString(3, subject.getSubjectCd());
            return stmt.executeUpdate() > 0;
        }
    }
}
