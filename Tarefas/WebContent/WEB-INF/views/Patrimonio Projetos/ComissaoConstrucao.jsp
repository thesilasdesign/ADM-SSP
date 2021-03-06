<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Comiss�o de Constru��o Contatos</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="clearfix">
				<div class="pull-right tableTools-container"></div>
			</div>
			<div class="table-header">�ltimos resultados</div>
			<div class='btn-group'>
				<button type='button' class='btn btn-primary' data-toggle='modal'
					data-target='#exampleModal' data-whatever=''>Adicionar
					Irm�o</button>
			</div>
			<table id="dynamic-table"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Servi�o</th>
						<th>Comum</th>
						<th>Telefone</th>
						<th>Celular</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Comissao}" var="Comissao">
						<tr>
							<td>${Comissao.nome}</td>
							<td>${Comissao.servico}</td>
							<td>${Comissao.comum}</td>
							<td>${Comissao.telefone}</td>
							<td>${Comissao.celular}</td>
							<td class="center"><a class="red"
								href="ComissaoRemove?id=${Comissao.comissaoConstrucaoId}"> <i
									class="ace-icon fa fa-trash-o bigger-130"></i>
							</a>&nbsp;&nbsp;&nbsp; <a class="red"
								href="ComissaoEdita?id=${Comissao.comissaoConstrucaoId}"> <i
									class="ace-icon fa fa-pencil blue bigger-130"></i>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
				<h4 class="modal-title" name="comum" id="exampleModalLabel">Cadastro
					Comissao Constru��o</h4>
			</div>
			<div class="modal-body">
				<form action="CadastrarComissao" name="cad" id="cad" method="post">
					<div class="form-group">
						<label for="recipient-name" class="control-label">Nome:</label> <input
							type="text" class="form-control" id="recipient-name" name="nome"
							placeholder="Jo�o da Silva">
					</div>
					<label for="recipient-name" class="control-label">Servi�o:</label>
					<input type="text" class="form-control" id="recipient-name"
						name="servico" placeholder="Ex.: Ajudante Geral, Pintor, Pedreiro">

					<div class="form-group">
						<label for="recipient-name" class="control-label">Comum:</label> <input
							type="text" class="form-control" id="recipient-name" name="comum"
							placeholder="Central Jandira">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Telefone:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="telefone" placeholder="11 4777-7777">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Celular:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="celular" placeholder="11 9666-3333">
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
		modal.find('.modal-title').text('Lan�amento de Batismo' + recipient)
		//modal.find('.modal-body input').val(recipient)
	})
</script>
<c:import url="../config/rodape.jsp" />