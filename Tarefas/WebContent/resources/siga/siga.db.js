Siga.DB = function () {
    var servico = "../DB/LimpezaBaseWS.asmx";

    return {
        SelecionarTabelas: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarTabelas", dto, callback);
        }
    }
}();