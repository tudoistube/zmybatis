package yes.joywins.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yes.joywins.dao.IF_CommentDao;
import yes.joywins.domain.CommentVO;

@Service
public class CommentServiceImpl implements IF_CommentService {
	
	@Inject
	private IF_CommentDao dao;

	@Override
	public CommentVO selectComment(Integer commentNo) throws Exception {
		// TODO Auto-generated method stub
		CommentVO dto = dao.selectComment(commentNo);

		return dto;
	}
	
	//public List<Comment> selectComments(Long commentNo) throws Exception {
	public List<CommentVO> selectComments() throws Exception {
		
		//Map<String, Object> condition = new HashMap<String, Object>();
		//condition.put("commentNo", commentNo);
		
		List<CommentVO> list = new ArrayList<>();
		
		list.addAll(dao.selectComments());
		
		System.out.println("list size = " + list.size());

		return list;
	}
	
}