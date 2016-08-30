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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.colorbox/1.6.4/jquery.colorbox-min.js"></script>
    <script src="../resources/index.js"></script>
    <s:head  />
</head>
<body>
	<form method="post" accept-charset="utf-8">
        <div class="barra_superior">
            <input type="text" id="query" name="formData.query" class="relleno" value="<s:property value='formData.query'/>" placeholder="">                       
            <button type="button" onclick="$('#query').val('');"><img src="../resources/close.png" alt="Borrar busqueda"></button>
            <s:checkbox key="formData.showOnlyMRU"/>
            <s:checkbox key="formData.showAll"/>
            <s:checkbox key="formData.showPend"/>
            <s:checkbox key="formData.showDupl"/>
            <button type="button"><img src="../resources/refresca.png" alt=""></button>
            <button type="button"><img src="../resources/xml.png" alt=""></button>
        </div>
		<table border="1">	
			<thead>
				<tr>
					<th>Archivo</th>
					<th>Info</th>
					<th>Ruta</th>
					<th>Nombre</th>
					<th>Imdb</th>
					<th>Rating</th>
					<th>R.Count</th>
				</tr>
			</thead>
			<tbody>
                <s:iterator value="formData.films" var="film">
                <tr>                    
                    <td><s:property value="#film.filename"/></td>
                    <td class="img_col"><img class="info" src="../resources/informacion.png" data-id="<s:property value='#film.id'/>"></td>
                    <td><s:property value="#film.ruta"/></td>
                    <td><s:property value="#film.name"/></td>                    
                    <td class="img_col"><img class="imdb" src="../resources/carpeta.png" data-id="<s:property value='#film.imdb_id'/>"></td>
                    <td><s:property value="#film.imdb_rating"/></td>
                    <td><s:property value="#film.imdb_ratingcount"/></td>
                </tr>
                </s:iterator>				
			</tbody>
		</table>
        <div class="barra_inferior">
            <s:select list="formData.mruList" name="formData.dirSelected" onchange="enviar();"></s:select>
            <span>Videos: <s:property value="formData.numero"/> de <s:property value="%{formData.films[0].total}"/> | Media Rating: <s:property value="formData.rating"/> de <s:property value="formData.ratingTotal"/></span>
            <button type="submit"><img src="../resources/refresca.png" alt="">Refresh</button>
        </div>
	</form>    
</body>
</html>