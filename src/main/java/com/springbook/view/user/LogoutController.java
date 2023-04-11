package com.springbook.view.user;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class LogoutController {
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("로그아웃 처리");
//
//		// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
//		HttpSession session = request.getSession();
//		session.invalidate();
//
//		// 2. 세션 종료 후, 메인 화면으로 이동한다.
//		// return "login";
//
//		// 2. 세션 종료후, 메인 화면으로 이동한다.
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}

}
