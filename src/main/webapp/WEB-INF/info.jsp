<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/info.css">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(document).ready(function () {
	var omdb = JSON.parse("<s:property value='omdb' escapeHtml='false' escapeJavaScript='true'/>");
	$('#title').text(omdb.Title);
	//$('#img_poster').setAttribute("src",omdb.Poster);
	$('#year').text(omdb.Year);
	$('#runtime').text(omdb.Runtime);
	$('#genre').text(omdb.Genre);
	$('#director').text(omdb.Director);
	$('#actors').text(omdb.Actors);
	$('#plot').text(omdb.Plot);
});
</script>
</head>
<body>
    <section>
        <header><span id="title">title</span></header>
        <article>
            <div id="poster"><img id="img_poster" src="" alt="poster"/></div>
            <div id="detail">
                <span id="year">&nbsp;</span>
                <span id="runtime">&nbsp;</span>
                <span id="genre">&nbsp;</span>
                <span id="director">&nbsp;</span>
                <span id="actors">&nbsp;</span>
                <span id="plot">&nbsp;</span>
            </div>
        </article>
    </section>
</body>
</html>