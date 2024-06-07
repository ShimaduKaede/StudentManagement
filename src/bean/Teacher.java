package bean;

// Serializableインターフェースを実装してBeanを作成する
import java.io.Serializable;

public class Teacher implements Serializable {
    
    private String teacherId;          // 教員ID   
    private String teacherPassword;    // パスワード
    private String teacherName;        // 氏名
    private School school;             // 学校コード

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
    public School getSchool() {
        return school;
    }

    // セッター
    public void setTeacherId(String TeacherId) {
        this.TeacherId;
    }
    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName;
    }
    public void setSchool(School school) {
        this.school = school;
    }
}
