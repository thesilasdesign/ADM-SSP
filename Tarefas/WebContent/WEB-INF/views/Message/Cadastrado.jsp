<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('Cadastrado aguarde libera��o, enviaremos E-mail de confirma��o')
		window.location.href = 'loginForm';
	</SCRIPT>"
</c:if>