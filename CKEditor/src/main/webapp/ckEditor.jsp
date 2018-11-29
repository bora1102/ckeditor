<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script src="resources/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script>
	var editorConfig = {
	        filebrowserUploadUrl : "/fileUpload.do", //이미지 업로드
	    };
	
	    CKEDITOR.on('dialogDefinition', function( ev ){
	        var dialogName = ev.data.name;
	        var dialogDefinition = ev.data.definition;
	
	        switch (dialogName) {
	            case 'image': //Image Properties dialog
	            //dialogDefinition.removeContents('info');
	            dialogDefinition.removeContents('Link');
	            dialogDefinition.removeContents('advanced');
	            break;
	        }
	    });
	 window.onload = function(){
	      ck = CKEDITOR.replace("ckeditor", editorConfig);
	 };
</script>
</head>
<body>
<div class="container">
	<br><br><br>
	<form action="insert" method="post">
		<div class="form-group">
			<div class="form-group">
				제목 <input type="text" class="form-control" name="title" id="subject">
			</div>
			<hr>
			<div id="form-group">
				<textarea name="content" id="ckeditor"></textarea>
			</div>
		</div>
		<button type="submit" class="btn btn-primary pull-right">저장</button>
	</form>
</div>
</body>
</html>