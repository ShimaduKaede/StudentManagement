package bean;

// `TestListStudent` クラスは、学生の科目に関する情報を保持するクラス。
public class TestListStudent {
    private String testListStudentName;  // 科目名を表すフィールド
    private String testListStudentCd;    // 科目コードを表すフィールド
    private int testListNum;             // 数量を表すフィールド
    private int testListPoint;           // 点数を表すフィールド

    // コンストラクタ（省略可能）

    // ゲッターメソッドとセッターメソッド

    // `subjectName` フィールドの値を返す。
    public String gettestListStudentName() {
        return testListStudentName;
    }

    // `subjectName` フィールドに値を設定。
    public void settestListStudentName(String testListStudentName) {
        this.testListStudentName = testListStudentName;
    }

    // `subjectCd` フィールドの値を返す。
    public String gettestListStudentCd() {
        return testListStudentCd;
    }

    // `subjectCd` フィールドに値を設定。
    public void settestListStudentCd(String testListStudentCd) {
        this.testListStudentCd = testListStudentCd;
    }

    // `num` フィールドの値を返す。
    public int gettestListNum() {
        return testListNum;
    }

    // `num` フィールドに値を設定。
    public void settestListNum(int testListNum) {
        this.testListNum = testListNum;
    }

    // `point` フィールドの値を返す。
    public int gettestListPoint() {
        return testListPoint;
    }

    // `point` フィールドに値を設定。
    public void settestListPoint(int testListPoint) {
        this.testListPoint = testListPoint;
    }
}
