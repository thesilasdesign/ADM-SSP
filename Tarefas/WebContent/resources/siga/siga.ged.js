Siga.GED = {};

Siga.GED.Arquivo = function () {
    var servico = "../GED/ArquivoWS.asmx";

    return {
        Selecionar: function (origem, codigoOrigem, callback) {
            var dto = {};
            dto.origem = origem;
            dto.codigoOrigem = codigoOrigem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();