<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>insert Test...</title>
	
	<style>
		#modDiv {
			width: 300px;
			height: 100px;
			background-color: gray;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-top: -50px;
			margin-left: -150px;
			padding: 10px;
			z-index: 1000;
		}
		
		.pagination {
		  width: 100%;
		}
		
		.pagination li{
		  list-style: none;
		  float: left; 
		  padding: 3px; 
		  border: 1px solid blue;
		  margin:3px;  
		}
		
		.pagination li a{
		  margin: 3px;
		  text-decoration: none;  
		}	
	</style>
</head>
<body>

	<h2>insert Test...</h2>
	
	<form role="form" method="post"
		  id = "insertForm"> <!-- ...595p.submit처리를 위해 id값을 설정함. -->
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자 아이디</label> 
				<input type="text" name='user_id' placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">댓글내용</label>
				<textarea class="form-control" 
							name="comment_content" rows="3" placeholder="Enter ..."></textarea>
			</div>		
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		<button type="reset" class="btn btn-warning">CANCEL</button>
	</form>

<script>    
    var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("처리가 완료되었습니다.");
    }    
</script>

</body>
</html>