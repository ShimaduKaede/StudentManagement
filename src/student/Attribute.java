package student;

import java.io.FileInputStream; // ファイルを読み込むためのFileInputStreamクラス
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Properties;    // プロパティファイルを扱うためのPropertiesクラス

import javax.servlet.ServletContext;    // サーバ上の物理パスを取得するためのServletcontextインターフェース
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;
import tool.EncodingFilter;

@WebServlet(urlPatterns={"/student/attribute"})
public class Attribute extends HttpServlet {
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
        for (String name : p.stringPropertyNames()) {
            // 設定ファイルから名前と値の組を1つ1つ取り出して
            // setAttributeメソッドで属性に設定
            context.setAttribute(name,p.getProperty(name));
        }
        out.println("アプリケーション属性を設定しました。");

        List<String> list=Collections.list(context.getAttributeNames());
        for (String name : list) {
            out.println("<p>"+name+" : ");
            out.println(context.getAttribute(name));
            out.println("</p>");
        }





        Page.footer(out);
    }

}
