<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<div class="page-content">
	<div class="page-header">
		<h1>Ministério</h1>
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
						data-target='#modal-form' data-whatever=''>Adicionar
						Irmãos</button>
				</div>
				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover" width="100%">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Ordenação</th>
							<th>Cidade</th>
							<th>Ministério</th>
							<th>Telefone</th>
							<th>Celular</th>
							<th>Editar</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ministerios}" var="ministerios">
							<tr>
								<td>${ministerios.nome}</td>
								<td><fmt:formatDate
										value="${ministerios.dataOrdenacao.time}" pattern="dd/MM/yyyy" /></td>
								<td>${ministerios.cidade}</td>
								<td>${ministerios.ministerio}</td>
								<td>${ministerios.telefone}</td>
								<td>${ministerios.celular}</td>
								<td><a
									href="RemoverMinisterio?id=${ministerios.ministerioId}">Remover</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="modal-form" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" name="comum" id="exampleModalLabel">Cadastro
					Ministério</h4>
			</div>
			<div class="modal-body">
				<form action="CadastroMinisterio" method="post">
					<div class="col-xs-12 col-sm-12">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Nome:</label> <input
								type="text" class="form-control" id="recipient-name" name="nome"
								placeholder="Nilton João da Silva">
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Ordenação:</label>
							<caelum:campoData id="dataOrdenacao" />
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Ministério:</label><br>
							<select name="ministerio" class="form-control">
								<option>Ancião</option>
								<option>Diacono</option>
							</select>
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Bairro:</label>
							<input type="text" class="form-control" id="recipient-name"
								name="comum" placeholder="Jd Isaura">
						</div>
					</div>
					<div class="col-xs-12 col-sm-12">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Cidade:</label>
							<input type="text" class="form-control" id="recipient-name"
								name="cidade" placeholder="Jandira">
						</div>
					</div>
					<div class="col-xs-12 col-sm-6">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Telefone:</label>
							<input type="text" class="form-control" id="recipient-name"
								name="telefone" placeholder="11 4141-5252">
						</div>
					</div>
					<div class="col-xs-12 col-sm-6">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Celular:</label>
							<input type="text" class="form-control" id="recipient-name"
								name="celular" placeholder="11 9685-6958">
						</div>
					</div>
					<div class="col-xs-12 col-sm-12">
						<div class="form-group">
							<label for="recipient-name" class="control-label">E-mail:</label>
							<input type="text" class="form-control" id="recipient-name"
								name="email" placeholder="antonio@congregacao.org.br">
						</div>
					</div>
					<div class="form-group">
						<label for="form-field-select-4"></label> <input type="hidden"
							name="txtLancamentos" />
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