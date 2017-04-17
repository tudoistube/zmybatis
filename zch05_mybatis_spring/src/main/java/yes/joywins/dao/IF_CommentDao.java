package yes.joywins.dao;

import java.util.List;

import yes.joywins.domain.CommentVO;

public interface IF_CommentDao {
	
	public CommentVO selectComment(Integer commentNo) throws Exception;
	
	public List<CommentVO> selectComments() throws Exception;

}
