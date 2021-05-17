package com.Lindsy.board5.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.Lindsy.board5.MyUtils;
import com.Lindsy.board5.cmt.CmtDAO;
import com.Lindsy.board5.user.UserDAO;
import com.Lindsy.board5.user.UserVO;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard" , request);
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		request.setAttribute("data", BoardDAO.selBoard(param));
		request.setAttribute("cmtList", CmtDAO.selCmtList(iboard));
		MyUtils.openJSP("board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
