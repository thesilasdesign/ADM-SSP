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
			<div class="tabbable">
				<ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab">

					<li class="active"><a data-toggle="tab" href="#faq-tab-1">
							<i class="blue ace-icon fa fa-question-circle bigger-120"></i>
							Chamados Abertos ${qtdeInformatica}
					</a></li>

					<li><a data-toggle="tab" href="#faq-tab-2"> <i
							class="green ace-icon fa fa-user bigger-120"></i> Meus
							Atendimentos
					</a></li>

					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="purple ace-icon fa fa-magic bigger-120"></i> Diversos <i
							class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul class="dropdown-menu dropdown-lighter dropdown-125">
							<li><a data-toggle="tab" href="#faq-tab-4"> Liberar
									Usuário </a></li>

							<!-- 							<li><a data-toggle="tab" href="#faq-tab-4"> Merchants </a></li> -->
						</ul></li>
					<!-- /.dropdown -->
				</ul>

				<div class="tab-content no-border padding-24">
					<div id="faq-tab-4" class="tab-pane fade">
						<div id="faq-list-4"
							class="panel-group accordion-style1 accordion-style2">
							<div class="panel panel-default">
								<div class="clearfix">
									<div class="pull-right tableTools-container"></div>
								</div>
								<div class="table-header">Liberar Usuaário</div>
								<div class="table-responsive">
									<table id="dynamic-table"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Nome</th>
												<th>Email</th>
												<th>Setor</th>
												<th class="hidden-480">Comum</th>
												<th><i
													class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>Data
													Cadastro</th>
												<th class="hidden-480">Ativar</th>
												<th>Editar</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${usuario}" var="usuario">
												<tr>
													<td>${usuario.usuarioId}</td>
													<td><a href=#>${usuario.nome}</a></td>
													<td>${usuario.email}</td>
													<td>${usuario.setor}</td>
													<td class=hidden-480>${usuario.comum}</td>
													<td class=hidden-480>${usuario.dataCadastro}</td>
													<c:if test="${usuario.status eq 1}">
														<td class=hidden-480><span
															class='label label-success label-sm arrowed-in'>Ativo</span></td>
													</c:if>
													<c:if test="${usuario.status eq 0}">
														<td class=hidden-480><span
															class='label label-danger label-sm'>Bloqueado</span></td>
													</c:if>
													<td>
														<div class='hidden-sm hidden-xs action-buttons'>
															<a class=blue href='StatusUsuario?id=${usuario.usuarioId}'>
																<c:if test="${usuario.status eq 0}">
																	<i class='ace-icon fa fa-check green bigger-129'></i>
																</c:if> <c:if test="${usuario.status eq 1}">
																	<i class='ace-icon fa fa-lock red bigger-170'></i>
																</c:if>
															</a> <a class='green'
																href='EditaPerfil?id=${usuario.usuarioId}' role='button'
																data-toggle='modal' name='modal'
																data-whatever='$email_per[$v]'> <i
																class='ace-icon fa fa-pencil blue bigger-130'></i>
															</a> <a class=red
																href='DeletarUsuario?id=${usuario.usuarioId}'> <i
																class='ace-icon fa fa-trash-o bigger-130'></i>
															</a>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div id="faq-tab-1" class="tab-pane fade in active">
						<div id="faq-list-1"
							class="panel-group accordion-style1 accordion-style2">
							<div class="panel panel-default">
								<div class="clearfix">
									<div class="pull-right tableTools-container"></div>
								</div>
								<div class="table-header">Últimas Solicitações</div>
								<div class="table-responsive">
									<table id="dynamic-table"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Tipo Solicitação</th>
												<th>Solicitação</th>
												<th>Data Abertura</th>
												<th>Status</th>
												<th>Local</th>
												<th>Nome do Atendente</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${informaticaAberto}"
												var="informaticaAberto">
												<tr>
													<td><a
														href="Chamado?id=${informaticaAberto.informaticaId}">
															${informaticaAberto.informaticaId} </a></td>
													<td>${informaticaAberto.tipoServico}</td>
													<td>${informaticaAberto.solicitacao}</td>
													<td><fmt:formatDate
															value="${informaticaAberto.dataAbertura.time}"
															pattern="dd/MM/yyyy" /></td>
													<td>${informaticaAberto.status}</td>
													<td>${informaticaAberto.local}</td>
													<td class="center"><a
														href="AtribuiChamado?id=${informaticaAberto.informaticaId}&nomeAtendente=${usuarioLogado.nome}">
															Atender</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<div id="faq-tab-2" class="tab-pane fade">
						<div id="faq-list-2"
							class="panel-group accordion-style1 accordion-style2">
							<div class="panel panel-default">
								<div class="clearfix">
									<div class="pull-right tableTools-container"></div>
								</div>
								<div class="table-header">Últimas Solicitações</div>
								<div class="table-responsive">
									<table id="dynamic-table"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Tipo Solicitação</th>
												<th>Solicitação</th>
												<th>Data Abertura</th>
												<th>Status</th>
												<th>Local</th>
												<th>Nome do Atendente</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${MeusChamados}" var="MeusChamados">
												<tr>
													<td><a href="Chamado?id=${MeusChamados.informaticaId}">
															${MeusChamados.informaticaId} </a></td>
													<td>${MeusChamados.tipoServico}</td>
													<td>${MeusChamados.solicitacao}</td>
													<td><fmt:formatDate
															value="${MeusChamados.dataAbertura.time}"
															pattern="dd/MM/yyyy" /></td>
													<td>${MeusChamados.status}</td>
													<td>${MeusChamados.local}</td>
													<td class="center"><a
														href="FinalizarChamado?id=${MeusChamados.informaticaId}">
															Finalizar</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<div id="faq-tab-3" class="tab-pane fade">
						<h4 class="blue">
							<i class="orange ace-icon fa fa-credit-card bigger-110"></i> <a
								href="SistMovNF"> Sistema de Movimentação de Nota Fiscal</a>
						</h4>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="../config/rodape.jsp" />