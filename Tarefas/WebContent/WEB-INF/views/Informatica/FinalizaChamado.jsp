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
			<form action="ResolucaoChamado" method="post">
				<div class="widget-body">
					<div class="widget-main">
						<div class="col-xs-6">
							<label for="form-field-8">ID Chamado:</label> <input readonly=""
								class="form-control" id="form-field-8" name="informaticaId"
								value="${atendendoChamdo.informaticaId}"></input>
						</div>
						<div class="col-xs-6">
							<label for="form-field-8">Data Abertura:</label> <input
								readonly="" class="form-control" id="form-field-8"
								name="dataAbertura"
								value="<fmt:formatDate value="${atendendoChamdo.dataAbertura.time}"
															pattern="dd/MM/yyyy" />"</input>
						</div>
						<div class="col-xs-6">
							<label for="form-field-8">Solicitação:</label> <input readonly=""
								class="form-control" id="form-field-8" name="tipoServico"
								value="${atendendoChamdo.tipoServico}"></input>
						</div>
						<div class="col-xs-6">
							<div>
								<label for="form-field-1">Tipo de Solicitação:</label> <select
									name="status" id="status"
									class="form-control">
									<option value="${atendendoChamdo.status}" selected>${atendendoChamdo.status}</option>
									<option value="1-ABERTO">1-ABERTO</option>
									<option value="2-EM ATENDIMENTO">2-EM ATENDIMENTO</option>
									<option value="3-PENDENTE">3-PENDENTE</option>
									<option value="4-CANCELADO">4-CANCELADO</option>
									<option value="5-CONCUIDO">5-CONCUIDO</option>
								</select>
							</div>
						</div>
						<div class="col-xs-12">
							<label for="form-field-8">Observação:</label>
							<textarea readonly="" class="form-control" id="form-field-8"
								name="descricao">${atendendoChamdo.descricao}</textarea>
						</div>
						<div class="col-xs-12">
							<label for="form-field-11">Resolução ou Cancelamento:</label>
							<textarea class="form-control" rows="5" cols="50"
								name="observacaoAtendente" placeholder="Ex.: Descreva sobre o chamado....">${atendendoChamdo.observacaoAtendente}</textarea>
						</div>
					
					</div>
					<hr>
					<div class="center">
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

<c:import url="../config/rodape.jsp" />