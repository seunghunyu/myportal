package com.bitacademy.myportal.vo;

public class BoardVo {
	private Long no;
	private String title;
	private String content;
	private Long hit;
	private String regDate;
	private Long userNo;
	private String userName;
	
	//기본생성자
	public BoardVo() {
		super();
	}

	public Long getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Long getHit() {
		return hit;
	}

	public String getRegDate() {
		return regDate;
	}

	public Long getUserNo() {
		return userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regDate="
				+ regDate + ", userNo=" + userNo + ", userName=" + userName + "]";
	}


	
	
}
