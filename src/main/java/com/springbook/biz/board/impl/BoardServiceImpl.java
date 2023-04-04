package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDAOSpring;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAOSpring boardDAO;
//	private LogAdvide log;
	
	
	
	
	
	
//	public BoardServiceImpl() {
//		log = new LogAdvide();
//	}
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		boardDAO.insertBoard(vo);
//		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//log.printLog();
		return boardDAO.getBoardList(vo);
	}

}
