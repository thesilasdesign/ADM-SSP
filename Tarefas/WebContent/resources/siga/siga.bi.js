Siga.BI = function () {
    var servico = "../BI/BusinessWS.asmx";

    return {
        Atualizar: function (codigoTipoProcesso, callback) {
            var dto = {};
            dto.codigoTipoProcesso = codigoTipoProcesso;

            Siga.UTIL.Ajax(servico + "/Atualizar", dto, callback);
        },
        PegarCompetenciaBW: function (codigoEstabelecimento, competencia, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.competencia = competencia;

            Siga.UTIL.Ajax(servico + "/PegarCompetenciaBW", dto, callback);
        }
    }
}();

Siga.BI.Lancamento = function () {
    var servico = "../BI/LancamentoWS.asmx";

    return {
        SelecionarAdministracoes: function (codigoRegional, callback) {
            var dto = {};
            dto.codigoRegional = codigoRegional;

            Siga.UTIL.Ajax(servico + "/SelecionarAdministracoes", dto, callback);
        },

        SelecionarInferiores: function (codigoAdministracao, callback) {
            var dto = {};
            dto.codigoAdministracao = codigoAdministracao;

            Siga.UTIL.Ajax(servico + "/SelecionarInferiores", dto, callback);
        },

        GerarBalancete: function (codigoEmpresa, codigoEstabelecimento, competencia, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.competencia = competencia;

            Siga.UTIL.Ajax(servico + "/GerarBalancete", dto, callback);
        },

        GerarRazao: function (codigoEmpresa, codigoEstabelecimento, codigoConta, competencia, indicadorContabil, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoConta = codigoConta;
            dto.competencia = competencia;
            dto.indicadorContabil = indicadorContabil;

            Siga.UTIL.Ajax(servico + "/GerarRazao", dto, callback);
        }
    }
}();