<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('Cadastrado aguarde liberação, enviaremos E-mail de confirmação')
		window.location.href = 'loginForm';
	</SCRIPT>"
</c:if>