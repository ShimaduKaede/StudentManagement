package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;
import bean.Teacher;

public class TeacherDAO extends DAO {

    public Teacher get(String teacherId) throws Exception {
        Teacher teacher = null;
        try (Connection con = getConnection()) {
            String query = "SELECT * FROM teacher WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, teacherId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setTeacherPassword(rs.getString("teacherPassword"));
                teacher.setTeacherName(rs.getString("teacherName"));

                School school = new School();
                school.setSchoolCd(rs.getString("schoolCd"));
                school.setSchoolName(rs.getString("schoolName"));
                teacher.setSchool(school);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("教師の取得エラー", e);
        }
        return teacher;
    }

    public Teacher login(String teacherId, String teacherPassword) throws Exception {
        Teacher teacher = null;
        try (Connection con = getConnection()) {
            String query = "SELECT * FROM teacher WHERE id=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, teacherId);
            ps.setString(2, teacherPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setTeacherPassword(rs.getString("teacherPassword"));
                teacher.setTeacherName(rs.getString("teacherName"));

                School school = new School();
                school.setSchoolCd(rs.getString("schoolCd"));
                school.setSchoolName(rs.getString("schoolName"));
                teacher.setSchool(school);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("教師のログインエラー", e);
        }
        return teacher;
    }
}


