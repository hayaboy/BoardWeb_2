package com.springbook.view.controller;


//Controller�� ������ View�̸��� ���λ�� ���̻縦 �����Ͽ� ���������� ����� View ��ο� ���ϸ��� �ϼ�
public class ViewResolver {

	
	public String prefix;
	public String suffix;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
	public String getView(String viewName){
		return prefix +viewName + suffix;
	}
	
}
