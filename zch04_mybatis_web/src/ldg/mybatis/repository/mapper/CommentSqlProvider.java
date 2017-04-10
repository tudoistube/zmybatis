package ldg.mybatis.repository.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Map;

public class CommentSqlProvider {
	
	public String selectCommentByCondition(Map<String, Object> condition) {
		/*...148p.마이바티스에서는 SQL 을 작성할 때 SQL 예약어들을 자동으로 
		          처리해주는 구문 빌더 API 를 사용할 수 있음.
		          예) BEGIN, SELECT, FROM...*/
		BEGIN();
		SELECT("comment_no, user_id, comment_content, reg_date");
		FROM("comment");
		WHERE("comment_no = #{commentNo}");

		return SQL();
	}
	
}
