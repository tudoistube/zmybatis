package ldg.mybatis.service;

import ldg.mybatis.model.Comment;
import ldg.mybatis.repository.CommentMapXmlRepository;

public class CommentMapService {
	private CommentMapXmlRepository commentRepository = new CommentMapXmlRepository();
	
	public Comment selectByPrimaryKey(Long commentNo) {
		return commentRepository.selectCommentByPrimaryKey(commentNo);
	}

}