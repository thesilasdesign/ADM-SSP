<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('Usuário já existe em nosso Cadastro, favor se informar com Informática!!!')
		window.location.href = 'loginForm';
	</SCRIPT>"
</c:if>