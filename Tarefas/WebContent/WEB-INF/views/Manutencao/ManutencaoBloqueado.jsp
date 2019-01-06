<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<h3 class="header smaller lighter blue">Solicitação Número: ${manutencao.manutencaoId}</h3>

<form action="AtualizaManutencao" method="post">

	<div class="col-xs-12 col-sm-4">
		<label for="form-field-4">Casa de oração:</label> <select
			name="comum" id="comum" class="form-control" required="required">
				<option value="${manutencao.comum}">${manutencao.comum}</option>
		</select>
	</div>

	<div class="col-xs-12 col-sm-4">
		<label for="form-field-2">Data de Solicitação:</label> <input
			type="text" placeholder="22/02/2016" class="form-control" id="dataSolicitacao" value="<fmt:formatDate 
			value="${manutencao.dataSolicitacao.time}" 
			pattern="dd/MM/yyyy" />"
			readonly="" /><caelum:campoData id="dataSolicitacao"/>
	</div>

	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Solicitante:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Joao Batista" name="ResponsavelSolicitacao" value="${manutencao.responsavelSolicitacao}">
			<input type="hidden" name="manutencaoId" value="${manutencao.manutencaoId}">
	</div>

	<div class="col-xs-12 col-sm-6">
		<label for="form-field-3">Ministerio/Cargo:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Tesoureiro" name="MinisterioCargo" value="${manutencao.ministerioCargo}">
	</div>

	<div class="col-xs-12 col-sm-6">
		<label for="form-field-3">E-mail:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: thiago@gmail.com" name="email" value="${manutencao.email}">
	</div>

	<div class="col-xs-12 col-sm-6">
		<label for="form-field-3">Telefone:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: 11 3444-4555" name="telefone" value="${manutencao.telefone}">
	</div>
	<div class="col-xs-12 col-sm-6">
		<label for="form-field-4">Ministerio Local Ciente? Selecione:</label> <select
			name="ministerioCiente" id="ministerioCiente" class="form-control" required="required">
				<option value="${manutencao.ministerioCiente}">${manutencao.ministerioCiente}</option>
		</select>
	</div>

	<div class="col-xs-12 col-sm-12">
		<label for="form-field-2">Observação:</label>
		<textarea class="form-control" required="required" rows="2" cols="50"
			name="observacao" placeholder="Ex.: Descrição da Manutencao....">${manutencao.observacao}</textarea>
	</div>
	
	<div class="col-xs-12 col-sm-12">
		<label for="form-field-2">Itens da Manutenção:</label>
		<textarea class="form-control" required="required" rows="3" cols="50"
			name="itens" placeholder="Ex.: 02 - Sacos Cimentos - Valor 23,00">${manutencao.itens}</textarea>
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-2">Estimativa de conclusão após aprovado:</label> <input
			type="text" placeholder="22/02/2016" class="form-control" value="<fmt:formatDate 
			value="${manutencao.estimativa.time}" 
			pattern="dd/MM/yyyy" />"
			readonly="" />
	</div>
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-4">Selecione Caixa:</label> <select
			name="caixa" id="caixa" class="form-control" required="required">
				<option value="${manutencao.caixa}">${manutencao.caixa}</option>
		</select>
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-2">Prazo Retorno ADM até:</label> <input
			type="text" placeholder="22/02/2016" class="form-control" value="<fmt:formatDate 
			value="${manutencao.prazoRetorno.time}" 
			pattern="dd/MM/yyyy" />"
			readonly="" />
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Assinatura Adm:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Batista" name="adm" value="${manutencao.adm}">
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Assinatura Engenharia:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Ronaldo" name="engenharia" value="${manutencao.engenharia}">
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Assinatura Ancião:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Adilson Batista" name="anciao" value="${manutencao.anciao}">
	</div>

<!-- 	<div class="col-xs-12 col-sm-12"> -->
<!-- 		<br> -->
<!-- 		<button type="submit" class="btn btn-sm btn-success"> -->
<!-- 			Gravar Dados <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i> -->
<!-- 		</button> -->
<!-- 	</div> -->
</form>
<c:import url="../config/rodape.jsp" />