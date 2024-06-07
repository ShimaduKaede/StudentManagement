package bean;

import java.io.Serializable;
import bean.School;
import bean.Student;
import bean.Subject;

public class Test implements Serializable {

    private Student student;    // 学生(学生番号,氏名,入学年度,クラス番号,在籍中フラグ,学校(学校コード,学校名))
    private String classNum;    // クラス番号
    private Subject subject;    // 科目(学校コード,科目コード,科目名)
    private School school;      // 学校(学校コード,学校名)
    private int testNo;         // 回数
    private int point;          // 得点


    
	// 学生情報を取得(ゲット)メソッド
	public Stirng getStudent() {
		return student;
	}
	// 学生情報を設置（セット）メソッド
	public void setStudent(Student student) {
		this.student=student;
	}

	// クラス番号を取得(ゲット)メソッド
	public String getClassNum() {
		return classNum;
	}
	// クラス番号を設置（セット）メソッド
	public void setClassNum(String classNum) {
		this.classNum=classNum;
	}

	// 科目情報を取得(ゲット)メソッド
	public Subject getSubject() {
		return subject;
	}
	// 科目情報を設置（セット）メソッド
	public void setSubject(Subject subject) {
		this.subject=subject;
	}

	// 学校情報(学校コード、学校名)を取得(ゲット)メソッド
	public School getSchool() {
		return school;
	}
	// 学校情報(学校コード、学校名)を設置（セット）メソッド
	public void setSchool(school student_no) {
		this.student_no=student_no;
	}

	// SchoolYear(?) 何かを取得(ゲット)メソッド
	// 仕様が不明のため、ひとまずentYearを返す
	public int getSchoolYear() {
		return entYear;
	}

}

