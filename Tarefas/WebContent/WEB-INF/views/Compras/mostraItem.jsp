<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="br.com.tarefas.config.Conversoes"%>
<%@ page import="br.com.tarefas.model.CompraItem"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-header">
	<h1>Pedido ${Compras.compraId} - Itens ${itens.compraItemId}</h1>
</div>

<div class="modal-body">
	<form action="AtualizaItem" method="post">
		<div class="col-xs-8 col-sm-8">
			<label for="recipient-name" class="control-label"> Descrição
				Marca/Modelo:</label> <input type="text" class="form-control"
				required="required" id="recipient-name" name="marcaModelo"
				id="marcaModelo" value="${itens.marcaModelo}">
		</div>
		<div class="col-xs-8 col-sm-8">
			<label for="recipient-name" class="control-label">Quantidade:</label>
			<input type="text" class="form-control" required="required"
				id="recipient-name" name="quantidade" id="quantidade"
				value="${itens.quantidade}"><input type="hidden"
				name="compraId" id="compraId" value="${Compras.compraId}"> <input
				type="hidden" name="compraItemId" id="compraItemId"
				value="${itens.compraItemId}">
		</div>

		<div class="col-xs-8 col-sm-8">
			<label for="recipient-name" class="control-label">Valor
				Unitário:</label> <input type="number" class="form-control"
				required="required" name="valorUnidade" step="any"
				value="${itens.valorUnidade}" />
		</div>
		<div class="col-xs-8 col-sm-8">
			<br>
			<button type="submit" class="btn btn-primary">Enviar dados</button>
		</div>
	</form>
</div>

<c:import url="../config/rodape.jsp" />