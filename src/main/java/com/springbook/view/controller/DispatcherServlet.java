package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//DispatcherServlet은 클라이언트의 요청을 가장 먼저 받아들이는 Front Controller, 하지만 클라이언트의 요청을 처리하기 위해 DispatcherServlet이 하는 일은 거의 없으며, 실질적인 요청 처리는 각 Controller에서 담당
//클라이언트의 요청을 받은 DispatcherServlet은 HandlerMapping을 통해 Controller 객체를 검색하고, 검색된 Controller를 실행
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	
	//서블릿 객체가 생성된 후 멤버변수 초기화하기 위해 자동으로 실행, DispatcherServlet은 이렇게 생성된
	// HandlerMapping과 ViewResolver를 이용하여 사용자의 요청을 처리
	public void init(ServletConfig config) throws ServletException {

		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		//2. HandlerMapping을 통해 path에 해당하는 Controller를 검색
		Controller ctrl=handlerMapping.getCotroller(path);
		
		//3. 검색된 Controller를 실행
		String viewName=ctrl.handleRequest(request, response);
		
		System.out.println(viewName);
		
		//4. ViewResolver를 통해 viewName에 해당하는 화면 검색
		String view = null;
		
		if(!viewName.contains(".do")) {
			view =viewResolver.getView(viewName);
		}else {
			view = viewName;
		}
		
		
		//5. 검색된 화면으로 이동
		response.sendRedirect(view);
		
		
		
	}

	public void destroy() {

	}

}
