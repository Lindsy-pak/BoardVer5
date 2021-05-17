package com.Lindsy.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lindsy.board5.MyUtils;


@WebServlet("/user/logout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		hs.invalidate(); //전체 삭제할 때 세션에는 최소한의 값만 담는 것이 좋다.
		//hs.setAttribute("loginUser", null);
		//hs.removeAttribute("");
		
		response.sendRedirect("login"); //user로 왔기 때문에 login만 적어도 가능
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
