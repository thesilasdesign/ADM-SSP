Siga.REL = {};

Siga.REL.CargoMinisterioFuncao = function () {
    var servico = "../REL/CargoMinisterioFuncaoWS.asmx";

    return {
        Selecionar: function (indicadorMusico, codigoTipoEstabelecimento, callback) {
            var dto = {};
            dto.indicadorMusico = indicadorMusico;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarParaUso: function (sender, indicadorMusico, codigoTipoEstabelecimento, callback) {
            var dto = {};
            dto.sender = sender;
            dto.indicadorMusico = indicadorMusico;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        },

        SelecionarCargosDisponiveis: function (indicadorMusico, codigoTipoEstabelecimento, codigoPessoa, codigoEstabelecimento, callback) {
            var dto = {};
            dto.indicadorMusico = indicadorMusico;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoPessoa = codigoPessoa;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarCargosDisponiveis", dto, callback);
        }

    }
}();

Siga.REL.Departamento = function () {
    var servico = "../REL/DepartamentoWS.asmx";

    return {
        Selecionar: function (callback) {
            Siga.UTIL.Ajax(servico + "/Selecionar", null, callback);
        },
        SelecionarParaUso: function (sender, callback) {
            var dto = {};
            dto.sender = sender;
            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        }
    }
}();

Siga.REL.Estabelecimento = function () {
    var servico = "../REL/EstabelecimentoWS.asmx";

    return {
        Selecionar: function (codigoTipoEstabelecimento, codigoEstabelecimentoSuperior, codigoEmpresa, indicadorEmpresa, indice, callback, incluirInativas) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimentoSuperior = codigoEstabelecimentoSuperior;
            dto.codigoEmpresa = codigoEmpresa;
            dto.indicadorEmpresa = indicadorEmpresa;
            dto.indice = indice;
            dto.incluirInativas = (incluirInativas == true);

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarParaAcesso: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            Siga.UTIL.Ajax(servico + "/SelecionarParaAcesso", dto, callback);
        },

        SelecionarParaConfiguracaoAcesso: function (codigoTipoEstabelecimento, codigoEstabelecimentoSuperior, codigoEmpresa, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimentoSuperior = codigoEstabelecimentoSuperior;
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarParaConfiguracaoAcesso", dto, callback);
        },

        SelecionarPorSuperior: function (codigoTipoEstabelecimento, listaSuperior, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.listaSuperior = listaSuperior;

            Siga.UTIL.Ajax(servico + "/SelecionarPorSuperior", dto, callback);
        },

        SelecionarPorSuperiorEmpresa: function (codigoTipoEstabelecimento, listaSuperior, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.listaSuperior = listaSuperior;

            Siga.UTIL.Ajax(servico + "/SelecionarPorSuperiorEmpresa", dto, callback);
        },

        SelecionarPorTiposSuperior: function (listaTipoEstabelecimento, listaSuperior, callback) {
            var dto = {};
            dto.listaTipoEstabelecimento = listaTipoEstabelecimento;
            dto.listaSuperior = listaSuperior;

            Siga.UTIL.Ajax(servico + "/SelecionarPorTiposSuperior", dto, callback);
        },

        SelecionarPorEmpresa: function (codigoTipoEstabelecimento, listaEmpresa, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.listaEmpresa = listaEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarPorEmpresa", dto, callback);
        },

        SelecionarPorEstado: function (codigoTipoEstabelecimento, listaEstado, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.listaEstado = listaEstado;

            Siga.UTIL.Ajax(servico + "/SelecionarPorEstado", dto, callback);
        },

        SelecionarRegionalPorEstado: function (listaEstado, callback) {
            var dto = {};
            dto.listaEstado = listaEstado;

            Siga.UTIL.Ajax(servico + "/SelecionarRegionalPorEstado", dto, callback);
        },

        SelecionarPorRegionalParaUsuario: function (codigoRegional, codigoUsuario, callback) {
            var dto = {};
            dto.codigoRegional = codigoRegional;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/SelecionarPorRegionalParaUsuario", dto, callback);
        },
        SelecionarPorAdministracaoParaUsuario: function (codigoAdministracao, codigoUsuario, callback) {
            var dto = {};
            dto.codigoAdministracao = codigoAdministracao;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/SelecionarPorAdministracaoParaUsuario", dto, callback);
        },
        SelecionarParaEstabelecimento: function (codigoTipoEstabelecimento, codigoEstabelecimentoSuperior, codigoEmpresa, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimentoSuperior = codigoEstabelecimentoSuperior;
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarParaEstabelecimento", dto, callback);
        },
        SelecionarPorLista: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarPorLista", dto, callback);
        },
        SelecionarParaUso: function (sender, codigoTipoEstabelecimento, codigoEstabelecimentoSuperior, codigoEmpresa, indicadorEmpresa, indice, callback) {
            var dto = {};
            dto.sender = sender;
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimentoSuperior = codigoEstabelecimentoSuperior;
            dto.codigoEmpresa = codigoEmpresa;
            dto.indicadorEmpresa = indicadorEmpresa;
            dto.indice = indice;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        },

        SelecionarConformePermissaoUsuario: function (codigoEmpresa, codigoTipoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarConformePermissaoUsuario", dto, callback);
        },

        SelecionarPorCodigoRelatorio: function (codigoRelatorio, callback) {
            var dto = {};
            dto.codigoRelatorio = codigoRelatorio;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigoRelatorio", dto, callback);
        },

        ValidaCodigoRelatorio: function (codigoRelatorio, codigoCasaOracao, callback) {
            var dto = {};
            dto.codigoRelatorio = codigoRelatorio;
            dto.codigoCasaOracao = codigoCasaOracao;

            Siga.UTIL.Ajax(servico + "/ValidaCodigoRelatorio", dto, callback);
        },

        SelecionarTipoEstabelecimento: function (listaTipoEstabelecimento, validaAcesso, callback) {
            var dto = {};
            dto.listaTipoEstabelecimento = listaTipoEstabelecimento;
            dto.validaAcesso = validaAcesso;

            Siga.UTIL.Ajax(servico + "/SelecionarTipoEstabelecimento", dto, callback);
        },

        SelectBoxCasaOracao: function (codigoEstabelecimentoSuperior, codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEstabelecimentoSuperior = codigoEstabelecimentoSuperior;
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelectBoxCasaOracao", dto, callback);
        },

        SelecionarCidade: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarCidade", dto, callback);
        },

        SelecionarSuperiorPiedade: function (codigoTipoEstabelecimento, codigoEstabelecimentoSuperior, codigoEmpresa, indicadorEmpresa, indice, codigoEstabelecimentoSuperiorPiedade, callback) {
            var dto = {};
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimentoSuperior = codigoEstabelecimentoSuperior;
            dto.codigoEmpresa = codigoEmpresa;
            dto.indicadorEmpresa = indicadorEmpresa;
            dto.indice = indice;
            dto.codigoEstabelecimentoSuperiorPiedade = codigoEstabelecimentoSuperiorPiedade;

            Siga.UTIL.Ajax(servico + "/SelecionarSuperiorPiedade", dto, callback);
        },

        SelecionarInfinito: function (campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinito",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span10' data-empresa='" + option.detail.CodigoEmpresa + "' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Identacao + option.text +
                            "       </div>" +
                            "       <div class='span2' style='min-height: 24px'><small class='pull-right badge " + classebadge + "'>" + option.detail.NomeEmpresa + "</small></div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarInfinitoComCO: function (campo, indicadorThisEmpresa, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinitoComCO",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.indicadorThisEmpresa = indicadorThisEmpresa;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span10' data-empresa='" + option.detail.CodigoEmpresa + "' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Identacao + option.text +
                            "       </div>" +
                            "       <div class='span2' style='min-height: 24px'><small class='pull-right badge " + classebadge + "'>" + option.detail.NomeEmpresa + "</small></div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarInfinitoCasaOracao: function (campo, indicadorOutraEmpresa, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinitoCasaOracao",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.indicadorOutraEmpresa = indicadorOutraEmpresa;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span12' data-empresa='" + option.detail.CodigoEmpresa + "' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Identacao + option.text +
                            "       </div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarInfinitoChamados: function (campo, campoRegional, codigoPermissao, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinitoChamados",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.indice = campoRegional != null ? $("#" + campoRegional + " option:selected").data("indice") : "";
                    dto.codigoPermissao = codigoPermissao;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span10' data-empresa='" + option.detail.CodigoEmpresa + "' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Identacao + option.text +
                            "       </div>" +
                            "       <div class='span2' style='min-height: 24px'><small class='pull-right badge " + classebadge + "'>" + option.detail.NomeEmpresa + "</small></div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarInfinitoExibindoAdmCo: function (campo, textoSelecione, outroPais) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinitoExibindoAdmCo",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.outroPais = outroPais;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span7' data-empresa='" + option.detail.Codigo + "' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Identacao + option.text +
                            "       </div>" +
                            "       <div class='span3' style='min-height: 24px'>" + option.detail.NomeEmpresa + "</div>" +
                            "       <div class='span2' style='min-height: 24px'>" + option.detail.CodigoRelatorioComum + "</div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarParaContaCorrente: function (campo, codigoConta, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarParaContaCorrente",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.codigoConta = codigoConta;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var casaOracao = option.detail.CasaOracao != null ? option.detail.CasaOracao : "";

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span12' data-empresa='" + option.detail.Codigo + "' style='min-height: 24px'>&nbsp;&nbsp;" + option.text +
                            "       </div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarCodigoPessoa: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarCodigoPessoa", dto, callback);
        },

        SelecionarFilhos: function (tipoEstabelecimento, estabelecimentosSuperiores, callback) {
            var dto = {};
            dto.tipoEstabelecimento = tipoEstabelecimento;
            dto.estabelecimentosSuperiores = estabelecimentosSuperiores;

            Siga.UTIL.Ajax(servico + "/SelecionarFilhos", dto, callback);
        },

        SelecionarPorPaisesParaUso: function (sender, listaTipoEstabelecimento, listaPaises, callback) {
            var dto = {};
            dto.sender = sender;
            dto.listaTipoEstabelecimento = listaTipoEstabelecimento;
            dto.listaPaises = listaPaises;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPaisesParaUso", dto, callback);
        },

        SelecionarPorPaisBI: function (listaTipoEstabelecimento, codigoPais, callback) {
            var dto = {};
            dto.listaTipoEstabelecimento = listaTipoEstabelecimento;
            dto.codigoPais = codigoPais;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPaisBI", dto, callback);
        },

        SelecionarPorPaisParaUso: function (sender, listaTipoEstabelecimento, codigoPais, callback) {
            var dto = {};
            dto.sender = sender;
            dto.listaTipoEstabelecimento = listaTipoEstabelecimento;
            dto.codigoPais = codigoPais;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPaisParaUso", dto, callback);
        },

        SelecionarAdministracaoPorPais: function (codigoPais, ativo, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;
            dto.ativo = ativo;

            Siga.UTIL.Ajax(servico + "/SelecionarAdministracaoPorPais", dto, callback);
        },

        SelecionarLocalTrabalho: function (codigoPais, codigoUsuario, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/SelecionarLocalTrabalho", dto, callback);
        },

        SelecionarPelasCidades: function (codigoCidade, callback) {
            var dto = {};
            dto.codigoCidade = codigoCidade;

            Siga.UTIL.Ajax(servico + "/SelecionarPelasCidades", dto, callback);
        },

        SelecionarTipoLocalidade: function (campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarTipoLocalidade",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var output = (
                        "<div class='row-fluid'>" +
                        "<div class='span12' style='min-height: 10px; padding-left:5px'>" + option.detail.NomeExibicao + "</div>" +
                        "</div>"
                    );

                    return output;
                }
            );
        },

        SelecionarTipoDoEstabelecimento: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarTipoDoEstabelecimento", dto, callback);
        }
    }
}();

Siga.REL.PessoaFisica = function () {
    var servico = "../REL/PessoaFisicaWS.asmx";

    return {
        Selecionar: function (termo, callback) {
            var dto = {};
            dto.termo = termo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarCargo: function (codigoCargo, callback) {
            var dto = {};
            dto.codigoCargo = codigoCargo;

            Siga.UTIL.Ajax(servico + "/SelecionarCargo", dto, callback);
        },

        SelecionarPorDocumento: function (documento, callback) {
            var dto = {};
            dto.documento = documento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorDocumento", dto, callback);
        },

        SelecionarPorCartao: function (cartao, codigoCargo, callback) {
            var dto = {};
            dto.cartao = cartao;
            dto.codigoCargo = codigoCargo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCartao", dto, callback);
        },

        SelecionarElegivel: function (numeroCartaoAcesso, callback) {
            var dto = {};
            dto.numeroCartaoAcesso = numeroCartaoAcesso;

            Siga.UTIL.Ajax(servico + "/SelecionarElegivel", dto, callback);
        },

        PossuiCargo: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/PossuiCargo", dto, callback);
        },

        ValidaCPF: function (cpf, callback) {
            var dto = {};
            dto.cpf = cpf;

            Siga.UTIL.Ajax(servico + "/ValidaCPF", dto, callback);
        },

        ValidaCPFExistente: function (cpf, callback) {
            var dto = {};
            dto.cpf = cpf;

            Siga.UTIL.Ajax(servico + "/ValidaCPFExistente", dto, callback);
        },

        ValidaCNPJ: function (cnpj, callback) {
            var dto = {};
            dto.cnpj = cnpj;

            Siga.UTIL.Ajax(servico + "/ValidaCNPJ", dto, callback);
        },

        ValidaCNPJExistente: function (cnpj, callback) {
            var dto = {};
            dto.cnpj = cnpj;

            Siga.UTIL.Ajax(servico + "/ValidaCNPJExistente", dto, callback);
        },

        SelecionarListaCargo: function (listaCargo, callback) {
            var dto = {};
            dto.listaCargo = listaCargo;

            Siga.UTIL.Ajax(servico + "/SelecionarListaCargo", dto, callback);
        },

        SelecionarListaCargoEmpresa: function (codigoEmpresa, listaCargo, codigoControleAcesso, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.listaCargo = listaCargo;
            dto.codigoControleAcesso = codigoControleAcesso;

            Siga.UTIL.Ajax(servico + "/SelecionarListaCargoEmpresa", dto, callback);
        },

        SelecionarInfinito: function (campo, textoSelecione, listaDiacono, codigoEmpresa, codigoEstabelecimento, codigoPessoa, listaStatusCargo) {
            Siga.Widgets.Select2.SingleAjaxInfinite2(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.listaDiacono = listaDiacono;
                    dto.codigoEmpresa = codigoEmpresa;
                    dto.codigoEstabelecimento = codigoEstabelecimento;
                    dto.codigoPessoa = codigoPessoa;
                    dto.listaStatusCargo = listaStatusCargo;

                    return JSON.stringify(dto);
                }
            );
        },

        SelecionarInfinitoFormatado: function (campo, textoSelecione, listaDiacono, codigoEmpresa, codigoEstabelecimento, codigoPessoa, listaStatusCargo, ativo) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.listaDiacono = listaDiacono;
                    dto.codigoEmpresa = codigoEmpresa;
                    dto.codigoEstabelecimento = codigoEstabelecimento;
                    dto.codigoPessoa = codigoPessoa;
                    dto.listaStatusCargo = listaStatusCargo;
                    dto.ativo = ativo;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span10' style='min-height: 24px'>" +
                        "           <strong>" + option.text + "</strong>" +
                        "       </div>"
                    );

                    if (option.detail.NomeCargo != null) {
                        output +=
                            "       <div class='span2' style='min-height: 20px'>" +
                            "           <small class='pull-right badge " + classebadge + "'>" + option.detail.NomeCargo + "</small>" +
                            "           <small class='pull-left badge badge-inverse'>" + option.detail.NomeAtivo + "</small>" +
                            "       </div>" +
                            "   </div>"
                    } else {
                        output +=
                            "   </div>"
                    }

                    if (option.detail.LocalidadeCargo != null) {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                        "           <small>" + option.detail.NomeEmpresa + " &raquo; " + option.detail.LocalidadeCargo + "</small>" +
                        "       </div>" +
                        "   </div>"
                    } else {
                        output +=
                        "   </div>"
                    }

                    output +=
                        "</div>";

                    return output;
                }
            );
        },

        SelecionarCargoPiedade: function (codigoCargo, callback) {
            var dto = {};
            dto.codigoCargo = codigoCargo;

            Siga.UTIL.Ajax(servico + "/SelecionarCargoPiedade", dto, callback);
        },

        SelecionarVWPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarVWPorCodigo", dto, callback);
        },

        SelecionarParaEstabelecimento: function (callback) {
            Siga.UTIL.Ajax(servico + "/SelecionarParaEstabelecimento", null, callback);
        },

        Inserir: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Inserir", dto, callback);
        },

        Ativar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Ativar", dto, callback);
        },

        Inativar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Inativar", dto, callback);
        }
    }
}();

Siga.REL.Dependencia = function () {
    var servico = "../REL/DependenciaWS.asmx";

    return {
        Selecionar: function (codigoCasaOracao, codigoTipo, callback) {
            var dto = {};
            dto.codigoCasaOracao = codigoCasaOracao;
            dto.codigoTipo = codigoTipo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Selecionar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarParaUso: function (codigoCasaOracao, codigoTipo, codigoSender, callback) {
            var dto = {};
            dto.codigoCasaOracao = codigoCasaOracao;
            dto.codigoTipo = codigoTipo;
            dto.codigoSender = codigoSender;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        },

        SelecionarParaUso: function (codigoPessoa, codigoSender, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.codigoSender = codigoSender;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        },

        SelecionarPorCodigoPessoaEndereco: function (codigoPessoa, codigoSender, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.codigoSender = codigoSender;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigoPessoaEndereco", dto, callback);
        },

        SelecionarPorPessoaEndereco: function (codigoPessoaEndereco, callback) {
            var dto = {};
            dto.codigoPessoaEndereco = codigoPessoaEndereco;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPessoaEndereco", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.REL.Evento = function () {
    var servico = "../REL/EventoWS.asmx";

    return {
        Selecionar: function (start, end, callback) {
            var dto = {};
            dto.start = start;
            dto.end = end;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.REL.Tarefa = function () {
    var servico = "../REL/TarefaWS.asmx";

    return {
        SelecionarPorEvento: function (codigoEvento, callback) {
            var dto = {};
            dto.codigoEvento = codigoEvento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorEvento", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        },
        Concluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Concluir", dto, callback);
        },
        ValidaExecucaoTarefa: function (codigoTarefa, callback, callbackError) {
            var dto = {};
            dto.codigoTarefa = codigoTarefa;

            Siga.UTIL.Ajax(
                servico + "/ValidaExecucaoTarefa",
                dto,
                callback,
                callbackError
            );
        }
    }
}();

Siga.REL.ControleAcessoPessoa = function () {
    var servico = "../REL/ControleAcessoPessoaWS.asmx";

    return {
        Selecionar: function (codigoControleAcesso, callback) {
            var dto = {};
            dto.codigoControleAcesso = codigoControleAcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        ExistePessoa: function (codigoControleAcesso, codigoPessoa, callback) {
            var dto = {};
            dto.codigoControleAcesso = codigoControleAcesso;
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/ExistePessoa", dto, callback);
        },
        Autenticar: function (codigoControleAcesso, codigoPessoa, callback) {
            var dto = {};
            dto.codigoControleAcesso = codigoControleAcesso;
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Autenticar", dto, callback);
        },
        Desfazer: function (codigoControleAcesso, codigoPessoa, callback) {
            var dto = {};
            dto.codigoControleAcesso = codigoControleAcesso;
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Desfazer", dto, callback);
        },
        TotalPessoas: function (codigoControleAcesso, callback) {
            var dto = {};
            dto.codigoControleAcesso = codigoControleAcesso;

            Siga.UTIL.Ajax(servico + "/TotalPessoas", dto, callback);
        }
    }
}();

Siga.REL.ModeloChecklistSecao = function () {
    var servico = "../REL/ModeloChecklistSecaoWS.asmx";

    return {
        Selecionar: function (modeloChecklist, callback) {
            var dto = {};
            dto.modeloChecklist = modeloChecklist;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.REL.ModeloChecklist = function () {
    var servico = "../REL/ModeloChecklistWS.asmx";

    return {
        Selecionar: function (codigoModeloChecklist, callback) {
            var dto = {};
            dto.codigoModeloChecklist = codigoModeloChecklist;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.REL.ChecklistSecao = function () {
    var servico = "../REL/ChecklistSecaoWS.asmx";

    return {
        Selecionar: function (codigoChecklist, callback) {
            var dto = {};
            dto.codigoChecklist = codigoChecklist;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        ExistePendentes: function (codigoChecklist, obrigatorio, callback) {
            var dto = {};
            dto.codigoChecklist = codigoChecklist;
            dto.obrigatorio = obrigatorio;

            Siga.UTIL.Ajax(servico + "/ExistePendentes", dto, callback);
        }
    }
}();

Siga.REL.ConfiguracaoEventoDia = function () {
    var servico = "../REL/ConfiguracaoEventoDiaWS.asmx";

    return {
        Selecionar: function (codigosTipoEvento, codigoEmpresa, codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigosTipoEvento = codigosTipoEvento;
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();