package yes.joywins.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import yes.joywins.dao.IF_CommentJdbcDao;
import yes.joywins.domain.CommentVO;

@Service
public class CommentJdbcServiceImpl implements IF_CommentJdbcService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentJdbcServiceImpl.class);
	
	@Inject
	private IF_CommentJdbcDao dao;


	@Override
	public CommentVO selectComment(Integer no) throws Exception { 
		
		logger.info("selectComment starts...........");
	
		Assert.notNull(no, "selectComment :: 댓글번호가 없습니다.");
	
		CommentVO result = dao.selectComment(no);
	
		if (result != null) {
			return result;
		}
		
		Assert.notNull(result, "selectComment :: 결과가 없습니다.");
		
		return null;
		
	}
	
	@Override
	public List<CommentVO> selectComments() throws Exception { 
		
		logger.info("selectComments starts...........");
		
		List<CommentVO> result = new ArrayList<>();
	
		result.addAll(dao.selectComments());
		
		System.out.println("result size = " + result.size());
		Assert.notNull(result, "selectComments :: 결과가 없습니다.");
	
		{
			return result;
		}
		
	}

	@Transactional
	@Override
	public Integer insertComment(CommentVO comment) throws Exception { 
		
		logger.info("CommentJdbcServiceImpl starts...........");
	
		Assert.notNull(comment, "insertComment :: 댓글 데이터가 없습니다.");
	
		Integer result = dao.insertComment(comment);
	
		if (result == 0) {
			logger.info("insertComment :: 댓글 삽입이 되지 않았습니다.");
			return null;
		}
		
		return result;
		
	}

	@Transactional
	@Override
	public Integer deleteComment(Integer no) throws Exception {
		logger.info("CommentJdbcServiceImpl starts...........");
		
		Assert.notNull(no, "deleteComment :: 댓글번호가 없습니다.");
	
		Integer result = dao.deleteComment(no);
	
		if (result == 0) {
			logger.info("insertComment :: 댓글 삭제가 되지 않았습니다.");
			return result;
		}		
		
		return null;
	}
	
}