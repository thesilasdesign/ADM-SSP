<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />

<div class="row">
	<div class="col-xs-12">
		<div class="clearfix">
			<div class="pull-right tableTools-container"></div>
		</div>
		<div class="table-header">Últimos resultados</div>
		<div class='btn-group'></div>
		<table id="dynamic-table"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Id Notificação</th>
					<th>Pedido</th>
					<th>Informação</th>
					<th>Acessar</th>
					<th>Editar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notif}" var="notif">
					<tr>
						<td>${notif.notificacaoId}</td>
						<td>${notif.campo1}</td>
						<td>${notif.campo2}</td>
						<td class=""><a class="blue" href="${notif.campo3}">Link<i class=""></i></td>
						<td class=""><a class="red" href="FinalizarNotificacao?id=${notif.notificacaoId}">Finalizar <i class=""></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:import url="../config/rodape.jsp" />