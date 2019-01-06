<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="cabecalho.jsp" />
<html>
<body>
	<c:import url="acessos.jsp" />

	<p>Bem vindo, ${usuarioLogado.login}</p>
	<a href="listaTarefas">Clique aqui</a> para acessar a lista de tarefas
	
	<a href="logout">Sair do sistema</a>
</body>
</html>
<c:import url="rodape.jsp" />