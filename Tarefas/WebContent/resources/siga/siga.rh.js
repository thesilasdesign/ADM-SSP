Siga.RH = {};

Siga.RH.Apontamento = function () {
    var servico = "../RH/ApontamentoWS.asmx";

    return {
        CalculoHoras: function (horaInicio, horaFim, valorReferencial, callback) {
            var dto = {};
            dto.horaInicio = horaInicio;
            dto.horaFim = horaFim;
            dto.valorReferencial = valorReferencial;

            Siga.UTIL.Ajax(servico + "/CalculoHoras", dto, callback);
        }
    }
}();

Siga.RH.LivroVoluntario = function () {
    var servico = "../RH/LivroVoluntarioWS.asmx";

    return {
        Selecionar: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarParaUso: function (codigoEstabelecimento, codigoLivro, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoLivro = codigoLivro;

            Siga.UTIL.Ajax(servico + "/SelecionarParaUso", dto, callback);
        }
    }
}();

Siga.RH.Voluntario = function () {
    var servico = "../RH/VoluntarioWS.asmx";

    return {
        ExistePessoa: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/ExistePessoa", dto, callback);
        },

        Inserir: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Inserir", dto, callback);
        },

        SelecionarPorPessoa: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPessoa", dto, callback);
        },

        SelecionarPorDocumento: function (documentoFederal, callback) {
            var dto = {};
            dto.documentoFederal = documentoFederal;

            Siga.UTIL.Ajax(servico + "/SelecionarPorDocumento", dto, callback);
        },

        SelecionarInfinito: function (campo, textoSelecione, ativo) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.ativo = ativo;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var output = (
                        "<div class='row-fluid'>" +
                        "<div class='span7' style='min-height: 10px'>" + option.detail.Nome + "</div>" +
                        "<div class='span2'><label class='badge badge-inverse'>" + (option.detail.Status == false ? Siga.Mensagem.Inativo.toUpperCase() : "") + "</label></div>" +
                        "<div class='span3' style='min-height: 10px'>" + option.detail.DocumentoFederal + "</div>" +
                        "</div>"
                    );

                    return output;
                }
            );
        }
    }
}();

Siga.RH.Profissao = function () {
    var servico = "../RH/ProfissaoWS.asmx";

    return {
        SelecionarInfinito: function (campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
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
                        "<div class='span12' style='min-height: 10px'>" + option.detail.Nome + "</div>" +
                        "</div>"
                    );

                    return output;
                }
            );
        }
    }
}();
