<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:import url="config/cabecalho.jsp" />
<c:import url="config/Menu.jsp" />
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="clearfix">
			<div class="pull-left alert alert-success no-margin">
				<button type="button" class="close" data-dismiss="alert">
					<i class="ace-icon fa fa-times"></i>
				</button>

				<i class="ace-icon fa fa-umbrella bigger-120 blue"></i> Clique na
				imagem abaixo ou em campos de perfil para editá-los ...
			</div>

			<div class="pull-right">
				<span class="green middle bolder">Completar perfil: &nbsp;</span>

				<div class="btn-toolbar inline middle no-margin">
					<div data-toggle="buttons" class="btn-group no-margin">
						<label class="btn btn-sm btn-yellow active"> <span
							class="bigger-110">1</span> <input type="radio" value="1" />
						</label> <label class="btn btn-sm btn-yellow"> <span
							class="bigger-110">2</span> <input type="radio" value="3" />
						</label>
					</div>
				</div>
			</div>
		</div>

		<div class="hr dotted"></div>

		<div>
			<div id="user-profile-1" class="user-profile row">
				<div class="col-xs-12 col-sm-3 center">
					<div>
						<span class="profile-picture"> <img id="avatar"
							class="editable img-responsive" alt="Alex's Avatar"
							src="resources/assets/avatars/profile-pic.jpg" />
						</span>

						<div class="space-4"></div>

						<div
							class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
							<div class="inline position-relative">
								<a href="#" class="user-title-label dropdown-toggle"
									data-toggle="dropdown"> <i
									class="ace-icon fa fa-circle light-green"></i> &nbsp; <span
									class="white"> ${perfil.nome} </span>
								</a>
							</div>
						</div>
					</div>

					<div class="space-6"></div>

					<div class="profile-contact-info">
						<div class="profile-contact-links align-left">
							<a href="#" class="btn btn-link"> <i
								class="ace-icon fa fa-plus-circle bigger-120 green"></i>
								${perfil.setor}
							</a> <a href="#" class="btn btn-link"> <i
								class="ace-icon fa fa-envelope bigger-120 pink"></i> Enviar
								E-mail
							</a> <a href="#" class="btn btn-link"> <i
								class="ace-icon fa fa-globe bigger-125 blue"></i>
								${perfil.email}
							</a>
						</div>


						<div class="space-6"></div>
					</div>
					<div class="hr hr12 dotted"></div>
					<div class="hr hr16 dotted"></div>
				</div>

				<div class="col-xs-12 col-sm-9">

					<div class="space-12"></div>

					<div class="profile-user-info profile-user-info-striped">
						<div class="profile-info-row">
							<div class="profile-info-name">Nome Usuário</div>

							<div class="profile-info-value">
								<span> ${perfil.nome} </span>
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">Localização</div>

							<div class="profile-info-value">
								<i class="fa fa-map-marker light-orange bigger-110"></i> <span>
									São Paulo </span> <span> ${perfil.cidade} </span>
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">E-mail</div>

							<div class="profile-info-value">
								<span> ${perfil.email} </span>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">Comum</div>

							<div class="profile-info-value">
								<span> ${perfil.comum} </span>
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">Setor Adm</div>

							<div class="profile-info-value">
								<span> ${perfil.setor} </span>
							</div>
						</div>
					</div>
					<div class="space-20"></div>
				</div>
			</div>
		</div>
		<div class="hide">
			<div id="user-profile-3" class="user-profile row">
				<div class="col-sm-offset-1 col-sm-10">
					<div class="space"></div>
					<form class="form-horizontal" action="alteraUsuario" method="post">
						<input type="hidden" value="${perfil.usuarioId}"
							name="UsuarioId">
							<input type="hidden" value="${perfil.perfil}"
							name="perfil">
						<div class="tabbable">
							<ul class="nav nav-tabs padding-16">
								<li class="active"><a data-toggle="tab" href="#edit-basic">
										<i class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
										Informações básicas
								</a></li>

								<li><a data-toggle="tab" href="#edit-settings"> <i
										class="purple ace-icon fa fa-cog bigger-125"></i> Informações
										diversos
								</a></li>

								<li><a data-toggle="tab" href="#edit-password"> <i
										class="blue ace-icon fa fa-key bigger-125"></i> Senha
								</a></li>
							</ul>

							<div class="tab-content profile-edit-tab-content">
								<div id="edit-basic" class="tab-pane in active">
									<h4 class="header blue bolder smaller">Geral</h4>

									<div class="row">
										<div class="col-xs-12 col-sm-4">
											<input type="file" />
										</div>

										<div class="space-4"></div>

										<div class="col-xs-12 col-sm-4">
											<div>
												<label for="form-field-select-3">Comum</label> <br /> <select
													class="chosen-select form-control" name="comum"
													id="form-field-select-3"
													data-placeholder="Choose a State...">
													<c:forEach items="${igreja}" var="igreja">
														<option value="${igreja.comum}">${igreja.comum}</option>
													</c:forEach>
												</select>
											</div>

											<div class="space-4"></div>


										</div>
									</div>

									<div class="space-4"></div>

									<h4 class="header blue bolder smaller">Endereço</h4>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-email">Nome</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-input-readonly" readonly="" name="nome"
												value="${perfil.nome}" />
											</span>

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-email">Endereço</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-field-email" name="endereco"
												value="${perfil.endereco}" />
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-email">Bairro</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-field-email" name="bairro"
												value="${perfil.bairro}" />
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-email">Cidade</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-field-email" name="cidade"
												value="${perfil.cidade}" />
											</span>
										</div>
									</div>
									<h4 class="header blue bolder smaller">Contato</h4>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-email">Email</label>

										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												readonly="" type="text" id="form-input-readonly"
												value="${perfil.email}" name="email" /> <i
												class="ace-icon fa fa-envelope"></i>
											</span>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-phone">Telefone</label>

										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												class="" type="text" name="telefone"
												value="${perfil.telefone}" /><i
												class="ace-icon fa fa-phone fa-flip-horizontal"></i>
											</span>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-phone">Celular</label>

										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												class="" type="text" name="celular"
												value="${perfil.celular}" /> <i
												class="ace-icon fa fa-phone fa-flip-horizontal"></i>
											</span>
										</div>
									</div>
									<div class="space"></div>
									<h4 class="header blue bolder smaller">Igreja</h4>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-facebook">Setor</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												readonly="" type="text" id="form-input-readonly"
												value="${perfil.setor}" name="setor" />
											</span>
										</div>
									</div>
									<div class="space-4"></div>
								</div>

								<div id="edit-settings" class="tab-pane">
									<div class="space-10"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-facebook">Data Nascimento</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-field-email" name="dataNascimento" 
												value="${perfil.dataNascimento}" />
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-facebook">Data Cadastro</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-field-email" name="dataCadastro" readonly=""
												value="${perfil.dataCadastro}"/>
											</span>
										</div>
									</div>

									<div class="space-8"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-facebook">Estado civil</label>
										<div class="col-sm-9">
											<span class="input-icon input-icon-right"> <input
												type="text" id="form-field-email" name="estadoCivil"
												value="${perfil.estadoCivil}" />
											</span>
										</div>
									</div>
									<div class="space-8"></div>
								</div>

								<div id="edit-password" class="tab-pane">
									<div class="space-10"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-pass1">Nova senha</label>

										<div class="col-sm-9">
											<input type="password" id="form-field-pass1" name="senha"
												value="${perfil.senha}" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-pass2">Confirmar senha</label>

										<div class="col-sm-9">
											<input type="password" id="form-field-pass2"
												name="repitaSenha" value="${perfil.senha}" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="submit">
									<i class="ace-icon fa fa-check bigger-110"></i> Salvar
								</button>

								&nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i> Reset
								</button>
							</div>
						</div>
					</form>
				</div>
				<!-- /.span -->
			</div>
			<!-- /.user-profile -->
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div>
</div>

<c:import url="config/rodape.jsp" />