package com.springbook.biz.board;

//import java.sql.Date;

import java.util.Date; //regDate ������ �⺻ �����ڰ� �ִ� java.util.Date Ÿ���� ������ ����, �ֳ��ϸ� Ư�� �ڹ� ��ü�� XML�� ��ȯ�Ϸ��� �ݵ�� �ش� Ŭ������ �⺻ �����ڰ� �־�߸� �Ѵ�.

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile; //A representation of an uploaded file received in a multipart request.

//VO(Value Object)

@XmlAccessorType(XmlAccessType.FIELD)  //BoardVO��ü�� XML�� ��ȯ, XmlAccessType.FIELD ������ �� ��ü�� ���� �ʵ�, �� �������� �ڵ����� �ڽ� ������Ʈ�� ǥ��
public class BoardVO {

	@XmlAttribute  //seq �������� @XmlAttribute �پ��µ� �̴� seq�� �Ӽ����� ǥ���϶�� �ǹ�
	private int seq;
	
	
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	@XmlTransient  // XML ��ȯ���� ����
	private String searchCondition;
	
	@XmlTransient
	private String searchKeyword;

	@XmlTransient
	private MultipartFile uploadFile; // ���� ���ε�� ���õ� ���� �߰�

	// @JsonIgnore //json���� ������ �ʵ��� ����, Getter���� ����
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	// setUploadFile() �޼ҵ尡 ȣ��Ƿ��� MultipartFileŸ���� ��ü�� ���� �����Ǿ� �־�� �Ѵ�. ��
	// MultipartFile ��ü�� �ٷ� ������ �����̳ʰ� �����Ѵ�.
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	// @JsonIgnore //json���� ������ �ʵ��� ����, Getter���� ����
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	// @JsonIgnore //json���� ������ �ʵ��� ����, Getter���� ����
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {

		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
}
