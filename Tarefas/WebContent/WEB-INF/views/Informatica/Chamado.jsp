<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Informática - Chamado ${informatica.informaticaId}</h1>
	</div>
	<!-- /.page-header -->
	<form action="AtualizaInformatica" method="post">
		<div class="widget-body">
			<div class="widget-main">
				<div>
					<label for="form-field-1">Tipo de Solicitação:</label> <select
						name="TipoServico" id="TipoServico" class="form-control">
						<option value="${informatica.tipoServico}">${informatica.tipoServico}</option>
					</select>
				</div>

				<div>
					<label for="form-field-2">Solicitação:</label> <input type="text" readonly=""
						class="form-control" id="recipient-name" placeholder="Projetor" name="solicitacao" value="${informatica.solicitacao}">
						<input type="hidden" name="informaticaId" value="${informatica.informaticaId}">
				</div>

				<div>
					<label for="form-field-3">Observação:</label>
					<textarea class="form-control" rows="5" cols="50" name="descricao" readonly=""
						placeholder="Descrever o serviço/equipamento solicitado">${informatica.descricao}</textarea>
				</div>
				<div>
					<label for="form-field-4">Local:</label> <select name="local"
						id="local" class="form-control">
							<option value="${informatica.local}">${informatica.local}</option>
					</select>
				</div>
				
				<div>
					<label for="form-field-2">Atendimento:</label> <select
						name="atendente" id="atendente" class="form-control">
						<option value="-Selecione--">--Selecione--</option>
						<option value="${usuarioLogado.nome}">${usuarioLogado.nome}</option>
					</select>
				</div>
				<hr />
				<div>
					<label for="form-field-5">Dados do Solicitante:</label>
				</div>
				<div>
					<input readonly="" type="text" class="form-control"
						id="recipient-name" name="solicitante"
						value="${informatica.solicitante}">
				</div>
				<div>
					<input readonly="" type="text" class="form-control"
						id="recipient-name" name="emailSolicitante"
						value="${informatica.emailSolicitante}">
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

<c:import url="../config/rodape.jsp" />