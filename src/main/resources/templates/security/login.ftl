<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8" />
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<title>登录</title>
	<script src="/static/plugins/jquery/jquery-1.12.4.min.js" type="text/javascript"></script>
</head>
<body>
	  <h1>登录<#if error??>11111---${error!}</#if></h1>
	  <form id="form1">
	  	<input type="text" name="id"/>
	  	<input type="text" name="name"/>
	  	<button type="button">提交</button>
	  </form>
	  <script>
	  	$(function(){
	  		$('#form1 button').click(function(){
	  			var formdata = $("#form1").serialize();
	  			var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
	  			$.ajax({
					type : "POST",
					url : "./login",
					data:formdata,
					dataType : "json",
					beforeSend: function(request) {
                        request.setRequestHeader(header, token);
                    },
					success : function(data) {
						if (!!data.error) {
							alert(data.error)
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
						console.log(errorThrown)
						alert('系统错误');
					}
				});
	  		})
	  	})
	  
	  
	  </script>
</body> 
</html>
