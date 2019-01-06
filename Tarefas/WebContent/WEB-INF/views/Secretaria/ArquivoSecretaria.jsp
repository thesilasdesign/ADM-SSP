<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Arquivos Secretária</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="clearfix">
				<div class="pull-right tableTools-container"></div>
			</div>
			<div class="table-responsive">
				<table id="dynamic-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Nome arquivo</th>
							<th>Baixar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${files}" var="files">
							<tr>
								<td>${files}</td>
								<td><a class=red
									href='http://www.portaljandiraccb.com.br/Diretorio/ArquivosSecretaria/${files}' target="_blank" download><i
										class='ace-icon fa fa-cloud-download bigger-130'></i></a></td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<c:import url="../config/rodape.jsp" />