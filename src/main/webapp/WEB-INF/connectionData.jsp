<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html">
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="title.connectionData"/></title>
</head>
<body>
    <s:form>
        <s:textfield key="connectionData.mysqlserver"></s:textfield>
        <s:textfield key="connectionData.mysqlport" type="number"></s:textfield>
        <s:textfield key="connectionData.mysqluser" placeholder="sa"></s:textfield>
        <s:textfield key="connectionData.mysqlpwd" type="password"></s:textfield>
        <s:submit></s:submit>
    </s:form>
</body>
</html>