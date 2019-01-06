<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<div class="page-content">
	<div class="page-header">
		<h1>Formas de Pagamento Pedido ${Compras.compraId}</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="clearfix">
				<div class="pull-right tableTools-container"></div>
			</div>
			
			<div class="btn-group">
				<div>
					<a href="javascript:window.history.go(-1)">Voltar</a>
				</div>
			</div>
			<div class="table-header">Últimos resultados</div>
			<div class="table-responsive">
				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover" width="100%">
					<thead>
						<tr>
							<th>Id Pagamento</th>
							<th>Forma Pagamento</th>
							<th>Tipo Pagamento</th>
							<th>Data Vencimento</th>
							<th>Valor Parcela</th>
							<th>Número Parcela</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagamentos}" var="pagamentos">
							<tr>
								<td>${pagamentos.pagamentoId}</td>
								<td>${pagamentos.avistaPrazo}</td>
								<td><fmt:formatDate value="${pagamentos.vencimento.time}"
										pattern="dd/MM/yyyy" /></td>
								<td>${pagamentos.tipoPagamento}</td>
								<td>${pagamentos.valorParcela}</td>
								<td>${pagamentos.numeroParcela}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<c:import url="../config/rodape.jsp" />