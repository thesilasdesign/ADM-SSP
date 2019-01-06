<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Área do Comprador</h3>
<div class="btn-group">
	<a href="NovaCompra" class="btn btn-primary btn-lg" role="button"
		aria-pressed="true">Inserir Nova Compra</a>
</div>

<div class="clearfix">
	<div class="pull-right tableTools-container"></div>
</div>
<div class="table-header">Últimos resultados</div>
<div class="table-responsive">
	<table id="dynamic-table"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Número Pedido</th>
				<th>Data Abertura</th>
				<th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>Descrição</th>
				<th class="hidden-480">Solicitante</th>
				<th class="hidden-480">Comum</th>
				<th class="hidden-480">Status</th>
				<th class="hidden-480">Valor Total</th>
				<th class="hidden-480">Opções</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Comprador}" var="Comprador">
				<tr>
					<td><a href="Pedido?id=${Comprador[0]}">${Comprador[0]}</a></td>
					<td><fmt:formatDate value="${Comprador[8]}"
							pattern="dd/MM/yyyy" /></td>
							<c:set var="string1" value="${Comprador[13]}" />
					<c:set var="string2" value="${fn:substring(string1, 0, 50)}" />
					<td title="${Comprador[13]}">${string2}</td>
					<td>${Comprador[18]}</td>
					<td>${Comprador[7]}</td>
					<td>${Comprador[19]}</td>
					
					<td>
							<fmt:formatNumber value= "${Comprador[27]}" type="NUMBER"  minFractionDigits="2"/>
						</td>
					<td><a class="red" href="GerarPDFCompra.pdf?id=${Comprador[0]}"> <i
							class="ace-icon fa fa-file-pdf-o bigger-130"></i>
					</a>&nbsp;&nbsp;<a class="green" href="aprovacaoCompra?id=${Comprador[0]}"> <i
							class="ace-icon fa fa-exchange bigger-130"></i>
					</a>&nbsp;&nbsp;<a class="blue" href="comentarioCompra?id=${Comprador[0]}"> <i
							class="ace-icon fa fa-comments-o bigger-130"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:import url="../config/rodape.jsp" />