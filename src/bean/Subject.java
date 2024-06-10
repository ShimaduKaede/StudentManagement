package bean;

import java.io.Serializable;

// `Subject` クラスは、科目に関する情報を保持するクラス。
// このクラスはシリアライズ可能であり、`Serializable` インターフェースを実装。
public class Subject implements Serializable {
    private String subjectCd;      // 科目コードを表すフィールド
    private String subjectName;    // 科目名を表すフィールド
    private School subjectSchool;  // 学校情報を表すフィールド

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
    public School getSubjectSchool() {
        return subjectSchool;
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
    public void setSubjectSchool(School subjectSchool) {
        this.subjectSchool = subjectSchool;
    }
}
