package student;

// import java.io.FileInputStream; // ファイルを読み込むためのFileInputStreamクラス
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletContext;    // サーバ上の物理パスを取得するためのServletcontextインターフェース
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import tool.Page;

@WebServlet(urlPatterns={"/student/attribute2"})
public class Attribute2 extends HttpServlet {
    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        // getServletContextメソッドによりServletContextオブジェクトを取得
        ServletContext context=getServletContext();
        List<String> list=Collections.list(context.getAttributeNames());
        for (String name : list) {
            out.println("<p>"+name+" : ");
            out.println(context.getAttribute(name));
            out.println("</p>");
        }

        Page.footer(out);
    }

}
