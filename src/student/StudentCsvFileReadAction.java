package student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContext;    // サーバ上の物理パスを取得するためのServletcontextインターフェース
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;
import tool.Action;

public class StudentCsvFileReadAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {

        // ServletContextオブジェクトを取得
         ServletContext context = request.getServletContext();
         String pathValue = request.getParameter("csvfilepath");

        // CSVファイルを読み込むためのBufferedReaderを作成
        // ここでエンコーディングを指定（UTF-8またはShift_JISなど）
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(pathValue), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                // 1行のデータをカンマ","で区切る
                String[] values = line.split(",");
                // valuesの値を各項目にセットする
                // DAOに送るために、データをStudent型の変数studentにセットする
                Student student = new Student();
                student.setStudentNo(values[0]);    // 学生番号
                student.setStudentName(values[1]);  // 氏名
                student.setEntYear(Integer.parseInt(values[2])); // 入学年度
                student.setClassNum(values[3]);     // クラス番号
                student.setIsAttend(Boolean.parseBoolean(values[4]));    // 在学中フラグ
                student.setSchoolCd(values[5]);     // 学校コード

                // 受け取ったデータを登録するためにStudentDAOを呼び出す
                StudentDAO dao = new StudentDAO();

                // StudentDAOのsave(Student)メソッドで登録する
                dao.save(student);
            }
        } catch (Exception e) {
            // ここに例外が発生した場合の処理を記述する
            // 例外の内容をログに記録したり、ユーザーにエラーメッセージを表示したりする
//            e.printStackTrace(); // 例外のスタックトレースを出力する（開発中に役立つ）
//            throw new ServletException("データの保存中にエラーが発生しました", e); // 例外を上位に投げる（例外チェーン化）
   	     // FrontControllerを使用している前提で、フォワードする場合
   	     return "student_create_done2.jsp";

        }

	     // FrontControllerを使用している前提で、フォワードする場合
	     return "student_create_done.jsp";
	}

}
