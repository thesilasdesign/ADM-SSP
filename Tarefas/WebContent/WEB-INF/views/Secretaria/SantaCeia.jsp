<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Santa Ceia</h1>
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
						Santa Ceia</button>
				</div>

				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Comum</th>
							<th>Ancião</th>
							<th>Data</th>
							<th>Irmãs</th>
							<th>Irmãos</th>
							<th>Total</th>
							<th>Editar</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${santaCeias}" var="santaCeias">
							<tr>
								<td>${santaCeias.comum}</td>
								<td>${santaCeias.anciao}</td>
								<td><fmt:formatDate value="${santaCeias.dataSantaCeia.time}"
										pattern="dd/MM/yyyy" /></td>
								<td>${santaCeias.homens}</td>
								<td>${santaCeias.mulheres}</td>
								<td>${santaCeias.total}</td>
								<td><a href="RemoverSantaCeia?id=${santaCeias.santaCeiaId}">Remover</a></td>
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
					Cadastro de Santa Ceia</h4>
			</div>
			<div class="modal-body">
				<form action="CadastroSantaCeia" method="post">
					<div class="form-group">
						<label for="recipient-name" class="control-label">Data Santa Ceia:</label>
						<input class="form-control" type="text" required="required"
							name="dataSantaCeia" placeholder="22/05/2015" />
					</div>
					<div class="form-group">
						<label for="form-field-4">Casa de Oração:</label> <select
							name="comum" class="form-control">
							<c:forEach items="${igrejas}" var="igrejas">
								<option value="${igrejas.comum}">${igrejas.comum}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Ancião
							Atendimento:</label> <input type="text" class="form-control"
							required="required" id="recipient-name" name="anciao"
							placeholder="ALEXANDRE SABÓ">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Irmãs:</label> <input
							type="text" class="form-control" required="required"
							id="recipient-name" name="homens" placeholder="25">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Irmãos:</label>
						<input type="text" class="form-control" required="required"
							id="recipient-name" name="mulheres" placeholder="35">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Ano:</label>
						<input type="text" class="form-control" required="required"
							id="recipient-name" name="ano" placeholder="2016">
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