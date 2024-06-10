package bean;

import java.io.Serializable;
public class TestListSubject implements Serializeble {
    
    private int testListSubjectEntYear;                     // 入学年度
    private String testListSubjectStudentNo;                // 学生番号
    private String testListSubjectStudentName;              // 学生名
    private String testListSubjectClassNum;                 // クラス番号
    private Map<integer,integer> testListSubjectPoints;     // 得点

    TestListSubject() {
    }
    // ゲッター
    public int getTestListSubjectEntYear() {
        return testListSubjectEntYear;
    }
    public String getTestListSubjectStudentNo() {
        return testListSubjectStudentNo;
    }
    public String getTestListSubjectStudentName() {
        return testListSubjectStudentName;
    }
    public String getTestListSubjectClassNum() {
        return testListSubjectClassNum;
    }
    public Map<Integer, Integer> getTestListSubjectPoints() {
        return testListSubjectPoints;
    }

    // セッター
    public int setIntYear(int testListSubjectEntYear) {
        this.testListSubjectEntYear = testListSubjectEntYear;
    }
    public String setStudentNo(string testListSubjectStudentNo) {
        this.testListSubjectStudentNo = testListSubjectStudentNo;
    }
    public String setStudentName(String testListSubjectStudentName) {
        this.testListSubjectStudentName = testListSubjectStudentName;
    }
    public String setClassNum(String testListSubjectClassNum) {
        this.testListSubjectClassNum = testListSubjectClassNum;
    }

}
