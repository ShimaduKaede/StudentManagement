package bean;

// `TestListStudent` クラスは、学生の科目に関する情報を保持するクラス。
public class TestListStudent {
    private String subjectName;  // 科目名を表すフィールド
    private String subjectCd;    // 科目コードを表すフィールド
    private int num;             // 数量を表すフィールド
    private int point;           // 点数を表すフィールド

    // コンストラクタ（省略可能）

    // ゲッターメソッドとセッターメソッド

    // `subjectName` フィールドの値を返す。
    public String getSubjectName() {
        return subjectName;
    }

    // `subjectName` フィールドに値を設定。
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // `subjectCd` フィールドの値を返す。
    public String getSubjectCd() {
        return subjectCd;
    }

    // `subjectCd` フィールドに値を設定。
    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    // `num` フィールドの値を返す。
    public int getNum() {
        return num;
    }

    // `num` フィールドに値を設定。
    public void setNum(int num) {
        this.num = num;
    }

    // `point` フィールドの値を返す。
    public int getPoint() {
        return point;
    }

    // `point` フィールドに値を設定。
    public void setPoint(int point) {
        this.point = point;
    }
}
