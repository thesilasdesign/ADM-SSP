<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('Usu�rio j� existe em nosso Cadastro, favor se informar com Inform�tica!!!')
		window.location.href = 'loginForm';
	</SCRIPT>"
</c:if>