Siga.PIA = {};

Siga.PIA.ItemValorCaixa = function () {
    var servico = "../PIA/ItemValorCaixaWS.asmx";

    return {
        Selecionar: function (codigoReuniao, callback) {
            var dto = {};
            dto.codigoReuniao = codigoReuniao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Inserir: function (sender, callback) {
            var dto = {};
            dto.sender = sender;

            Siga.UTIL.Ajax(servico + "/Inserir", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.PIA.ItemAtendimento = function () {
    var servico = "../PIA/ItemAtendimentoWS.asmx";

    return {
        Selecionar: function (codigoAtendimento, callback) {
            var dto = {};
            dto.codigoAtendimento = codigoAtendimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Inserir: function (sender, callback) {
            var dto = {};
            dto.sender = sender;

            Siga.UTIL.Ajax(servico + "/Inserir", dto, callback);
        },

        Atualizar: function (sender, callback) {
            var dto = {};
            dto.sender = sender;

            Siga.UTIL.Ajax(servico + "/Atualizar", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.PIA.Prontuario = function () {
    var servico = "../PIA/ProntuarioWS.asmx";

    return {
        //Não pode chamar o prontuário via Ajax, por questão de segurança
        /*PessoaPossui: function (CodigoPessoa, callback) {
            var dto = {};
            dto.CodigoPessoa = CodigoPessoa;

            Siga.UTIL.Ajax(servico + "/PessoaPossui", dto, callback);
        },*/
        ValidaTempoCrente: function (idadeAnos, crenteAnos, crenteMeses, callback) {
            var dto = {};
            dto.idadeAnos = idadeAnos;
            dto.crenteAnos = crenteAnos;
            dto.crenteMeses = crenteMeses;

            Siga.UTIL.Ajax(servico + "/ValidaTempoCrente", dto, callback);
        }
        //Não pode chamar o prontuário via Ajax, por questão de segurança
        /*SelecionarInfinito: function (campo, textoSelecione) {
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

                    var classebadge = 'badge-grey';
                    var bordercolor = 'black';

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span10' style='min-height: 24px'>" +
                        "           <strong>" + option.detail.NumeroFormatado + " " + option.text + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'><small class='pull-right badge " + classebadge + "'>" + "Prontuário" + "</small></div>" +
                        "   </div>"
                    );

                    if (option.detail.NomeConjuge != "") {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                        "           <small> " + option.detail.NomeConjuge + " </small>" +
                        "       </div>" +
                        "   </div>" +
                        "</div>";
                    }

                    return output;
                }
            );
        }*/
    }
}();

Siga.PIA.Atendimento = function () {
    var servico = "../PIA/AtendimentoWS.asmx";

    return {
        Selecionar: function (codigoReuniao, situacao, callback) {
            var dto = {};
            dto.codigoReuniao = codigoReuniao;
            dto.situacao = situacao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarPorNumero: function (codigoReuniao, numero, callback, callbackError) {
            var dto = {};
            dto.codigoReuniao = codigoReuniao;
            dto.numero = numero;

            Siga.UTIL.Ajax(servico + "/SelecionarPorNumero", dto, callback, callbackError);
        },
        VerificarQtaAtendimento: function (codigoReuniao, codigoProntuario, indicadorEmergencia, codigoAtendimento, callback) {
            var dto = {};
            dto.codigoReuniao = codigoReuniao;
            dto.codigoProntuario = codigoProntuario;
            dto.indicadorEmergencia = indicadorEmergencia;
            dto.codigoAtendimento = codigoAtendimento;

            Siga.UTIL.Ajax(servico + "/VerificarQtaAtendimento", dto, callback);
        },
        VerificaTipoCaso: function (codigoReuniao, codigoProntuario, callback) {
            var dto = {};
            dto.codigoReuniao = codigoReuniao;
            dto.codigoProntuario = codigoProntuario;

            Siga.UTIL.Ajax(servico + "/VerificaTipoCaso", dto, callback);
        },
        InserirAnotacao: function (descricao, codigoAtendimento, codigoPrograma, callback) {
            var dto = {};
            dto.descricao = descricao;
            dto.codigoAtendimento = codigoAtendimento;
            dto.codigoPrograma = codigoPrograma;

            Siga.UTIL.Ajax(servico + "/InserirAnotacao", dto, callback);
        },
        InserirAnotacaoLista: function (descricao, listaAtendimento, codigoPrograma, callback) {
            var dto = {};
            dto.descricao = descricao;
            dto.listaAtendimento = listaAtendimento;
            dto.codigoPrograma = codigoPrograma;

            Siga.UTIL.Ajax(servico + "/InserirAnotacaoLista", dto, callback);
        }
    }
}();

Siga.PIA.GrupoAtendimento = function () {
    var servico = "../PIA/GrupoAtendimentoWS.asmx";

    return {
        SelecionarPorCargo: function (codigoCasaOracao, codigoCargo, callback) {
            var dto = {};
            dto.codigoCasaOracao = codigoCasaOracao;
            dto.codigoCargo = codigoCargo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCargo", dto, callback);
        },
        Selecionar: function (codigoCargo, codigoGrupoAtendimento, callback) {
            var dto = {};
            dto.codigoCargo = codigoCargo;
            dto.codigoGrupoAtendimento = codigoGrupoAtendimento;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.PIA.CartaoDebito = function () {
    var servico = "../PIA/CartaoDebito.asmx";

    return {
        Selecionar: function (codigoCasaOracao, callback) {
            var dto = {};
            dto.codigoCasaOracao = codigoCasaOracao;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.PIA.Viagem = function () {
    var servico = "../PIA/Viagem.asmx";

    return {
        CalcularDiaria: function (strData, dias, callback) {
            var dto = {};
            dto.dias = dias;
            dto.strData = strData;

            Siga.UTIL.Ajax(servico + "/CalcularDiaria", dto, callback);
        }
    }
}();

Siga.PIA.Reuniao = function () {
    var servico = "../PIA/ReuniaoWS.asmx";

    return {
        Inserir: function (sender, codigoPrograma, motivo, callback) {
            var dto = {};
            dto.sender = sender;
            dto.codigoPrograma = codigoPrograma;
            dto.motivo = motivo;

            Siga.UTIL.Ajax(servico + "/Inserir", dto, callback);
        },
        Saldocaixa: function (valorCaixa, sDataReuniao, callback) {
            var dto = {};
            dto.valorCaixa = valorCaixa;
            dto.sDataReuniao = sDataReuniao;

            Siga.UTIL.Ajax(servico + "/Saldocaixa", dto, callback);
        }
    }
}();

Siga.PIA.ViagemTransporte = function () {
    var servico = "../PIA/ViagemTransporteWS.asmx";

    return {
        Selecionar: function (codigoViagem, callback) {
            var dto = {};
            dto.codigoViagem = codigoViagem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.PIA.ViagemHospedagem = function () {
    var servico = "../PIA/ViagemHospedagemWS.asmx";

    return {
        Selecionar: function (codigoViagem, callback) {
            var dto = {};
            dto.codigoViagem = codigoViagem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.PIA.ViagemDespesa = function () {
    var servico = "../PIA/ViagemDespesaWS.asmx";

    return {
        Selecionar: function (codigoViagem, callback) {
            var dto = {};
            dto.codigoViagem = codigoViagem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.PIA.ReuniaoProntuario = function () {
    var servico = "../PIA/ReuniaoProntuarioWS.asmx";

    return {
        SelecionarInfinito: function (campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term.replaceAll(" ", "");
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");


                    var output = '<div class="row-fluid">' +
                                 '<div class="span2" style="min-height: 25px">' + option.detail.NumeroFormatado + '</div>';
                    if (option.detail.NomeConjuge != "") {
                        output += '<div class="span10" style="min-height: 25px">' + option.text + " / " + option.detail.NomeConjuge + '</div>';
                    } else {
                        output += '<div class="span10" style="min-height: 25px">' + option.text + '</div>';
                    }
                    '</div>'

                    return output;
                }
            );
        }
    }
}();