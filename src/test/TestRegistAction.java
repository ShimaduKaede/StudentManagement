package test;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import bean.Teacher;

import bean.Test;

import dao.TestDAO;

import tool.Action;

import tool.Utl;

public class TestRegistAction extends Action {

public String execute(

HttpServletRequest request, HttpServletResponse response

) throws Exception {

Utl utl = new Utl();

// セッションから学校情報を取得

Teacher teacher = utl.getUser(request);

// Schoolがnullの場合の処理

if (teacher.getSchoolCd() == null) {

// 適切なエラーメッセージを設定してエラーページにリダイレクト

request.setAttribute("error", "学校情報が見つかりません。再度ログインしてください。");

return "error.jsp";

}

int ent_year = Integer.parseInt(request.getParameter("f1"));

String class_num = request.getParameter("f2");

String subject_name = request.getParameter("f3");

int no = Integer.parseInt(request.getParameter("f4"));

String school=teacher.getSchoolCd();

TestDAO dao=new TestDAO();

List<Test> testlist=new ArrayList<>();

testlist=dao.filter(class_num,subject_name,no,school,ent_year);

request.setAttribute("testlist", testlist);

request.setAttribute("class_num",class_num);

request.setAttribute("subject_name", subject_name);

request.setAttribute("ent_year", ent_year);

// FrontControllerを使用しているためreturn文でフォワードできる

return "test_regist.jsp";

}

}