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
<div class="page-content">
	<div class="page-header">
		<h1>Aprovação Pedido ${compras.compraId}</h1>
	</div>
	<!-- /.page-header -->
	<form action="EnviaAprovacao" method="post">
		<div class="col-xs-12 col-sm-12">
		<input type="hidden" name="compraId" value="${compras.compraId}">
			<label for="form-field-4">Enviar para aprovação:</label> <select
				name="enviaAprovacao" id="enviaAprovacao" class="form-control">
				<option value="1">Solicitação de Aprovação</option>
			</select> 
			<button type="submit" class="btn btn-sm btn-success">
				Enviar para aprovação <i
					class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
	<div class="col-xs-12 col-sm-12">
		<hr>
		<label for="form-field-4">Status de aprovação:</label><br>
		<hr>

		<c:set var="presidente" value="${compras.aprovacaoPresidente}" />
		<c:if test="${fn:contains(presidente, '1')}">
			<label for="form-field-4">Presidente: Enviado para aprovação</label>
			<br>
		</c:if>
		<c:if test="${fn:contains(presidente, '2')}">
			<label for="form-field-4">Presidente: Reprovado</label>
			<br>
		</c:if>

		<c:set var="tesoureiro" value="${compras.aprovacaoTesoureiro}" />
		<c:if test="${fn:contains(tesoureiro, '1')}">
			<label for="form-field-4">Tesouraria: Enviado para aprovação</label>
			<br>
		</c:if>
		<c:if test="${fn:contains(tesoureiro, '2')}">
			<label for="form-field-4">Tesouraria: Reprovado</label>
			<br>
		</c:if>

		<c:set var="engenheiro" value="${compras.aprovacaoEngenheiro}" />
		<c:if test="${fn:contains(engenheiro, '1')}">
			<label for="form-field-4">Engenharia: Enviado para aprovação</label>
			<br>
		</c:if>
		<c:if test="${fn:contains(engenheiro, '2')}">
			<label for="form-field-4">Engenharia: Reprovado</label>
			<br>
		</c:if>

	</div>
</div>
<c:import url="../config/rodape.jsp" />