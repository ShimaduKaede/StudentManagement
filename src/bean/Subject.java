package bean;

import java.io.Serializable;
public class Subject implements Serializable {
    private String subjectCd;      // 科目コード
    private String subjectName;    // 科目名
    private School school;          // 学校情報


    // ゲッター
    public String getSubjectCd() {
        return subjectCd;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public School getSubjectSchool() {
        return school;
    }

    // セッター
    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;

    }
    public void Setsubject_School(School school) {
        this.school = school;
    }
}
