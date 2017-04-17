package yes.joywins.domain;

import java.util.Date;


public class CommentVO {
	
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
