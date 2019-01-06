<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Painel de Compras</h3>
<div class="btn-group">
	<a href="NovaCompra" class="btn btn-primary btn-lg" role="button"
		aria-pressed="true">Inserir Nova Compra</a>
</div>
<br>
<br>
<div class="table-header">�ltimos resultados</div>
<div class="table-responsive">
	<table id="dynamic-table" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>N�mero Pedido</th>
				<th>Data Abertura</th>
				<th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>Solicitante</th>
				<th class="hidden-480">Descri��o</th>
				<th class="hidden-480">Comum</th>
				<th class="hidden-480">Status</th>
				<th class="hidden-480">Valor Total</th>
				<th class="hidden-480">Comprador</th>
				<th class="hidden-480">Op��es</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Compras}" var="Compras">
				<tr>
					<td><a href="PedidoBloqueado?id=${Compras.compraId}">${Compras.compraId}</a></td>
					<td><fmt:formatDate value="${Compras.dataAbertura.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${Compras.solicitante}</td>
					<c:set var="string1" value="${Compras.descricao}" />
					<c:set var="string2" value="${fn:substring(string1, 0, 50)}" />
					<td title="${Compras.descricao}">${string2}</td>
					<td>${Compras.comum}</td>
					<td>${Compras.status}</td>
					<td><fmt:formatNumber value="${Compras.valorTotal}"
							type="NUMBER" minFractionDigits="2" /></td>
					<td>${Compras.comprador}</td>
					<td><a class="red"
						href="GerarPDFCompra.pdf?id=${Compras.compraId}"> <i
							class="ace-icon fa fa-file-pdf-o bigger-130"></i>
					</a>&nbsp;&nbsp;<a class="green"
						href="aprovacaoCompra?id=${Compras.compraId}"> <i
							class="ace-icon fa fa-exchange bigger-130"></i>
					</a>&nbsp;&nbsp;<a class="blue"
						href="comentarioCompra?id=${Compras.compraId}"> <i
							class="ace-icon fa fa-comments-o bigger-130"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:import url="../config/rodape.jsp" />