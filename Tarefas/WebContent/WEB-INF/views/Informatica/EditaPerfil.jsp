<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Área Informática</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<form class="form-horizontal" role="form" action="DefinePerfil"
				method="post" name="cad" id="cad">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1"> ID Usuário </label>
					<div class="col-sm-9">
						<input readonly="" type="text" class="col-xs-10 col-sm-5"
							id="form-input-readonly" value="${usuario.usuarioId}"
							name="usuarioId" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1"> E-mail </label>
					<div class="col-sm-9">
						<input readonly="" type="text" class="col-xs-10 col-sm-5"
							id="form-input-readonly" name="email" value="${usuario.email}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1"> Nome </label>
					<div class="col-sm-9">
						<input readonly="" type="text" class="col-xs-10 col-sm-5"
							id="form-input-readonly" value="${usuario.nome}" name="nome" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1"> Comum </label>
					<div class="col-sm-9">
						<input readonly="" type="text" class="col-xs-10 col-sm-5"
							id="form-input-readonly" value="${usuario.comum}" name="comum" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1">Ministério</label>

					<div class="col-sm-9">
						<select data-placeholder="Choose a Country..."
							class="col-xs-10 col-sm-5" name="setor">
							<option>${usuario.setor}</option>
							<option>ADM - Secretária</option>
							<option>ADM - Tesouraria</option>
							<option>ADM - Compras</option>
							<option>ADM - Projetos</option>
							<option>ADM - Informática</option>
							<option>ADM - Presidente</option>
							<option>ADM - Vice Presidente</option>
							<option>Ancião</option>
							<option>Diacono</option>
							<option>Encarregado Regional</option>
							<option>Cooperador Oficial</option>
							<option>Cooperador de Jovens</option>
							<option>Encarregado Local</option>
							<option>Tesoureiro</option>
							<option>Outros</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						for="form-field-1">Perfil Acesso</label>

					<div class="col-sm-9">
						<select data-placeholder="Choose a Country..."
							class="col-xs-10 col-sm-5" name="perfil">
							<c:if test="${usuario.perfil eq ''}">
								<option>--- Selecione o Perfil ---</option>
							</c:if>
							<c:if test="${usuario.perfil != ''}">
								<option>${usuario.perfil}</option>
							</c:if>
							<option value="1">ADM - Secretária</option>
							<option value="2">ADM - Tesouraria</option>
							<option value="3">ADM - Música</option>
							<option value="4">ADM - Compras</option>
							<option value="5">ADM - Informática</option>
							<option value="6">ADM - Patrimonio Projetos</option>
							<option value="7">Ancião Diacono</option>
							<option value="8">Cooperadores / Tesoureiros</option>
							<option value="9">ADM Presidente / Vice Presidente</option>
							<option value="10">ADM Engenharia</option>
							<option value="11">ADM Conselho Fiscal</option>
							<option value="12">ADM Distribuidora</option>
						</select>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="clearfix form-actions">
					<div class="col-md-offset-3 col-md-9">
						<button class="btn btn-info" type="submit">
							<i class="ace-icon fa fa-check bigger-110"></i> Enviar dados
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
</div>

<c:import url="../config/rodape.jsp" />