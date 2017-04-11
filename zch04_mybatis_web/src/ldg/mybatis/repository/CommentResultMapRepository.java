package ldg.mybatis.repository;

import ldg.mybatis.model.*;

import org.apache.ibatis.session.SqlSession;

public class CommentResultMapRepository extends AbstractRepository {
	private final String namespace = "ldg.mybatis.repository.mapper.CommentMapperWithResultMap1";


	public Comment selectCommentByPrimaryKeyWithConstructor(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectCommentByPrimaryKeyWithConstructor";
			return (Comment)sqlSession.selectOne(statement, commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
	public CommentUser selectCommentByPrimaryKeyAssociation(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectCommentByPrimaryKeyAssociation";
			return (CommentUser)sqlSession.selectOne(statement, commentNo);
		} finally {
			sqlSession.close();
		}
	}

	public CommentColumnPrefix selectColumnPrefix(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectColumnPrefix";
			return sqlSession.selectOne(statement, commentNo);
		} finally {
			sqlSession.close();
		}
	}
	

	public CommentReplies selectCommentByPrimaryKeyCollection(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectCommentByPrimaryKeyCollection";
			return (CommentReplies)sqlSession.selectOne(statement, commentNo);
		} finally {
			sqlSession.close();
		}
	}
	
}
