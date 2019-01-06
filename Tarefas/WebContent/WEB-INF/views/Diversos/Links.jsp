<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<div class="page-content">
	<div class="page-header">
		<h1>Links Úteis</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="tabbable">
				<ul class="nav nav-tabs padding-12 tab-color-blue background-blue"
					id="myTab4">
					<li class=""><a data-toggle="tab" href="#home4"
						aria-expanded="false">CCB Info</a></li>

					<li class=""><a data-toggle="tab" href="#profile4"
						aria-expanded="false">E-mail Siga</a></li>

					<li class="active"><a data-toggle="tab" href="#dropdown14"
						aria-expanded="true">Acesso Câmeras</a></li>
				</ul>

				<div class="tab-content">
					<div id="home4" class="tab-pane">
						<a href="https://appl.ccbinfo.congregacao.org.br" target="_blank">CCB
							Info</a>
					</div>

					<div id="profile4" class="tab-pane">
						<a href="https://login.microsoftonline.com/common/login"
							target="_blank">E-mail Congregação</a> <p><a
							href="https://siga.congregacao.org.br" target="_blank">SIGA</a></p>
					</div>

					<div id="dropdown14" class="tab-pane active">
						<a href="http://camccbjandiraadm.tecvozddns.com.br:8010/webcamera.html"
							target="_blank">Câmeras Central</a> -- Usuário: visitante - Senha: visitante <p><a
							href="http://jandccbpiedade.ddns-intelbras.com.br:8010" target="_blank">Câmeras Estacionamento Piedade</a> -- Usuário: visita - Senha: visita</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="../config/rodape.jsp" />