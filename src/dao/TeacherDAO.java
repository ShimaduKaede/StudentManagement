package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Teacher;


public class TeacherDAO extends DAO{
		public List<Teacher> login(String teacherId , String teacherPassword) throws Exception {
			List<Teacher> teacher=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
			"SELECT *  FROM TEACHER WHERE id = ? AND password = ?");
			st.setString(1, teacherId);
			st.setString(2, teacherPassword);
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				Teacher p=new Teacher();
				// getのなかの引数はｓｑｌのカラム名をとってきている
				p.setTeacherId(rs.getString("ID"));
				p.setTeacherPassword(rs.getString("PASSWORD"));
				p.setTeacherName(rs.getString("NAME"));

				 School school = new School();
				    school.setSchoolCd(rs.getString("SCHOOL_CD"));
				    p.setSchool(school);

				if (teacherPassword.equals(p.getTeacherPassword())) {
				teacher.add(p);

				}}
				st.close();
				con.close();

					return teacher;


			}


			public List<Teacher> get(String teacherId) throws Exception {
				List<Teacher> teacher=new ArrayList<>();

				Connection con=getConnection();


				PreparedStatement st=con.prepareStatement(
					"SELECT * FROM SUBJECT WHERE ID = ?");
					st.setString(1 , teacherId);
				ResultSet rs=st.executeQuery();

				while (rs.next()) {
					Teacher teacherList = new Teacher();
					teacherList.setTeacherId(rs.getString("ID"));
					teacherList.setTeacherName(rs.getString("NAME"));
					teacherList.setTeacherPassword(rs.getString("PASSWORD"));

					School school = new School();
					school.setSchoolCd(rs.getString("SCHOOL_CD"));


					teacher.add(teacherList);
				}

				st.close();
				con.close();

				return teacher;
			}
}

