package bean;
// Serializableインタフェースを実装してBeanを作成する
public class Student implements java.io.Serializable {

	private int student_id;
	private String student_name;
	private int course_id;


	public int getStudent_id() {
		return student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public int getCourse_id() {
		return course_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id=student_id;
	}
	public void setStudent_name(String student_name) {
		this.student_name=student_name;
	}
	public void setCourse_id(int course_id) {
		this.course_id=course_id;
	}

}