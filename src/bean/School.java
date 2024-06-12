package bean;

import java.io.Serializable;
public class School implements Serializable {
    private String schoolCd;      // 学校コード
    private String schoolName;    // 学校名

    // ゲッター
    public String getSchoolCd() {
        return schoolCd;
    }
    public String getSchoolName() {
        return schoolName;
    }

    // セッター
    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
