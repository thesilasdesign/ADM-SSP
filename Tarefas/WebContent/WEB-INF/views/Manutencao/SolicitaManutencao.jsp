<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<h3 class="header smaller lighter blue">Solicitação Manutenção</h3>

<form action="CadastroManutencao" method="post">

	<div class="col-xs-12 col-sm-4">
		<label for="form-field-4">Casa de oração:</label> <select
			name="comum" id="comum" class="form-control" required="required">
			<c:forEach items="${comum}" var="comum">
				<option value="${comum.comum}">${comum.comum}</option>
			</c:forEach>
		</select>
	</div>

	<div class="col-xs-12 col-sm-4">
		<label for="form-field-2">Data de Solicitação:</label> <input
			type="text" placeholder="22/02/2016" class="form-control"
			<caelum:campoData id="dataSolicitacao"/>
	</div>

	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Solicitante:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Joao Batista" name="ResponsavelSolicitacao">
	</div>

	<div class="col-xs-12 col-sm-6">
		<label for="form-field-3">Ministerio/Cargo:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Tesoureiro" name="MinisterioCargo">
	</div>

	<div class="col-xs-12 col-sm-6">
		<label for="form-field-3">E-mail:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: thiago@gmail.com" name="email">
	</div>

	<div class="col-xs-12 col-sm-6">
		<label for="form-field-3">Telefone:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: 11 3444-4555" name="telefone">
	</div>
	<div class="col-xs-12 col-sm-6">
		<label for="form-field-4">Ministerio Local Ciente? Selecione:</label> <select
			name="ministerioCiente" id="ministerioCiente" class="form-control" required="required">
				<option value="Ancião">Ancião</option>
				<option value="Cooperador">Cooperador</option>
				<option value="Diácono">Diácono</option>
		</select>
	</div>

	<div class="col-xs-12 col-sm-12">
		<label for="form-field-2">Observação:</label>
		<textarea class="form-control" required="required" rows="5" cols="50"
			name="observacao" placeholder="Ex.: Descrição da Manutencao...."></textarea>
	</div>
	
	<div class="col-xs-12 col-sm-12">
		<label for="form-field-2">Itens da Manutenção:</label>
		<textarea class="form-control" required="required" rows="5" cols="50"
			name="itens" placeholder="Ex.: 02 - Sacos Cimentos - Valor 23,00"></textarea>
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-2">Estimativa de conclusão após aprovado:</label> <input
			type="text" placeholder="22/02/2016" class="form-control"
			<caelum:campoData id="estimativa"/>
	</div>
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-4">Selecione Caixa:</label> <select
			name="caixa" id="caixa" class="form-control" required="required">
				<option value="Caixa Manutenção">Caixa Manutenção</option>
				<option value="Caixa Manutenção">Caixa Construção</option>
				<option value="Analise Engenharia">Analise Engenharia</option>
				<option value="Passará Reunião Bimestral">Passará Reunião Bimestral</option>
				<option value="Mão de Obra Voluntária">Mão de Obra Voluntária</option>
				<option value="Mão de Obra Terceirizada">Mão de Obra Terceirizada</option>
		</select>
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-2">Prazo Retorno ADM até:</label> <input
			type="text" placeholder="22/02/2016" class="form-control"
			<caelum:campoData id="prazoRetorno"/>
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Assinatura Adm:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Batista" name="adm">
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Assinatura Engenharia:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Ronaldo" name="engenharia">
	</div>
	
	<div class="col-xs-12 col-sm-4">
		<label for="form-field-3">Assinatura Ancião:</label> <input type="text"
			required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Adilson Batista" name="anciao">
	</div>

	<div class="col-xs-12 col-sm-12">
		<br>
		<button type="submit" class="btn btn-sm btn-success">
			Gravar Dados <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
		</button>
	</div>
</form>
<c:import url="../config/rodape.jsp" />