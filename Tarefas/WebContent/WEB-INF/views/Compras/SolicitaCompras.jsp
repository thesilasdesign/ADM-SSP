<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Solicita��o de Compras</h3>
<div class="btn-group">
	<a href="NovaCompra" class="btn btn-primary btn-lg" role="button"
		aria-pressed="true">Inserir Nova Compra</a>
</div>
<br>
<br>
<div class="table-header">�ltimos resultados</div>
<div class="table-responsive">
	<table id="dynamic-table"
		class="table table-striped table-bordered table-hover" width="100%">
		<thead>
			<tr>
				<th class="th-inner sortable both desc">N�mero Pedido</th>
				<th>Data Abertura</th>
				<th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>Solicitante</th>
				<th class="hidden-480">Descri��o</th>
				<th class="hidden-480">Comum</th>
				<th class="hidden-480">Status</th>
				<th class="hidden-480">ValorTotal</th>
				<th class="hidden-480">Comprador</th>
				<th class="hidden-480">PDF/Coment�rios</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Compras}" var="Compras">
				<tr>
					<!--Se for ate aprova��o ent�o ter� acesso a altera��o no pedido-->
					<c:if
						test="${Compras.status eq '1-SOLICITADO' or Compras.status eq '2-ANALISE COMPRADOR' or Compras.status eq '3-PENDENTE INFORMA��O' or Compras.status eq '4-AGUARDANDO APROVA��O'}">
						<td><a href="Pedido?id=${Compras.compraId}">${Compras.compraId}</a></td>
					</c:if>

					<!--Se for ap�s aprova��o ent�o ter� acesso a altera��o no pedidoBloqueado-->
					<c:if
						test="${Compras.status eq '5-APROVADO' or Compras.status eq '6-ORCAMENTO E COMPRA' or Compras.status eq '7-AGUARDANDO ENTREGA' or Compras.status eq '8-FINALIZADO' or Compras.status eq '9-CANCELADO' or Compras.status eq '10-REPROVADO' or Compras.status eq '11-TESOURARIA-OK'}">
						<td><a href="Pedido?id=${Compras.compraId}">${Compras.compraId}</a></td>
					</c:if>

					<td><fmt:formatDate value="${Compras.dataAbertura.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${Compras.solicitante}</td>
					<c:set var="string1" value="${Compras.descricao}" />
					<c:set var="string2" value="${fn:substring(string1, 0, 50)}" />
					<td title="${Compras.descricao}">${string2}</td>
					<td>${Compras.comum}</td>
					<td><fmt:formatNumber value= "${Compras.valorTotal}" type="NUMBER"  minFractionDigits="2"/></td>
					<td>${Compras.status}</td>
					<td>${Compras.comprador}</td>
					<td><a class="red"
						href="GerarPDFCompra.pdf?id=${Compras.compraId}"> <i
							class="ace-icon fa fa-file-pdf-o bigger-130"></i>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="blue"
						href="comentarioCompra?id=${Compras.compraId}"> <i
							class="ace-icon fa fa-comments-o bigger-130"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:import url="../config/rodape.jsp" />

