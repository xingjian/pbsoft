<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试struts环境</title>
</head>
<body>
	<s:form name="loginForm" action="login" method="post" namespace="/">
		<s:textfield label="用户名" name="userName" />
		<s:password label="密    码" name="password" />
		<s:submit value="登录" />
		<s:reset value="重置" />
	</s:form>
</body>
</html>