<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Batismos</h1>
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
						Batismo</button>
				</div>


				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover" width="100%">
					<thead>
						<tr>
							<th>Data Batismo</th>
							<th>Igreja</th>
							<th>Ancião Atendimento</th>
							<th>Irmãs</th>
							<th>Irmãos</th>
							<th>Total</th>
							<th>Editar</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${batismos}" var="batismos">
							<tr>
								<td><fmt:formatDate value="${batismos.dataBatismo.time}"
										pattern="dd/MM/yyyy" /></td>
								<td>${batismos.igreja}</td>
								<td>${batismos.atendimento}</td>
								<td>${batismos.quantidadeMulher}</td>
								<td>${batismos.quantidadeHomem}</td>
								<td>${batismos.quantidadeTotal}</td>
								<td><a href="RemoverBatismo?id=${batismos.batismoId}">Remover</a></td>

							</tr>
						</c:forEach>
						<tr>

							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Total</td>
							<td>${total}</td>
							<td></td>
						</tr>
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
				<h4 class="modal-title" name="comum" id="exampleModalLabel">
					Cadastro de Batismo</h4>
			</div>
			<div class="modal-body">
				<form action="CadastroBatismo" method="post">
					<div class="form-group">
						<label for="recipient-name" class="control-label">DataBatismo:</label>
						<input class="form-control" type="text" required="required"
							name="DataBatismo" placeholder="22/05/2015" />
					</div>
					<div class="form-group">
						<label for="form-field-4">Casa de Oração:</label> <select
							name="igreja" class="form-control" required="required">
							<c:forEach items="${igreja}" var="igreja">
								<option value="${igreja.comum}">${igreja.comum}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Ancião
							Atendimento:</label> <input type="text" class="form-control"
							required="required" id="recipient-name" name="atendimento"
							placeholder="ALEXANDRE SABÓ">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Ancião
							Localidade:</label> <input type="text" class="form-control"
							required="required" name="localidadeAnciao" id="quantidade"
							placeholder="ALEXANDRE SABÓ">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Irmãs:</label> <input
							type="text" class="form-control" required="required"
							id="recipient-name" name="quantidadeMulher" placeholder="25">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Irmãos:</label>
						<input type="text" class="form-control" required="required"
							id="recipient-name" name="quantidadeHomem" placeholder="35">
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