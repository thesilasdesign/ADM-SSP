<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-header">
	<h1>Adicionar Item Manuten��o ${manutencao.manutencaoId}</h1>
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
				<th>Descri��o Marca / Modelo</th>
				<th>Quantidade</th>
				<th class="hidden-480">Valor Unit�rio</th>
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
						href="DeletaItem?id=${Itens[0]}"> <i
							class='ace-icon fa fa-trash-o bigger-130'></i>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="green"
						href="AlterarItem?id=${Itens[0]}"> <i
							class="ace-icon fa fa-pencil blue bigger-130"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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
							Unit�rio:</label> <input type="number" class="form-control"
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