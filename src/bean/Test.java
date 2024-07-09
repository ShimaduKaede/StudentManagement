package bean;

import java.io.Serializable;

public class Test implements Serializable {
	private String studentNo;	// 学生番号
    private String studentName;	// 学生名
    private String classNum;    // クラス番号
    private String subjectCd;   // 科目コード
    private String subjectName;	// 科目名
    private int testNo;         // 回数
    private int point;          // 得点
    private int point2;

	// クラス番号を取得(ゲット)メソッド
	public String getClassNum() {
		return classNum;
	}
	// クラス番号を設置（セット）メソッド
	public void setClassNum(String classNum) {
		this.classNum=classNum;
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


	// 科目名を取得(ゲット)メソッド
	public String getSubjectCd() {
		return subjectCd ;
	}
	// 科目名を設置（セット）メソッド
	public void setSubjectCd(String subjectCd) {
		this.subjectCd=subjectCd;
	}

}

