</div>
</div>
</div>
</div>
</div>
</div>
<!-- /.main-content -->
<div class="footer">
	<div class="footer-inner">
		<div class="footer-content">
			<span class="bigger-120"> <span class="blue bolder">Congregação Cristã no Brasil - Todos os direitos reservados</span> &copy; 2019
			</span> &nbsp; &nbsp; <span class="action-buttons">
			</span>
		</div>
	</div>
</div>

<a href="#" id="btn-scroll-up"
	class="btn-scroll-up btn btn-sm btn-inverse"> <i
	class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<!-- /.main-container -->

<script src="resources/assets/js/jquery.2.1.1.min.js"></script>

<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='assets/js/jquery.min.js'>"
					+ "<"+"/script>");
</script>

<script type="text/javascript">
	if ('ontouchstart' in document.documentElement)
		document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
				+ "<"+"/script>");
</script>
</body>

<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='assets/js/jquery.min.js'>"
					+ "<"+"/script>");
</script>

<script type="text/javascript">
	if ('ontouchstart' in document.documentElement)
		document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
				+ "<"+"/script>");
</script>
<script src="resources/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
		  <script src="resources/assets/js/excanvas.min.js"></script>
		<![endif]-->
<script src="resources/assets/js/jquery-ui.custom.min.js"></script>
<script src="resources/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="resources/assets/js/jquery.gritter.min.js"></script>
<script src="resources/assets/js/bootbox.min.js"></script>
<script src="resources/assets/js/jquery.easypiechart.min.js"></script>
<script src="resources/assets/js/bootstrap-datepicker.min.js"></script>
<script src="resources/assets/js/jquery.hotkeys.min.js"></script>
<script src="resources/assets/js/bootstrap-wysiwyg.min.js"></script>
<script src="resources/assets/js/select2.min.js"></script>
<script src="resources/assets/js/fuelux.spinner.min.js"></script>
<script src="resources/assets/js/bootstrap-editable.min.js"></script>
<script src="resources/assets/js/ace-editable.min.js"></script>
<script src="resources/assets/js/jquery.maskedinput.min.js"></script>

<!-- ace scripts -->
<script src="resources/assets/js/ace-elements.min.js"></script>
<script src="resources/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
	jQuery(function($) {

		//editables on first profile page
		$.fn.editable.defaults.mode = 'inline';
		$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
		$.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'
				+ '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';

		//editables 

		//text editable
		$('#username').editable({
			type : 'text',
			name : 'username'
		});

		//select2 editable
		var countries = [];
		$.each({
			"CA" : "Canada",
			"IN" : "India",
			"NL" : "Netherlands",
			"TR" : "Turkey",
			"US" : "United States"
		}, function(k, v) {
			countries.push({
				id : k,
				text : v
			});
		});

		var cities = [];
		cities["CA"] = [];
		$.each([ "Toronto", "Ottawa", "Calgary", "Vancouver" ], function(k, v) {
			cities["CA"].push({
				id : v,
				text : v
			});
		});
		cities["IN"] = [];
		$.each([ "Delhi", "Mumbai", "Bangalore" ], function(k, v) {
			cities["IN"].push({
				id : v,
				text : v
			});
		});
		cities["NL"] = [];
		$.each([ "Amsterdam", "Rotterdam", "The Hague" ], function(k, v) {
			cities["NL"].push({
				id : v,
				text : v
			});
		});
		cities["TR"] = [];
		$.each([ "Ankara", "Istanbul", "Izmir" ], function(k, v) {
			cities["TR"].push({
				id : v,
				text : v
			});
		});
		cities["US"] = [];
		$.each([ "New York", "Miami", "Los Angeles", "Chicago", "Wysconsin" ],
				function(k, v) {
					cities["US"].push({
						id : v,
						text : v
					});
				});

		var currentValue = "NL";
		$('#country').editable(
				{
					type : 'select2',
					value : 'NL',
					//onblur:'ignore',
					source : countries,
					select2 : {
						'width' : 140
					},
					success : function(response, newValue) {
						if (currentValue == newValue)
							return;
						currentValue = newValue;

						var new_source = (!newValue || newValue == "") ? []
								: cities[newValue];

						//the destroy method is causing errors in x-editable v1.4.6+
						//it worked fine in v1.4.5
						/**			
						$('#city').editable('destroy').editable({
							type: 'select2',
							source: new_source
						}).editable('setValue', null);
						 */

						//so we remove it altogether and create a new element
						var city = $('#city').removeAttr('id').get(0);
						$(city).clone().attr('id', 'city').text('Select City')
								.editable({
									type : 'select2',
									value : null,
									//onblur:'ignore',
									source : new_source,
									select2 : {
										'width' : 140
									}
								}).insertAfter(city);//insert it after previous instance
						$(city).remove();//remove previous instance

					}
				});

		$('#city').editable({
			type : 'select2',
			value : 'Amsterdam',
			//onblur:'ignore',
			source : cities[currentValue],
			select2 : {
				'width' : 140
			}
		});

		//custom date editable
		$('#signup').editable({
			type : 'adate',
			date : {
				//datepicker plugin options
				format : 'yyyy/mm/dd',
				viewformat : 'yyyy/mm/dd',
				weekStart : 1

			//,nativeUI: true//if true and browser support input[type=date], native browser control will be used
			//,format: 'yyyy-mm-dd',
			//viewformat: 'yyyy-mm-dd'
			}
		})

		$('#age').editable({
			type : 'spinner',
			name : 'age',
			spinner : {
				min : 16,
				max : 99,
				step : 1,
				on_sides : true
			//,nativeUI: true//if true and browser support input[type=number], native browser control will be used
			}
		});

		$('#login').editable({
			type : 'slider',
			name : 'login',

			slider : {
				min : 1,
				max : 50,
				width : 100
			//,nativeUI: true//if true and browser support input[type=range], native browser control will be used
			},
			success : function(response, newValue) {
				if (parseInt(newValue) == 1)
					$(this).html(newValue + " hour ago");
				else
					$(this).html(newValue + " hours ago");
			}
		});

		$('#about').editable({
			mode : 'inline',
			type : 'wysiwyg',
			name : 'about',

			wysiwyg : {
			//css : {'max-width':'300px'}
			},
			success : function(response, newValue) {
			}
		});

		// *** editable avatar *** //
		try {//ie8 throws some harmless exceptions, so let's catch'em

			//first let's add a fake appendChild method for Image element for browsers that have a problem with this
			//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
			try {
				document.createElement('IMG').appendChild(
						document.createElement('B'));
			} catch (e) {
				Image.prototype.appendChild = function(el) {
				}
			}

			var last_gritter
			$('#avatar')
					.editable(
							{
								type : 'image',
								name : 'avatar',
								value : null,
								image : {
									//specify ace file input plugin's options here
									btn_choose : 'Change Avatar',
									droppable : true,
									maxSize : 110000,//~100Kb

									//and a few extra ones here
									name : 'avatar',//put the field name here as well, will be used inside the custom plugin
									on_error : function(error_type) {//on_error function will be called when the selected file has a problem
										if (last_gritter)
											$.gritter.remove(last_gritter);
										if (error_type == 1) {//file format error
											last_gritter = $.gritter
													.add({
														title : 'File is not an image!',
														text : 'Please choose a jpg|gif|png image!',
														class_name : 'gritter-error gritter-center'
													});
										} else if (error_type == 2) {//file size rror
											last_gritter = $.gritter
													.add({
														title : 'File too big!',
														text : 'Image size should not exceed 100Kb!',
														class_name : 'gritter-error gritter-center'
													});
										} else {//other error
										}
									},
									on_success : function() {
										$.gritter.removeAll();
									}
								},
								url : function(params) {
									// ***UPDATE AVATAR HERE*** //
									//for a working upload example you can replace the contents of this function with 
									//examples/profile-avatar-update.js

									var deferred = new $.Deferred

									var value = $('#avatar').next().find(
											'input[type=hidden]:eq(0)').val();
									if (!value || value.length == 0) {
										deferred.resolve();
										return deferred.promise();
									}

									//dummy upload
									setTimeout(
											function() {
												if ("FileReader" in window) {
													//for browsers that have a thumbnail of selected image
													var thumb = $('#avatar')
															.next().find('img')
															.data('thumb');
													if (thumb)
														$('#avatar').get(0).src = thumb;
												}

												deferred.resolve({
													'status' : 'OK'
												});

												if (last_gritter)
													$.gritter
															.remove(last_gritter);
												last_gritter = $.gritter
														.add({
															title : 'Avatar Updated!',
															text : 'Uploading to server can be easily implemented. A working example is included with the template.',
															class_name : 'gritter-info gritter-center'
														});

											},
											parseInt(Math.random() * 800 + 800))

									return deferred.promise();

									// ***END OF UPDATE AVATAR HERE*** //
								},

								success : function(response, newValue) {
								}
							})
		} catch (e) {
		}

		/**
		//let's display edit mode by default?
		var blank_image = true;//somehow you determine if image is initially blank or not, or you just want to display file input at first
		if(blank_image) {
			$('#avatar').editable('show').on('hidden', function(e, reason) {
				if(reason == 'onblur') {
					$('#avatar').editable('show');
					return;
				}
				$('#avatar').off('hidden');
			})
		}
		 */

		//another option is using modals
		$('#avatar2')
				.on(
						'click',
						function() {
							var modal = '<div class="modal fade">\
					  <div class="modal-dialog">\
					   <div class="modal-content">\
						<div class="modal-header">\
							<button type="button" class="close" data-dismiss="modal">&times;</button>\
							<h4 class="blue">Change Avatar</h4>\
						</div>\
						\
						<form class="no-margin">\
						 <div class="modal-body">\
							<div class="space-4"></div>\
							<div style="width:75%;margin-left:12%;"><input type="file" name="file-input" /></div>\
						 </div>\
						\
						 <div class="modal-footer center">\
							<button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> Submit</button>\
							<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> Cancel</button>\
						 </div>\
						</form>\
					  </div>\
					 </div>\
					</div>';

							var modal = $(modal);
							modal.modal("show").on("hidden", function() {
								modal.remove();
							});

							var working = false;

							var form = modal.find('form:eq(0)');
							var file = form.find('input[type=file]').eq(0);
							file.ace_file_input({
								style : 'well',
								btn_choose : 'Click to choose new avatar',
								btn_change : null,
								no_icon : 'ace-icon fa fa-picture-o',
								thumbnail : 'small',
								before_remove : function() {
									//don't remove/reset files while being uploaded
									return !working;
								},
								allowExt : [ 'jpg', 'jpeg', 'png', 'gif' ],
								allowMime : [ 'image/jpg', 'image/jpeg',
										'image/png', 'image/gif' ]
							});

							form
									.on(
											'submit',
											function() {
												if (!file
														.data('ace_input_files'))
													return false;

												file.ace_file_input('disable');
												form.find('button').attr(
														'disabled', 'disabled');
												form
														.find('.modal-body')
														.append(
																"<div class='center'><i class='ace-icon fa fa-spinner fa-spin bigger-150 orange'></i></div>");

												var deferred = new $.Deferred;
												working = true;
												deferred
														.done(function() {
															form
																	.find(
																			'button')
																	.removeAttr(
																			'disabled');
															form
																	.find(
																			'input[type=file]')
																	.ace_file_input(
																			'enable');
															form
																	.find(
																			'.modal-body > :last-child')
																	.remove();

															modal.modal("hide");

															var thumb = file
																	.next()
																	.find('img')
																	.data(
																			'thumb');
															if (thumb)
																$('#avatar2')
																		.get(0).src = thumb;

															working = false;
														});

												setTimeout(
														function() {
															deferred.resolve();
														},
														parseInt(Math.random() * 800 + 800));

												return false;
											});

						});

		//////////////////////////////
		$('#profile-feed-1').ace_scroll({
			height : '250px',
			mouseWheelLock : true,
			alwaysVisible : true
		});

		$('a[ data-original-title]').tooltip();

		$('.easy-pie-chart.percentage').each(function() {
			var barColor = $(this).data('color') || '#555';
			var trackColor = '#E2E2E2';
			var size = parseInt($(this).data('size')) || 72;
			$(this).easyPieChart({
				barColor : barColor,
				trackColor : trackColor,
				scaleColor : false,
				lineCap : 'butt',
				lineWidth : parseInt(size / 10),
				animate : false,
				size : size
			}).css('color', barColor);
		});

		///////////////////////////////////////////

		//right & left position
		//show the user info on right or left depending on its position
		$('#user-profile-2 .memberdiv').on('mouseenter touchstart', function() {
			var $this = $(this);
			var $parent = $this.closest('.tab-pane');

			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $this.offset();
			var w2 = $this.width();

			var place = 'left';
			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				place = 'right';

			$this.find('.popover').removeClass('right left').addClass(place);
		}).on('click', function(e) {
			e.preventDefault();
		});

		///////////////////////////////////////////
		$('#user-profile-3').find('input[type=file]').ace_file_input({
			style : 'well',
			btn_choose : 'Change avatar',
			btn_change : null,
			no_icon : 'ace-icon fa fa-picture-o',
			thumbnail : 'large',
			droppable : true,

			allowExt : [ 'jpg', 'jpeg', 'png', 'gif' ],
			allowMime : [ 'image/jpg', 'image/jpeg', 'image/png', 'image/gif' ]
		}).end().find('button[type=reset]').on(
				ace.click_event,
				function() {
					$('#user-profile-3 input[type=file]').ace_file_input(
							'reset_input');
				}).end().find('.date-picker').datepicker().next().on(
				ace.click_event, function() {
					$(this).prev().focus();
				})
		$('.input-mask-phone').mask('(999) 999-9999');

		$('#user-profile-3').find('input[type=file]').ace_file_input(
				'show_file_list', [ {
					type : 'image',
					name : $('#avatar').attr('src')
				} ]);

		////////////////////
		//change profile
		$('[data-toggle="buttons"] .btn').on('click', function(e) {
			var target = $(this).find('input[type=radio]');
			var which = parseInt(target.val());
			$('.user-profile').parent().addClass('hide');
			$('#user-profile-' + which).parent().removeClass('hide');
		});

		/////////////////////////////////////
		$(document).one('ajaxloadstart.page', function(e) {
			//in ajax mode, remove remaining elements before leaving page
			try {
				$('.editable').editable('destroy');
			} catch (e) {
			}
			$('[class*=select2]').remove();
		});
	});
</script>

<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='assets/js/jquery.min.js'>"
					+ "<"+"/script>");
</script>
<script type="text/javascript">
	if ('ontouchstart' in document.documentElement)
		document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
				+ "<"+"/script>");
</script>

<!-- page specific plugin scripts -->
<script src="resources/assets/js/jquery.dataTables.min.js"></script>
<script src="resources/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="resources/assets/js/dataTables.tableTools.min.js"></script>
<script src="resources/assets/js/dataTables.colVis.min.js"></script>

<!-- ace scripts -->
<script src="resources/assets/js/ace-elements.min.js"></script>
<script src="resources/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
	jQuery(function($) {
		//initiate dataTables plugin
		var oTable1 = $('#dynamic-table').wrap(
				"<div class='dataTables_borderWrap' />") //if you are applying horizontal scrolling (sScrollX)
		.dataTable({
			"order": [[ 0, "desc" ]],
				//,
			//"sScrollY": "200px",
			//"bPaginate": false,

			//"sScrollX": "100%",
			//"sScrollXInner": "120%",
			//"bScrollCollapse": true,
			//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
			//you may want to wrap the table inside a "div.dataTables_borderWrap" element

			"iDisplayLength" : 50
		});
		oTable1.fnAdjustColumnSizing();

		//TableTools settings
		TableTools.classes.container = "btn-group btn-overlap";
		TableTools.classes.print = {
			"body" : "DTTT_Print",
			"info" : "tableTools-alert gritter-item-wrapper gritter-info gritter-center white",
			"message" : "tableTools-print-navbar"
		}

		//initiate TableTools extension
		var tableTools_obj = new $.fn.dataTable.TableTools(
				oTable1,
				{
					"sSwfPath" : "resources/assets/swf/copy_csv_xls_pdf.swf",

					"sRowSelector" : "td:not(:last-child)",
					"sRowSelect" : "multi",
					"fnRowSelected" : function(row) {
						//check checkbox when row is selected
						try {
							$(row).find('input[type=checkbox]').get(0).checked = true
						} catch (e) {
						}
					},
					"fnRowDeselected" : function(row) {
						//uncheck checkbox
						try {
							$(row).find('input[type=checkbox]').get(0).checked = false
						} catch (e) {
						}
					},

					"sSelectedClass" : "success",
					"aButtons" : [
							{
								"sExtends" : "copy",
								"sToolTip" : "Copy to clipboard",
								"sButtonClass" : "btn btn-white btn-primary btn-bold",
								"sButtonText" : "<i class='fa fa-copy bigger-110 pink'></i>",
								"fnComplete" : function() {
									this
											.fnInfo(
													'<h3 class="no-margin-top smaller">Table copied</h3>\
									<p>Copied '
															+ (oTable1
																	.fnSettings()
																	.fnRecordsTotal())
															+ ' row(s) to the clipboard.</p>',
													1500);
								}
							},

							{
								"sExtends" : "csv",
								"sToolTip" : "Export to CSV",
								"sButtonClass" : "btn btn-white btn-primary  btn-bold",
								"sButtonText" : "<i class='fa fa-file-excel-o bigger-110 green'></i>"
							},

							{
								"sExtends" : "pdf",
								"sToolTip" : "Export to PDF",
								"sButtonClass" : "btn btn-white btn-primary  btn-bold",
								"sButtonText" : "<i class='fa fa-file-pdf-o bigger-110 red'></i>"
							},

							{
								"sExtends" : "print",
								"sToolTip" : "Print view",
								"sButtonClass" : "btn btn-white btn-primary  btn-bold",
								"sButtonText" : "<i class='fa fa-print bigger-110 grey'></i>",

								"sMessage" : "<div class='navbar navbar-default'><div class='navbar-header pull-left'><a class='navbar-brand' href='#'><small>Optional Navbar &amp; Text</small></a></div></div>",

								"sInfo" : "<h3 class='no-margin-top'>Print view</h3>\
									  <p>Please use your browser's print function to\
									  print this table.\
									  <br />Press <b>escape</b> when finished.</p>",
							} ]
				});
		//we put a container before our table and append TableTools element to it
		$(tableTools_obj.fnContainer()).appendTo($('.tableTools-container'));

		//also add tooltips to table tools buttons
		//addding tooltips directly to "A" buttons results in buttons disappearing (weired! don't know why!)
		//so we add tooltips to the "DIV" child after it becomes inserted
		//flash objects inside table tools buttons are inserted with some delay (100ms) (for some reason)
		setTimeout(function() {
			$(tableTools_obj.fnContainer()).find('a.DTTT_button').each(
					function() {
						var div = $(this).find('> div');
						if (div.length > 0)
							div.tooltip({
								container : 'body'
							});
						else
							$(this).tooltip({
								container : 'body'
							});
					});
		}, 200);

		//ColVis extension
		var colvis = new $.fn.dataTable.ColVis(oTable1, {
			"buttonText" : "<i class='fa fa-search'></i>",
			"aiExclude" : [ 0, 50 ],
			"bShowAll" : true,
			//"bRestore": true,
			"sAlign" : "right",
			"fnLabel" : function(i, title, th) {
				return $(th).text();//remove icons, etc
			}

		});

		//style it
		$(colvis.button()).addClass('btn-group').find('button').addClass(
				'btn btn-white btn-info btn-bold')

		//and append it to our table tools btn-group, also add tooltip
		$(colvis.button()).prependTo('.tableTools-container .btn-group').attr(
				'title', 'Show/hide columns').tooltip({
			container : 'body'
		});

		//and make the list, buttons and checkboxed Ace-like
		$(colvis.dom.collection)
				.addClass(
						'dropdown-menu dropdown-light dropdown-caret dropdown-caret-right')
				.find('li').wrapInner('<a href="javascript:void(0)" />') //'A' tag is required for better styling
				.find('input[type=checkbox]').addClass('ace').next().addClass(
						'lbl padding-8');

		/////////////////////////////////
		//table checkboxes
		$('th input[type=checkbox], td input[type=checkbox]').prop('checked',
				false);

		//select/deselect all rows according to table header checkbox
		$('#dynamic-table > thead > tr > th input[type=checkbox]').eq(0).on(
				'click',
				function() {
					var th_checked = this.checked;//checkbox inside "TH" table header

					$(this).closest('table').find('tbody > tr').each(
							function() {
								var row = this;
								if (th_checked)
									tableTools_obj.fnSelect(row);
								else
									tableTools_obj.fnDeselect(row);
							});
				});

		//select/deselect a row when the checkbox is checked/unchecked
		$('#dynamic-table').on('click', 'td input[type=checkbox]', function() {
			var row = $(this).closest('tr').get(0);
			if (!this.checked)
				tableTools_obj.fnSelect(row);
			else
				tableTools_obj.fnDeselect($(this).closest('tr').get(0));
		});

		$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
			e.stopImmediatePropagation();
			e.stopPropagation();
			e.preventDefault();
		});

		//And for the first simple table, which doesn't have TableTools or dataTables
		//select/deselect all rows according to table header checkbox
		var active_class = 'active';
		$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on(
				'click',
				function() {
					var th_checked = this.checked;//checkbox inside "TH" table header

					$(this).closest('table').find('tbody > tr').each(
							function() {
								var row = this;
								if (th_checked)
									$(row).addClass(active_class).find(
											'input[type=checkbox]').eq(0).prop(
											'checked', true);
								else
									$(row).removeClass(active_class).find(
											'input[type=checkbox]').eq(0).prop(
											'checked', false);
							});
				});

		//select/deselect a row when the checkbox is checked/unchecked
		$('#simple-table').on('click', 'td input[type=checkbox]', function() {
			var $row = $(this).closest('tr');
			if (this.checked)
				$row.addClass(active_class);
			else
				$row.removeClass(active_class);
		});

		/********************************/
		//add tooltip for small view action buttons in dropdown menu
		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});

		//tooltip placement on right or left
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			//var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}

	})
</script>
</html>