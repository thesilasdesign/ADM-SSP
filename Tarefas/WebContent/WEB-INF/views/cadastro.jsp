<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
<title>.::Administração Jandira::.</title>

<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="resources/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="resources/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="resources/assets/css/ace.min.css" />

<!--[if lte IE 9]>
                <link rel="stylesheet" href="resources/assets/css/ace-part2.min.css" />
        <![endif]-->
<link rel="stylesheet" href="resources/assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
          <link rel="stylesheet" href="resources/assets/css/ace-ie.min.css" />
        <![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
        <script src="resources/assets/js/html5shiv.min.js"></script>
        <script src="resources/assets/js/respond.min.js"></script>
        <![endif]-->

<title>SIGA</title>
<link rel="icon"
	href="#"
	type="image/png">

<meta name="description" content="">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<meta name="robots" content="noindex, nofollow">
<!--basic styles-->
<link rel="stylesheet" href="resources/js/bootstrap.min.css">
<link rel="stylesheet" href="resources/js/bootstrap-responsive.min.css">
<link rel="stylesheet" href="resources/js/font-awesome.min.css">
<link rel="stylesheet" href="resources/js/font-awesome.min(1).css">

<!--[if IE 7]>
    <link rel="stylesheet" href="resources/assets/css/font-awesome-ie7.min.css" />
	<![endif]-->

<!--page specific plugin styles-->
<link rel="stylesheet" href="resources/js/select2.css">

<!--fonts-->
<link rel="stylesheet" href="resources/js/ace-fonts.css">

<!--ace styles-->
<link rel="stylesheet" href="resources/js/ace.min.css">
<link rel="stylesheet" href="resources/js/ace-responsive.min.css">
<link rel="stylesheet" href="resources/js/ace-skins.min.css">

<!--[if lte IE 8]>
	<link rel="stylesheet" href="resources/assets/css/ace-ie.min.css" />
    <![endif]-->

<!-- inline styles related to this page -->
<link rel="stylesheet" href="resources/js/siga.css">

<!-- ace settings handler -->
<script async="" src="resources/js/analytics.js"></script>
<script src="resources/js/ace-extra.min.js"></script>
</head>

<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a href="#" class="brand"
					style="padding: 10px 0 10px 20px; margin-right: -25px;">Administração Jandira</a>
			</div>
		</div>
	</div>

	<div class="container" style="padding: 8px; padding-top: 24px">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span6">&nbsp;</div>

					<div class="span6">
						<div class="widget-box transparent">
							<div class="widget-body">
								<div class="widget-main">
									<div class="row-fluid">
										<div class="span12">
											<form action="addCadastro" method="post">
												<div class="row-fluid">
													<div class="span12">
														<h1>Cadastro de Usuário</h1>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span12">
														<div class="control-group">
															<label for="f_usuario" class="control-label">E-mail:</label>
															<div class="controls">
																<div class="input-icon input-icon-right">
																	<i class="icon-user"></i> <input type="text"
																		name="email" id="email" maxlength="255"
																		placeholder="jose.oliveira@congregacao.org.br"
																		required="required" class="input-block-level">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span12">
														<div class="control-group">
															<label for="f_usuario" class="control-label">Nome
																Usuário:</label>
															<div class="controls">
																<div class="input-icon input-icon-right">
																	<i class="icon-user"></i> <input type="text"
																		name="nome" id="nome" maxlength="80"
																		placeholder="Jose Oliveira" required="required"
																		class="input-block-level">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span12">
														<div class="control-group">
															<label for="f_usuario" class="control-label">Setor:</label>
															<div class="controls">
																<div class="input-icon input-icon-right">
																	<i class="glyphicon glyphicon-exclamation-sign"></i> <input
																		type="text" name="setor" id="setor" maxlength="80"
																		required="required" class="input-block-level"
																		placeholder="Ex.: ADM Secretária">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span12">
														<div class="control-group">
															<label for="f_usuario" class="control-label">Comum:</label>
															<div class="controls">
																<div class="input-icon input-icon-right">
																	<i class="glyphicon glyphicon-globe"></i> <input
																		type="text" name="comum" id="comum" maxlength="80"
																		required="required" class="input-block-level"
																		placeholder="Jd Gabriela">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span12">
														<div class="control-group">
															<label for="f_usuario" class="control-label">Senha:</label>
															<div class="controls">
																<div class="input-icon input-icon-right">
																	<i class="icon-lock"></i> <input type="password"
																		name="senha" id="senha" maxlength="80"
																		required="required" class="input-block-level">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span12">
														<div class="control-group">
															<label for="f_usuario" class="control-label">Repita
																Senha:</label>
															<div class="controls">
																<div class="input-icon input-icon-right">
																	<i class="icon-lock"></i> <input type="password"
																		name="repitaSenha" id="repitaSenha" maxlength="80"
																		required="required" class="input-block-level">
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row-fluid">
													<div class="span6">
														<button type="submit"
															class="btn btn-primary btn-small no-border bolder">
															Enviar</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<br> <br> <br> <br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="my-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">A modal with a
						slider in it!</h3>
				</div>

				<div class="modal-body">
					Some content <br /> <br /> <br /> <br /> <br /> 1 <br /> <br />
					<br /> <br /> <br /> 2
				</div>

				<div class="modal-footer">
					<button class="btn btn-sm btn-danger pull-right"
						data-dismiss="modal">
						<i class="ace-icon fa fa-times"></i> Close
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div class="row-fluid">
		<div class="span12">
			<hr>
			<p class="center">Congregação Cristã no Brasil - Todos os
				direitos reservados</p>
		</div>
	</div>

	<form id="f-encerrar" name="f-encerrar" method="post"
		autocomplete="off">
		<input type="hidden" name="encerrar" id="encerrar" value="S">
		<input type="hidden" id="id" name="id">
	</form>

	<!--basic scripts-->
	<!--[if !IE]>-->
	<script src="resources/js/jquery-2.0.3.min.js"></script>
	<!--<![endif]-->

	<!--[if IE]>
    <script src="resources/assets/js/jquery-1.10.2.min.js"></script>
    <![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='resources/assets/js/jquery.mobile.custom.min.js'>"
							+ "<" + "/script>");
	</script>

	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/jquery.blockui.js"></script>

	<script src="resources/js/bootbox.min.js"></script>

	<script src="resources/js/jquery.gritter.min.js"></script>

	<script src="resources/js/jquery.validate.min.js"></script>

	<script src="resources/js/jquery.autonumeric.js"></script>

	<script src="resources/js/jquery.number.min.js"></script>

	<script src="resources/js/jquery.maskedinput.min.js"></script>

	<script src="resources/js/jquery.cookie.js"></script>

	<!-- page specific plugin scripts -->

	<script src="resources/js/select2.js"></script>

	<!--ace scripts-->
	<script src="resources/js/ace-elements.min.js"></script>

	<script src="resources/js/ace.min.js"></script>

	<!--siga scripts-->
	<script src="resources/js/siga.js"></script>
	<script src="resources/js/siga.util.js"></script>
	<script src="resources/js/siga.sis.js"></script>
	<script src="resources/js/siga.ctb.js"></script>
	<script src="resources/js/siga.rel.js"></script>
	<script src="resources/js/siga.est.js"></script>
	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="resources/assets/js/jquery.2.1.1.min.js"></script>

	<!-- <![endif]-->

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='resources/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="resources/assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!-- ace scripts -->
	<script src="resources/assets/js/ace-elements.min.js"></script>
	<script src="resources/assets/js/ace.min.js"></script>
</body>
</html>