package com.Lindsy.board5.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lindsy.board5.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request); // 디테일 페이지로 돌아갈 수 있도록 iboard값을 들고와준다. 
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		
		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser); //내가 쓴 댓글을 다른사람이 삭제가 안되겠끔 
		
		CmtDAO.delCmt(param);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO param = new CmtVO();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		CmtDAO.insCmt(param);
		
		response.sendRedirect("detail?iboard=" + iboard);
		
	}

}