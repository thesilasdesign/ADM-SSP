<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('Sua Senha foi enviada no seu E-mail')
		window.location.href = 'loginForm';
	</SCRIPT>"
</c:if>