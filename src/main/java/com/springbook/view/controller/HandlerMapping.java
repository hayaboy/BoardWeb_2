package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;


//Map Ÿ���� �÷����� ��������� ����, �Խ��� ���α׷��� �ʿ��� ��� Controller ��ü���� ����ϰ� ����
public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());		
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());		
	}
	
	
	//path�� �ش��ϴ� Controller ��ü�� HashMap �÷������κ��� �˻��Ͽ� ����
	public Controller getCotroller(String path){
		return mappings.get(path);
	}
}
