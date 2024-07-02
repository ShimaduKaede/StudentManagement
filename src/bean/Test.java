package bean;

import java.io.Serializable;

public class Test implements Serializable {
    private Student student;	// 学生情報
	private String studentNo;	// 学生番号
    private String studentName;	// 学生名
    private String classNum;    // クラス番号
	private Subject subject;	// 科目情報(学校コード,科目コード,科目名)
    private String schoolCd;    // 学校コード
    private String subjectCd;   // 科目コード
    private String subjectName;	// 科目名
	private School school;		// 学校情報(学校コード,学校名)
	private String schoolName;	// 学校名
    private int testNo;         // 回数
    private int point;          // 得点
    private int point2;

	// 学生番号を取得(ゲット)メソッド
	public Student getStudent() {
		return student;
	}
	// 学生情報を設置（セット）メソッド
	public void setStudent(Student student) {
		this.studentNo=student.studentNo;
		this.studentName=student.studentName;
		this.entYear=student.entYear;
		this.classNum=student.classNum;
		this.isAttend=student.isAttend;
		this.schoolCd=student.schoolCd;
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
		this.schoolCd=schoolCd;
		this.subjectCd=subjectCd;
		this.subjectName=subjectName;
	}
	// 学校情報(学校コード、学校名)を取得(ゲット)メソッド
	public School getSchool() {
		return school;
	}
	// 学校情報(学校コード、学校名)を設置（セット）メソッド
	public void setSchool(School school) {
		this.schoolCd=school.schoolCd;
		this.schoolName=school.schoolName;
	}

	// 回数を取得(ゲット)メソッド
	public int getTestNo() {
		return testNo;
	}
	// 回数を設置(セット)メソッド
	public void setTestNo(int testNo) {
		this.testNo=testNo;
	}

    // 得点を取得(ゲット)メソッド
	public int getPoint() {
		return point;
	}
	// 得点を設置(セット)メソッド
	public void setPoint(int point) {
		this.point=point;
	}

	// 科目名を取得(ゲット)メソッド
	public String getSubjectname() {
		return subjectName;
	}
	// 科目名を設置（セット）メソッド
	public void setSubjectname(String subjectName) {
		this.subjectName=subjectName;
	}


	// 科目名を取得(ゲット)メソッド
	public String getStudentname() {
		return studentName;
	}
	// 科目名を設置（セット）メソッド
	public void setStudentname(String studentName) {
		this.studentName=studentName;
	}

    // 得点を取得(ゲット)メソッド
	public int getPoint2() {
		return point2;
	}
	// 得点を設置(セット)メソッド
	public void setPoint2(int point2) {
		this.point2=point2;
	}

	// 科目名を取得(ゲット)メソッド
	public String getStudentno() {
		return studentNo;
	}
	// 科目名を設置（セット）メソッド
	public void setStudentno(String studentno) {
		this.studentNo=studentno;
	}

}

