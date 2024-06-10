package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;
import bean.Teacher;

public class TeacherDao extends DAO {

    public Teacher get(String id) throws Exception {
        Teacher teacher = null;
        try (Connection con = getConnection()) {
            String query = "SELECT t.teacherId, t.teacherPassword, t.teacherName, s.schoolCd, s.schoolName " +
                           "FROM Teachers t " +
                           "JOIN Schools s ON t.schoolCd = s.schoolCd " +
                           "WHERE t.teacherId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
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
            throw new Exception("Error retrieving teacher", e);
        }
        return teacher;
    }

    public Teacher login(String id, String password) throws Exception {
        Teacher teacher = null;
        try (Connection con = getConnection()) {
            String query = "SELECT t.teacherId, t.teacherPassword, t.teacherName, s.schoolCd, s.schoolName " +
                           "FROM Teachers t " +
                           "JOIN Schools s ON t.schoolCd = s.schoolCd " +
                           "WHERE t.teacherId = ? AND t.teacherPassword = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, password);
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
            throw new Exception("Error logging in teacher", e);
        }
        return teacher;
    }
}
