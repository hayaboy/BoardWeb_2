package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;  // � Controller ��ü�� �˻��Ǵ��� ���� �ڵ�� �����Ϸ��� ��� Controller�� �ֻ��� �������̽��� �ʿ�
//
//import com.springbook.biz.user.UserVO;
//import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�...");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ���� ó��...");
		if (userDAO.getUser(vo) != null)
			return "getBoardList.do";
		else
			return "login.jsp";
	}

//	@RequestMapping(value = "/login.do")
//	public String login(UserVO vo, UserDAO userDAO) {
//		if (userDAO.getUser(vo) != null)
//			return "getBoardList.do";
//		else
//			return "login.jsp";
//	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		
//		System.out.println("�α��� ó��");

//		// 1. ����� �Է� ���� ����
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		System.out.println(id +" " + password);
//		
//		// 2. DB ���� ó��
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//
//		// 3. ȭ�� �׺���̼� // redirect:�� ���̸� ViewResolver�� �����Ǿ� �ִ��� �̸� �����ϰ� �����̷�Ʈ��
//		ModelAndView mav=new ModelAndView();
//		if (user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//			
//		} else {
//			mav.setViewName("redirect:login.jsp"); 
//		}
//		return mav;
//	}

}
