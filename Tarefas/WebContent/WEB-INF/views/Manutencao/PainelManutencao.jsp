<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Painel de Manutenção</h3>
<div class="btn-group">
	<div>
		<a href="SolicitaManutencao">Inserir Nova Solicitação</a>
	</div>
</div>
<div class="table-header">Últimos resultados</div>
<div class="table-responsive">
	<table id="dynamic-table"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Número Manutenção</th>
				<th>Data Solicitação</th>
				<th><i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>Solicitante</th>
				<th class="hidden-480">Estimativa Conclusão</th>
				<th class="hidden-480">Comum</th>
				<th class="hidden-480">Caixa</th>
				<th class="hidden-480">Telefone</th>
				<th class="hidden-480">Opções</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${manutencao}" var="manutencao">
				<tr>
					<td><a
						href="ManutencaoBloqueado?id=${manutencao.manutencaoId}">${manutencao.manutencaoId}</a></td>
					<td><fmt:formatDate value="${manutencao.dataSolicitacao.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${manutencao.responsavelSolicitacao}</td>
					<td><fmt:formatDate value="${manutencao.estimativa.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${manutencao.comum}</td>
					<td>${manutencao.caixa}</td>
					<td>${manutencao.telefone}</td>
					<td><a class="red"
						href="GerarPDFManutencao.pdf?id=${manutencao.manutencaoId}"> <i
							class="ace-icon fa fa-file-pdf-o bigger-130"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:import url="../config/rodape.jsp" />