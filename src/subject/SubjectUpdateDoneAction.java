package subject ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class SubjectUpdateDoneAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

        // getJspNameメソッド
        // 引数：なし
        // 戻り値：String
        public String getJspName(){
            String jspName;

            return jspName; 
        }

        // getSuccessUrlメソッド
        // 引数：なし
        // 戻り値：String
        public String getSuccessUrl(){
            String successUrl;

            return successUrl;
        }

        // setRequestDataメソッド
        // 引数：HttpServletRequest型のrequest
        // 戻り値：なし
        public void setRequestData(HttpServletRequest request){

        }

        // getメソッド
        // 引数：HttpServletRequest型のrequest,HttpServletResponse型のresponse
        // 戻り値：String
        public String get(HttpServletRequest request, HttpServletResponse response){
            String rtn;

            return rtn;
        }

        // postメソッド
        // 引数：HttpServletRequest型のrequest,HttpServletResponse型のresponse
        // 戻り値：String
        public String post(HttpServletRequest request, HttpServletResponse response){
            String rtn;

            return rtn;
        }
    }
}