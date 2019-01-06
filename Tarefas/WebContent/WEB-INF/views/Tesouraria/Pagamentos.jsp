<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Pagamentos Compras/Tesouraria</h3>

<div class="table-header">Últimos resultados</div>
<div class="table-responsive">
	<table id="dynamic-table"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Número Pedido</th>
				<th>Data Abertura</th>
				<th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>Solicitante</th>
				<th class="hidden-480">Descrição</th>
				<th class="hidden-480">Comum</th>
				<th class="hidden-480">Status</th>
				<th class="hidden-480">Valor Total</th>
				<th class="hidden-480">Comprador</th>
				<th class="hidden-480">Opções</th>
				<th class="hidden-480">Finalizar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Compras}" var="Compras">
				<tr>
					<td><a href="ShowPedido?id=${Compras.compraId}">${Compras.compraId}</a></td>
					<td><fmt:formatDate value="${Compras.dataAbertura.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${Compras.solicitante}</td>
					<td>${Compras.descricao}</td>
					<td>${Compras.comum}</td>
					<td>${Compras.status}</td>
					<td>${Compras.valorTotal}</td>
					<td>${Compras.comprador}</td>
					<td><a class="red" href="GerarPDFCompra.pdf?id=${Compras.compraId}"> <i
							class="ace-icon fa fa-file-pdf-o bigger-130"></i>
					</a>&nbsp;&nbsp;</td>
					<td><a href="ConcluirPedido?id=${Compras.compraId}">Pedido Ok</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:import url="../config/rodape.jsp" />