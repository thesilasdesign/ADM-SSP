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
		<h1>Formas de Pagamento Pedido ${Compras.compraId}</h1>
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
						Pagamento</button>
				</div>
				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover" width="100%">
					<thead>
						<tr>
							<th>Id Pagamento</th>
							<th>Forma Pagamento</th>
							<th>Tipo Pagamento</th>
							<th>Data Vencimento</th>
							<th>Valor Parcela</th>
							<th>Número Parcela</th>
							<th>Editar</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagamentos}" var="pagamentos">
							<tr>
								<td>${pagamentos.pagamentoId}</td>
								<td>${pagamentos.avistaPrazo}</td>
								<td><fmt:formatDate
										value="${pagamentos.vencimento.time}" pattern="dd/MM/yyyy" /></td>
								<td>${pagamentos.tipoPagamento}</td>
								<td>${pagamentos.valorParcela}</td>
								<td>${pagamentos.numeroParcela}</td>
								<td><a
									href="RemoverParcela?id=${pagamentos.pagamentoId}">Remover</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<div class=" center col-xs-8 col-sm-8">
	</br> <a href="ItemPedido" class="btn btn-app btn-yellow"> <i
		class="ace-icon fa fa-bars bigger-230"></i> Itens
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="Pagamento?id=${Compras.compraId}" class="btn btn-app btn-danger"> <i
		class="ace-icon fa fa-credit-card bigger-230"></i>Pagto
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="GerarPDFCompra?id=${Compras.compraId}" class="btn btn-app btn-success"> <i
		class="ace-icon fa fa-file-pdf-o bigger-230"></i> PDF
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="ArquivoCompra?id=${Compras.compraId}" class="btn btn-app btn-primary"> <i
		class="ace-icon fa fa-files-o bigger-230"></i> Arquivos
	</a>
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
					Pagamento</h4>
			</div>
			<div class="modal-body">
				<form action="CadastroPagamento" method="post">
					<div class="col-xs-12 col-sm-6">
						<div class="form-group">
							<label for="3">Selecione a Forma de Pagamento:</label> <select
								name='AvistaPrazo' id='AvistaPrazo' class='form-control'>
								<option value='' selected>-- Selecione um Tipo --</option>
								<option value="A Vista">A Vista</option>
								<option value="A Prazo">A Prazo</option>
							</select>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6">
						<div class="form-group">
							<label for="form-field-2">Tipo Pagamento</label> <select
								name="TipoPagamento" id="TipoPagamento" class="form-control">
								<option value="Boleto" selected="selected">Boleto</option>
								<option value="Deposito" selected="selected">Deposito</option>
								<option value="Transferencia" selected="selected">Transferencia</option>
								<option value="Cheque" selected="selected">Cheque</option>
								<option value="Cartao Credito" selected="selected">Cartao
									Credito</option>
								<option value="Dinheiro" selected="selected">Dinheiro</option>
							</select>
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<div class="form-group">
							<label for="form-field-3">Data Vencimento:</label> <input
								type="text" required="" form-control" <caelum:campoData id="Vencimento" />
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Valor
								Parcela:</label> <input type="number" required="" class="form-control"
								id="recipient-name" name="ValorParcela" placeholder="344,99" step="any">
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Número
								Parcela:</label> <input type="number" required="" class="form-control"
								id="recipient-name" name="NumeroParcela" placeholder="Ex.: 01,02,03">
						</div>
					</div>

					<div class="col-xs-12 col-sm-12">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Observação:</label>
							<input type="text" class="form-control" required="" id="recipient-name"
								name="Observacao" placeholder="Ex.: Compra realizado para pagamento dia 23/08...">
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