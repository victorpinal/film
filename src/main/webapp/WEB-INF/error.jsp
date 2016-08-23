<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html">
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="error.title"/></title>
</head>
<body>
    <p><h3><s:text name="error.description"/></h3></p>
    <p><s:property value="exception"/></p>
    <s:a action="index"><s:text name="error.back"/></s:a>
</body>
</html>