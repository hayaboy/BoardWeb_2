package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String loginView(@ModelAttribute("user") UserVO vo) {  //������ �����̳ʰ� �����ϴ� ��ü�� �̸��� Ŭ���� �̸�(UserVO)�� ù���ڸ� �ҹ��ڷ� ������ �̸��� �ڵ����� �����ȴ�. 
																 // ���� UserVO ��ü�� ������ ������ �� ${userVO.������}�� ����� ���̴�.
		                                                         // �׷��� ��ü�� �̸��� �����Ϸ��� @ModelAttribute�� ����ؾ� �Ѵ�. ���⼭�� user�� ������ 
		System.out.println("�α��� ȭ������ �̵�...");
//		vo.setId("test");
//		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ���� ó��...");
		
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		
		UserVO user=userDAO.getUser(vo);
		if(user !=null) {
			session.setAttribute("userName", user.getName());
			System.out.println(user.getName());
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
		
		
//		if (userDAO.getUser(vo) != null)
//			return "getBoardList.do";
//		else
//			return "login.jsp";
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
