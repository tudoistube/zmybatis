package ldg.mybatis.repository;

import ldg.mybatis.model.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class CommentMapXmlRepository extends AbstractRepository {
	private final String namespace = "ldg.mybatis.repository.mapper.CommentMapper1";

	public Comment selectCommentByPrimaryKey(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectCommentByPrimaryKey";
			return (Comment)sqlSession.selectOne(statement, commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectCommentByCondition";
			return sqlSession.selectList(statement, condition);
		} finally {
			sqlSession.close();
		}
	}
}
