package yes.joywins.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import yes.joywins.domain.CommentVO;

@Repository
public class CommentJdbcDaoImpl implements IF_CommentJdbcDao {
	
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentJdbcDaoImpl.class);
	

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	

	@Override
	public CommentVO selectComment(Integer no) throws Exception {
		
		logger.info("selectComment starts...........");

		Assert.notNull(no, "selectCommentByPrimaryKey :: 댓글번호가 없습니다.");

		StringBuilder sql = new StringBuilder("");
		sql.append(" SELECT comment_no, user_id, comment_content, reg_date ");
		sql.append(" FROM ztbl_comment WHERE comment_no = :commentNo ");

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("commentNo", no);
		
		/* ...213p.MapSqlParameterSource : 조회 조건에 동적으로 값을 설정하기 위해 사용함.
 				   이 객체는 Map 을 사용하는 스프링 JDBC 의 파라미터 객체임.
 				   SQL 에서 ':MapKeyName' 형태로 표현식을 사용하면 Map 의 키와 일치하는 값을
 				   자동으로 설정해줌.
 				   ex) ':commentNo'
 				   스프링 JDBC 는 MapSqlParameterSource 외에도 Map 이 아닌 자바빈을 사용할 수 있는
 				   BeanPropertySqlParameterSource 도 제공하므로, SQL 의 파라미터 객체를 Map 과
 				   자바빈의 사용여부에 따라 선택해서 사용하면 됨.*/
		SqlParameterSource namedParameters = new MapSqlParameterSource(condition);
		
		/* ...213p.MapSqlParameterSource 를 사용해서 SQL 에 파라미터를 설정함.
 				   ↓
 				   SQL 을 실행하고 결과를 자바 객체에 설정하기 위해 
 				   스프링 JDBC 는 결과를 자바 객체에 설정하기 위해 제공하는 RowMapper 를 이용함.
 				   RowMapper 중 자바빈에 결과를 설정하는 ParameterizedBeanPropertyRowMapper 를 사용함.
 				   ParameterizedBeanPropertyRowMapper 는 컬럼명에 해당하는 setter() 를 사용해서 자동으로
 				   값을 설정한 후 객체를 반환함.
 				   
 				   컬럼명과 setter() 의 이름이 동일한 규칙으로 지정돼 있다면 추가로 할 작업은 없음.
 				   컬럼명이 '_'(언더바) 로 명명 규칙을 사용할 때는 낙타 표기법을 사용해 컬럼 별칭을
 				   지정해주면 편리하게 작업할 수 있음.
		 */
		RowMapper<CommentVO> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(CommentVO.class);
		
		CommentVO result = this.jdbcTemplate.queryForObject(sql.toString(), namedParameters, rowMapper);

		if (result != null) {
			return result;
		}
		
		Assert.notNull(result, "selectComment :: 결과가 없습니다.");
		
		return null;
		
	}


	@Override
	public Integer insertComment(CommentVO comment) throws Exception {
		
		logger.info("insertComment starts...........");
		
		Assert.notNull(comment, "insertComment :: 댓글 데이터가 없습니다.");

		StringBuilder sql = new StringBuilder("");
		sql.append("INSERT INTO ztbl_comment(user_id, comment_content, reg_date) ");
		sql.append("VALUES (:user_id, :comment_content, sysdate()) ");

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(comment);
		return this.jdbcTemplate.update(sql.toString(), namedParameters);
	}


	@Override
	public Integer deleteComment(Integer no) throws Exception {

		logger.info("deleteComment starts...........");
		
		Assert.notNull(no, "deleteComment :: 댓글번호가 없습니다.");

		StringBuilder sql = new StringBuilder("");
		sql.append("DELETE FROM ztbl_comment WHERE comment_no = :commentNo ");

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("commentNo", no);
		SqlParameterSource namedParameters = new MapSqlParameterSource(condition);
		
		return this.jdbcTemplate.update(sql.toString(), namedParameters);
		
	}


	@Override
	public List<CommentVO> selectComments() throws Exception {
		
		logger.info("selectComments starts...........");

		StringBuilder sql = new StringBuilder("");
		
		sql.append(" SELECT comment_no, user_id, comment_content, reg_date ");
		sql.append(" FROM ztbl_comment WHERE comment_no > 0 ");
		sql.append(" ORDER BY comment_no desc, user_id desc ");
		
		String sql2 = " SELECT comment_no, user_id, comment_content, reg_date "
				    + " FROM ztbl_comment WHERE comment_no > 0 "
				    + " ORDER BY comment_no desc, user_id desc ";

		Map<String, Object> condition = new HashMap<String, Object>();
		//condition.put("commentNo", no);
		
		/* ...213p.MapSqlParameterSource : 조회 조건에 동적으로 값을 설정하기 위해 사용함.
 				   이 객체는 Map 을 사용하는 스프링 JDBC 의 파라미터 객체임.
 				   SQL 에서 ':MapKeyName' 형태로 표현식을 사용하면 Map 의 키와 일치하는 값을
 				   자동으로 설정해줌.
 				   ex) ':commentNo'
 				   스프링 JDBC 는 MapSqlParameterSource 외에도 Map 이 아닌 자바빈을 사용할 수 있는
 				   BeanPropertySqlParameterSource 도 제공하므로, SQL 의 파라미터 객체를 Map 과
 				   자바빈의 사용여부에 따라 선택해서 사용하면 됨.*/
		SqlParameterSource namedParameters = new MapSqlParameterSource(condition);
		
		/* ...213p.MapSqlParameterSource 를 사용해서 SQL 에 파라미터를 설정함.
 				   ↓
 				   SQL 을 실행하고 결과를 자바 객체에 설정하기 위해 
 				   스프링 JDBC 는 결과를 자바 객체에 설정하기 위해 제공하는 RowMapper 를 이용함.
 				   RowMapper 중 자바빈에 결과를 설정하는 ParameterizedBeanPropertyRowMapper 를 사용함.
 				   ParameterizedBeanPropertyRowMapper 는 컬럼명에 해당하는 setter() 를 사용해서 자동으로
 				   값을 설정한 후 객체를 반환함.
 				   
 				   컬럼명과 setter() 의 이름이 동일한 규칙으로 지정돼 있다면 추가로 할 작업은 없음.
 				   컬럼명이 '_'(언더바) 로 명명 규칙을 사용할 때는 낙타 표기법을 사용해 컬럼 별칭을
 				   지정해주면 편리하게 작업할 수 있음.
		 */
		RowMapper<CommentVO> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(CommentVO.class);
		
		//CommentVO result = this.jdbcTemplate.queryForObject(sql.toString(), namedParameters, rowMapper);
		List<CommentVO> result = this.jdbcTemplate.query(sql2, namedParameters, rowMapper);

		if (result != null) {
			return result;
		}
		
		Assert.notNull(result, "selectComments :: 결과가 없습니다.");
		
		return null;
		
	}

}
