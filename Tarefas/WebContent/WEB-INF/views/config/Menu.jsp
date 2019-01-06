<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="br.com.tarefas.interceptor.PageFilter"%>
<%@ page import="br.com.tarefas.model.Usuario"%>
<%@ page import="br.com.tarefas.controller.LoginController"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	PageFilter pagina = new PageFilter();
	
	String query = pagina.PaginaAtual(request, response);

	session.setAttribute("Pagina", query);
%>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script>

	<div id="sidebar" class="sidebar                  responsive">
		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-success">
					<i class="ace-icon fa fa-signal"></i>
				</button>

				<button class="btn btn-info">
					<i class="ace-icon fa fa-pencil"></i>
				</button>

				<button class="btn btn-warning">
					<i class="ace-icon fa fa-users"></i>
				</button>

				<button class="btn btn-danger">
					<i class="ace-icon fa fa-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span> <span class="btn btn-info"></span>

				<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
			</div>
		</div>
		<ul class="nav nav-list">
			<c:if test="${fn:contains(pagina, Home)}">
				<li class="active">
			</c:if>
			<c:if test="${not fn:contains(pagina, Home)}">
				<li class="">
			</c:if>
			<a href="Home"> <i class="menu-icon fa fa-tachometer"></i> <span
				class="menu-text"> Área de Trabalho </span>
			</a>
			<b class="arrow"></b>
			</li>
			<li class="">
			<a href="ComissaoConstrucao"> <i class="menu-icon fa fa-university"></i> <span
				class="menu-text">Comissão Constr.</span>
			</a>
			<b class="arrow"></b>
			</li>

			<c:forEach items="${MENU1}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU2}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU3}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU4}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>

			<c:forEach items="${MENU5}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU6}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU7}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU8}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU9}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU10}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU11}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>


			</c:forEach>
			<c:forEach items="${MENU12}" var="list">

				<c:set var="pagina" value="${Pagina}" />
				<c:set var="item" value="${list.key.substring(3)}" />

				<c:if test="${fn:contains(pagina, item)}">
					<li class="active">
				</c:if>
				<c:if test="${not fn:contains(pagina, item)}">
					<li class="">
				</c:if>

				<c:if test="${list.key.substring(3) eq 'Secretaria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-users"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Tesouraria'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-credit-card"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Orquestra'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-music"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Compras'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-shopping-cart"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Solicitações'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-th"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Eventos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon glyphicon glyphicon-calendar"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Patrimonio Projetos'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-building-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Relatorios'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-file-text-o"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Conselho Fiscal'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-archive"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Distribuidora'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-book"> </i>
				</c:if>
				<c:if test="${list.key.substring(3) eq 'Links Úteis'}">
					<a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-link"> </i>
				</c:if>




				<span class="menu-text"> ${list.key.substring(3)} <span
					class="badge badge-primary"></span>
				</span>
				<b class="arrow fa fa-angle-down"></b>
				</a>
				<b class="arrow"></b>


				<ul class="submenu">
					<c:forEach items="${list.value}" var="listItem">

						<c:set var="pagina" value="${Pagina}" />
						<c:set var="item" value="${listItem[1]}" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active">
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<li class="">
						</c:if>


						<b class="arrow"></b>
						<c:set var="item" value="${listItem[0]}" />
						<c:set var="pagina" value="Seguros" />

						<c:if test="${fn:contains(pagina, item)}">
							<li class="active"><a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"> </i> <span
									class="menu-text"> Seguros <span
										class="badge badge-primary"></span>
								</span> <b class="arrow fa fa-angle-down"></b>
							</a> <b class="arrow"></b>
								<ul class="submenu">
									<li class=""><a href="Adesao"> <i
											class="menu-icon fa fa-caret-right"></i> Cadastro Adesão
									</a> <b class="arrow"></b></li>
									<li class=""><a href="Presenca"> <i
											class="menu-icon fa fa-caret-right"></i> Livro Presença
									</a> <b class="arrow"></b></li>
									<li class=""><a href="EmitirRelatorio"> <i
											class="menu-icon fa fa-caret-right"></i> Relatório
									</a> <b class="arrow"></b></li>

								</ul>
						</c:if>
						<c:if test="${not fn:contains(pagina, item)}">
							<a href="${listItem[1]}"> <i
								class="menu-icon fa fa-caret-right"></i>${listItem[0]}
							</a>
						</c:if>

						</li>
					</c:forEach>
				</ul>
				</li>
			</c:forEach>
		</ul>
		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i class="ace-icon fa fa-angle-double-left"
				data-icon1="ace-icon fa fa-angle-double-left"
				data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>

		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'collapsed')
			} catch (e) {
			}
		</script>
	</div>

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="Home">Home</a></li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
				<!-- /.nav-search -->
			</div>

			<div class="page-content">
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
						id="ace-settings-btn">
						<i class="ace-icon fa fa-cog bigger-130"></i>
					</div>

					<div class="ace-settings-box clearfix" id="ace-settings-box">
						<div class="pull-left width-50">
							<div class="ace-settings-item">
								<div class="pull-left">
									<select id="skin-colorpicker" class="hide">
										<option data-skin="no-skin" value="#438EB9">#438EB9</option>
										<option data-skin="skin-1" value="#222A2D">#222A2D</option>
										<option data-skin="skin-2" value="#C6487E">#C6487E</option>
										<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
									</select>
								</div>
								<span>&nbsp; Choose Skin</span>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-navbar" /> <label class="lbl"
									for="ace-settings-navbar"> Fixed Navbar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-sidebar" /> <label class="lbl"
									for="ace-settings-sidebar"> Fixed Sidebar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-breadcrumbs" /> <label class="lbl"
									for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-rtl" /> <label class="lbl"
									for="ace-settings-rtl"> Right To Left (rtl)</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-add-container" /> <label class="lbl"
									for="ace-settings-add-container"> Inside <b>.container</b>
								</label>
							</div>
						</div>
						<!-- /.pull-left -->

						<div class="pull-left width-50">
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-hover" /> <label class="lbl"
									for="ace-settings-hover"> Submenu on Hover</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-compact" /> <label class="lbl"
									for="ace-settings-compact"> Compact Sidebar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-highlight" /> <label class="lbl"
									for="ace-settings-highlight"> Alt. Active Item</label>
							</div>
						</div>
						<!-- /.pull-left -->
					</div>
					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->