package student;

import java.io.BufferedReader;
import java.io.FileInputStream; // ファイルを読み込むためのFileInputStreamクラス
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContext;    // サーバ上の物理パスを取得するためのServletcontextインターフェース
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;


@WebServlet(urlPatterns={"/student/file"})
public class File extends HttpServlet {
    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        // ServletContextオブジェクトを取得
        ServletContext context = getServletContext();

        // CSVファイルのサーバ上のパスを取得
        String path = context.getRealPath("/WEB-INF/student_data.csv");

        // CSVファイルを読み込むためのBufferedReaderを作成
        // ここでエンコーディングを指定（UTF-8またはShift_JISなど）
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                // 1行のデータをカンマ","で区切る
                String[] values = line.split(",");

                for (String value : values) {
                    System.out.println(value);
                }
            }
        }
        Page.footer(out);
    }

}
