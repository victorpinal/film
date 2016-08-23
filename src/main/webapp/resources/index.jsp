<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title><s:text name="title"/></title>
	<link rel="stylesheet" href="../resources/index.css">
</head>
<body>
	<form action="index" method="get" accept-charset="utf-8">
        <div class="barra_superior">
            <input type="text" name="queryData.query" class="relleno" value="%{queryData.query}" placeholder="">            
            <button type="button"><img src="../resources/close.png" alt=""></button>
            <label><input type="checkbox" name="queryData.mru" value="%{queryData.mru}">MRU</label>
            <label><input type="checkbox" name="queryData.todo" value="%{queryData.todo}">Todo</label>
            <label><input type="checkbox" name="queryData.pend" value="%{queryData.pend}">Pend.IMDB</label>
            <label><input type="checkbox" name="queryData.dupl" value="%{queryData.dupl}">Duplicados</label>
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
				<tr>
					<td class="img_col"><img src="../resources/Video.png"></td>
					<td>data</td>
					<td class="img_col"><img src="../resources/informacion.png"></td>
					<td>data</td>
					<td>data</td>
					<td class="img_col"><img src="../resources/busca.png"></td>
					<td class="img_col"><img src="../resources/subs.png"></td>
					<td>data</td>
					<td class="img_col"><img src="../resources/carpeta.png"></td>
					<td>data</td>
					<td>data</td>
				</tr>
			</tbody>
		</table>
        <div class="barra_inferior">
            <button type="button"><img src="../resources/Home.png" alt="">Change dir</button>
            <select name="dir" class="relleno">
                <option value="">D:\Video</option>			
            </select>
            <button type="button"><img src="../resources/carpeta.png" alt=""></button>
            <span>Videos: #Num de #NUM | Media Rating: #Media de #MEDIA</span>
            <button type="button"><img src="../resources/refresca.png" alt="">Refresh</button>
        </div>
	</form>
</body>
</html>