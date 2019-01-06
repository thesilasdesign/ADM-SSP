Siga.ENG = {};

Siga.ENG.Obra = function () {
    var servico = "../ENG/ObraWS.asmx";

    return {
        Selecionar: function (codigoPessoaEndereco, callback) {
            var dto = {};
            dto.codigoPessoaEndereco = codigoPessoaEndereco;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.ENG.ObraPessoa = function () {
    var servico = "../ENG/ObraPessoaWS.asmx";

    return {
        Selecionar: function (codigoObra, callback) {
            var dto = {};
            dto.codigoObra = codigoObra;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();