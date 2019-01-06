<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-header">
	<h1>Adicionar Item Pedido ${Compras.compraId}</h1>
</div>
<!-- /.page-header -->

<div class="table-header">Adicionar Item</div>
<div class="table-responsive">
	<div class="btn-group">
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal" data-whatever="">Adicionar Item</button>
	</div>
	<table id="dynamic-table"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Descrição Marca / Modelo</th>
				<th>Quantidade</th>
				<th class="hidden-480">Valor Unitário</th>
				<th class="hidden-480">Total</th>
				<th class="center">Editar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Itens}" var="Itens">
				<tr>
					<td>${Itens[3]}</td>
					<td>${Itens[4]}</td>
					<td>${Itens[6]}</td>
					<td>${Itens[5]}</td>
					<td class="center" colspan="15"><a class=red
						href="DeletaItem?id=${Itens[0]}&valorRetira=${Itens[5]}&idCompra=${Itens[7]}">
							<i class='ace-icon fa fa-trash-o bigger-130'></i>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="green"
						href="AlterarItem?id=${Itens[0]}&idCompra=${Itens[7]}&valorAltera=${Itens[5]}">
							<i class="ace-icon fa fa-pencil blue bigger-130"></i>
					</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td>Valor Total:</td>
				<td><fmt:formatNumber value="${Compras.valorTotal}"
						type="NUMBER" minFractionDigits="2" /></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<div class=" center col-xs-8 col-sm-8">
	</br> <a href="ItemPedido" class="btn btn-app btn-yellow"> <i
		class="ace-icon fa fa-bars bigger-230"></i> Itens
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="Pagamento?id=${Compras.compraId}"
		class="btn btn-app btn-danger"> <i
		class="ace-icon fa fa-credit-card bigger-230"></i>Pagto
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="GerarPDFCompra?id=${Compras.compraId}"
		class="btn btn-app btn-success"> <i
		class="ace-icon fa fa-file-pdf-o bigger-230"></i> PDF
	</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="ArquivoCompra?id=${Compras.compraId}"
		class="btn btn-app btn-primary"> <i
		class="ace-icon fa fa-files-o bigger-230"></i> Arquivos
	</a>
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
				<h4 class="modal-title" id="exampleModalLabel">Adicionar Itens
					Pedido</h4>
			</div>
			<div class="modal-body">
				<form action="AdicionarItens" method="post">
					<div class="form-group">
						<label for="recipient-name" class="control-label">Descricao
							Marca/Modelo:</label> <input type="text" class="form-control"
							required="required" id="recipient-name" name="marcaModelo"
							id="marcaModelo" placeholder="Modelo xxxxx Marca yyyyyyy">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Quantidade:</label>
						<input type="text" class="form-control" required="required"
							id="recipient-name" name="quantidade" id="quantidade"
							placeholder="100"><input type="hidden" name="compraId"
							id="CompraId" value="${Compras.compraId}">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Valor
							Unitário:</label> <input type="number" class="form-control"
							required="required" name="valorUnidade" step="any"
							placeholder="23.00" />
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
<c:import url="../config/rodape.jsp" />