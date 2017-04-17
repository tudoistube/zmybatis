package yes.joywins.service;

import java.util.List;

import yes.joywins.domain.CommentVO;

public interface IF_CommentService {
	
	public CommentVO selectComment(Integer commentNo) throws Exception;
	public List<CommentVO> selectComments() throws Exception;

}
