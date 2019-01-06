Siga.JUR = {};

Siga.JUR.Reparticao = function () {
    var servico = "../JUR/ReparticaoWS.asmx";

    return {
        Selecionar: function (codigoOrgao, callback) {
            var dto = {};
            dto.codigoOrgao = codigoOrgao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.Orgao = function () {
    var servico = "../JUR/OrgaoWS.asmx";

    return {
        Homologar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Homologar", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoParte = function () {
    var servico = "../JUR/ProcessoParteWS.asmx";

    return {
        Selecionar: function (codigoProcesso, callback) {
            var dto = {};
            dto.codigoProcesso = codigoProcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoResponsavel = function () {
    var servico = "../JUR/ProcessoResponsavelWS.asmx";

    return {
        Selecionar: function (codigoProcesso, callback) {
            var dto = {};
            dto.codigoProcesso = codigoProcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoVinculado = function () {
    var servico = "../JUR/ProcessoVinculadoWS.asmx";

    return {
        Selecionar: function (codigoProcesso, callback) {
            var dto = {};
            dto.codigoProcesso = codigoProcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.Processo = function () {
    var servico = "../JUR/ProcessoWS.asmx";

    return {
        SelecionarVWPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarVWPorCodigo", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoDespesa = function () {
    var servico = "../JUR/ProcessoDespesaWS.asmx";

    return {
        Selecionar: function (codigoProcesso, callback) {
            var dto = {};
            dto.codigoProcesso = codigoProcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoOcorrencia = function () {
    var servico = "../JUR/ProcessoOcorrenciaWS.asmx";

    return {
        Selecionar: function (codigoProcesso, callback) {
            var dto = {};
            dto.codigoProcesso = codigoProcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoCompromisso = function () {
    var servico = "../JUR/ProcessoCompromissoWS.asmx";

    return {
        Selecionar: function (codigoProcessoOcorrencia, callback) {
            var dto = {};
            dto.codigoProcessoOcorrencia = codigoProcessoOcorrencia;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.ProcessoCompromissoResponsavel = function () {
    var servico = "../JUR/ProcessoCompromissoResponsavelWS.asmx";

    return {
        Selecionar: function (codigoProcessoCompromisso, callback) {
            var dto = {};
            dto.codigoProcessoCompromisso = codigoProcessoCompromisso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.JUR.AreaDireito = function () {
    var servico = "../JUR/AreaDireitoWS.asmx";

    return {
        Selecionar: function (codigoTipoProcesso, callback) {
            var dto = {};
            dto.codigoTipoProcesso = codigoTipoProcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.JUR.TipoAssunto = function () {
    var servico = "../JUR/TipoAssuntoWS.asmx";

    return {
        Selecionar: function (codigoAreaDireito, callback) {
            var dto = {};
            dto.codigoAreaDireito = codigoAreaDireito;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();