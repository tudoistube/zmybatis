package ldg.mybatis.service;

import ldg.mybatis.model.Comment;
import ldg.mybatis.model.CommentReplies;
import ldg.mybatis.model.CommentUser;
import ldg.mybatis.repository.CommentResultMapRepository;

public class CommentResultMapService {
	private CommentResultMapRepository commentRepository = new CommentResultMapRepository();
	

	public Comment selectCommentByPrimaryKeyConstructor(Long commentNo) {
		return commentRepository.selectCommentByPrimaryKeyWithConstructor(commentNo);
	}
	
	public CommentUser selectCommentByPrimaryKeyAssociation(Long commentNo) {
		return commentRepository.selectCommentByPrimaryKeyAssociation(commentNo);
	}

	public CommentReplies selectCommentByPrimaryKeyCollection(Long commentNo) {
		return commentRepository.selectCommentByPrimaryKeyCollection(commentNo);
	}
}