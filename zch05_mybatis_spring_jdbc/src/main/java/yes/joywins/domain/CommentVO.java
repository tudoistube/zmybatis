package yes.joywins.domain;

import java.util.Date;


public class CommentVO {
	
	/*
	 * ...주의사항!
          반드시 DB 의 자료형과 일치하는지 확인할 것.
		  자료형이 Integer 인데 Long 으로 해서 Domain 클래스를 만들면 어떠한 오류도 없는데
		  페이지가 오류없이 실행은 되는데 쿼리 결과가 안나와서 원인을 찾느라 심신이 버닝된 적 있음.
	 */
	private Integer comment_no;
	private String user_id;
	private Date reg_date;
	private String comment_content;
	
	public Integer getComment_no() {
		return comment_no;
	}
	public void setComment_no(Integer comment_no) {
		this.comment_no = comment_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	@Override
	public String toString() {
		return "CommentVO [comment_no=" + comment_no + ", user_id=" + user_id + ", reg_date=" + reg_date
				+ ", comment_content=" + comment_content + "]";
	}
	
	

}
