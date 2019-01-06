<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Solicitação Informática</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3 class="header smaller lighter blue">Solicitações para a
				Informática</h3>
			<div>
				<a href="TelaCadastroSolicitacao">Inserir nova Solicitação</a>
			</div>
			<div class="clearfix">
				<div class="pull-right tableTools-container"></div>
			</div>
			<div class="table-header">Últimas Solicitações</div>
			<div class="table-responsive">
				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tipo Solicitação</th>
							<th>Solicitação</th>
							<th>Data Abertura</th>
							<th>Status</th>
							<th>Local</th>
							<th>Nome do Atendente</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${informatica}" var="informatica">
							<tr>
								<td>${informatica.informaticaId}</td>
								<td>${informatica.tipoServico}</td>
								<td>${informatica.solicitacao}</td>
								<td><fmt:formatDate
										value="${informatica.dataAbertura.time}" pattern="dd/MM/yyyy" /></td>
								<td>${informatica.status}</td>
								<td>${informatica.local}</td>
								<td>${informatica.atendente}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<c:import url="../config/rodape.jsp" />