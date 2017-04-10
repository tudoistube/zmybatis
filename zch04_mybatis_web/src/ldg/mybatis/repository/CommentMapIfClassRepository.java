package ldg.mybatis.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ldg.mybatis.model.Comment;
import ldg.mybatis.repository.mapper.IF_CommentMapper;

public class CommentMapIfClassRepository extends AbstractRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentMapIfClassRepository.class);
	
	public Comment selectCommentByPrimaryKey(Long commentNo) {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Comment result = null;
		try {
			/* ...149p.매퍼 XML 을 사용할 때와 차이점 :
	           XML 매핑 구문을 사용할 때 : SqlSession 객체가 제공하는 메서드를 사용함.
	           어노테이션 매핑 구문을 사용할 때 : SqlSession 객체가 제공하는 getMapper() 를
	                                              사용해 인터페이스가 제공하는 메서드를 그대로
	                                              호출해서 사용함.*/
			result = sqlSession.getMapper(IF_CommentMapper.class).selectCommentByPrimaryKey(commentNo);
		} catch (Exception e) {
			LOGGER.warn("{} : {}", e.getMessage(), e);
		} finally {
			sqlSession.close();
		}
		return result;
	}
}
