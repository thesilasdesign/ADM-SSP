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
			<div class="error-container">
				<div class="well">
					<h1 class="grey lighter smaller">
						<span class="blue bigger-125"> <i
							class="ace-icon fa fa-sitemap"></i> 404
						</span> Página não encontrada
					</h1>

					<hr />
					<h3 class="lighter smaller">Nós verificamos em todos os
						lugares, mas não foi possivel encontra-la!</h3>

					<div>
						<form class="form-search">
							<span class="input-icon align-middle"> <i
								class="ace-icon fa fa-search"></i> <input type="text"
								class="search-query" placeholder="Give it a search..." />
							</span>
							<button class="btn btn-sm" type="button">Go!</button>
						</form>

						<div class="space"></div>
						<h4 class="smaller">Tente um dos seguintes procedimentos:</h4>

						<ul class="list-unstyled spaced inline bigger-110 margin-15">
							<li><i class="ace-icon fa fa-hand-o-right blue"></i> Re-
								verifique a url de erros de digitação</li>

							<li><i class="ace-icon fa fa-hand-o-right blue"></i>Abrir Chamado Informatica</li>
						</ul>
					</div>

					<hr />
					<div class="space"></div>

					<div class="center">
						<a href="javascript:history.back()" class="btn btn-grey"> <i
							class="ace-icon fa fa-arrow-left"></i> Voltar Página
						</a> <a href="SolicitaInformatica" class="btn btn-primary"> <i
							class="ace-icon fa fa-tachometer"></i> Abrir Chamado
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="../config/rodape.jsp" />
