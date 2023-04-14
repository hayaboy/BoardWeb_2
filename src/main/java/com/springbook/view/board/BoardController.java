package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller       //@SessionAttributes board��� �̸����� ����� �����Ͱ� �ִٸ� �� �����͸� ���ǿ��� �ڵ����� �����϶�� �����̴�.
@SessionAttributes("board") //Annotation that indicates the session attributes that a specific handler uses, @SessionAttributes�̿��ϸ� ���ǿ� ����� ������ �ۼ��� ���� null�� ������Ʈ ���� �ʵ��� ó����
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	//@ModelAttribute�� ��ü�� �̸��� ������ �������ε� ��������� View(JSP)���� ����� �����͸� �����ϴ� �뵵�ε� ����� �� �ִ�.
	//@ModelAttribute�� ������ �޼���� @RequestMapping ������̼��� ����� �޼ҵ庸�� ���� ȣ��
	//@ModelAttribute �޼ҵ� �������� ���ϵ� ��ü�� �ڵ����� Model�� ����ȴ�. ���� @ModelAttribute �޼ҵ� �������� ���ϵ� ��ü�� View ���������� ����� �� �ִ�.
	
	// �˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
		
	// �� ���
		@RequestMapping(value = "/insertBoard.do")  // ������ �����̳ʰ� BoardVO ��ü ������ MultipartFile ��ü�� �����ϰ� �Ҵ���, �׷��� multipartResolver��� �̸����� ��ϵ� CommonsMultipartResolver ��ü�� ������ ������ �����̳ʴ� MultipartFile ��ü�� ������ �� ����. 
		public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {
			
			// ���� ���ε� ó��
			MultipartFile uploadFile = vo.getUploadFile();
			
			if(!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File("D:\\boardWebFile" + fileName));
			}
			
			boardDAO.insertBoard(vo);
			return "getBoardList.do";
		}

		// �� ����
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
			System.out.println("��ȣ : " + vo.getSeq());
			System.out.println("���� : " + vo.getTitle());
			System.out.println("�ۼ��� : " + vo.getWriter());
			System.out.println("���� : " + vo.getContent());
			System.out.println("����� : " + vo.getRegDate());
			System.out.println("��ȸ�� : " + vo.getCnt());
			
			
			boardDAO.updateBoard(vo);
			return "getBoardList.do";
		}

		// �� ����
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
			boardDAO.deleteBoard(vo);
			return "getBoardList.do";
		}

		// �� �� ��ȸ
		@RequestMapping("/getBoard.do")   //model���� board��� �̸����� BoardVO ��ü�� ����ȴ�. �ֳ��ϸ� @SessionAttributes("board") �������� ����
		public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {    // �޼ҵ帶�� ����Ÿ���� �ٸ����ϴ� �ͺ��ٴ� String���� �����ϴ� ���� �� �����ϱ⿡ ��κ� String���� �����Ѵ�. ModelAndView�� �����ߴ� �˻� ����� ���� Model�� ����, �̷��� �𵨿� ����� �����ʹ� ModelAnView�� �����ϰ� ���ϵ� JSP ȭ�鿡�� ����� �� �ִ�.
			model.addAttribute("board", boardService.getBoard(vo));// Model ���� ����
//			mav.addObject("board", boardDAO.getBoard(vo)); // Model ���� ����
//			mav.setViewName("getBoard.jsp"); // View ���� ����
			return "getBoard.jsp"; //View �̸� ����
		}

		// �� ��� �˻�1
//		@RequestMapping("/getBoardList.do")   
//		public String getBoardList(@RequestParam(value = "searchCondition",  defaultValue = "TITLE", required = false) String condition, @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, BoardVO vo, BoardDAO boardDAO, Model model) {
			//@RequestParam :  Annotation which indicates that a method parameter should be bound to a web request parameter
			// Spring MVC������ HTTP ��û �Ķ���� ������ �����ϱ� ���� @RequestParam�� ������
			// @RequestParam�� ����ϸ� �˻��� ���õ� �Ķ���� ������ ������ �� �ִ�.
			// @RequestParam�� HttpServletRequest���� �����ϴ� getParameter() �޼���� ���� ����� ������̼�
			
			/*@RequestParam ���� �� required �Ӽ��� �����ϸ� �⺻���� true��
			  required �Ӽ��� true�� �����ϸ� �޼��� ȣ�� �� �ݵ�� ������ �̸��� �Ű������������ؾ���(�Ű������� ������ ���ܰ� �߻�)
		      required �Ӽ��� false�� �����ϸ� �޼��� ȣ�� �� ������ �̸��� �Ű������� ���޵Ǹ� ���� �����ϰ� ������ null�� �Ҵ���
			 * 
			 *  */
//			System.out.println("�˻� ���� : " + condition);
//			System.out.println("�˻� �ܾ� : " + keyword);
//			model.addAttribute("boardList", boardService.getBoardList(vo));
//			mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ���� ����
//			mav.setViewName("getBoardList.jsp"); // View ���� ����
//			return "getBoardList.jsp";  //View �̸� ����
//		}
		
		
		
		// �� ��� �˻�2
		@RequestMapping("/getBoardList.do")   
		public String getBoardList(BoardVO vo, Model model) {
			//Null Check, �˻� ���ǰ� �˻� Ű���尡 ���޵��� ���� ���� ���Ͽ�(���� ��� �α��� ���� �� "getBoardList.do" ��û�� ���޵ǰų� ��ȭ�鿡�� �� ��� ��ũ�� Ŭ���Ͽ� "getBoardList.do" ��û�� ������ �����ϸ� �˻� ���ǰ� �˻� Ű���� ������ ���޵��� �ʴ´�. �� ��
			// BoardVO ��ü�� sarchCondition�� searchKeyword �������� null�� ������, ���� �̷� ���� �⺻���� �����Ͽ� �����Ͻ�������Ʈ�� �����ؾ� �ϹǷ� �� üũ��
			System.out.println(vo.getSearchCondition());
			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}
			if(vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}
			
			// Model ���� ����
			
			model.addAttribute("boardList", boardService.getBoardList(vo));	
			return "getBoardList.jsp"; // View �̸� ����
		}
		
		
		
		
		
		@RequestMapping("/dataTransform.do")
		@ResponseBody  //�ڹ� ��ü�� Http���� ���������� ��ü�� ��ȯ�ϱ� ���� ���
		public BoardListVO dataTransform(BoardVO vo ) {
			
			
			
			vo.setSearchCondition("TITLE");
			vo.setSearchKeyword("");
			List<BoardVO> boardList = boardService.getBoardList(vo);
			
			BoardListVO boardListVO = new BoardListVO();
			boardListVO.setBoardList(boardList);
			
			
			
			
			return boardListVO;
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
