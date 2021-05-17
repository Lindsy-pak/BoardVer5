package com.Lindsy.board5.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.Lindsy.board5.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MyUtils.openJSP("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		System.out.println("연결?" + uid);
		UserVO vo = new UserVO();
		vo.setUid(uid);
		

		UserVO result = UserDAO.selUser(vo);
		if (result == null) { // 아이디 없음
			request.setAttribute("errMsg", "아이디를 확인 해 주세요");
			//에러메세지를 확인함
		} else if (BCrypt.checkpw(upw, result.getUpw())) { // 아이디 있음 & 비밀번호 체크 성공
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			//BCrypt라는 암호화 라이브러리에서 가져온 비밀번호 체크하는 메서드를 사용 upw는 평문 result.getUpw는 디제스트 
			// 암호화된 비밀번호와 사용자로부터 받은 비밀번호를 비교함 

			response.sendRedirect("/board/list");
			return; //무조건 있어야함 리턴을 주지않으면 doGet메서드와 충돌해서 에러가 뜬다. 
		} else { // 비밀번호 틀림
			request.setAttribute("errMsg", "비밀번호를 확인 해 주세요");
		}
		doGet(request, response);
	}

}
