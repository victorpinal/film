function enviar() {
	$("form")[0].submit();
}
function info(e) {
    $.colorbox({href: 'info?id=' + e.currentTarget.getAttribute("data-id"), width: '400px', height: '200px' });
}
$(document).ready(function () {
	$("input[name='formData.query']").on("keydown", function (e) { if (e.which === 13) { enviar(); } });
	$("input[type='checkbox']").click(enviar);
	$(".info").click(info);
});