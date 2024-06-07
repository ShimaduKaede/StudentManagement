package bean;

import java.io.Serializable;
public class TestListSubject implements Serializeble {
    
    private int entYear;
    private String studentNo;
    private String studentName;
    private String classNum;
    private Map<integer,integer> testlistPoints;

    TestListSubject() {
    }
    // ゲッター
    public int getEntYear() {
        return entYear;
    }
    public String getStudentNo() {
        return studentNo;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getClassNum() {
        return classNum;
    }
    public Map<Integer, Integer> getPoints() {
        return points;
    }

    // セッター
    public int setIntYear(int entYear) {
        this.entYear = entYear;
    }
    public String setStudentNo(string studentNo) {
        this.studentNo = studentNo;
    }
    public String

}
