package bean;

import java.io.Serializable;
public class School implements Serializable {
    private String school_cd;      // 学校コード
    private String school_name;    // 学校名

    // ゲッター
    public String getCd() {
        return school_cd;
    }
    public String getName() {
        return school_name;
    }

    // セッター
    public void setCd(String school_cd) {
        this.school_cd = school_cd;
    }
    public void setName(String school_name) {
        this.school_name = school_name;
    }
}
