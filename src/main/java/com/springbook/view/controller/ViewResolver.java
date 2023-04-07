package com.springbook.view.controller;


//Controller가 리턴한 View이름에 접두사와 접미사를 결합하여 최종적으로 실행될 View 경로와 파일명을 완성
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
