<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="../config/cabecalho.jsp" />
<c:import url="../config/Menu.jsp" />
<h3 class="header smaller lighter blue">Pagamentos Compras/Tesouraria</h3>
	<div id="modal-table" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						Results for "Latest Registered Domains
					</div>
				</div>

				<div class="modal-body no-padding">
					<table
						class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
						<thead>
							<tr>
								<th>Domain</th>
								<th>Price</th>
								<th>Clicks</th>

								<th><i class="ace-icon fa fa-clock-o bigger-110"></i>
									Update</th>
							</tr>
						</thead>

						
					</table>
				</div>

				<div class="modal-footer no-margin-top">
					<button class="btn btn-sm btn-danger pull-left"
						data-dismiss="modal">
						<i class="ace-icon fa fa-times"></i> Close
					</button>

					<ul class="pagination pull-right no-margin">
						<li class="prev disabled"><a href="#"> <i
								class="ace-icon fa fa-angle-double-left"></i>
						</a></li>

						<li class="active"><a href="#">1</a></li>

						<li><a href="#">2</a></li>

						<li><a href="#">3</a></li>

						<li class="next"><a href="#"> <i
								class="ace-icon fa fa-angle-double-right"></i>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- PAGE CONTENT ENDS -->
<c:import url="../config/rodape.jsp" />