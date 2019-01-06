<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>.::Administração Santana de Parnaíba e Pirapora::.</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="resources/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<link rel="stylesheet"
	href="resources/assets/fonts/fonts.googleapis.com.css" />


<link rel="stylesheet" href="resources/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<script src="resources/assets/js/ace-extra.min.js"></script>

<link rel="stylesheet"
	href="resources/assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet"
	href="resources/assets/css/jquery.gritter.min.css" />
<link rel="stylesheet" href="resources/assets/css/select2.min.css" />
<link rel="stylesheet" href="resources/assets/css/datepicker.min.css" />
<link rel="stylesheet"
	href="resources/assets/css/bootstrap-editable.min.css" />
<link rel="stylesheet"
	href="resources/assets/fonts/fonts.googleapis.com.css" />

</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>
			</button>
			<div class="navbar-header pull-left">
				<a href="Home" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> Administração Santana de Parnaíba e Pirapora
				</small>
				</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">

					<c:if
						test="${usuarioLogado.perfil eq 4 or usuarioLogado.perfil eq 5 or usuarioLogado.email eq 'antonioluiz-sp@uol.com.br'}">
						<li class="warning"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"> <i
								class="ace-icon fa fa-bell-slash-o" aria-hidden="true"></i> <span
								class="badge badge-success">${qtdeNotificacao}</span>
						</a>
							<ul
								class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header"><i
									class="ace-icon fa fa-exclamation-triangle"></i>${qtdeNotificacao}
									Alertas de Notificação <c:forEach items="${NotificacaoAbertas}"
										var="NotificacaoAbertas">
										<li class="dropdown-content">
											<ul class="dropdown-menu dropdown-navbar navbar-pink">
												<li><a
													href="${NotificacaoAbertas.campo3}">
														<div class="clearfix">
															<span class="pull-left"> <i class=""></i> ${NotificacaoAbertas.campo1} - ${NotificacaoAbertas.campo2} 
														</div> 
												</a></li> 
											</ul> 
										</li> 
									</c:forEach>
								<li class="dropdown-footer"><a href="PainelNotificacao">
										Verificar Painel de Notificações!!! <i class= "ace-icon fafa-arrow-right"></i>
								</a></li>
							</ul></li>
					</c:if>

					<c:if
						test="${usuarioLogado.email eq 'thesilasdesign@gmail.com' or usuarioLogado.email eq 'antonioluiz-sp@uol.com.br' or usuarioLogado.email eq 'miranda.adailton@yahoo.com' or usuarioLogado eq 'douglas.feltrin@congregacao.org.br'}">
						<li class="red"><a id="id-btn-dialog2" href="AreaAprovacoes">
								<i class="ace-icon fa fa-check-circle"></i> <span
								class="hidden-phone">Área Aprovações</span>
						</a></li>
					</c:if>
					<c:if test="${usuarioLogado.perfil eq 5}">
						<li class="warning"><a id="id-btn-dialog2"
							href="AreaInformatica"> <i class="ace-icon fa fa-laptop"></i>
								<span class="hidden-phone">Área Informatica</span>
						</a></li>

						<li class="purple"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"> <i
								class="ace-icon fa fa-bell icon-animated-bell"></i> <span
								class="badge badge-success">${qtdeInformatica}</span>
						</a>
							<ul
								class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header"><i
									class="ace-icon fa fa-exclamation-triangle"></i>${qtdeInformatica}
									Informática Chamados abertos <c:forEach
										items="${informaticaAberto}" var="informaticaAberto">
										<li class="dropdown-content">
											<ul class="dropdown-menu dropdown-navbar navbar-pink">
												<li><a
													href="Chamado?id=${informaticaAberto.informaticaId}">
														<div class="clearfix">
															<span class="pull-left"> <i class=""></i> PEDIDO:
																${informaticaAberto.informaticaId} -
																${informaticaAberto.local} 
														</div>
												</a></li>
											</ul>
										</li>
									</c:forEach>
								<li class="dropdown-footer"><a href="PainelInformatica">
										Verificar painel Informática!!! <i
										class="ace-icon fa fa-arrow-right"></i>
								</a></li>
							</ul></li>
					</c:if>
					<c:if
						test="${usuarioLogado.perfil eq 4 or usuarioLogado.perfil eq 5 or usuarioLogado.email eq 'antonioluiz-sp@uol.com.br'}">
						<li class="green"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"> <i
								class="ace-icon fa fa-shopping-cart" aria-hidden="true"></i> <span
								class="badge badge-success">${qtdeCompras}</span>
						</a>
							<ul
								class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header"><i
									class="ace-icon fa fa-exclamation-triangle"></i>${qtdeCompras}
									Compras abertas <c:forEach items="${ComprasAbertas}"
										var="ComprasAbertas">
										<li class="dropdown-content">
											<ul class="dropdown-menu dropdown-navbar navbar-pink">
												<li><a
													href="PedidoBloqueado?id=${ComprasAbertas.compraId}">
														<div class="clearfix">
															<span class="pull-left"> <i class=""></i> PEDIDO:
																${ComprasAbertas.compraId} - ${ComprasAbertas.comum} 
														</div>
												</a></li>
											</ul>
										</li>
									</c:forEach>
								<li class="dropdown-footer"><a href="PainelCompras">
										Verificar painel Compras!!! <i
										class="ace-icon fa fa-arrow-right"></i>
								</a></li>
							</ul></li>
					</c:if>
					<c:if
						test="${usuarioLogado.email eq 'antonioluiz-sp@uol.com.br'  or usuarioLogado.email eq 'thesilasdesign@gmail.com'}">
						<li class=red><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"> <i
								class="ace-icon fa fa-check white bigger-129"></i> <span
								class="badge badge-success">${qtdePresidente}</span>
						</a>

							<ul
								class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header"><i
									class="ace-icon fa fa-exclamation-triangle"></i>${qtdePresidente}
									Aprovação Presidente <c:forEach items="${aprovacaoPresidente}"
										var="aprovacaoPresidente">
										<li class="dropdown-content">
											<ul class="dropdown-menu dropdown-navbar navbar-pink">
												<li><a
													href="Aprovar?tipo=presidente&id=${aprovacaoPresidente.compraId}">
														<div class="clearfix">
															<span class="pull-left"> <i class=""></i> PEDIDO:
																${aprovacaoPresidente.compraId} -
																${aprovacaoPresidente.comum} 
														</div>
												</a></li>
											</ul>
										</li>
									</c:forEach>
								<li class="dropdown-footer"><a
									href="Aprovar?tipo=presidente"> Verificar painel!!! <i
										class="ace-icon fa fa-arrow-right"></i>
								</a></li>
							</ul></li>
					</c:if>

					<c:if
						test="${usuarioLogado.email eq 'miranda.adailton@yahoo.com' or usuarioLogado.email eq 'antonioluiz-sp@uol.com.br' or usuarioLogado.email eq 'thesilasdesign@gmail.com'}">
						<li class="grey"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"> <i
								class="ace-icon fa fa-check white bigger-129"></i> <span
								class="badge badge-success">${qtdeTesoureiro}</span>
						</a>
							<ul
								class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header"><i
									class="ace-icon fa fa-exclamation-triangle"></i>${qtdeTesoureiro}
									Aprovação Tesoureiro <c:forEach items="${aprovacaoTesoureiro}"
										var="aprovacaoTesoureiro">
										<li class="dropdown-content">
											<ul class="dropdown-menu dropdown-navbar navbar-pink">
												<li><a
													href="Aprovar?tipo=tesoureiro&id=${aprovacaoTesoureiro.compraId}">
														<div class="clearfix">
															<span class="pull-left"> <i class=""></i> PEDIDO:
																${aprovacaoTesoureiro.compraId} -
																${aprovacaoTesoureiro.comum} 
														</div>
												</a></li>
											</ul>
										</li>
									</c:forEach>
								<li class="dropdown-footer"><a
									href="Aprovar?tipo=tesoureiro"> Verificar painel!!! <i
										class="ace-icon fa fa-arrow-right"></i>
								</a></li>
							</ul></li>
					</c:if>
					<c:if
						test="${usuarioLogado.email eq 'douglas.feltrin@congregacao.org.br' or usuarioLogado.email eq 'antonioluiz-sp@uol.com.br' or usuarioLogado.email eq 'thesilasdesign@gmail.com'}">
						<li class=blue><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"> <i
								class="ace-icon fa fa-check white bigger-129"></i> <span
								class="badge badge-success">${qtdeEngenheiro}</span>
						</a>

							<ul
								class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header"><i
									class="ace-icon fa fa-exclamation-triangle"></i>${qtdeEngenheiro}
									Aprovação Engenheiro <c:forEach items="${aprovacaoEngenheiro}"
										var="aprovacaoEngenheiro">
										<li class="dropdown-content">
											<ul class="dropdown-menu dropdown-navbar navbar-pink">
												<li><a
													href="Aprovar?tipo=engenheiro&id=${aprovacaoEngenheiro.compraId}">
														<div class="clearfix">
															<span class="pull-left"> <i class=""></i> PEDIDO:
																${aprovacaoEngenheiro.compraId} -
																${aprovacaoEngenheiro.comum} 
														</div>
												</a></li>
											</ul>
										</li>
									</c:forEach>
								<li class="dropdown-footer"><a
									href="Aprovar?tipo=engenheiro"> Verificar painel!!! <i
										class="ace-icon fa fa-arrow-right"></i>
								</a></li>
							</ul></li>
					</c:if>

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <i class="ace-icon fa fa-user"></i> <span
							class="user-info informacao-usuario hidden-phone"> <small>Bem-vindo,</small>
								${usuarioLogado.nome}
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul class="dropdown-menu">
							<li><a href="perfil" id="btn-preferencias">Preferências</a>
							</li>
							<li><a href="alterarSenha" id="btn-alterarsenha">Alterar
									senha</a></li>
						</ul></li>
					<li class="red"><a id="id-btn-dialog2" href="logout"> <i
							class="ace-icon fa fa-power-off" aria-hidden="true"></i> <span
							class="hidden-phone">Sair</span>
					</a></li>
				</ul>
			</div>
		</div>
		<!-- /.navbar-container -->
	</div>