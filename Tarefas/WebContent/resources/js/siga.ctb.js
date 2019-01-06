Siga.CTB = {};

Siga.CTB.Conta = function () {
    var servico = "../CTB/ContaWS.asmx";

    return {
        Selecionar: function (estabelecimento, callback) {
            var dto = {};
            dto.estabelecimento = estabelecimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Selecionar2: function (estabelecimento, callback) {
            var dto = {};
            dto.estabelecimento = estabelecimento;

            Siga.UTIL.Ajax(servico + "/Selecionar2", dto, callback);
        },

        SelecionarPorEmpresa: function (listaEmpresa, codigoTipoEstabelecimento, callback) {
            var dto = {};
            dto.listaEmpresa = listaEmpresa;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorEmpresa", dto, callback);
        },

        SelecionarPorListaEstabelecimento: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorListaEstabelecimento", dto, callback);
        },

        SelecionarParaFaturaParaUso: function (codigoConta, indice, saldoInicial, indicadorEscrita, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.indice = indice;
            dto.saldoInicial = saldoInicial;
            dto.indicadorEscrita = indicadorEscrita;

            Siga.UTIL.Ajax(servico + "/SelecionarParaFaturaParaUso", dto, callback);
        },

        SelecionarIndice: function (indice, callback) {
            var dto = {};
            dto.indice = indice;

            Siga.UTIL.Ajax(servico + "/SelecionarIndice", dto, callback);
        },

        SelecionarIndiceTipoLivro: function (indice, codigoEstabelecimento, callback) {
            var dto = {};
            dto.indice = indice;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarIndiceTipoLivro", dto, callback);
        },

        SelecionarIndiceParaUso: function (indice, codigoConta, callback) {
            var dto = {};
            dto.indice = indice;
            dto.codigoConta = codigoConta;

            Siga.UTIL.Ajax(servico + "/SelecionarIndiceParaUso", dto, callback);
        },

        SelecionarFormaPagamento: function (codigoFormaPagamento, incluiContaAplicacao, indicadorEscrita, callback) {
            var dto = {};
            dto.codigoFormaPagamento = codigoFormaPagamento;
            dto.incluiContaAplicacao = incluiContaAplicacao;
            dto.indicadorEscrita = indicadorEscrita;

            Siga.UTIL.Ajax(servico + "/SelecionarFormaPagamento", dto, callback);
        },

        SelecionarFormaPagamentoTesouraria: function (codigoConta, codigoFormaPagamento, incluiContaAplicacao, indicadorEscrita, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.codigoFormaPagamento = codigoFormaPagamento;
            dto.incluiContaAplicacao = incluiContaAplicacao;
            dto.indicadorEscrita = indicadorEscrita;

            Siga.UTIL.Ajax(servico + "/SelecionarFormaPagamentoTesouraria", dto, callback);
        },

        SelecionarFormaPagamentoTesourariaRecebimento: function (codigoFormaPagamento, callback) {
            var dto = {};
            dto.codigoFormaPagamento = codigoFormaPagamento;

            Siga.UTIL.Ajax(servico + "/SelecionarFormaPagamentoTesourariaRecebimento", dto, callback);
        },

        SelecionarFormaPagamentoParaUso: function (codigoFormaPagamento, codigoConta, callback) {
            var dto = {};
            dto.codigoFormaPagamento = codigoFormaPagamento;
            dto.codigoConta = codigoConta;

            Siga.UTIL.Ajax(servico + "/SelecionarFormaPagamentoParaUso", dto, callback);
        },

        SelecionarFormaPagamentoDestino: function (codigoFormaPagamento, callback) {
            var dto = {};
            dto.codigoFormaPagamento = codigoFormaPagamento;

            Siga.UTIL.Ajax(servico + "/SelecionarFormaPagamentoDestino", dto, callback);
        },

        SelecionarPorCodigoContaSuperior: function (listaContaSuperior, codigoEstabelecimento, callback) {
            var dto = {};
            dto.listaContaSuperior = listaContaSuperior;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigoContaSuperior", dto, callback);
        },

        SelecionarComSaldo: function (listaContaSuperior, codigoEstabelecimento, callback) {
            var dto = {};
            dto.listaContaSuperior = listaContaSuperior;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarComSaldo", dto, callback);
        },

        SelecionarFormaPagamentoDestinoParaTesouraria: function (codigoConta, codigoFormaPagamento, indicadorEscrita, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.codigoFormaPagamento = codigoFormaPagamento;
            dto.indicadorEscrita = indicadorEscrita;

            Siga.UTIL.Ajax(servico + "/SelecionarFormaPagamentoDestinoParaTesouraria", dto, callback);
        },

        ExisteContaBancaria: function (codigoBanco, agenciaBanco, contaBanco, callback) {
            var dto = {};
            dto.codigoBanco = codigoBanco;
            dto.agenciaBanco = agenciaBanco;
            dto.contaBanco = contaBanco;

            Siga.UTIL.Ajax(servico + "/ExisteContaBancaria", dto, callback);
        },

        SelecionarParaUsoContabilidade: function (codigoEstabelecimento, indicadorEscrita, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.indicadorEscrita = indicadorEscrita;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUsoContabilidade", dto, callback);
        },

        SelecionarParaUsoOperacao: function (codigoConta, tipoEstabelecimento, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.tipoEstabelecimento = tipoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUsoOperacao", dto, callback);
        },

        SelecionarParaUsoOperacaoPiedade: function (codigoConta, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUsoOperacaoPiedade", dto, callback);
        },

        SelecionarParaUsoOperacaoCasaOracao: function (codigoConta, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUsoOperacaoCasaOracao", dto, callback);
        },

        CalculaSaldo: function (codigoConta, indicadorOperacional, data, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.indicadorOperacional = indicadorOperacional;
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/CalculaSaldo", dto, callback);
        },

        SelecionarParaTipoColeta: function (parametro, callback) {
            var dto = {};
            dto.parametro = parametro;

            Siga.UTIL.Ajax(servico + "/SelecionarParaTipoColeta", dto, callback);
        }
    }
}();

Siga.CTB.Competencia = function () {
    var servico = "../CTB/CompetenciaWS.asmx";

    return {

        SelecionarCompetenciasParaRelatorioDespesa: function (codigoEmpresa, encerrado, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.encerrado = encerrado;

            Siga.UTIL.Ajax(servico + "/SelecionarCompetenciasParaRelatorioDespesa", dto, callback);
        },

        SelecionarCompetencias: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarCompetencias", dto, callback);
        },

        SelecionarTodas: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarTodas", dto, callback);
        }
    }
}();

Siga.CTB.CentroCusto = function () {
    var servico = "../CTB/CentroCustoWS.asmx";

    return {
        SelecionarInfinito: function (campo, textoSelecione, callback) {
            Siga.Widgets.Select2.SingleAjaxInfinite2(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                null
            );

            if (jQuery.isFunction(callback)) {
                callback();
            }
        },

        SelecionarPorEstabelecimento: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorEstabelecimento", dto, callback);
        },

        SelecionarParaUso: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        }
    }
}();

Siga.CTB.Lancamento = function () {
    var servico = "../CTB/LancamentoWS.asmx";

    return {
        SelecionarParametro: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarParametro", dto, callback);
        }
    }
}();

/******************************/
/*         Traduções         */
Siga.CTB.ContaTraducao = function () {
    var servico = "../CTB/ContaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.CTB.HistoricoTraducao = function () {
    var servico = "../CTB/HistoricoTraducaoWS.asmx";

    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.CTB.ConsistenciaTraducao = function () {
    var servico = "../CTB/ConsistenciaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.CTB.SaldoInicial = function () {
    var servico = "../CTB/SaldoInicialWS.asmx";

    return {
        Selecionar: function (codigoConta, codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarPessoaAtivo: function (codigoConta, codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarPessoaAtivo", dto, callback);
        }
    }
}();

Siga.CTB.ApuracaoRetencao = function () {
    var servico = "../CTB/ApuracaoRetencaoWS.asmx";

    return {
        Selecionar: function (codigoEstabelecimento, codigoFornecedor, sdata1, sdata2, indcofins, indcsll, indpis, indinss, indiss, indirrf, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoFornecedor = codigoFornecedor;
            dto.sdata1 = sdata1;
            dto.sdata2 = sdata2;
            dto.indcofins = indcofins;
            dto.indcsll = indcsll;
            dto.indpis = indpis;
            dto.indinss = indinss;
            dto.indiss = indiss;
            dto.indirrf = indirrf;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarISS: function (codigoEstabelecimento, codigoFornecedor, sdata1, sdata2, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoFornecedor = codigoFornecedor;
            dto.sdata1 = sdata1;
            dto.sdata2 = sdata2;

            Siga.UTIL.Ajax(servico + "/SelecionarISS", dto, callback);
        },

        ConvertNumeric: function (valorcofins, valorcsll, valorpis, valorinss, valoriss, valorirrf, callback) {
            var dto = {};
            dto.valorcofins = valorcofins;
            dto.valorcsll = valorcsll;
            dto.valorpis = valorpis;
            dto.valorinss = valorinss;
            dto.valoriss = valoriss;
            dto.valorirrf = valorirrf;

            Siga.UTIL.Ajax(servico + "/ConvertNumeric", dto, callback);
        },

        ConvertNumericISS: function (valoriss, callback) {
            var dto = {};
            dto.valoriss = valoriss;

            Siga.UTIL.Ajax(servico + "/ConvertNumericISS", dto, callback);
        }
    }
}();