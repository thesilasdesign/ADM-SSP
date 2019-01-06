<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<h3 class="header smaller lighter blue">Solicitações para Compras</h3>

<form action="SolicitaCompras" method="post">
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-3">Pessoa que receberá entrega:</label> <input
			type="text" required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Ronaldo Batista" name="pessoa" readonly="readonly"
			value="${compras.pessoa}"> <input type="hidden" name="status"
			value="${compras.status}"> <input type="hidden"
			name="compraId" value="${compras.compraId}">
	</div>
	<div class="col-xs-8 col-sm-2">
		<label for="form-field-2">Data de Solicitação:</label> <input
			type="text" name="dataAbertura" class="form-control"
			value="<fmt:formatDate 
			value="${compras.dataAbertura.time}" 
			pattern="dd/MM/yyyy" />"
			readonly="" />
	</div>

	<div class="col-xs-8 col-sm-3">
		<label for="form-field-4">Casa de oração solicitante:</label> <select
			name="comum" id="comum" class="form-control" required="required">
			<option value="${compras.comum}">${compras.comum}</option>
		</select>
	</div>

	<div class="col-xs-8 col-sm-8">
		<label for="form-field-2">Justificativa:</label>
		<textarea class="form-control" required="required" rows="5"
			readonly="" cols="50" value="${compras.descricao}" name="descricao"
			placeholder="Ex.: Justificativa da compra....">${compras.descricao}</textarea>
	</div>

	<div class="col-xs-8 col-sm-8">
		<label for="form-field-4">Indicaçao de Fornecedor para pedido:</label>
		<input type="text" class="form-control" required="required"
			placeholder="Ex.: Santil Ltda" name="fornecedor" readonly=""
			value="${compras.fornecedor}">
	</div>

	<div class="col-xs-12 col-sm-12">
		<label>Dados para entrega</label>
	</div>

	<div class="col-xs-8 col-sm-2">
		<label for="form-field-3">Data para entrega:</label> <input
			placeholder="22/02/2016" type="text" class="form-control"
			name="dataEntrega" readonly=""
			value="<fmt:formatDate 
			value="${compras.dataEntrega.time}" 
			pattern="dd/MM/yyyy" />" />
	</div>
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-3">Horário para entrega:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: 11 4707-9999" name="horaEntrega" readonly=""
			value="${compras.horaEntrega}">
	</div>
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-4">Centro de Custo:</label> <select
			name="centroCusto" id="centroCusto" class="form-control">
			<option value="${compras.centroCusto}">${compras.centroCusto}</option>
		</select>
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-3">Telefone de Entrega:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: 11 4707-9999" name="telefone" readonly=""
			value="${compras.telefone}">
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-3">Endereço entrega:</label> <input type="text"
			class="col-xs-5 col-sm-12" required="required" readonly=""
			placeholder="Ex.: Rua Amapa, 90 casa 6" name="enderecoEntrega"
			value="${compras.enderecoEntrega}"> <br> <br>
	</div>

	<div class="col-xs-8 col-sm-8">
		<br> <label>Itens do Pedido</label>
	</div>
	<div class="col-xs-8 col-sm-8">
		<table id="dynamic-table"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Quantidade</th>
					<th>Marca / Modelo</th>
					<th class="hidden-480">Valor Unitário</th>
					<th class="hidden-480">Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Itens}" var="Itens">
					<tr>
						<td>${Itens[4]}</td>
						<td>${Itens[3]}</td>
						<td>${Itens[6]}</td>
						<td>${Itens[5]}</td>
					</tr>

				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>Valor Total:</td>
					<td>${compras.valorTotal}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-xs-12 col-sm-12">
		<br> <label>Solicitante</label>
	</div>
	<div class="col-xs-8 col-sm-4">
		<label for="form-field-3">Nome Solicitante:</label> <input type="text"
			class="col-xs-5 col-sm-12" required="required" name="solicitante"
			id="solicitante" readonly="" value="${compras.solicitante}"><br>
	</div>
	<div class="centered col-xs-8 col-sm-4 ">
		<label for="form-field-3">Email Solicitante:</label> <input
			type="text" readonly="" class="col-xs-5 col-sm-12"
			required="required" name="emailSolicitante" id="emailSolicitante"
			value="${compras.emailSolicitante}"><br>
	</div>
	<div class="col-xs-12 col-sm-6">
		<br>
		<button type="submit" class="btn btn-sm btn-success">
			Voltar <i class="ace-icon fa fa-arrow-right icon-on-left bigger-110"></i>
		</button>
	</div>
</form>

<c:if
	test="${usuarioLogado.perfil eq 4 or usuarioLogado.perfil eq 5 and(compras.status eq '1-SOLICITADO')}">
	<form action="SelecionaComprador" method="post">
		<div class="col-xs-8 col-sm-8">
			<br> <label>Área do Comprador</label>
		</div>
		<div class="col-xs-8 col-sm-8">
			<input type="hidden" name="status" value="${compras.status}">
			<input type="hidden" name="compraId" value="${compras.compraId}">
			<label for="form-field-4">Selecione um Comprador:</label> <select
				name="comprador" id="comprador" class="form-control"
				required="required">
				<option value="${compras.compradorId}|${compras.comprador}">${compras.comprador}</option>
				
				<c:forEach items="${compradores}" var="compradores">
					<option value="${compradores.usuarioId}|${compradores.nome}">${compradores.nome}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-xs-8 col-sm-8">
			<br>
			<button type="submit" class="btn btn-sm btn-success">
				Enviar <i
					class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</c:if>
<c:import url="../config/rodape.jsp" />