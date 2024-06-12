package bean;

import java.io.Serializable;

// Serializableインタフェースを実装してBeanを作成する
// SchoolBeanの設定を取得するため、StudentBeanに追加
public class Student extends School implements Serializable {

	private String studentNo;       // 学生番号
	private String studentName;     // 氏名
	private int entYear;            // 入学年度
    private String classNum;        // クラス番号
    private boolean isAttend;       // 在籍中フラグ
    private School school;          // 学校(学校コード,学校名)

	// 学生番号を取得(ゲット)メソッド
	public Stirng getStudentNo() {
		return studentNo;
	}
	// 学生番号を設置（セット）メソッド
	public void setStudentNo(String studentNo) {
		this.studentNo=studentNo;
	}

	// 学生氏名を取得(ゲット)メソッド
	public String getStudentName() {
		return studentName;
	}
	// 学生氏名を設置(セット)メソッド
	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}

	// 入学年度を取得(ゲット)メソッド
	public int getEntYear() {
		return entYear;
	}
	// 入学年度を設置(セット)メソッド
	public void setEntYear(int entYear) {
		this.entYear=entYear;
	}

	// クラス番号を取得(ゲット)メソッド
	public String getClassNum() {
		return classNum;
	}
	// クラス番号を設置（セット）メソッド
	public void setClassNum(String classNum) {
		this.classNum=classNum;
	}

	// 在籍中を取得(ゲット)メソッド
	public boolean getIsAttend() {
		return isAttend;
	}
	// 在籍中を設置（セット）メソッド
	public void setIsAttend(boolean isAttend) {
		this.isAttend=isAttend;
	}

	// 学校(学校コード、学校名)を取得(ゲット)メソッド
	public School getSchool() {
		return school;
	}
	// 学校(学校コード、学校名)を設置（セット）メソッド
	public void setSchool(School school) {
		this.school=school;
	}

	// SchoolYear(?) 何かを取得(ゲット)メソッド
	// 仕様が不明のため、ひとまずentYearを返す
	public int getSchoolYear() {
		return entYear;
	}

}

