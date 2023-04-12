package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller       //@SessionAttributes board라는 이름으로 저장된 데이터가 있다면 그 데이터를 세션에도 자동으로 저장하라는 설정이다.
@SessionAttributes("board") //Annotation that indicates the session attributes that a specific handler uses, @SessionAttributes이용하면 세션에 저장된 정보들 작성자 등이 null로 업데이트 되지 않도록 처리됨
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	//@ModelAttribute는 객체의 이름의 변경할 목적으로도 사용하지만 View(JSP)에서 사용할 데이터를 설정하는 용도로도 사용할 수 있다.
	//@ModelAttribute가 설정된 메서드는 @RequestMapping 어노테이션이 적용된 메소드보다 먼저 호출
	//@ModelAttribute 메소드 실행결과로 리턴된 객체는 자동으로 Model에 저장된다. 따라서 @ModelAttribute 메소드 실행결과로 리턴된 객체를 View 페이지에서 사용할 수 있다.
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
		
	// 글 등록
		@RequestMapping(value = "/insertBoard.do")
		public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
			boardDAO.insertBoard(vo);
			return "getBoardList.do";
		}

		// 글 수정
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
			System.out.println("번호 : " + vo.getSeq());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("작성자 : " + vo.getWriter());
			System.out.println("내용 : " + vo.getContent());
			System.out.println("등록일 : " + vo.getRegDate());
			System.out.println("조회수 : " + vo.getCnt());
			
			
			boardDAO.updateBoard(vo);
			return "getBoardList.do";
		}

		// 글 삭제
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
			boardDAO.deleteBoard(vo);
			return "getBoardList.do";
		}

		// 글 상세 조회
		@RequestMapping("/getBoard.do")   //model에도 board라는 이름으로 BoardVO 객체가 저장된다. 왜냐하면 @SessionAttributes("board") 설정으로 인해
		public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {    // 메소드마다 리턴타입을 다르게하는 것보다는 String으로 통일하는 것이 더 간결하기에 대부분 String으로 통일한다. ModelAndView에 저장했던 검색 결과는 이제 Model에 저장, 이렇게 모델에 저장된 데이터는 ModelAnView와 동일하게 리턴된 JSP 화면에서 사용할 수 있다.
			model.addAttribute("board", boardService.getBoard(vo));// Model 정보 저장
//			mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
//			mav.setViewName("getBoard.jsp"); // View 정보 저장
			return "getBoard.jsp"; //View 이름 리턴
		}

		// 글 목록 검색
		@RequestMapping("/getBoardList.do")   
		public String getBoardList(@RequestParam(value = "searchCondition",  defaultValue = "TITLE", required = false) String condition, @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, BoardVO vo, BoardDAO boardDAO, Model model) {
			//@RequestParam :  Annotation which indicates that a method parameter should be bound to a web request parameter
			// Spring MVC에서는 HTTP 요청 파라미터 정보를 추출하기 위한 @RequestParam를 제공함
			// @RequestParam을 사용하면 검색과 관련된 파라미터 정보를 추출할 수 있다.
			// @RequestParam은 HttpServletRequest에서 제공하는 getParameter() 메서드와 같은 기능의 어노테이션
			
			/*@RequestParam 적용 시 required 속성을 생략하면 기본값은 true임
			  required 속성을 true로 설정하면 메서드 호출 시 반드시 지정한 이름의 매개변수를전달해야함(매개변수가 없으면 예외가 발생)
		      required 속성을 false로 설정하면 메서드 호출 시 지정한 이름의 매개변수가 전달되면 값을 저장하고 없으면 null을 할당함
			 * 
			 *  */
			System.out.println("검색 조건 : " + condition);
			System.out.println("검색 단어 : " + keyword);
			model.addAttribute("boardList", boardService.getBoardList(vo));
//			mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
//			mav.setViewName("getBoardList.jsp"); // View 정보 저장
			return "getBoardList.jsp";  //View 이름 리턴
		}
}
