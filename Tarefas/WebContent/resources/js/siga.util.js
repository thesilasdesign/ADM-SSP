(function ($) {
    $.fn.draggable = function (opt) {
        opt = $.extend({
            handle: "",
            cursor: "move"
        }, opt);

        var $selected = this;
        var $elements = (opt.handle === "") ? this : this.find(opt.handle);

        $elements.css('cursor', opt.cursor).on("mousedown", function (e) {
            var pos_y = $selected.offset().top - e.pageY,
                pos_x = $selected.offset().left - e.pageX;

            var maxTop = $selected.closest('.modal').css('zIndex') - 1041;

            $(document).on("mousemove", function (e) {
                var top = e.pageY + pos_y,
                    left = e.pageX + pos_x;

                top = top < (window.pageYOffset + maxTop) ? (window.pageYOffset + maxTop) : top; // Cima
                top = top > (window.innerHeight - 50 + window.pageYOffset) ? (window.innerHeight - 50 + window.pageYOffset) : top; // Baixo
                left = left < (100 - $selected.width()) ? (100 - $selected.width()) : left; //Esquerda
                left = left > window.innerWidth - 100 ? window.innerWidth - 100 : left; //Direita

                $selected.offset({
                    top: top,
                    left: left
                });
            }).on("mouseup", function () {
                $(this).off("mousemove"); // Unbind events from document                
            });
            e.preventDefault(); // disable selection
        });

        return this;
    };

    $.fn.modalResize = function (opt) {
        opt = $.extend({
            handle: "",
            cursor: "se-resize"
        }, opt);

        var $selected = this;
        var $elements = (opt.handle === "") ? this : this.find(opt.handle);

        var modal = $selected.last(),
            modalBody = modal.find(".modal-body");

        var xAbs = parseFloat(modal.css("maxWidth").replace('px', '')),
            yAbs = parseFloat(modalBody.css('height').replace('px', ''));

        $elements.css('cursor', opt.cursor).on("mousedown", function (e) {
            var pos_y = $selected.offset().top - e.pageY,
                pos_x = $selected.offset().left - e.pageX;

            var modal_y = modalBody.height(),
                modal_x = modal.width();

            $(document).on("mousemove", function (e) {
                var height = e.pageY + pos_y;
                var width = e.pageX + pos_x;

                height = yAbs > (modal_y + height) ? yAbs : modal_y + height;
                height = height > window.innerHeight - 165 ? window.innerHeight - 165 : height;

                width = xAbs > (modal_x + width) ? xAbs : modal_x + width;
                width = width > window.innerWidth - 20 ? window.innerWidth - 20 : width;

                modal.css("maxWidth", width + 'px');
                modalBody.css("height", height + 'px');

            }).on("mouseup", function () {
                $(this).off("mousemove"); // Unbind events from document                
            });
            e.preventDefault(); // disable selection
        });

        return this;
    };

    $.fn.selectableColumns = function () {
        var table = $(this);

        table.find('tbody tr').click(function () {
            $(this).parent().children().removeClass('active');
            $(this).addClass('active');
        });

        $(window).off('keydown');
        $(window).keydown(function (e) {
            var active = table.find("tbody tr.active");

            function changePage(newActive, str, elem) {
                if (newActive.length != 0) {
                    active.removeClass("active");
                    newActive.addClass("active");

                    if (str == 'prev') {
                        var cima = window.pageYOffset,
                            baixo = newActive.offset().top;
                        if (baixo < cima) {
                            $("html, body").animate({ scrollTop: baixo - 5 + "px" }, 30);
                        }
                    } else {
                        var cima = window.pageYOffset + window.innerHeight,
                            baixo = newActive.offset().top + newActive.height()

                        if (baixo > cima) {
                            $("html, body").animate({ scrollTop: baixo - window.innerHeight + 5 + "px" }, 30);
                        }
                    }
                } else if (active.length == 0) {
                    table.find("tbody tr:" + elem).click();
                } else if (table.next().find(".dataTables_paginate ." + str + ".disabled a").length == 0) {
                    active.removeClass("active");
                    table.next().find(".dataTables_paginate ." + str + " a").click();
                }
            }
            if ($(".modal[id!='modal-competencia'][id!='modal-filtro']").length == 0) {
                switch (e.keyCode) {
                    case 38: //Cima
                        changePage(active.prev("tr"), 'prev', 'last');
                        return false;
                        break;
                    case 40: //Baixo
                        changePage(active.next("tr"), 'next', 'first');
                        return false;
                        break;
                };
            }
        });

        return this;
    };
}(jQuery));

Siga.UTIL = function () {
    return {
        ValidaData: function (e) {
            if ($(e).val() != "") {
                var validaDataFutura = false;
                if ($(e).data("futura") == "N") {
                    validaDataFutura = true;
                }

                var validaConsistencia = false;
                if ($(e).data("consistencia") == "S") {
                    validaConsistencia = true;
                }

                var validaCompetencia = false;
                if ($(e).data("competencia") == "S") {
                    validaCompetencia = true;
                }

                var validaFechamento = true;
                if ($(e).data("fechamento") == "N") {
                    validaCompetencia = false;
                }

                var validaCompetenciaAtual = false;
                if ($(e).data("competenciaatual") == "S") {
                    validaCompetenciaAtual = true;
                }

                var validaDocumentoFiscalEmissao = false;
                var serie = "";
                if ($(e).data("documentofiscalemissao") == "S" && $(e).data("serie") != "") {
                    validaDocumentoFiscalEmissao = true;
                    serie = $(e).data("serie");
                }

                var dataDocumentoOriginal = "";
                var labelDocumentoOriginal = "";
                if ($(e).data("datadocumentooriginal") != null && $(e).data("datadocumentooriginal") != "") {
                    dataDocumentoOriginal = $(e).data("datadocumentooriginal");
                    labelDocumentoOriginal = $(e).data("labeldocumentooriginal");
                }

                var dto = {};
                dto.data = $(e).val();
                dto.validaDataFutura = validaDataFutura;
                dto.validaCompetencia = validaCompetencia;
                dto.validaFechamento = validaFechamento;
                dto.validaConsistencia = validaConsistencia;
                dto.validaCompetenciaAtual = validaCompetenciaAtual;
                dto.validaDocumentoFiscalEmissao = validaDocumentoFiscalEmissao;
                dto.serie = serie;
                dto.dataDocumentoOriginal = dataDocumentoOriginal;
                dto.labelDocumentoOriginal = labelDocumentoOriginal

                Siga.UTIL.Ajax(
                    "../UTIL/UtilWS.asmx/ValidaData",
                    dto,
                    function (d) {
                        $(e).val(d.Texto);
                    },
                    function (d) {
                        try {
                            var json = $.parseJSON(d.Message);

                            if (json.DataForaCompetencia) {
                                Siga.UTIL.Confirmacao(
                                    json.Message,
                                    function () {
                                        setTimeout(function () {
                                            $(e).focus();
                                        }, 0);
                                        return;
                                    },
                                    function () {
                                        setTimeout(function () {
                                            $(e).val("");
                                            $(e).focus();
                                        }, 0);
                                    }
                                );
                            }
                        }
                        catch (err) {
                            Siga.UTIL.Mensagem("alerta", d.Message, function () {
                                setTimeout(function () {
                                    $(e).val("");
                                    $(e).focus();
                                }, 0);
                            });
                        }
                    }
                );
            }
        },

        Mensagem: function (tipo, mensagem, callback) {
            var titulo = (Siga.Mensagem != null ? (tipo == "erro" ? Siga.Mensagem.SIS0083 : (tipo == "alerta" ? Siga.Mensagem.SIS0084 : Siga.Mensagem.SIS0085)) : "Atenção");
            var cor = (tipo == "erro" ? "red" : (tipo == "alerta" ? "orange" : "blue"));
            var icone = (tipo == "erro" ? "remove-sign" : (tipo == "alerta" ? "warning-sign" : "info-sign"));

            var corpo = (
                "<div class='row-fluid'>" +
                "    <div class='span2 center' style='vertical-align: middle'><i class='icon-" + icone + " " + cor + " bigger-300'></i></div>" +
                "    <div class='span10'>" + /*$("<div />").html(mensagem).text()*/ mensagem + "</div>" +
                "</div>"
            );

            Siga.UTIL.EscondePopupComponentes();

            bootbox.dialog(corpo, [{
                "label": Siga.Mensagem != null ? Siga.Mensagem.Ok : "OK",
                "class": "btn btn-small btn-primary no-border",
                "callback": callback
            }], {
                "header": titulo,
                "onEscape": callback,
                "animate": false
            });
        },

        Confirmacao: function (mensagem, callbackSim, callbackNao, callbackSempre) {
            var titulo = Siga.Mensagem.Confirmacao;
            var cor = "blue";
            var icone = "question-sign";

            var corpo = (
                "<div class='row-fluid'>" +
                "    <div class='span2 center' style='vertical-align: middle'><i class='icon-" + icone + " " + cor + " bigger-300'></i></div>" +
                "    <div class='span10'>" + /*$("<div />").html(mensagem).text()*/ mensagem + "</div>" +
                "</div>"
            );

            Siga.UTIL.EscondePopupComponentes();

            bootbox.dialog(
                corpo,
                [
                    {
                        "label": Siga.Mensagem.Sim,
                        "class": "btn btn-small btn-primary no-border",
                        "callback": callbackSim
                    },
                    {
                        "label": Siga.Mensagem.Nao,
                        "class": "btn btn-small no-border",
                        "callback": callbackNao
                    }
                ],
                {
                    "header": titulo,
                    "onEscape": callbackNao,
                    "animate": false
                }
            );

            if (jQuery.isFunction(callbackSempre)) {
                callbackSempre();
            }
        },

        EscondePopupComponentes: function () {
            if ($.fn.datepicker) {
                $("input.datepicker").datepicker('hide');
                $("input.modal-datepicker").datepicker('hide');
            }

            if ($.fn.select2) {
                $("div.select2-dropdown-open").each(function (e) {
                    var id = $(this).attr("id").replace("s2id_", "");
                    $("#" + id).select2("close");
                });
            }
        },

        Ajax: function (url, dto, callbackSuccess, callbackError, parseJson) {
            $.ajax({
                type: "POST",
                url: url,
                data: (dto) ? JSON.stringify(dto) : "{}",
                contentType: "application/json; charset=iso-8859-1",
                dataType: "json",
                cache: false,
                success: function (response) {
                    var data = response.d;

                    if (parseJson) {
                        data = JSON.parse(data);
                    }
                    else {
                        if ((typeof response.d) == 'string') {
                            data = eval('(' + response.d + ')');
                        }
                    }

                    if (jQuery.isFunction(callbackSuccess)) {
                        callbackSuccess(data);
                    }
                },
                error: function (xhr, status, error) {
                    var data = eval("(" + xhr.responseText + ")");

                    if (data.Message.indexOf("?logoff=") > -1) {
                        window.location = '../index.aspx' + data.Message;
                    }
                    else if (jQuery.isFunction(callbackError)) {
                        callbackError(data);
                    }
                    else {
                        Siga.UTIL.Mensagem("alerta", data.Message);
                    }
                }
            });
        },

        AjaxFormSubmit: function (form, callbackSuccess, callbackError) {
            var jqForm = $(form);
            var jqUrl = jqForm.attr("action");

            var jqData = new FormData(form);
            jqData.append("__jqSubmit__", "S");

            $.ajax({
                url: jqUrl,
                type: 'POST',
                data: jqData,
                mimeType: "multipart/form-data",
                contentType: false,
                cache: false,
                processData: false,
                success: function (response) {
                    var data = response;

                    try {
                        if (typeof (response) == 'string' && response != null && response != "") {
                            data = eval("(" + response + ")");
                        }
                    } catch (e) { }

                    if (jQuery.isFunction(callbackSuccess)) {
                        callbackSuccess(data);
                    }
                },
                error: function (xhr, status, error) {

                    var data = eval("(" + xhr.responseText + ")");

                    if (jQuery.isFunction(callbackError)) {
                        callbackError(data);
                    }
                    else {
                        try {
                            Siga.UTIL.Mensagem("alerta", data.Message);
                        } catch (e) {
                            Siga.UTIL.Mensagem("alerta", e);
                        }
                    }
                }
            });
        },

        ValidaPeriodo: function (f_data1, f_data2, l_data1, l_data2, callback, callbackError) {
            var dto = {};
            dto.f_data1 = f_data1;
            dto.f_data2 = f_data2;
            dto.l_data1 = l_data1;
            dto.l_data2 = l_data2;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/ValidaPeriodo", dto, callback, callbackError);
        },

        ValidaDataMaior: function (f_data1, f_data2, l_data1, l_data2, callback) {
            var dto = {};
            dto.f_data1 = f_data1;
            dto.f_data2 = f_data2;
            dto.l_data1 = l_data1;
            dto.l_data2 = l_data2;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/ValidaDataMaior", dto, callback);
        },

        ValidaDataMaiorOuIgual: function (f_data1, f_data2, l_data1, l_data2, callback, callbackError) {
            var dto = {};
            dto.f_data1 = f_data1;
            dto.f_data2 = f_data2;
            dto.l_data1 = l_data1;
            dto.l_data2 = l_data2;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/ValidaDataMaiorOuIgual", dto, callback, callbackError);
        },

        ValidaDataMenorOuIgual: function (f_data1, f_data2, l_data1, l_data2, callback, callbackError) {
            var dto = {};
            dto.f_data1 = f_data1;
            dto.f_data2 = f_data2;
            dto.l_data1 = l_data1;
            dto.l_data2 = l_data2;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/ValidaDataMenorOuIgual", dto, callback, callbackError);
        },

        ValidaHora: function (hora1, hora2, callback) {
            var dto = {};
            dto.f_hora1 = hora1;
            dto.f_hora2 = hora2;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/ValidaHora", dto, callback);
        },

        ValidaEmail: function (email, limiteQuantidade, callback, callbackError) {
            var dto = {};
            dto.email = email;
            dto.limiteQuantidade = limiteQuantidade;

            Siga.UTIL.Ajax("../util/UtilWS.asmx/ValidaEmail", dto, callback, callbackError);
        },

        CalculaTempoDatas: function (data1, data2, callback) {
            var dto = {};
            dto.f_data1 = data1;
            dto.f_data2 = data2;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/CalculaTempoDatas", dto, callback);
        },

        CalculaData: function (ano, mes, dia, dataOriginal, callback) {
            var dto = {};
            dto.ano = ano;
            dto.mes = mes;
            dto.dia = dia;
            dto.dataOriginal = dataOriginal;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/CalculaData", dto, callback);
        },

        GeraDigitoModulo11: function (numero, callback) {
            var dto = {};
            dto.numero = numero;

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/GeraDigitoModulo11", dto, callback);
        },

        ConfirmarUltimoRegistro: function (campos, callbackIncluir, callbackDescartar, callbackCancelar) {
            var dto = {};
            dto.registro = campos.registro;
            dto.numeroRegistros = campos.numeroRegistros;

            var returnIncluir = false;
            var returnDescartar = false;
            var returnCancelar = false;

            Siga.UTIL.ShowModal("../SIS/SIS99913.aspx?registro=" + dto.registro + "&numero_registros=" + dto.numeroRegistros, function (ret, data) {
                if (ret == true) {
                    if (data.retorno == "incluir") {
                        if (jQuery.isFunction(callbackIncluir)) {
                            callbackIncluir();
                        }
                    } else if (data.retorno == "descartar") {
                        if (jQuery.isFunction(callbackDescartar)) {
                            callbackDescartar();
                        }
                    }
                } else {
                    if (jQuery.isFunction(callbackCancelar)) {
                        callbackCancelar();
                    }
                }
            }, null, "modal-medium");
        },

        ShowModal: function (url, callback, id, modalType) {
            var d = document.createElement("div");

            var modalClass = "modal-small";
            if (modalType != null) {
                modalClass = modalType;
            }

            if (id != null) {
                d.setAttribute("id", id);
            }

            Siga.ModalDinamicoCount++;

            $('body').css('overflow-y', 'hidden');
            $('body').css('width', '100%');

            $(d).load(url, function (e) {
                /* Resolver barra de rolagem */
                var win = $(d).modal({
                    show: true,
                    keyboard: false,
                    backdrop: 'static'
                });

                $(d).data("modalObject", win);

                var $modal = $(d).find(".modal").draggable({ handle: ".modal-header" });
                $modal.addClass(modalClass).css({
                    'left': ($(window).width() / 2) - ($modal.width() / 2),
                    'z-index': (1042 + (Siga.ModalDinamicoCount * 10)),
                    'top': 'calc(5% + ' + (Siga.ModalDinamicoCount - 1) * 10 + 'px)'
                });

                $(".modal-backdrop").addClass("modal-backdrop-" + Siga.ModalDinamicoCount + "x");

                // Código do programa
                var modalFooter = $(d).find(".modal-footer");
                if (modalFooter) {

                    var arrayUrl = url.split('/');
                    var programa = arrayUrl[arrayUrl.length - 1].split('?')[0].replaceAll('.aspx', '');

                    if (Siga.Permissoes.Ajuda && programa != "SIS99908" && programa != "SIS00506") {
                        modalFooter.append('<a class="btn btn-link hidden-phone" onclick="Siga.UTIL.ConfigurarAjuda(\'' + programa + '\')" style="margin-right: 12px; float: left; padding: 0px !important; text-decoration: none"><i class="icon-question-sign bigger-160"></i></button>');
                    }
                    if (Siga.Permissoes.Traducao) {
                        modalFooter.append('<a class="btn btn-link hidden-phone" onclick="Siga.UTIL.Traducao(\'' + programa + '\')" style="margin-right: 12px; float: left; padding: 0px !important; text-decoration: none"><i class="icon-globe bigger-160"></i></a>');
                    }

                    modalFooter.append('<div class="resizer right" style="position: absolute;margin-left: calc(100% - 40px); height: 15px; width: 25px;"></div>')
                    modalFooter.append('<span class="hidden-phone" style="padding-top: 4px; float: left">' + programa + '</span>');
                }

                win.on('hidden', function (event) {

                    if ($(event.target.children).hasClass("modal")) {
                        $(".modal-backdrop").removeClass("modal-backdrop-" + Siga.ModalDinamicoCount + "x");
                        Siga.ModalDinamicoCount--;
                        // Se não tiver mais modais visíveis, retorna barra de rolagem  
                        if ($(".modal:visible").length < 1) {
                            $('body').css('overflow-y', 'auto');
                            $('body').css('width', '100%');
                        }

                        var ret = win.data('returnValue');
                        var obj = null;

                        if (ret == true) {
                            obj = win.data('returnObject');
                        }

                        $(d).remove();

                        if (jQuery.isFunction(callback)) {
                            callback(ret, obj);
                        }
                    }
                });

                $.unblockUI();
            });
        },

        ReloadModal: function (url, oModal, modalClass) {
            $.blockUI();

            $(oModal).load(url, function (e) {
                $(oModal).find(".modal").addClass(modalClass);
                var $modal = $(oModal).find(".modal");
                $modal.css({
                    'zIndex': '1055',
                    'left': ($(window).width() / 2) - ($modal.width() / 2)/*,
                    'top': ($(window).height() / 2) - ($modal.height() / 2)*/
                });

                // Código do programa
                var modalFooter = $(oModal).find(".modal-footer");
                if (modalFooter) {
                    var arrayUrl = url.split('/');
                    var programa = arrayUrl[arrayUrl.length - 1].split('?')[0].replaceAll('.aspx', '');

                    if (Siga.Permissoes.Ajuda && programa != "SIS99908" && programa != "SIS00506") {
                        modalFooter.append('<a class="btn btn-link hidden-phone" onclick="Siga.UTIL.ConfigurarAjuda(\'' + programa + '\')" style="margin-right: 12px; float: left; padding: 0px !important; text-decoration: none"><i class="icon-question-sign bigger-160"></i></button>');
                    }
                    if (Siga.Permissoes.Traducao) {
                        modalFooter.append('<a class="btn btn-link hidden-phone" onclick="Siga.UTIL.Traducao(\'' + programa + '\')" style="margin-right: 12px; float: left; padding: 0px !important; text-decoration: none"><i class="icon-globe bigger-160"></i></a>');
                    }

                    modalFooter.append('<div class="resizer right" style="position: absolute;margin-left: calc(100% - 40px); height: 15px; width: 25px;"></span></div>')
                    modalFooter.append('<span class="hidden-phone" style="padding-top: 4px; float: left">' + programa + '</span>');
                }

                $.unblockUI();
            });
        },

        CloseModal: function (target, returnValue, returnObject, noRemove) {
            var jqDynamic = ($(target).closest(".modal").attr("id") == "modal-filtro");
            $(target).class
            if (jqDynamic) {
                $(target).closest(".modal").modal("hide");
            }
            else {
                var win = $(target).closest(".modal").parent().data("modalObject");
                win.data("returnValue", returnValue);
                win.data("returnObject", returnObject);
                win.data("noRemove", noRemove ? true : false);
                win.modal("hide");
            }

            if ($(".modal:visible").length == 1) {
                $('body').css('position', 'initial');
                $('body').css('overflow-y', 'auto');
                $('body').css('width', '100%');
            }
        },

        Redirect: function (url) {
            $.blockUI();

            setTimeout(function () { window.location = url; }, 100);
        },

        ExecuteReport: function (form, callback) {
            if ($(form).find("#f_saidapara").val() != null) {
                var saidapara = $(form).find("#f_saidapara").val().toLowerCase();
                var download = $(form).find("#f_download").val();
                if (saidapara != "pdf" || download == "download") {
                    form.target = "f_downloadarquivo";
                    form.submit();

                    return;
                }
            }

            // Imprimir pdf
            $(form).attr("method", "get");

            var maxWidth = 1024;
            var maxHeight = 580;

            var winWidth = $(window).width();
            var winHeight = $(window).height();

            var reportWidth = winWidth >= maxWidth ? maxWidth : winWidth;
            var reportHeight = winHeight >= maxHeight ? maxHeight : winHeight;
            var reportLeft = Siga.Int32.TryParse((winWidth - reportWidth) / 2);
            var reportTop = Siga.Int32.TryParse((winHeight - reportHeight) / 2);

            var reportWindow = window.open("", "Siga_Report_Window", "left=" + reportLeft + "px, top=" + reportTop + "px, width=" + reportWidth + "px, height=" + reportHeight + "px", true);

            if ((typeof reportWindow) === 'undefined') {
                $.unblockUI();

                Siga.UTIL.Mensagem("info", Siga.Mensagem.SIS0090, function () {
                    return;
                });
            }

            if (navigator.appVersion.indexOf("Windows Phone") > 0) {
                form.target = reportWindow;
            } else {
                form.target = "Siga_Report_Window";
            }
            form.submit();

            if (jQuery.isFunction(callback)) {
                callback();
            }

            reportWindow.focus();
        },

        ExecuteReportDinamico: function (form, action, position) {
            if ($(form).find("#f_saidapara").val() != null) {
                var saidapara = $(form).find("#f_saidapara").val().toLowerCase();
                var download = $(form).find("#f_download").val();
                if (saidapara != "pdf" || download == "download") {
                    form.target = "f_downloadarquivo";
                    form.submit();

                    return;
                }
            }

            // Imprimir pdf
            $(form).attr("method", "get");
            $(form).attr("action", action);

            var maxWidth = 1024;
            var maxHeight = 580;

            var winWidth = $(window).width();
            var winHeight = $(window).height();

            var reportWidth = winWidth >= maxWidth ? maxWidth : winWidth;
            var reportHeight = winHeight >= maxHeight ? maxHeight : winHeight;
            var reportLeft = Siga.Int32.TryParse((winWidth - reportWidth - position) / 2);
            var reportTop = Siga.Int32.TryParse((winHeight - reportHeight - position) / 2);

            var id = "Siga_Sinamico_" + (new Date().getTime()).toString();

            var reportWindow = window.open("", id, "left=" + reportLeft + "px, top=" + reportTop + "px, width=" + reportWidth + "px, height=" + reportHeight + "px", true);

            if ((typeof reportWindow) === 'undefined') {
                $.unblockUI();

                Siga.UTIL.Mensagem("info", Siga.Mensagem.SIS0090, function () {
                    return;
                });
            }

            form.target = id;
            form.submit();

            reportWindow.focus();
        },

        Popup: function (url) {
            var maxWidth = 1024;
            var maxHeight = 580;

            var winWidth = $(window).width();
            var winHeight = $(window).height();

            var reportWidth = winWidth >= maxWidth ? maxWidth : winWidth;
            var reportHeight = winHeight >= maxHeight ? maxHeight : winHeight;
            var reportLeft = Siga.Int32.TryParse((winWidth - reportWidth) / 2);
            var reportTop = Siga.Int32.TryParse((winHeight - reportHeight) / 2);

            var reportWindow = window.open(url, "Siga_Popup", "left=" + reportLeft + "px, top=" + reportTop + "px, width=" + reportWidth + "px, height=" + reportHeight + "px", true);

            if ((typeof reportWindow) === 'undefined') {
                Siga.UTIL.Mensagem("info", Siga.Mensagem.SIS0090, function () {
                    return;
                });
            }

            reportWindow.focus();
        },

        ConfigurarAjuda: function (sender) {
            Siga.UTIL.ShowModal("../SIS/SIS00506.aspx?codigo=" + sender, null, null, "modal-large");
        },

        Traducao: function (sender) {
            Siga.UTIL.ShowModal("../SIS/SIS00508.aspx?codigo=" + sender, null, null, "modal-large");
        },

        ConfiguraMenu: function (mini, callback) {
            var dto = {};
            dto.mini = (mini == true);

            Siga.UTIL.Ajax("../UTIL/UtilWS.asmx/ConfiguraMenu", dto, callback);
        },

        SelectRequired: function (jqRef) {
            if (jqRef.attr("required") != null && !jqRef.hasClass("selectOff")) {
                var id = jqRef.attr("id");

                if ($("#" + id + " option[value!=''][disabled!=''][disabled!='disabled']").length == 1) {
                    jqRef.val($("#" + id + " option[value!=''][disabled!=''][disabled!='disabled']:last").val());
                    jqRef.select2("val", $("#" + id + " option[value!=''][disabled!=''][disabled!='disabled']:last").val());
                }
            }
        },

        SalvarSearch: function (codigoPrograma, sSearch) {
            var dto = {};
            dto.codigoPrograma = codigoPrograma;
            dto.sSearch = sSearch;

            Siga.UTIL.Ajax("../SIS/ProgramaFiltroWS.asmx/SalvarSearch", dto);
        },

        FormatarDecimal: function (valor, callback) {
            var dto = {};
            dto.valor = valor;

            Siga.UTIL.Ajax("../util/UtilWS.asmx/FormatarDecimal", dto, callback);
        }
    }
}();