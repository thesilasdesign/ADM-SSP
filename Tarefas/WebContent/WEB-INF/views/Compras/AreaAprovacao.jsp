<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Pedidos Aguardando Aprovação</h3>

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
<!-- 				<th class="hidden-480 center">Aprovado por ?</th> -->
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
					<td><fmt:formatNumber value= "${Compras.valorTotal}" type="NUMBER"  minFractionDigits="2"/></td>
<%-- 					<td>${Compras.aprovacaoPresidente} -- ${Compras.aprovacaoTesoureiro} -- ${Compras.aprovacaoEngenheiro}</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
   function salvo() {
      alert( "Aprovado com Sucesso" );
  }
</script>

<c:import url="../config/rodape.jsp" />