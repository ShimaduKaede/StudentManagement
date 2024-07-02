package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.TestDAO;
import tool.Action;
import tool.Utl;
// test_regist.jsp(成績管理一覧画面)でTestRegistExecuteActionを起動
// TestRegistExecuteActionでやること↓
// ・入力値のチェック
//  alt【0～100で無い数値が入力されていた場合】
//  正しくない数値が入力されていた入力欄に
// 「0～100の範囲で入力してください」とメッセージを表示する(test_regist.jspに)
// 入力された値をDBに保存する(TestDAOを使ってTestBeanへ保存：登録)
// 成績登録完了画面(test_regist_done.jsp)を表示する

public class TestRegistExecuteAction extends Action {
    public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

        // "testList"という名前で入力されたデータをゲット
        List<test> testList = request.getAttribute("testList");

        // 入力値チェック
        for (int i=0;i<testList.size();i++) {
            // test_regist.jspから点数データの値が有効か確認する
            int point=Integer.parseInt(request.getParameter("point"));

            // 点数に不適切な値が入力された場合の処理
            if (point < 0 || point > 100) {
                // 適切なエラーメッセージを設定してtest_regist.jspにリダイレクト
                request.setAttribute("error", "0～100の範囲で入力してください。");
                return "test_regist.jsp";
            }
        }
        // 入力値をDBに保存
		// TestDAOの生成
        TestDAO dao = new TestDAO();
        // DAOのsave1メソッドを使ってDB保存
        boolean flg = dao.save1(testList);

        // 成績登録完了画面(test_regist_done.jsp)を表示する
        return "test_regist_done.jsp";
    }
}


