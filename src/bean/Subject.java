package bean;

import java.io.Serializable;

// `Subject` クラスは、科目に関する情報を保持するクラス。
// このクラスはシリアライズ可能であり、`Serializable` インターフェースを実装。
public class Subject implements Serializable {
    private String subjectCd;      // 科目コードを表すフィールド
    private String subjectName;    // 科目名を表すフィールド
    private School school;  // 学校情報を表すフィールド

    // デフォルトコンストラクタ（省略可能）

    // ゲッターメソッド
    // `subjectCd` フィールドの値を返す。
    public String getSubjectCd() {
        return subjectCd;
    }

    // `subjectName` フィールドの値を返す。
    public String getSubjectName() {
        return subjectName;
    }

    // `subjectSchool` フィールドの値を返す。
    public School getSchool() {
        return school;
    }

    // セッターメソッド
    // `subjectCd` フィールドに値を設定。
    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    // `subjectName` フィールドに値を設定します。
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // `subjectSchool` フィールドに値を設定。
    public void setSchool(School school) {
        this.school = school;
    }
}
