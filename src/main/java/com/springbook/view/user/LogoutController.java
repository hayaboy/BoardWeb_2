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
//		System.out.println("�α׾ƿ� ó��");
//
//		// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
//		HttpSession session = request.getSession();
//		session.invalidate();
//
//		// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
//		// return "login";
//
//		// 2. ���� ������, ���� ȭ������ �̵��Ѵ�.
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}

}
