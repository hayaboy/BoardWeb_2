package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. 스프링 컨테이너로부터 BoardServiceImpl 객체(boardService)를 Lookup함
		UserService userService = (UserService) container.getBean("userService");

		
		//3. 로그인 기능 테스트
		UserVO vo=new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user=userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영");
		}else {
			System.out.println("로그인 실패");
		}
		
		//4. 컨테이너 종료
		container.close();
	}

}
