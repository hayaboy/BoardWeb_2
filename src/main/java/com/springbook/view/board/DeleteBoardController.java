package com.springbook.view.board;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController {
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//
//		System.out.println("�� ���� ó��");
//
//		// 1. ����� �Է� ���� ����
//		String seq = request.getParameter("seq");
//
//		// 2. DB ���� ó��
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//
//		// 3. ȭ�� �׺���̼�
//		// return "getBoardList.do";
//
//		// 3. ȭ�� �׺���̼�
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//
//	}

}
