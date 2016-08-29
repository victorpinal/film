jQuery(document).ready(function() {
	$("input[name='formData.query']").on("keydown",function(e) { if (e.which == 13) enviar(); });
	//$("input[type='checkbox']").click(enviar());
})
function enviar() {
	$("form")[0].submit();
}