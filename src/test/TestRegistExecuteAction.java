package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Teacher;
import dao.TestDAO;
import tool.Action;
// test_regist.jsp(成績管理一覧画面)でTestRegistExecuteActionを起動
// TestRegistExecuteActionでやること↓
// ・入力値のチェック
//  alt【0～100で無い数値が入力されていた場合】
//  正しくない数値が入力されていた入力欄に
// 「0～100の範囲で入力してください」とメッセージを表示する(test_regist.jspに)
// 入力された値をDBに保存する(TestDAOを使ってTestBeanへ保存：登録)
// 成績登録完了画面(test_regist_done.jsp)を表示する
import tool.Utl;

public class TestRegistExecuteAction extends Action {
    public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
    	Utl utl = new Utl();
    	// セッションから学校情報を取得
    	Teacher teacher = utl.getUser(request);

    	School school = new School();
    	school.setSchoolCd(teacher.getSchoolCd());
    	String schoolCd =teacher.getSchoolCd();


        // indexという値を取得->ループ回数の指定
    	int index=Integer.parseInt(request.getParameter("index"));

        // ループで各データの取得->更新or追加
        for (int i=1;i<=(int)index;i++) {
            // 入力された値とそれに付随するデータを取得(iで割り振った箇所を指定)
            int point=Integer.parseInt(request.getParameter("point"+i));
            String class_num = request.getParameter("class_num"+i);
            int no = Integer.parseInt(request.getParameter("no"+i));
            String studentno = request.getParameter("studentno"+i);
            String subjectcd = request.getParameter("subjectcd"+i);
            String subjectname = request.getParameter("subject_name"+i);

            //取得したデータからその点数がすでに登録されているかを確認
            TestDAO dao= new TestDAO();
            //subjectcdが取得できた場合->update文
            if (subjectcd!=null){
            	boolean Update = dao.Update(class_num,subjectcd,no,schoolCd,studentno,point);
            	if (Update!=true){
            		//エラーが起きた時
            		return "error.jsp";
            	}
            }
            //取得されなかった場合->subjectnameからsubjectでcd取得->insert文
            else{
            	boolean Insert = dao.Insert(class_num,subjectname,no,schoolCd,studentno,point);
            	if (Insert!=true){
            		return "error.jsp";
            	}
            }
            }


        // 成績登録完了画面(test_regist_done.jsp)を表示する
        return "test_regist_done.jsp";
    }
}


