package com.javaex.vo;

public class BoardVo {

	private int no;
	private int user_no;
	private String title;
	private String content;
	private int hit;
	private String reg_date;
	private String name;

	public BoardVo() {
		super();
	}
	
	public BoardVo(int user_no, String title, String content) {
		super();
		this.user_no = user_no;
		this.title = title;
		this.content = content;
	}

	public BoardVo(int no, int user_no, String title, String content, int hit, String reg_date, String name) {
		super();
		this.no = no;
		this.user_no = user_no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", user_no=" + user_no + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", reg_date=" + reg_date + ", name=" + name + "]";
	}
	
	

}
