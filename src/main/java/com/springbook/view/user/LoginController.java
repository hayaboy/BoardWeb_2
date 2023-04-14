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
//import org.springframework.web.servlet.mvc.Controller;  // 어떤 Controller 객체가 검색되더라도 같은 코드로 실행하려면 모든 Controller의 최상위 인터페이스가 필요
//
//import com.springbook.biz.user.UserVO;
//import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {  //스프링 컨테이너가 생성하는 객체의 이름은 클래스 이름(UserVO)의 첫글자를 소문자로 변경한 이름이 자동으로 설정된다. 
																 // 따라서 UserVO 객체의 변수에 접근할 때 ${userVO.변수명}을 사용한 것이다.
		                                                         // 그런데 객체의 이름을 변경하려면 @ModelAttribute를 사용해야 한다. 여기서는 user로 변경함 
		System.out.println("로그인 화면으로 이동...");
//		vo.setId("test");
//		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리...");
		
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
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
//		System.out.println("로그인 처리");

//		// 1. 사용자 입력 정보 추출
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		System.out.println(id +" " + password);
//		
//		// 2. DB 연동 처리
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//
//		// 3. 화면 네비게이션 // redirect:을 붙이면 ViewResolver가 설정되어 있더라도 이를 무시하고 리다이렉트함
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
