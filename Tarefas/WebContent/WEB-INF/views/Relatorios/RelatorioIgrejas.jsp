<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Relatórios Igrejas</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="clearfix">
				<div class="pull-right tableTools-container"></div>
			</div>
			<div class="table-header">Últimos resultados</div>
			<table id="dynamic-table"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id Igreja</th>
						<th>Cod Igreja</th>
						<th>Comum</th>
						<th>Cooperador</th>
						<th>Ancião</th>
						<th>Diácono</th>
						<th>Dias Culto</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${igrejas}" var="igrejas">
						<tr>
							<td>${igrejas.igrejaId}</td>
							<td>${igrejas.codIgrejas}</td>
							<td>${igrejas.comum}</td>
							<td>${igrejas.cooperador}</td>
							<td>${igrejas.anciao}</td>
							<td>${igrejas.diacono}</td>
							<td>${igrejas.diasCulto}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>

<script>
	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var recipient = button.data('whatever') // Extract info from data-* attributes
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		var modal = $(this)
		modal.find('.modal-title').text('Lançamento de Batismo' + recipient)
		//modal.find('.modal-body input').val(recipient)
	})
</script>
<c:import url="../config/rodape.jsp" />