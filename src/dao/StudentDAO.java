package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;


public class StudentDAO extends DAO {

    // 学生をIDで取得するメソッド
    public Student get(String studentNo) throws Exception {
        Student student = null;
        String sql = "SELECT STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM STUDENT WHERE STUDENT_NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setStudentNo(rs.getString("STUDENT_NO"));
                    student.setStudentName(rs.getString("STUDENT_NAME"));
                    student.setEntYear(rs.getInt("ENT_YEAR"));
                    student.setClassNum(rs.getString("CLASS_NUM"));
                    student.setIsAttend(rs.getBoolean("IS_ATTEND"));
                    student.setSchoolCd(rs.getString("SCHOOL_CD"));
                }
            }
        }
        return student;
    }

    // 学生リストを取得するメソッド
    public List<Student> getAllStudents() throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM STUDENT";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentNo(rs.getString("STUDENT_NO"));
                student.setStudentName(rs.getString("STUDENT_NAME"));
                student.setEntYear(rs.getInt("ENT_YEAR"));
                student.setClassNum(rs.getString("CLASS_NUM"));
                student.setIsAttend(rs.getBoolean("IS_ATTEND"));
                student.setSchoolCd(rs.getString("SCHOOL_CD"));
                studentList.add(student);
            }
        }
        return studentList;
    }

    // 学生を追加するメソッド
    public boolean save(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT (STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentNo());
            stmt.setString(2, student.getStudentName());
            stmt.setInt(3, student.getEntYear());
            stmt.setString(4, student.getClassNum());
            stmt.setBoolean(5, student.getIsAttend());
            stmt.setString(6, student.getSchool().getSchoolCd());
            return stmt.executeUpdate() > 0;
        }
    }

    // 学生を更新するメソッド
    public boolean update(Student student) throws Exception {
        String sql = "UPDATE STUDENT SET STUDENT_NAME = ?, ENT_YEAR = ?, CLASS_NUM = ?, IS_ATTEND = ?, SCHOOL_CD = ? WHERE STUDENT_NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentName());
            stmt.setInt(2, student.getEntYear());
            stmt.setString(3, student.getClassNum());
            stmt.setBoolean(4, student.getIsAttend());
            stmt.setString(5, student.getSchool().getSchoolCd());
            stmt.setString(6, student.getStudentNo());
            return stmt.executeUpdate() > 0;
        }
    }

    // 学生を削除するメソッド
    public boolean delete(String studentNo) throws Exception {
        String sql = "DELETE FROM STUDENT WHERE STUDENT_NO = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentNo);
            return stmt.executeUpdate() > 0;
        }
    }

    // 学校フィルタで学生リストを取得するメソッド
    public List<Student> filter(School school, boolean isAttend) throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT STUDENT_NO, STUDENT_NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM STUDENT WHERE SCHOOL_CD = ? AND IS_ATTEND = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getSchoolCd());
            stmt.setBoolean(2, isAttend);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setStudentNo(rs.getString("STUDENT_NO"));
                    student.setStudentName(rs.getString("STUDENT_NAME"));
                    student.setEntYear(rs.getInt("ENT_YEAR"));
                    student.setClassNum(rs.getString("CLASS_NUM"));
                    student.setIsAttend(rs.getBoolean("IS_ATTEND"));
                    student.setSchool(school);
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }
}