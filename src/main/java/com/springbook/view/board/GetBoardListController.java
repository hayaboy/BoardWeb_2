package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 목록 검색 처리");
		
		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		
		// 3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다. 그런데 세션이라는 것은 클라이언트 브라우저당 하나씩 
		//메모리에 생성되어 클라이언트의 상태 정보를 유지하기 위해 생성한다. 따라서 세션에 많은 정보가 저장되면 될수록
		//서버에 부담을 줄 수 밖에 없다.
		//결국, 검색 결과는 세션이 아닌 HttpServletRequest 객체에 저장하는 것이 맞다.
		//HttpServletRequest는 클라이언트의 요청으로 생성되었다가 응답 메시지가 클라이언트로 전송되면 자동으로 
		//삭제되는 일회서 객체다. 따라서 검색 결과를 세션이 아닌 HttpServletRequest 객체에 저장하여 공유하면
		//서버에 부담을 주지 않고도 데이터를 공유할 수 있다.
		//하지만 GetBoardListController는 검색 결과를 HttpSession도 아니고 HttpServletRequest도 아닌
		//ModelAndView에 저장하고 있다. ModelAndView는 Model과 View 정보를 모두 저장하여 리턴할 때 사용
		//DispatcherServlet은 Controller가 리턴한 ModelAndView 객체에서 Model 정보를 추출한 다음
		//HttpServletRequest 객체에 검색 결과에 해당하는 Model 정보를 저장하여 JSP로 포워딩한다.
		//따라서 JSP파일에서는 검색결과를 세션이 아닌 HttpServletRequest로부터 꺼내 쓸 수 있다.
		
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		return "getBoardList";  // 확장자가 없는 이유는 ViewResolver를 이용하여 View이름 완성
		
		// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); 	// Model 정보 저장
		mav.setViewName("getBoardList"); 	// View 정보 저장
		return mav;
		
	}

}
