package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("�� ���� ó��");
		
		// 1. ����� �Է� ���� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}

}
