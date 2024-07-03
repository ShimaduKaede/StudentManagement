package student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;    // サーバ上の物理パスを取得するためのServletcontextインターフェース
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import tool.Page;

@WebServlet(urlPatterns={"/student/attribute3"})
public class Attribute3 extends HttpServlet {
    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        // getServletContextメソッドによりServletContextオブジェクトを取得
        ServletContext context=getServletContext();

        String debug=(String)context.getAttribute("debug");
        if (debug.equals("yes")){
            out.println("<p>デバッグモードで実行します。</p>");
        }
        int memory=Integer.parseInt(
            (String)context.getAttribute("memory"));
        if (memory<1000000) {
            out.println("<p>省メモリモードで実行します。</p>");
        }

        Page.footer(out);
    }

}
