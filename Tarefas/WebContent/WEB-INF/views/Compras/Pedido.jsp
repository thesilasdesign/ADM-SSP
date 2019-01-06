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

<form action="AtualizaCompra" method="post">
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-3">Pessoa que receberá entrega:</label> <input
			type="text" required="required" class="col-xs-5 col-sm-12"
			placeholder="Ex.: Ronaldo Batista" name="pessoa"
			value="${compras.pessoa}"> <input type="hidden"
			name="compraId" value="${compras.compraId}">
	</div>
	<div class="col-xs-8 col-sm-2">
		<label for="form-field-2">Data de Solicitação:</label> <input
			type="text" name="dataAbertura" class="form-control"
			value="<fmt:formatDate 
			value="${compras.dataAbertura.time}" 
			pattern="dd/MM/yyyy" />" />
	</div>

	<div class="col-xs-8 col-sm-3">
		<label for="form-field-4">Casa de oração solicitante:</label> <select
			name="comum" id="comum" class="form-control" required="required">
			<option value="${compras.comum}">${compras.comum}</option>
			<c:forEach items="${igrejas}" var="igrejas">
				<option value="${igrejas.comum}">${igrejas.comum}</option>
			</c:forEach>
		</select>
	</div>

	<div class="col-xs-8 col-sm-8">
		<label for="form-field-2">Justificativa:</label>
		<textarea class="form-control" required="required" rows="5" cols="50"
			name="descricao" placeholder="Ex.: Justificativa da compra....">${compras.descricao}</textarea>
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-4">Indicaçao de Fornecedor para pedido:</label>
		<input type="text" class="form-control" required="required"
			placeholder="Ex.: Santil Ltda" name="fornecedor"
			value="${compras.fornecedor}">
	</div>

	<div class="col-xs-12 col-sm-12">
		<label>Dados para entrega</label>
	</div>

	<div class="col-xs-8 col-sm-2">
		<label for="form-field-3">Data para entrega:</label> <input
			placeholder="22/02/2016" type="text" class="form-control"
			name="dataEntrega"
			value="<fmt:formatDate 
			value="${compras.dataEntrega.time}" 
			pattern="dd/MM/yyyy" />" />
	</div>
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-3">Horário para entrega:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: 11 4707-9999" name="horaEntrega"
			value="${compras.horaEntrega}">
	</div>
	<div class="col-xs-8 col-sm-3">
		<label for="form-field-4">Centro de Custo:</label> <select
			name="centroCusto" id="centroCusto" class="form-control">
			<option value="${compras.centroCusto}">${compras.centroCusto}</option>
			<option value="89190 - CONSTRUÇÃO">89190 - CONSTRUÇÃO</option>
			<option value="77171 - MANUTENÇÃO">77171 - MANUTENÇÃO</option>
		</select>
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-3">Telefone de Entrega:</label> <input
			type="text" class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: 11 4707-9999" name="telefone"
			value="${compras.telefone}">
	</div>
	<div class="col-xs-8 col-sm-8">
		<label for="form-field-3">Endereço entrega:</label> <input type="text"
			class="col-xs-5 col-sm-12" required="required"
			placeholder="Ex.: Rua Amapa, 90 casa 6" name="enderecoEntrega"
			value="${compras.enderecoEntrega}">
	</div>

	<div class="col-xs-8 col-sm-8">
		<br> <label>Área do Comprador</label>
	</div>
	<c:if test="${usuarioLogado.perfil eq 4 or usuarioLogado.perfil eq 5}">

		<div class="col-xs-8 col-sm-8">
			<label for="form-field-4">Selecione um Comprador:</label> <select
				name="comprador" id="comprador" class="form-control"
				required="required">
				<option value="${compras.compradorId}|${compras.comprador}">${compras.comprador}</option>
				<option value='|'>--||--</option>
				<option value='1|Silas Oliveira'>Silas Oliveira</option>
				<option value='54|José Wilson'>José Wilson</option>
				<option value='55|Isaac Santos'>Isaac Santos</option>
				<option value='56|José Luiz'>José Luiz</option>
				<option value='51|Michael Bryan'>Michael Bryan</option>
				<option value='27|Renato Ulisses'>Renato Ulisses</option>
				<option value='127|Marlene Lima'>Marlene Lima</option>
				<option value='171|Cristiane de Lima'>Cristiane de Lima</option>
				<option value='166|Rosimeire Raquel de Souza'>Rosimeire Raquel de Souza</option>
			</select>
		</div>

		<div class="col-xs-8 col-sm-8">
			<label for="form-field-4">Mudar Status:</label> <select name="status"
				class="form-control" required="required">
				<option value="${compras.status}">${compras.status}</option>
				<option value="2-ANALISE COMPRADOR">2-ANALISE COMPRADOR</option>
				<option value="3-PENDENTE INFORMAÇÃO">3-PENDENTE INFORMAÇÃO</option>
				APROVAÇÃO
				</option>
				<option value="6-ORCAMENTO E COMPRA">6-ORCAMENTO E COMPRA</option>
				<option value="7-AGUARDANDO ENTREGA">7-AGUARDANDO ENTREGA</option>
				<option value="8-FINALIZADO">8-FINALIZADO</option>9-CANCELADO
				<option value="9-CANCELADO">9-CANCELADO</option>
				<option value="12-AGUARDANDO APROVACAO REUNIAO">12-AGUARDANDO APROVACAO REUNIAO</option>
			</select>
		</div>
	</c:if>
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
	<div class=" center col-xs-8 col-sm-8">
		<br>
		<button type="submit" class="btn btn-sm btn-success">
			Atualizar Pedido <i
				class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
		</button>
	</div>
</form>

<div class=" center col-xs-8 col-sm-8">
	</br> <a href="ItemPedido" class="btn btn-app btn-yellow"> <i
		class="ace-icon fa fa-bars bigger-230"></i> Itens
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="Pagamento?id=${compras.compraId}" class="btn btn-app btn-danger"> <i
		class="ace-icon fa fa-credit-card bigger-230"></i>Pagto
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="GerarPDFCompra.pdf?id=${compras.compraId}" class="btn btn-app btn-success"> <i
		class="ace-icon fa fa-file-pdf-o bigger-230"></i> PDF
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="ArquivoCompra?id=${compras.compraId}" class="btn btn-app btn-primary"> <i
		class="ace-icon fa fa-files-o bigger-230"></i> Arquivos
	</a>
</div>

<c:import url="../config/rodape.jsp" />