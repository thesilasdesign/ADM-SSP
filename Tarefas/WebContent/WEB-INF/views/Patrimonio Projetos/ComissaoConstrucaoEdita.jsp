<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Comissão de Construção Editar</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">

			<form action="AtualizaComissao" name="cad" id="cad" method="post">
				<div class="form-group">
					<label for="recipient-name" class="control-label">Nome:</label> <input
						type="text" class="form-control" id="recipient-name" name="nome"
						value="${Comissao.nome}"> <input type="hidden"
						class="form-control" id="recipient-name"
						name="comissaoConstrucaoId"
						value="${Comissao.comissaoConstrucaoId}">
				</div>
				<label for="recipient-name" class="control-label">Serviço:</label> <input
					type="text" class="form-control" id="recipient-name" name="servico"
					value="${Comissao.servico}">

				<div class="form-group">
					<label for="recipient-name" class="control-label">Comum:</label> <input
						type="text" class="form-control" id="recipient-name" name="comum"
						value="${Comissao.comum}">
				</div>
				<div class="form-group">
					<label for="recipient-name" class="control-label">Telefone:</label>
					<input type="text" class="form-control" id="recipient-name"
						name="telefone" value="${Comissao.telefone}">
				</div>
				<div class="form-group">
					<label for="recipient-name" class="control-label">Celular:</label>
					<input type="text" class="form-control" id="recipient-name"
						name="celular" value="${Comissao.celular}">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default" data-dismiss="modal">Fechar</button>
					<button type="submit" class="btn btn-primary">Enviar dados</button>
				</div>
			</form>
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