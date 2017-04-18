package yes.joywins.service;

import java.util.List;

import yes.joywins.domain.CommentVO;

public interface IF_CommentJdbcService {
	
	public CommentVO selectComment(Integer no) throws Exception;
	
	public List<CommentVO> selectComments() throws Exception;
	
	public Integer insertComment(CommentVO comment) throws Exception;
	
	public Integer deleteComment(Integer no) throws Exception;

}
