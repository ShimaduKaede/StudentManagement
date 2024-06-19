package bean;

// Serializableインターフェースを実装してBeanを作成する
import java.io.Serializable;

public class ClassNum implements Serializable {
    private String schoolCd;    // 学校コード
    private String classNum;    // クラス番号

    // 学校コードを取得(ゲット)する
    public String getScoolCd() {
        return schoolCd;
    }
    // 学校コードを設定(セット)する
    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
    // クラス番号を取得(ゲット)する
    public String getClassNum() {
        return classNum;
    }
    // クラス番号を設定(セット)する
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}
