package bean;

// Serializableインターフェースを実装してBeanを作成する
import java.io.Serializable;

public class Teacher implements Serializable {
    // test
    private String teacherId;          // 教員ID   
    private String teacherPassword;    // パスワード
    private String teacherName;        // 氏名
    private String schoolCd;           // 学校コード

    // ゲッター
    public String getTeacherId() {
        return teacherId;
    }
    public String getTeacherPassword() {
        return teacherPassword;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public String getSchoolCd() {
        return schoolCd;
    }

    // セッター
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public void setSchoolCd(String schoolCd) {
        this.schoolCd = schoolCd;
    }
}
