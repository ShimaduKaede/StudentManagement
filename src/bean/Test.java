package bean;

import java.io.Serializable;

public class Test implements Serializable {

    private String studentNo;    // 学生(学生番号,氏名,入学年度,クラス番号,在籍中フラグ,学校(学校コード,学校名))
    private String studentName;
    private String classNum;    // クラス番号
    private String subjectCd;    // 科目(学校コード,科目コード,科目名)
    private String schoolCd;      // 学校(学校コード,学校名)
    private String subjectName;
    private int testNo;         // 回数
    private int point;          // 得点



	// 学生情報を取得(ゲット)メソッド
	public String getStudent() {
		return studentNo;
	}
	// 学生情報を設置（セット）メソッド
	public void setStudent(String studentNo) {
		this.studentNo=studentNo;
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
	public String getSubject() {
		return subjectCd;
	}
	// 科目情報を設置（セット）メソッド
	public void setSubject(String subjectCd) {
		this.subjectCd=subjectCd;
	}

	// 学校情報(学校コード、学校名)を取得(ゲット)メソッド
	public String getSchool() {
		return schoolCd;
	}
	// 学校情報(学校コード、学校名)を設置（セット）メソッド
	public void setSchool(String schoolCd) {
		this.schoolCd=schoolCd;
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

}

