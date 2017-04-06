package ldg.mybatis.repository.session;

import java.io.*;
import java.util.*;

import ldg.mybatis.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class CommentSessionRepository {
	private final String namespace = "ldg.mybatis.repository.mapper.CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		//...81p.클래스패스를 기준으로 가장 상위에 있음.
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		//...81p.마이바티스 설정 정보를 가진 객체 생성함.
		//       SqlSessionFactory 객체는 애플리케이션 내에서 한 개만 생성됨.
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public Comment selectCommentByPrimaryKey(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Comment)sqlSession.selectOne(namespace + ".selectCommentByPrimaryKey", commentNo);
		} finally {
			sqlSession.close();
		}
	}

	public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".selectCommentByCondition", condition);
		} finally {
			sqlSession.close();
		}
	}

	public Integer insertComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".insertComment";
			int result = sqlSession.insert(statement, comment);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateComment(Comment comment) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".updateComment";
			int result = sqlSession.update(statement, comment);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Integer deleteComment(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".deleteComment";
			int result = sqlSession.delete(statement, commentNo);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
