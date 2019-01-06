<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />

<div class="page-content">
	<div class="page-header">
		<h1>Comunicados</h1>
	</div>
	<!-- /.page-header -->
	<div class="space"></div>
	<div class="col-xs-12 col-sm-12">
		<div class="widget-body">
			<h4 class="pink">
				<a href="#modal-form" role="button" class="blue" data-toggle="modal">Cadastrar
				</a>
			</h4>
		</div>
	</div>
	<div class="col-xs-12">
		<div class="table-header">Últimos resultados</div>
		<div class="table-responsive">
			<table id="dynamic-table"
				class="table table-striped table-bordered table-hover" width="100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Assunto</th>
						<th>Data Comunicado</th>
						<th>Local</th>
						<th class="center">Remover</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${eventos}" var="eventos">
						<tr>
							<td>${eventos.eventosId}</td>
							<td>${eventos.titulo}</td>
							<td>${eventos.data}</td>
							<td>${eventos.local}</td>
							<td class="center"><a
								href="removeEvento?id=${eventos.eventosId}">Remover</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
					Eventos</h4>
			</div>
			<div class="modal-body">
				<form action="Cadastro" method="post">
					<div class="widget-body">
						<div class="widget-main">
							<div>
								<label for="form-field-8">Título:</label> <input
									class="form-control" required="" id="form-field-8"
									name="titulo" placeholder="Ex.: Reunião Cooperadores"></input>
							</div>
							<div>
								<label for="form-field-8">Data e hora:</label> <input
									class="form-control" required="" id="form-field-8" name="data"
									placeholder="Ex.: 16/03/2015"></input>
							</div>
							<div>
								<label for="form-field-8">Local:</label> <input
									class="form-control" required="" id="form-field-8" name="local"
									placeholder="Ex.: Central Jandira"></input>
							</div>
							<hr />
							<div>
								<label for="form-field-11">Texto:</label>
								<textarea class="form-control" required="" rows="5" cols="50"
									name="texto"
									placeholder="Ex.: Editar de convocação para reunião...."></textarea>
							</div>
						</div>
						<div class="form-actions center">
							<button type="submit" class="btn btn-sm btn-success">
								Enviar <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div id="result"></div>
<c:import url="../config/rodape.jsp" />
