<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('Sua Senha foi atualizada')
		window.location.href = 'logout';
	</SCRIPT>"
</c:if>