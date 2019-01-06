<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('As senhas precisam ser iguais')
		window.location.href = 'alterarSenha';
	</SCRIPT>"
</c:if>