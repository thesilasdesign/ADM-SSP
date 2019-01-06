<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-header">
	<h1>Edita agenda</h1>
</div>
<!-- /.page-header -->
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<form class="form-horizontal" role="form"
			action="AtualizaAgenda" method="post" name="cad"
			id="cad">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> ID Usuário </label>
				<div class="col-sm-9">
					<input readonly="" type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.agendaId}"
						name="agendaId" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> E-mail </label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.email}"
						name="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> Nome </label>
				<div class="col-sm-9">
					<input readonly="" type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.nome}"
						name="nome" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> Cargo </label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.cargo}"
						name="cargo" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> Comum </label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.comum}"
						name="comum" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> Telefone: </label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.telefone}"
						name="telefone" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> Celular: </label>
				<div class="col-sm-9">
					<input type="text" class="col-xs-10 col-sm-5"
						id="form-input-readonly" value="${contatos.celular}"
						name="celular" />
				</div>
			</div>

			<div class="space-4"></div>
			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<button class="btn btn-info" type="submit">
						<i class="ace-icon fa fa-check bigger-110"></i> Atualizar dados
					</button>

					&nbsp; &nbsp; &nbsp;
					<button class="btn" type="reset">
						<i class="ace-icon fa fa-undo bigger-110"></i> Cancelar
					</button>
				</div>
			</div>
		</form>
	</div>

</div>
<c:import url="../config/rodape.jsp" />