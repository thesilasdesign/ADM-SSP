<c:import url="config/cabecalho.jsp" />

<c:if test="${not empty downloaderror}">
	<SCRIPT LANGUAGE='JavaScript'>
		window.alert('CPF já Cadastrado!!! Favor verificar')
		window.location.href = 'Adesao';
	</SCRIPT>"
</c:if>