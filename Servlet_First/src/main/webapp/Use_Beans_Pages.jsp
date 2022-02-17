<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Use_Beans_Pages</title>
</head>
<body>
<!-- 取得した値を表示する -->
<h2>id:${customer.id}</h2>
<h2>name:<c:out value="${customer.name}"/></h2>
<h2>height:<c:out value="${customer.height}"/></h2>
<h2>flag:${customer.flag}</h2>
<hr/>

</body>
</html>