<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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

<link rel="stylesheet" href="resources/js/ace.min.css">
<link rel="stylesheet" href="resources/js/ace-responsive.min.css">
<link rel="stylesheet" href="resources/js/ace-skins.min.css">
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="resources/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="resources/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="resources/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="resources/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="resources/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="resources/assets/js/ace-extra.min.js"></script>
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
											<form action="AtualizaSenha" method="post">
												<div class="row-fluid">
													<div class="span12">
														<br> <br> <br>
														<h1>Alterar Senha</h1>
														<br> <br>
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
	<div class="row-fluid">
		<div class="span12">
			<hr>
			<p class="center">Congregação Cristã no Brasil - Todos os
				direitos reservados</p>
		</div>
	</div>

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='resources/assets/js/jquery.mobile.custom.min.js'>"
							+ "<" + "/script>");
	</script>

	<script src="resources/js/bootstrap.min.js"></script>


	<!--ace scripts-->
	<script src="resources/js/ace-elements.min.js"></script>

	<script src="resources/js/ace.min.js"></script>



	<script src="resources/assets/js/jquery.2.1.1.min.js"></script>

	<!-- <![endif]-->

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='resources/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="resources/assets/js/bootstrap.min.js"></script>

	<script src="resources/assets/js/ace-elements.min.js"></script>
	<script src="resources/assets/js/ace.min.js"></script>
	<script src="resources/assets/js/jquery.2.1.1.min.js"></script>


	<script src="resources/assets/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/ace-elements.min.js"></script>
	<script src="resources	assets/js/ace.min.js"></script>
</body>
</html>