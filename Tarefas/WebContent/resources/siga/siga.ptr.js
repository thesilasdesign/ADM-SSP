Siga.PTR = {};

Siga.PTR.PessoaEnderecoProcesso = function () {
    var servico = "../PTR/PessoaEnderecoProcessoWS.asmx";

    return {
        SelecionarParaPessoaEndereco: function (codigoPessoaEndereco, codigoEmpresa, callback) {
            var dto = {};
            dto.codigoPessoaEndereco = codigoPessoaEndereco;
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarParaPessoaEndereco", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.PTR.CampoDocumento = function () {
    var servico = "../PTR/CampoDocumentoWS.asmx";

    return {
        Selecionar: function (codigoDocumento, callback) {
            var dto = {};
            dto.codigoDocumento = codigoDocumento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.PTR.CampoDocumentacao = function () {
    var servico = "../PTR/CampoDocumentacaoWS.asmx";

    return {
        SelecionarVW: function (codigoDocumentacao, codigoDocumento, callback) {
            var dto = {};
            dto.codigoDocumentacao = codigoDocumentacao;
            dto.codigoDocumento = codigoDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarVW", dto, callback);
        }
    }
}();

Siga.PTR.BensImoveis = function () {
    var servico = "../PTR/BensImoveisWS.asmx";

    return {
        Selecionar: function(codigoEmpresa, callback){
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarVW: function (codigoAdministracao, codigoCasaOracao, callback) {
            var dto = {};
            dto.codigoAdministracao = codigoAdministracao;
            dto.codigoCasaOracao = codigoCasaOracao;

            Siga.UTIL.Ajax(servico + "/SelecionarVW", dto, callback);
        },

        SelecionarPorCasaOracao: function (codigoCasaOracao, callback) {
            var dto = {};
            dto.codigoCasaOracao = codigoCasaOracao;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCasaOracao", dto, callback);
        }
    }
}();

Siga.PTR.Documentacao = function () {
    var servico = "../PTR/DocumentacaoWS.asmx";

    return {
        SelecionarPorPessoaEndereco: function (codigoPessoaEndereco, codigoTipoDocumento, callback) {
            var dto = {};
            dto.codigoPessoaEndereco = codigoPessoaEndereco;
            dto.codigoTipoDocumento = codigoTipoDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPessoaEndereco", dto, callback);
        }
    }
}();

Siga.PTR.Documento = function () {
    var servico = "../PTR/DocumentoWS.asmx";

    return {
        SelecionarPorTipo: function (codigoTipoDocumento, callback) {
            var dto = {};
            dto.codigoTipoDocumento = codigoTipoDocumento;

            Siga.UTIL.Ajax(servico + "/SelecionarPorTipo", dto, callback);
        },
        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        }
    }
}();


