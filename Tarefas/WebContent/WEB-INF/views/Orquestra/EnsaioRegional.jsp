<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Ensaio Regional</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="clearfix">
				<div class="pull-right tableTools-container"></div>
			</div>
			<div class="table-header">Últimos resultados</div>
			<div class="table-responsive">
				<div class='btn-group'>
					<button type='button' class='btn btn-primary' data-toggle='modal'
						data-target='#exampleModal' data-whatever=''>Adicionar
						Ensaio</button>
				</div>

				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Data Ensaio</th>
							<th>Ancião Atendimento</th>
							<th>Regiona Atendimento</th>
							<th>Músicos</th>
							<th>Organistas</th>
							<th>Irmandade</th>
							<th>Total Geral</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ensaio}" var="ensaio">
							<tr>
								<td><fmt:formatDate value="${ensaio.dataEnsaio.time}"
						pattern="dd/MM/yyyy" /></td>
								<td>${ensaio.anciaoAtendimento}</td>
								<td>${ensaio.regionalAtendimento}</td>
								<td>${ensaio.musicos}</td>
								<td>${ensaio.organistas}</td>
								<td>${ensaio.irmandade}</td>
								<td>${ensaio.totalGeral}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" name="comum" id="exampleModalLabel">Lançamento
					de ensaio</h4>
			</div>
			<div class="modal-body">
				<form action="CadastrarEnsaio" name="cad" id="cad"
					method="post">
					<div class="form-group">
						<label for="recipient-name" class="control-label">Data:</label>
						 <input type="text" placeholder="22/02/2016" class="form-control" <caelum:campoData id="dataEnsaio"/>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Ancião
							Atendimento:</label> <input type="text" class="form-control"
							id="recipient-name" name="anciaoAtendimento"
							placeholder="Alexandre Sabó" required="AAAA">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Regional
							Atendimento:</label> <input type="text" class="form-control"
							id="recipient-name" name="regionalAtendimento"
							placeholder="Joel Ferreira da Silva" required="AAAA">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Músicos
							Total:</label> <input type="text" class="form-control"
							id="recipient-name" name="musicos" placeholder="500"
							required="AAAA">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Organistas
							Total:</label> <input type="text" class="form-control"
							id="recipient-name" name="organistas" placeholder="59"
							required="AAAA">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Irmandade
							Total:</label> <input type="text" class="form-control"
							id="recipient-name" name="irmandade" placeholder="200"
							required="AAAA">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default" data-dismiss="modal">Fechar</button>
						<button type="submit" class="btn btn-primary">Enviar
							dados</button>
					</div>
				</form>
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