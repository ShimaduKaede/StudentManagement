package student;

import java.io.FileInputStream; // ファイルを読み込むためのFileInputStreamクラス
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;    // プロパティファイルを扱うためのPropertiesクラス

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

        // getServletContextメソッドによりServletContextオブジェクトを取得
        ServletContext context=getServletContext();
        // 設定ファイルのサーバ上のパスを取得
        // getRealPathメソッドの引数にはコンテキストルートを起点とするパスを指定
        String path=context.getRealPath("/WEB-INF/student_data.csv");
        // 設定ファイルを開く
        FileInputStream in=new FileInputStream(path);
        // Propertiesクラスのインスタンスを生成
        Properties p=new Properties();
        // loadメソッドを使ってファイルを読み込む
        p.load(in);
        in.close();
        // Propertiesオブジェクトに保存された名前の一覧を取得する
        // stringPropertyNamesメソッドを使用
        // CSVファイルのデータを1行ずつ読み込んでいる
        for (String list : p.stringPropertyNames()) {
            // listデータの文字化けをなおす
            
            // 1行のデータをカンマ","で区切る(listからdiv_listへ)
            String[] div_list = list.split(",");
            for (int j=0;j<div_list.length;j++){
                System.out.println(div_list[j]);
            }
        }
        Page.footer(out);
    }

}
