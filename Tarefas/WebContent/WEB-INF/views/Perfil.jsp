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
							src="data:image/jpeg;base64,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" />
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