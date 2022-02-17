<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBean_SetGet.jsp</title>
</head>
<body>
<!-- useBeanでインスタンスを取得する -->
<jsp:useBean id="customer0000" class="first.bean.CustomerBean"/>

<!-- setPropertyでインスタンスに値を設定 -->
<jsp:setProperty property="id" name="customer0000" value="2"/>
<jsp:setProperty property="name" name="customer0000" value="佐藤"/>
<jsp:setProperty property="height" name="customer0000" value="170.0"/>
<jsp:setProperty property="flag" name="customer0000" value="1"/>

getPropertyで取り出す：
<jsp:getProperty property="id" name="customer0000"/>
<jsp:getProperty property="name" name="customer0000"/>
<jsp:getProperty property="height" name="customer0000"/>
<jsp:getProperty property="flag" name="customer0000"/>

</body>
</html>