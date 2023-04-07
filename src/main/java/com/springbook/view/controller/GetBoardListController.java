package com.springbook.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("�� ��� �˻� ó��");
		// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ���� �����Ѵ�.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";  // Ȯ���ڰ� ���� ������ ViewResolver�� �̿��Ͽ� View�̸� �ϼ�
	}

}
