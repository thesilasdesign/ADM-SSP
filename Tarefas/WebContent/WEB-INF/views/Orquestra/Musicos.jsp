<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Músicos</h1>
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
						Músicos</button>
				</div>

				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Músico Id</th>
							<th>Comum</th>
							<th>Nome</th>
							<th>Instrumento</th>
							<th>Celular</th>
							<th>Oficializado</th>
							<th>Editar</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${musicos}" var="musicos">
							<tr>
								<td>${musicos.musicoId}</td>
								<td>${musicos.comum}</td>
								<td>${musicos.nome}</td>
								<td>${musicos.instrumento}</td>
								<td>${musicos.celular}</td>
								<td>${musicos.oficializado}</td>
								<td><a href="RemoverMusicos?id=${musicos.musicoId}">Remover</a></td>
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
				<h4 class="modal-title" name="comum" id="exampleModalLabel">Cadastro de Músicos</h4>
			</div>
			<div class="modal-body">
				<form action="CadastroMusicos" name="cad" id="cad" method="post">
					<div class="form-group">
						<label for="recipient-name" class="control-label">Nome:</label> <input
							type="text" class="form-control" id="recipient-name" name="nome"
							placeholder="João da Silva">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Instrumento:</label><br>
						<select name="instrumento" class="form-control">
							<option>Violino</option>
							<option>Viola</option>
							<option>Violoncelo</option>
							<option>Flauta</option>
							<option>Oboé</option>
							<option>Fagote</option>
							<option>Clarineta</option>
							<option>Clarone</option>
							<option>Sax Soprano</option>
							<option>Sax Alto</option>
							<option>Sax Tenor</option>
							<option>Sax Baritono</option>
							<option>Sax Baixo</option>
							<option>Trompetes</option>
							<option>Fluegel-Horn</option>
							<option>Trompas</option>
							<option>Trombones</option>
							<option>Eufónicos</option>
							<option>Tubas</option>
							<option>Acordeon</option>
						</select>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Endereço:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="endereco" placeholder="Rua jandira, 29 casa 5">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Bairro:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="bairro" placeholder="Centro">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Cidade:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="cidade" placeholder="Jandira">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Telefone:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="telefone" placeholder="11 4707-8888">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Celular:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="celular" placeholder="11 9 6333-9666">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">E-mail:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="email" placeholder="nome@bol.com.br">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Batizado:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="batizado" placeholder="EX.: Sim .. Não">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Data de
							Batismo:</label> <input type="text" class="form-control"
							id="recipient-name" name="dataBatismo"
							placeholder="Ex.: Não ou 25/02/2015">
					</div>

					<div class="form-group">
						<label for="recipient-name" class="control-label">Oficializado:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="oficializado" placeholder="EX.: Sim .. Não">
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