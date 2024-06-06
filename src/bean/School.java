package bean;

import java.io.Serializable;
public class School implements Serializable {
    private String cd;
    private String name;

    // ゲッター
    public String getCd() {
        return cd;
    }
    public String getName() {
        return name;
    }

    // セッター
    public void setCd(String cd) {
        this.cd = cd;
    }
    public void setName(String name) {
        this.name = name;
    }
}
