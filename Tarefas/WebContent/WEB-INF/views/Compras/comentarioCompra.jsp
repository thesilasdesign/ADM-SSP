<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Comentários do Pedido ${compras.compraId}</h1>
	</div>
	<div class="col-xs-8 col-sm-8">
	<c:forEach items="${coments}" var="coments">
	<p class="alert alert-info">Nome Usuário: ${coments[3]} <br>Data Comentário: ${coments[2]}<br> Comentário: ${coments[4]} </p>
	</c:forEach>
		<form action="InsereComentario" method="post">
			<div class="form-group">
				<label for="message-text" class="control-label">Comentário:</label>
				<textarea class="form-control" name="texto" id="message-text"></textarea>
				<input value="${compras.compraId}" name="compraId" type="hidden">
				<input value="${usuarioLogado.nome}" name="nome" type="hidden">
			</div>
			<div class="modal-footer">
				<button type="reset" class="btn btn-default">Apagar</button>
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>
		</form>
	</div>
</div>
<c:import url="../config/rodape.jsp" />