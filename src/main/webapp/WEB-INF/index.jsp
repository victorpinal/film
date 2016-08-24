<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title><s:text name="title"/></title>
	<link rel="stylesheet" href="../resources/index.css">
    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <s:head  />
</head>
<body>
	<form method="post" accept-charset="utf-8">
        <div class="barra_superior">
            <input type="text" name="queryData.query" class="relleno" value="<s:property value='queryData.query'/>" placeholder="">                       
            <button type="button"><img src="../resources/close.png" alt=""></button>
            <s:checkbox key="queryData.mru"/>
            <s:checkbox key="queryData.todo"/>
            <s:checkbox key="queryData.pend"/>
            <s:checkbox key="queryData.dupl"/>
            <button type="button"><img src="../resources/refresca.png" alt=""></button>
            <button type="button"><img src="../resources/xml.png" alt=""></button>
        </div>
		<table border="1">	
			<thead>
				<tr>
					<th>Ver</th>
					<th>Archivo</th>
					<th>Info</th>
					<th>Ruta</th>
					<th>Nombre</th>
					<th>&nbsp;</th>
					<th>Sub</th>
					<th>Imdb</th>
					<th>&nbsp;</th>
					<th>Rating</th>
					<th>R.Count</th>
				</tr>
			</thead>
			<tbody>
                <s:iterator value="formData.films" var="film">
                <tr>
                    <td class="img_col"><img src="../resources/Video.png"></td>
                    <td><s:property value="#film.filename"/></td>
                    <td class="img_col"><img src="../resources/informacion.png"></td>
                    <td><s:property value="#film.ruta"/></td>
                    <td><s:property value="#film.name"/></td>
                    <td class="img_col"><img src="../resources/busca.png"></td>
                    <td class="img_col"><img src="../resources/subs.png"></td>
                    <td><s:property value="#film.imdb_id"/></td>
                    <td class="img_col"><img src="../resources/carpeta.png"></td>
                    <td><s:property value="#film.imdb_rating"/></td>
                    <td><s:property value="#film.imdb_ratingcount"/></td>
                </tr>
                </s:iterator>				
			</tbody>
		</table>
        <div class="barra_inferior">
            <button type="button"><img src="../resources/Home.png" alt="">Change dir</button>
            <s:select list="formData.mru" name="queryData.dir" onchange="jQuery('form')[0].submit();"></s:select>
            <button type="button"><img src="../resources/carpeta.png" alt=""></button>
            <span>Videos: #Num de <s:property value="%{formData.films[0].total}"/> | Media Rating: #Media de #MEDIA</span>
            <button type="submit"><img src="../resources/refresca.png" alt="">Refresh</button>
        </div>
	</form>    
    <script>
        jQuery("input[name='queryData.query']").on("keydown",function(e) { if (e.which == 13) $("form")[0].submit(); });
    </script>
</body>
</html>