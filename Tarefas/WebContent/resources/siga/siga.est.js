Siga.EST = {};

Siga.EST.Produto = function () {
    var servico = "../EST/ProdutoWS.asmx";

    return {
        SelecionarComSaldo: function (codigoGrupo, codigoSubGrupo, callback) {
            var dto = {};
            dto.codigoGrupo = codigoGrupo;
            dto.codigoSubGrupo = codigoSubGrupo;
            dto.codigoTipoMaterial = null;

            Siga.UTIL.Ajax(servico + "/SelecionarComSaldo", dto, callback);
        },


        SelecionarInfinito: function (campo, codigoEstabelecimento, codigoGrupo, codigoSubGrupo, codigoFamilia, codigoTipoMaterial, ativo, textoInativo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinito",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};

                    dto.codigoEstabelecimento = $("#" + codigoEstabelecimento).val();
                    dto.codigoGrupo = codigoGrupo;
                    dto.codigoSubGrupo = codigoSubGrupo;
                    dto.codigoFamilia = codigoFamilia
                    dto.codigoTipoMaterial = codigoTipoMaterial;
                    dto.ativo = ativo;
                    dto.termo = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");
                    var output =
                    "<div class='select2-customresult'>" +
                    "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                    "       <div class='span2' style='min-height: 20px'>" + option.detail.CodigoAuxiliar + "</div>" +
                    "       <div class='span8' style='min-height: 20px'>&nbsp;&nbsp;" + option.detail.Nome +
                    (option.detail.Ativo == false ? "<span class='pull-right badge badge-inverse'>" + textoInativo + " </span>" : "") +
                    "       </div>" +
                    "       <div class='span2' style='min-height: 20px; text-align:right; padding-right:4px'>" + option.detail.UnidadeMedida + "</div>" +
                    "   </div>" +
                    "</div> ";
                    return output;
                },
                function (option) {
                    $("#" + campo).data("quantidade", option.detail.Estoque);
                    return option.detail.CodigoAuxiliar + " - " + option.text
                }
                //,
                //function (term, text, option) {
                //    var query = "";
                //    if (option.attr("data-ref") != undefined) {
                //        query = (
                //            option.attr("data-ref") +
                //            option.attr("data-ref").replaceAll("-", "") +
                //            text
                //        );
                //    }

                //    return query.toUpperCase().indexOf(term.toUpperCase()) >= 0;
                //}
            );
        },

        SelecionarComSaldo: function (codigoGrupo, codigoSubGrupo, codigoTipoMaterial, callback) {
            var dto = {};
            dto.codigoGrupo = codigoGrupo;
            dto.codigoSubGrupo = codigoSubGrupo;
            dto.codigoTipoMaterial = codigoTipoMaterial;

            Siga.UTIL.Ajax(servico + "/SelecionarComSaldo", dto, callback);
        },

        SelecionarComSaldoData: function (codigoGrupo, codigoSubGrupo, codigoTipoMaterial, dataSaldo, codigoLocalArmazenagem, callback) {
            var dto = {};
            dto.codigoGrupo = codigoGrupo;
            dto.codigoSubGrupo = codigoSubGrupo;
            dto.codigoTipoMaterial = codigoTipoMaterial;
            dto.dataSaldo = dataSaldo;
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;

            Siga.UTIL.Ajax(servico + "/SelecionarComSaldoData", dto, callback);
        },

        SelecionarProdutoPorAlmoxarifado: function (codigoEmpresa, codigoEstabelecimento, data, codigoLocalArmazenagem, listaGrupo, codigoSubGrupo, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.data = data;
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;
            dto.listaGrupo = listaGrupo;
            dto.codigoSubGrupo = codigoSubGrupo;

            Siga.UTIL.Ajax(servico + "/SelecionarProdutoPorAlmoxarifado", dto, callback);
        },

        SelecionarProduto: function (codigoEmpresa, codigoEstabelecimento, data, codigoLocalArmazenagem, listaGrupo, codigoSubGrupo, codigoTipoItemDocumentoFiscal, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.data = data;
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;
            dto.listaGrupo = listaGrupo;
            dto.codigoSubGrupo = codigoSubGrupo;
            dto.codigoTipoItemDocumentoFiscal = codigoTipoItemDocumentoFiscal;

            Siga.UTIL.Ajax(servico + "/SelecionarProduto", dto, callback);
        },


        //Rotina Reserva
        SelecionarReserva: function (data, codigoSubGrupo, callback) {
            var dto = {};
            dto.data = data;
            dto.codigoSubGrupo = codigoSubGrupo;

            Siga.UTIL.Ajax(servico + "/SelecionarReserva", dto, callback);
        },

        SelecionarComSaldoReservado: function (codigoLocalArmazenagem, listaGrupo, dataDocumento, callback) {
            var dto = {};
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;
            dto.listaGrupo = listaGrupo;
            dto.dataDocumento = dataDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarComSaldoReservado", dto, callback);
        },

        SelecionarParaFBL: function (codigoLocalArmazenagem, dataDocumento, callback) {
            var dto = {};
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;
            dto.dataDocumento = dataDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarParaFBL", dto, callback);
        },

        SelecionarComSaldoLocalidade: function (codigoLocalArmazenagem, listaGrupo, codigoPessoa, dataDocumento, callback) {
            var dto = {};
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;
            dto.listaGrupo = listaGrupo;
            dto.codigoPessoa = codigoPessoa;
            dto.dataDocumento = dataDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarComSaldoLocalidade", dto, callback);
        },

        Selecionar: function (codigoGrupo, codigoSubGrupo, codigoFamilia, codigoTipoMaterial, termo, ativo, carregarRelacionamentos, callback) {
            var dto = {};
            dto.codigoGrupo = codigoGrupo;
            dto.codigoTipoEstabelecimento = null;
            dto.codigoSubGrupo = codigoSubGrupo;
            dto.codigoFamilia = codigoFamilia;
            dto.codigoTipoMaterial = codigoTipoMaterial;
            dto.termo = termo;
            dto.ativo = ativo;
            dto.carregarRelacionamentos = carregarRelacionamentos;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarValorTabelaEpoca: function (lista, data, callback) {
            var dto = {};
            dto.lista = lista;
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/SelecionarValorTabelaEpoca", dto, callback);
        }
    }
}();


Siga.EST.ProdutoTraducao = function () {
    var servico = "../EST/ProdutoTraducaoWS.asmx";
    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.Estoque = function () {
    var servico = "../EST/EstoqueWS.asmx";

    return {
        VerificaEstoque: function (codigoEmpresa, codigoEstabelecimento, codigoProduto, quantidade, codigoLocalArmazenagem, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoProduto = codigoProduto;
            dto.quantidade = quantidade;
            dto.codigoLocalArmazenagem = codigoLocalArmazenagem;

            Siga.UTIL.Ajax(servico + "/VerificaEstoque", dto, callback);
        }
    }
}();

Siga.EST.ProdutoFornecedor = function () {
    var servico = "../EST/ProdutoFornecedorWS.asmx";

    return {
        Selecionar: function (codigoFornecedor, callback) {
            var dto = {};
            dto.codigoFornecedor = codigoFornecedor;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.EST.HomologacaoProdutoDetalhe = function () {
    var servico = "../EST/HomologacaoProdutoDetalheWS.asmx";

    return {
        Selecionar: function (codigoHomologacao, callback) {
            var dto = {};
            dto.codigoHomologacao = codigoHomologacao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.EST.HomologacaoProduto = function () {
    var servico = "../EST/HomologacaoProdutoWS.asmx";

    return {
        Cancelar: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Cancelar", dto, callback);
        }
    }
}();


Siga.EST.OrdemProducao = function () {
    var servico = "../EST/OrdemProducaoWS.asmx";

    return {
        Selecionar: function (codigoDocumento, callback) {
            var dto = {};
            dto.codigoDocumento = codigoDocumento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        ValorTotal: function (codigoDocumento, callback) {
            var dto = {};
            dto.codigoDocumento = codigoDocumento;

            Siga.UTIL.Ajax(servico + "/ValorTotal", dto, callback);
        }
    }
}();

Siga.EST.ItemRequisicao = function () {
    var servico = "../EST/ItemRequisicaoWS.asmx";

    return {
        Selecionar: function (codigoRequisicao, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        RetornaCodigoItemRequisicao: function (codigoBarras, codigoRequisicao, callback) {
            var dto = {};
            dto.codigoBarras = codigoBarras;
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/RetornaCodigoItemRequisicao", dto, callback);
        },


        ValidacaoProduto: function (codigoRequisicao, codigoProduto, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;
            dto.codigoProduto = codigoProduto;

            Siga.UTIL.Ajax(servico + "/ValidacaoProduto", dto, callback);
        },
        ValidacaoQuantidade: function (codigoRequisicao, codigoItemRequisicao, codigoProduto, quantidade, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;
            dto.codigoItemRequisicao = codigoItemRequisicao;
            dto.codigoProduto = codigoProduto;
            dto.quantidade = quantidade;

            Siga.UTIL.Ajax(servico + "/ValidacaoQuantidade", dto, callback);
        },
        TotalProduto: function (codigoRequisicao, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/TotalProduto", dto, callback);
        },
        ValidacaoConferencia: function (codigoRequisicao, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/ValidacaoConferencia", dto, callback);
        },
        SelecionarProduto: function (codigoRequisicao, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/SelecionarProduto", dto, callback);
        },
        QuantidadeConferir: function (codigoRequisicao, codigoItemRequisicao, codigoProduto, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;
            dto.codigoItemRequisicao = codigoItemRequisicao;
            dto.codigoProduto = codigoProduto;

            Siga.UTIL.Ajax(servico + "/QuantidadeConferir", dto, callback);
        },
        SelecionarReserva: function (codigoRequisicao, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/SelecionarReserva", dto, callback);
        },
        TotalReserva: function (codigoRequisicao, callback) {
            var dto = {};
            dto.codigoRequisicao = codigoRequisicao;

            Siga.UTIL.Ajax(servico + "/TotalReserva", dto, callback);
        }
    }
}();

Siga.EST.GrupoTraducao = function () {
    var servico = "../EST/GrupoTraducaoWS.asmx";
    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.SubGrupo = function () {
    var servico = "../EST/SubGrupoWS.asmx";

    return {
        Selecionar: function (codigoGrupo, exibirImobilizado, callback) {
            var dto = {};
            dto.codigoGrupo = codigoGrupo;
            dto.exibirImobilizado = exibirImobilizado;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarParaUso: function (sender, codigoGrupo, exibirImobilizado, callback) {
            var dto = {};
            dto.sender = sender;
            dto.codigoGrupo = codigoGrupo;
            dto.exibirImobilizado = exibirImobilizado;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        },
        VerificarSubGrupo: function (codigoSubGrupo, callback) {
            var dto = {};
            dto.codigoSubGrupo = codigoSubGrupo;

            Siga.UTIL.Ajax(servico + "/VerificarSubGrupo", dto, callback);
        },
        SelecionarCodigoContaImobilizado: function (codigoSubGrupo, callback) {
            var dto = {};
            dto.codigoSubGrupo = codigoSubGrupo;

            Siga.UTIL.Ajax(servico + "/SelecionarCodigoContaImobilizado", dto, callback);
        },
        SelecionarComEstoque: function (codigoEmpresa, codigoEstabelecimento, data, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/SelecionarComEstoque", dto, callback);
        },
        SelecionarParaUsoLista: function (listaSubGrupo, listaGrupo, exibirImobilizado, callback) {
            var dto = {};
            dto.listaSubGrupo = listaSubGrupo;
            dto.listaGrupo = listaGrupo;
            dto.exibirImobilizado = exibirImobilizado;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUsoLista", dto, callback);
        },
        VerificarListaSubGrupo: function (listaGrupo, listaSubGrupo, exibirImobilizado, callback) {
            var dto = {};
            dto.listaGrupo = listaGrupo;
            dto.listaSubGrupo = listaSubGrupo;
            dto.exibirImobilizado = exibirImobilizado;

            Siga.UTIL.Ajax(servico + "/VerificarListaSubGrupo", dto, callback);
        }
    }
}();

Siga.EST.SubGrupoTraducao = function () {
    var servico = "../EST/SubGrupoTraducaoWS.asmx";
    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.Familia = function () {
    var servico = "../EST/FamiliaWS.asmx";

    return {
        SelecionarParaUso: function (sender, codigoGrupo, callback) {
            var dto = {};
            dto.sender = sender;
            dto.codigoGrupo = codigoGrupo;
            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        },
        SelecionarParaUsoLista: function (listaFamilia, listaGrupo, callback) {
            var dto = {};
            dto.listaFamilia = listaFamilia;
            dto.listaGrupo = listaGrupo;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUsoLista", dto, callback);
        },
        VerificarListaFamilia: function (listaGrupo, listaFamilia, callback) {
            var dto = {};
            dto.listaGrupo = listaGrupo;
            dto.listaFamilia = listaFamilia;

            Siga.UTIL.Ajax(servico + "/VerificarListaFamilia", dto, callback);
        },
        VerificarFamilia: function (codigoFamilia, callback) {
            var dto = {};
            dto.codigoFamilia = codigoFamilia;

            Siga.UTIL.Ajax(servico + "/VerificarFamilia", dto, callback);
        }
    }
}();

Siga.EST.FamiliaTraducao = function () {
    var servico = "../EST/FamiliaTraducaoWS.asmx";
    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.UnidadeMedidaTraducao = function () {
    var servico = "../EST/UnidadeMedidaTraducaoWS.asmx";
    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.Operacao = function () {
    var servico = "../EST/OperacaoWS.asmx";

    return {
        Selecionar: function (codigoTipoOperacaoDocumentoFiscal, callback) {
            var dto = {};
            dto.codigoTipoOperacaoDocumentoFiscal = codigoTipoOperacaoDocumentoFiscal;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.OperacaoTraducao = function () {
    var servico = "../EST/OperacaoTraducaoWS.asmx";

    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.TipoItemDocumentoFiscal = function () {
    var servico = "../EST/TipoItemDocumentoFiscalWS.asmx";

    return {
        Selecionar: function (codigoTipo, callback) {

            var dto = {};
            dto.codigoTipo = codigoTipo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarFundoBiblico: function (codigoTipo, callback) {

            var dto = {};
            dto.codigoTipo = codigoTipo;

            Siga.UTIL.Ajax(servico + "/SelecionarFundoBiblico", dto, callback);
        }
    }
}();

Siga.EST.ModeloDocumentoFiscal = function () {
    var servico = "../EST/ModeloDocumentoFiscalWS.asmx";

    return {
        Selecionar: function (codigoTipoItemDocumentoFiscal, callback) {
            var dto = {};
            dto.codigoTipoItemDocumentoFiscal = codigoTipoItemDocumentoFiscal;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarModeloEntradaSaida: function (codigoTipoItemDocumentoFiscal, callback) {
            var dto = {};
            dto.codigoTipoItemDocumentoFiscal = codigoTipoItemDocumentoFiscal;

            Siga.UTIL.Ajax(servico + "/SelecionarModeloEntradaSaida", dto, callback);
        }
    }
}();

Siga.EST.Requisicao = function () {
    var servico = "../EST/RequisicaoWS.asmx";

    return {
        CalcularDescontoFinanceiro: function (codigoOperacao, codigoRequisicao, callback) {
            var dto = {};
            dto.codigoOperacao = codigoOperacao;
            dto.codigoRequisicao = codigoRequisicao;
            Siga.UTIL.Ajax(servico + "/CalcularDescontoFinanceiro", dto, callback);
        },

        ListarEstoqueInfinito: function (campo, codigoEmpresa, codigoEstabelecimento, data, codigoLocalArmazenagem, codigoProduto, campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/ListarEstoqueInfinito",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};

                    dto.codigoEmpresa = codigoEmpresa;
                    dto.codigoEstabelecimento = codigoEstabelecimento;
                    dto.data = data;
                    dto.codigoLocalArmazenagem = codigoLocalArmazenagem;
                    dto.codigoProduto = codigoProduto;
                    dto.term = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span10' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.NomeLocalArmazenagem +
                            "       </div>" +
                            "       <div class='span2' style='min-height: 24px'>" + option.detail.Estoque + "</div>" +
                            "   </div>" +
                            "</div> ";
                    return output;
                },
                function (option) {
                    $("#" + campo).data("quantidade", option.detail.Estoque);
                    return option.text
                }
            );
        }
    }
}();

Siga.EST.Serie = function () {
    var servico = "../EST/SerieWS.asmx";

    return {
        Selecionar: function (ativo, indicadorFiscal, callback) {

            var dto = {};
            dto.ativo = ativo;
            dto.indicadorFiscal = indicadorFiscal;


            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.DocumentoFiscal = function () {
    var servico = "../EST/DocumentoFiscalWS.asmx";

    return {
        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;
            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        },

        Selecionar: function (tipoData, data1, data2, numero, serie, codigoPessoa, codigoTipoEmissaoDocumentoFiscal, listaOperacao, callback) {
            var dto = {};
            dto.tipoData = tipoData;
            dto.data1 = data1;
            dto.data2 = data2;
            dto.numero = numero;
            dto.serie = serie;
            dto.codigoPessoa = codigoPessoa;
            dto.codigoTipoEmissaoDocumentoFiscal = codigoTipoEmissaoDocumentoFiscal;
            dto.listaOperacao = listaOperacao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarPorTransportador: function (codigoTransportador, callback) {
            var dto = {};
            dto.codigoTransportador = codigoTransportador;
            Siga.UTIL.Ajax(servico + "/SelecionarPorTransportador", dto, callback);
        },

        SelecionarXML: function (chave, callback) {
            var dto = {};
            dto.chave = chave;
            Siga.UTIL.Ajax(servico + "/SelecionarXML", dto, callback);
        },

        PermitePesquisar: function (codigoOperacao, callback) {
            var dto = {};
            dto.codigoOperacao = codigoOperacao;
            Siga.UTIL.Ajax(servico + "/PermitePesquisar", dto, callback);
        },

        TotalPeso: function (codigoTransportador, callback) {
            var dto = {};
            dto.codigoTransportador = codigoTransportador;
            Siga.UTIL.Ajax(servico + "/TotalPeso", dto, callback);
        },

        TotalValor: function (codigoTransportador, callback) {
            var dto = {};
            dto.codigoTransportador = codigoTransportador;
            Siga.UTIL.Ajax(servico + "/TotalValor", dto, callback);
        },

        TotalQuantidade: function (codigoTransportador, callback) {
            var dto = {};
            dto.codigoTransportador = codigoTransportador;
            Siga.UTIL.Ajax(servico + "/TotalQuantidade", dto, callback);
        },

        CancelarDT: function (codigo, codigoPrograma, callback) {
            var dto = {};
            dto.codigo = codigo;
            dto.codigoPrograma = codigoPrograma;
            dto.validaFechamento = true;
            Siga.UTIL.Ajax(servico + "/CancelarDT", dto, callback);
        },

        CancelarDTFundoBiblico: function (codigo, codigoPrograma, callback) {
            var dto = {};
            dto.codigo = codigo;
            dto.codigoPrograma = codigoPrograma;
            dto.validaFechamento = false;
            Siga.UTIL.Ajax(servico + "/CancelarDT", dto, callback);
        },

        GerarNumeroDocumentoFiscalPelaSerie: function (codigoSerie, callback) {
            var dto = {};
            dto.codigoSerie = codigoSerie;
            Siga.UTIL.Ajax(servico + "/GerarNumeroDocumentoFiscalPelaSerie", dto, callback);
        }
    }
}();

Siga.EST.ItemDocumentoFiscal = function () {
    var servico = "../EST/ItemDocumentoFiscalWS.asmx";

    return {
        Selecionar: function (codigoDocumento, tipoItem, callback) {
            var dto = {};
            dto.codigoDocumento = codigoDocumento;
            dto.tipoItem = tipoItem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarProduto: function (codigoDocumento, tipoItem, ordenacaoCrescente, callback) {
            var dto = {};
            dto.codigoDocumento = codigoDocumento;
            dto.tipoItem = tipoItem;
            dto.ordenacaoCrescente = ordenacaoCrescente;

            Siga.UTIL.Ajax(servico + "/SelecionarProduto", dto, callback);
        },

        SelecionarRetencoes: function (codigoDocumento, callback) {
            var dto = {};
            dto.codigoDocumento = codigoDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarRetencoes", dto, callback);
        },

        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        },

        SaldoEmEstoque: function (codigoProduto, callback) {
            var dto = {};
            dto.codigoProduto = codigoProduto;

            Siga.UTIL.Ajax(servico + "/SaldoEmEstoque", dto, callback);
        },

        ItensDoPedido: function (codigoDocumentoFiscal, callback) {
            var dto = {};
            dto.codigoDocumentoFiscal = codigoDocumentoFiscal;

            Siga.UTIL.Ajax(servico + "/ItensDoPedido", dto, callback);
        }

    }
}();

Siga.EST.CotacaoRemetente = function () {
    var servico = "../EST/CotacaoRemetenteWS.asmx";

    return {
        Selecionar: function (codigoCotacao, callback) {
            var dto = {};
            dto.codigoCotacao = codigoCotacao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.EST.CFOP = function () {
    var servico = "../EST/CFOPWS.asmx";

    return {
        Selecionar: function (codigoTipoOperacaoDocumentoFiscal, codigoTipoItemDocumentoFiscal, codigoTipoDestino, callback) {

            var dto = {};

            dto.codigoTipoOperacaoDocumentoFiscal = codigoTipoOperacaoDocumentoFiscal;
            dto.codigoTipoItemDocumentoFiscal = codigoTipoItemDocumentoFiscal;
            dto.codigoTipoDestino = codigoTipoDestino;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.CST = function () {
    var servico = "../EST/CSTWS.asmx";

    return {
        Selecionar: function (imposto, codigoTipoOperacaoDocumentoFiscal, callback) {

            var dto = {};
            dto.imposto = imposto;
            dto.codigoTipoOperacaoDocumentoFiscal = codigoTipoOperacaoDocumentoFiscal;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.EST.Bem = function () {
    var servico = "../EST/BemWS.asmx";

    return {
        Selecionar: function (codigoProduto, indicadorVenda, callback) {
            var dto = {};
            dto.codigoProduto = codigoProduto;
            dto.indicadorVenda = indicadorVenda;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        GerarSequencia: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/GerarSequencia", dto, callback);
        }
    }
}();

Siga.EST.ImportacaoBem = function () {
    var servico = "../EST/ImportacaoBemWS.asmx";

    return {
        GerarSequencia: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/GerarSequencia", dto, callback);
        }
    }
}();

Siga.EST.Fornecedor = function () {
    var servico = "../EST/FornecedorWS.asmx";

    return {
        SelecionarPorDocumento: function (documento, callback) {
            var dto = {};
            dto.documento = documento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorDocumento", dto, callback);
        },

        SelecionarPorDocumentoECategoria: function (documento, categoriaPessoa, callback) {
            var dto = {};
            dto.documento = documento;
            dto.categoriaPessoa = categoriaPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarPorDocumentoECategoria", dto, callback);
        },

        Homologar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            Siga.UTIL.Ajax(servico + "/Homologar", dto, callback);
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

        SelecionarInfinito: function (campo, textoSelecione, codigoCategoriaPessoa, indicadorGenerico, ativo, incluirDistribuidoras) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.codigoCategoriaPessoa = codigoCategoriaPessoa;
                    dto.incluirDistribuidoras = incluirDistribuidoras != undefined ? incluirDistribuidoras : false;
                    dto.indicadorGenerico = null;
                    dto.ativo = null;

                    if (indicadorGenerico != undefined) {
                        dto.indicadorGenerico = indicadorGenerico;
                    }

                    if (ativo != undefined) {
                        dto.ativo = ativo;
                    }

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';
                    var inativo = "";

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span8' style='min-height: 24px'>" +
                        "           <strong>" + option.text + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'> " +
                        "           <small class='pull-left badge badge-inverse'>" + option.detail.NomeAtivo + "</small>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'> " +
                        "           <small class='pull-right badge " + classebadge + "'>" + option.detail.NomeCategoria + "</small>" +
                        "       </div>" +
                        "   </div>");

                    if (option.detail.CodigoTipoPessoa == "2") {
                        if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                            output +=
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                            "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                            "           <small>" + option.detail.NomeFantasia + "</small>" +
                            "       </div>" +
                            "   </div>";
                        } else {
                            output +=
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                            "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                            "           <small>" + Siga.Mensagem.SIS0091 + "</small>" +
                            "       </div>" +
                            "   </div>";
                        }
                    }

                    if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span12' style='min-height: 20px; padding-left: 20px'>" +
                        "           <small>" + option.detail.Logradouro + ', ' +
                                               option.detail.Numero + ' - ' +
                                               option.detail.Cidade + ' - ' +
                                               option.detail.Estado + ' - CEP ' +
                                               option.detail.CEP + '</small>' +
                        "       </div>";
                    } else {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span12' style='min-height: 20px; padding-left: 20px'>" +
                        "       </div>";
                    }

                    if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                        var docFed = option.detail.CodigoTipoPessoa == 2 ? Siga.Mensagem.SIS0092 : Siga.Mensagem.SIS0093;
                        output +=
                        "   </div>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        (option.detail.DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + docFed + option.detail.DocumentoFederal + "</small></div>" : "") +
                        (option.detail.DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>IE: " + option.detail.DocumentoEstadual + "</small></div>" : "");
                    }

                    output +=
                    "   </div>" +
                    "</div>";

                    return output;
                }
            );
        },

        //Trazer listagem Simples: Nome E CNPJ
        SelecionarInfinito2: function (campo, textoSelecione, codigoCategoriaPessoa, indicadorGenerico, ativo, incluirDistribuidoras) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.codigoCategoriaPessoa = codigoCategoriaPessoa;
                    dto.incluirDistribuidoras = incluirDistribuidoras != undefined ? incluirDistribuidoras : false;
                    dto.indicadorGenerico = null;
                    dto.ativo = null;

                    if (indicadorGenerico != undefined) {
                        dto.indicadorGenerico = indicadorGenerico;
                    }

                    if (ativo != undefined) {
                        dto.ativo = ativo;
                    }

                    return JSON.stringify(dto);
                },

                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var docFederal = "";
                    if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                        var docFed = option.detail.CodigoTipoPessoa == 2 ? Siga.Mensagem.SIS0092 : Siga.Mensagem.SIS0093;
                        docFederal +=
                        (option.detail.DocumentoFederal != "" ? docFed + option.detail.DocumentoFederal : "")
                    }

                    var output = (
                        "<div class='select2-customresult' style='padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span9' style='min-height: 24px'>" +
                        "           " + option.text +
                        "       </div>" +
                        "       <div class='span3' style='min-height: 24px'>" +
                        "           " + docFederal +
                        "       </div>" +
                        "   </div>" +
                        "</div>"
                    );

                    return output;
                }
            );
        },

        SelecionarInfinitolista: function (campo, textoSelecione, sListaCategoriaPessoa, indicadorGenerico, ativo, incluirDistribuidoras) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarListaCategoria",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.sListaCategoriaPessoa = sListaCategoriaPessoa;
                    dto.incluirDistribuidoras = incluirDistribuidoras != undefined ? incluirDistribuidoras : false;
                    dto.indicadorGenerico = null;
                    dto.ativo = null;

                    if (indicadorGenerico != undefined) {
                        dto.indicadorGenerico = indicadorGenerico;
                    }

                    if (ativo != undefined) {
                        dto.ativo = ativo;
                    }

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';
                    var inativo = "";

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span8' style='min-height: 24px'>" +
                        "           <strong>" + option.text + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'> " +
                        "           <small class='pull-left badge badge-inverse'>" + option.detail.NomeAtivo + "</small>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'> " +
                        "           <small class='pull-right badge " + classebadge + "'>" + option.detail.NomeCategoria + "</small>" +
                        "       </div>" +
                        "   </div>");

                    if (option.detail.CodigoTipoPessoa == "2") {
                        if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                            output +=
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                            "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                            "           <small>" + option.detail.NomeFantasia + "</small>" +
                            "       </div>" +
                            "   </div>";
                        } else {
                            output +=
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                            "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                            "           <small>" + Siga.Mensagem.SIS0091 + "</small>" +
                            "       </div>" +
                            "   </div>";
                        }
                    }

                    if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span12' style='min-height: 20px; padding-left: 20px'>" +
                        "           <small>" + option.detail.Logradouro + ', ' +
                                               option.detail.Numero + ' - ' +
                                               option.detail.Cidade + ' - ' +
                                               option.detail.Estado + ' - CEP ' +
                                               option.detail.CEP + '</small>' +
                        "       </div>";
                    } else {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span12' style='min-height: 20px; padding-left: 20px'>" +
                        "       </div>";
                    }

                    if (option.detail.IndicadorGenerico == "N") {//Se o fornecedor não é Genérico
                        var docFed = option.detail.CodigoTipoPessoa == 2 ? Siga.Mensagem.SIS0092 : Siga.Mensagem.SIS0093;
                        output +=
                        "   </div>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        (option.detail.DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + docFed + option.detail.DocumentoFederal + "</small></div>" : "") +
                        (option.detail.DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>IE: " + option.detail.DocumentoEstadual + "</small></div>" : "");
                    }

                    output +=
                    "   </div>" +
                    "</div>";

                    return output;
                }
            );
        },

        AdicionarFornecedor: function (param, campo, categoria) {
            Siga.UTIL.ShowModal("../EST/EST02702.aspx" + param, function (ret, item) {
                if (item != null) {
                    if (item.CodigoCategoria == categoria || categoria == null) {
                        $("#" + campo).val(item.Codigo);
                        $("#" + campo).data("text", item.Nome);
                        $("#" + campo).trigger("change");
                    }
                }
            }, null, "modal-xlarge");
        },

        AdicionarFornecedorlista: function (param, campo) {
            Siga.UTIL.ShowModal("../EST/EST02702.aspx" + param, function (ret, item) {
                if (item != null) {
                    if (item.CodigoCategoria == 2 || item.CodigoCategoria == 5) {
                        $("#" + campo).val(item.Codigo);
                        $("#" + campo).data("text", item.Nome);
                        $("#" + campo).trigger("change");
                    }
                }
            }, null, "modal-xlarge");
        },

        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        }
    }
}();

Siga.EST.Pedido = function () {
    var servico = "../EST/PedidoWS.asmx";

    return {
        SelecionarPorFornecedor: function (codigoFornecedor, codigoTipoItem, callback) {
            var dto = {};
            dto.codigoFornecedor = codigoFornecedor;
            dto.codigoTipoItem = codigoTipoItem;

            Siga.UTIL.Ajax(servico + "/SelecionarPorFornecedor", dto, callback);
        }
    }
}();


Siga.EST.Montagem = function () {
    var servico = "../EST/MontagemWS.asmx";

    return {
        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;
            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        }
    }
}();

Siga.EST.MontagemDetalhe = function () {
    var servico = "../EST/MontagemDetalheWS.asmx";

    return {
        Selecionar: function (codigoMontagem, callback) {
            var dto = {};
            dto.codigoMontagem = codigoMontagem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }

    }
}();

Siga.EST.LocalArmazenagem = function () {
    var servico = "../EST/LocalArmazenagemWS.asmx";

    return {
        SelecionarPorProduto: function (codigoProduto, codigoEmpresa, codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoProduto = codigoProduto;
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorProduto", dto, callback);
        }

    }
}();