<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:import url="config/cabecalho.jsp" />
<c:import url="config/Menu.jsp" />
<div class="col-sm-12">
	<div class="alert alert-danger">
		<b>Novo Portal - Se encontrar algum erro, favor reportar para Silas ou Gildasio - Deus Abençoe	</b>
	</div>
	<div class="widget-header widget-header-flat">
		<h4 class="widget-title lighter">
			<i class="ace-icon fa fa-star orange"></i> Comunicados
		</h4>
	</div>
	
		<div id="accordion" class="accordion-style1 panel-group">
			<c:forEach items="${eventos}" var="eventos" varStatus="status">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">

							<c:if test="${status.index == 0}">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseOne">
							</c:if>
							<c:if test="${status.index == 1}">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo">
							</c:if>
							<c:if test="${status.index == 2}">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion" href="#collapseThree">
							</c:if>

							<i class="ace-icon fa fa-angle-down bigger-110"
								data-icon-hide="ace-icon fa fa-angle-down"
								data-icon-show="ace-icon fa fa-angle-right"></i>
							${eventos.titulo} - ${eventos.data} </a>
						</h4>
					</div>
					<c:if test="${status.index == 0}">
						<div class="panel-collapse collapse in" id="collapseOne">
					</c:if>
					<c:if test="${status.index == 1}">
						<div class="panel-collapse collapse in" id="collapseTwo">
					</c:if>
					<c:if test="${status.index == 2}">
						<div class="panel-collapse collapse in" id="collapseThree">
					</c:if>
					<div class="panel-body">${eventos.texto}</div>
				</div>
		</div>
		</c:forEach>
	</div>
</div>



<c:import url="config/rodape.jsp" />