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
							class="ace-icon fa fa-random"></i> 500
						</span> Página de Erro 
					</h1>

					<hr />
					<h3 class="lighter smaller">
						Mas estamos trabalhando <i
							class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>
						nisso!
					</h3>

					<div class="space"></div>

					<div>
						<h4 class="lighter smaller">Enquanto isso , tente um dos
							seguintes procedimentos:</h4>

						<ul class="list-unstyled spaced inline bigger-110 margin-15">
							<li><i class="ace-icon fa fa-hand-o-right blue"></i> Abrir chamdo</li>

							<li><i class="ace-icon fa fa-hand-o-right blue"></i> Dê-nos mais informações sobre como ocorreu o erro específico!</li>
						</ul>
					</div>

					<hr />
					<div class="space"></div>

					<div class="center">
						<a href="javascript:history.back()" class="btn btn-grey"> <i
							class="ace-icon fa fa-arrow-left"></i> Voltar Página
						</a> <a href="SolicitaInformatica" class="btn btn-primary"> <i
							class="ace-icon fa fa-tachometer"></i> Ábrir Chamado
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="../config/rodape.jsp" />
