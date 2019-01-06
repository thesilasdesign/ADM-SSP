<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<h3 class="header smaller lighter blue">Solicitações para Compras</h3>

<form action="CadastraCompra" method="post">
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-3">Pessoa que receberá entrega:</label> <input
			type="text" required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Ronaldo Batista" name="pessoa">
	</div>
	<div class="col-xs-8 col-sm-2">
		<label for="form-field-2">Data de Solicitação:</label> <input
			type="text" placeholder="22/02/2016" class="form-control"
			<caelum:campoData id="dataSolicitacao"/>
	</div>

	<div class="col-xs-8 col-sm-3">
		<label for="form-field-4">Casa de oração solicitante:</label> <select
			name="comum" id="comum" class="form-control" required="required">
			<option value=""></option>
			<c:forEach items="${igrejas}" var="igrejas">
				<option value="${igrejas.comum}">${igrejas.comum}</option>
			</c:forEach>
		</select>
	</div>

	<div class="col-xs-8 col-sm-8">
		<label for="form-field-2">Justificativa:</label>
		<textarea class="form-control" required="required" rows="5" cols="50"
			name="descricao" placeholder="Ex.: Justificativa da compra...."></textarea>
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-4">Indicaçao de Fornecedor para pedido:</label>
		<input type="text" class="form-control" required="required"
			placeholder="Ex.: Santil Ltda" name="fornecedor">
	</div>
	<div class="col-xs-12 col-sm-12">
		<label>Dados para entrega</label>
	</div>

	<div class="col-xs-8 col-sm-2">
		<label for="form-field-3">Data para entrega:</label> <input
			placeholder="22/02/2016" type="text" class="form-control"
			<caelum:campoData id="dataEntrega"/>
	</div>
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-3">Horário para entrega:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.:14:00 horas" name="horaEntrega">
	</div>
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-4">Centro de Custo:</label> <select
			name="centroCusto" id="centroCusto" class="form-control"
			required="required">
			<option value="77171 - MANUTENÇÃO">77171 - MANUTENÇÃO</option>
			<option value="89190 - CONSTRUÇÃO">89190 - CONSTRUÇÃO</option>
		</select>
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-3">Telefone de Entrega:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: 11 4707-9999" name="telefone">
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-3">Endereço entrega:</label> <input type="text"
			class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: Rua Amapa, 90 casa 6" name="enderecoEntrega">
	</div>

	<div class="col-xs-12 col-sm-12">
		<br> <label>Solicitante</label>
	</div>
	<div class="col-xs-8 col-sm-4">
		<label for="form-field-3">Nome Solicitante:</label> <input type="text"
			class="col-xs-5 col-sm-12" required="required" name="solicitante"
			id="solicitante" value="${usuarioLogado.nome}"><br>
	</div>
	<div class="centered col-xs-8 col-sm-4 ">
		<label for="form-field-3">Email Solicitante:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			name="emailSolicitante" id="emailSolicitante"
			value="${usuarioLogado.email}"><br>
	</div>

	<div class="col-xs-12 col-sm-6">
		<br>
		<button type="submit" class="btn btn-sm btn-success">
			Enviar <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
		</button>
	</div>
</form>
<c:import url="../config/rodape.jsp" />