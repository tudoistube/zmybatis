package ldg.mybatis.repository.mapper;
/*...146p.인터페이스에서는 네임스페이스 = 패키지명 + 인터페이스이름. */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import ldg.mybatis.model.Comment;

public interface IF_CommentMapper {
	
	//...146p.SQL 을 보기 편하게 문자열들을 잘라 배열 형태로 정의할 수 있음.
	//@Select("SELECT comment_no, user_id, comment_content, reg_date FROM COMMENT WHERE comment_no = #{commentNo}")
	@Select({"SELECT ", 
		     "comment_no, user_id, comment_content, reg_date ", 
		     "FROM COMMENT ", 
		     "WHERE comment_no = #{commentNo}"})
	Comment selectCommentByPrimaryKey(Long commentNo);
	
	
	/*...147p.동적 SQL 을 만드는 다른 클래스와 메서드를 지정할 수 있음.
	          동적 SQL 을 만드는 자바 클래스는 CommentSqlProvider.class 이고,
	          CommentSqlProvider 클래스의 selectCommentByCondition 메서드를 실행한
	          결과물로 만들어지는 SQL 을 사용하도록 함.*/
	@SelectProvider(type=CommentSqlProvider.class, method="selectCommentByCondition")
	List<Comment> selectCommentByCondition(Map<String, Object> condition);

}
