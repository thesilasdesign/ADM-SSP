Siga.TES = {};

Siga.TES.LancamentoPessoa = function () {
    var servico = "../TES/LancamentoPessoaWS.asmx";

    return {
        SelecionarEmLancamento: function (codigoConta, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;

            Siga.UTIL.Ajax(servico + "/SelecionarEmLancamento", dto, callback);
        },
        SelecionarInfinito: function (campo, textoSelecione, codigoConta) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarEmLancamento",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.codigoConta = codigoConta;


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
                        "       <div class='span10' style='min-height: 24px'>" +
                        "           <strong>" + option.text + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'> " +
                        "           <small class='pull-right badge " + classebadge + "'>" + option.detail.NomeCategoria + "</small>" +
                        "       </div>" +
                        "   </div>");




                    output +=
                    "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                    "       <div class='span12' style='min-height: 20px; padding-left: 20px'>" +
                    "           <small>" + option.detail.Logradouro + ', ' +
                                           option.detail.Numero + ' - ' +
                                           option.detail.Cidade + ' - ' +
                                           option.detail.Sigla + ' - ' + Siga.Mensagem.SIS0103 + '' +
                                           option.detail.CEP + '</small>' +
                    "       </div>";



                    var docFed = option.detail.CodigoTipoPessoa == 2 ? Siga.Mensagem.SIS0092 : Siga.Mensagem.SIS0093;
                    output +=
                    "   </div>" +
                    "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                    (option.detail.DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + docFed + option.detail.DocumentoFederal + "</small></div>" : "") +
                    (option.detail.DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>" + Siga.Mensagem.SIS0104 + ": " + option.detail.DocumentoEstadual + "</small></div>" : "");


                    output +=
                    "   </div>" +
                    "</div>";

                    return output;
                }
            );
        },
    }
}();


Siga.TES.Deposito = function () {
    var servico = "../TES/DepositoWS.asmx";

    return {
        SelecionarValorDisponivel: function (codigoCompetencia, data, callback) {
            var dto = {};
            dto.codigoCompetencia = codigoCompetencia;
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/SelecionarValorDisponivel", dto, callback);
        },

        SelecionarValorDisponivelSemCompetencia: function (data, callback) {
            var dto = {};
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/SelecionarValorDisponivelSemCompetencia", dto, callback);
        }
    }
}();

Siga.TES.Despesa = function () {
    var servico = "../TES/DespesaWS.asmx";

    return {
        SelecionarValorDisponivel: function (codigoConta, data, callback) {
            var dto = {};
            dto.codigoConta = codigoConta;
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/SelecionarValorDisponivel", dto, callback);
        },
        SelecionarExistente: function (codigoPessoa, data, documento, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.data = data;
            dto.documento = documento;

            Siga.UTIL.Ajax(servico + "/SelecionarExistente", dto, callback);
        }
    }
}();

Siga.TES.Fatura = function () {
    var servico = "../TES/FaturaWS.asmx";

    return {
        AdicionarMes: function (sdata, callback) {
            var dto = {};
            dto.sdata = sdata;

            Siga.UTIL.Ajax(servico + "/AdicionarMes", dto, callback);
        },

        ValidaDataParcela: function (f_data1, f_data2, callback) {
            var dto = {};
            dto.f_data1 = f_data1;
            dto.f_data2 = f_data2;

            Siga.UTIL.Ajax(servico + "/ValidaDataParcela", dto, callback);
        },

        SelecionarAdiantamentos: function (listaAdiantamentosSelecionados, codigoPessoa, callback) {
            var dto = {};
            dto.listaAdiantamentosSelecionados = listaAdiantamentosSelecionados;
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarAdiantamentos", dto, callback);
        }
    }
}();

Siga.TES.TransferenciaNumerario = function () {
    var servico = "../TES/TransferenciaNumerarioWS.asmx";

    return {
        SelecionarExterna: function (codigoTransferenciaNumerario, codigoCompetencia, callback) {
            var dto = {};
            dto.codigoCompetencia = codigoCompetencia;
            dto.codigoTransferenciaNumerario = codigoTransferenciaNumerario;

            Siga.UTIL.Ajax(servico + "/SelecionarExterna", dto, callback);
        },

        SelecionarInterna: function (codigoTransferenciaNumerario, codigoCompetencia, codigoEstabelecimentoContrapartida, callback) {
            var dto = {};
            dto.codigoCompetencia = codigoCompetencia;
            dto.codigoTransferenciaNumerario = codigoTransferenciaNumerario;
            dto.codigoEstabelecimentoContrapartida = codigoEstabelecimentoContrapartida;

            Siga.UTIL.Ajax(servico + "/SelecionarInterna", dto, callback);
        },

        SelecionarCompetencia: function (codigoEstabelecimentoContrapartida, callback) {
            var dto = {};
            dto.codigoEstabelecimentoContrapartida = codigoEstabelecimentoContrapartida;

            Siga.UTIL.Ajax(servico + "/SelecionarCompetencia", dto, callback);
        }
    }
}();

Siga.TES.StatusTransferenciaNumerario = function () {
    var servico = "../TES/StatusTransferenciaNumerarioWS.asmx";

    return {
        Selecionar: function (tipo, callback) {
            var dto = {};
            dto.tipo = tipo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.TES.TipoTransferenciaNumerario = function () {
    var servico = "../TES/TipoTransferenciaNumerarioWS.asmx";

    return {
        Selecionar: function (indColeta, callback) {
            var dto = {};
            dto.indColeta = indColeta;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();


Siga.TES.TipoColetaTraducao = function () {
    var servico = "../TES/TipoColetaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();


Siga.TES.Rateio = function () {
    var mensagem = {};
    return {
        CarregarTela: function (mensagens, sep, dec) {
            mensagem = mensagens;

            function AdicionarItemRateio(codigoDespesa, nomeDespesa, codigoCentroCusto, nomeCentroCusto, percentual, valor) {


                var error = false;
                var errorMessage = mensagem.m;
                var errorField = null;
                var select = false;

                if (codigoDespesa == "") {
                    error = true;
                    errorMessage += mensagem.m1;
                    errorField = $("#f_despesa_rateio");
                    select = true;
                }

                if (codigoCentroCusto == "") {
                    error = true;
                    errorMessage += mensagem.m2;
                    errorField = $("#f_centrocusto_rateio");
                    select = true;
                }

                if (Siga.Decimal.ConverterNumeroCientifico(percentual) == 0 || Siga.Decimal.ConverterNumeroCientifico(valor) == 0) {
                    error = true;
                    errorMessage += mensagem.m3;
                    errorField = $("#f_percentual_rateio");
                    select = false;
                }

                for (var i = 0; i < arrRateio.length; i++) {
                    if (arrRateio[i].CodigoCentroCusto == codigoCentroCusto && arrRateio[i].CodigoDespesa == codigoDespesa) {
                        error = true;
                        errorMessage += mensagem.m4;
                        errorField = $("#f_despesa_rateio");
                        select = true;
                        break;
                    }
                }

                var valorDocumento = Siga.Decimal.TryParse($("#f_valor").autoNumeric('get'));
                var somatorioValor = 0;

                var i = arrRateio.length;
                while (i--) {
                    somatorioValor += parseFloat(arrRateio[i].Valor.replace(".", "").replace(",", "") / 100);
                }
                somatorioValor += Siga.Decimal.TryParse($("#f_valor_rateio").autoNumeric("get"));

                if (parseFloat(somatorioValor.toFixed(2)) > valorDocumento) {
                    error = true;
                    errorMessage += mensagem.m5;
                    errorField = $("#f_percentual_rateio");
                }

                errorMessage += "</ul>";

                if (error) {
                    Siga.UTIL.Mensagem("alerta", errorMessage, function (e) {
                        if (errorField != null) {
                            setTimeout(function () { if (select) { errorField.select2('focus'); } else { errorField.focus(); } }, 100);
                        }
                        return;
                    });
                    return;
                } else {

                    /* Inclui o Rateio */

                    if (parseFloat(somatorioValor.toFixed(2)) < valorDocumento) {       // Se há resto para informar
                        // Dados do novo rateio
                        codigoRateio++;
                        var rateioInserido = {};
                        rateioInserido.Sequencia = parseInt($("#td_sequencia_rateio").html());
                        rateioInserido.CodigoCentroCusto = codigoCentroCusto;
                        rateioInserido.NomeCentroCusto = nomeCentroCusto;
                        rateioInserido.Percentual = percentual;
                        rateioInserido.Valor = valor;
                        rateioInserido.CodigoDespesa = codigoDespesa;
                        rateioInserido.NomeDespesa = nomeDespesa;
                        rateioInserido.Codigo = codigoRateio;

                        arrRateio.push(rateioInserido);

                        $.tmpl(
                            $("#row-rateio").text(),
                            rateioInserido
                        ).insertBefore("#tr-rateio-mestre");

                        setObjToCurrency($("#g-valor-" + codigoRateio));

                        $("#f_valor_rateio").autoNumeric('set', (valorDocumento - somatorioValor).toFixed(2));
                        $("#f_valor_rateio").trigger("change");

                        $("#td_sequencia_rateio").html(rateioInserido.Sequencia + 1);

                        $("#f_despesa_rateio").val('').trigger("change");
                        $("#f_despesa_rateio").select2('focus');
                        $("#f_centrocusto_rateio").val('').trigger("change");
                    } else {                                                            // Se já informou tudo vai pro próximo campo
                        $("#f_fornecedor").select2("focus");
                    }

                    $("#b-rateio-excluir-" + codigoRateio).click(function (e) {
                        e.preventDefault();

                        var codigo = $(this).data("codigo");

                        var strMensagem = mensagem.exclusao;
                        strMensagem = strMensagem.replace("{centro_custo}", $("#g-nomeCentroCusto-" + codigo).html()).replace("{despesa}", $("#g-nomeDespesa-" + codigo).html());

                        var tr = $(this).closest('tr');

                        Siga.UTIL.Confirmacao(strMensagem, function () {
                            tr.fadeOut(400, function () {
                                tr.remove();

                                i = arrRateio.length;
                                while (i--) {
                                    if (arrRateio[i].Codigo == codigo) {
                                        arrRateio.splice(i, 1);
                                        break;
                                    }
                                }

                                valorDocumento = Siga.Decimal.TryParse($("#f_valor").autoNumeric('get'));
                                somatorioValor = 0;

                                i = arrRateio.length;
                                while (i--) {
                                    somatorioValor += parseFloat(arrRateio[i].Valor.replace(".", "").replace(",", "."));//parseFloat(arrRateio[i].Valor.replace(".", "").replace(",", "."));
                                }

                                $("#f_valor_rateio").autoNumeric('set', (valorDocumento - somatorioValor).toFixed(2));
                                $("#f_valor_rateio").trigger("change");

                                var iNewSeq = 1;
                                $(".col-sequencia").each(function () {
                                    $(this).html(iNewSeq);
                                    iNewSeq++;
                                });
                            });
                        });
                    });
                }
            }

            $(".percentual").each(function (e) {
                if ($(this).attr("type") == "text") {
                    $(this).attr("type", "tel");
                }

                $(this).css("text-align", "right");

                $(this).autoNumeric(
                    'init',
                    {
                        aSep: "<%= System.Globalization.CultureInfo.CurrentUICulture.NumberFormat.CurrencyGroupSeparator %>",
                        aDec: "<%= System.Globalization.CultureInfo.CurrentUICulture.NumberFormat.CurrencyDecimalSeparator %>",
                        mDec: 2,
                        vMax: 100.00
                    }
                    );
            });

            $("#f_percentual_rateio").change(function () {
                var valorDocumento = Siga.Decimal.TryParse($("#f_valor").autoNumeric('get'));
                var percentualRateio = Siga.Decimal.TryParse($(this).autoNumeric('get'));

                var valorRateio = (valorDocumento * percentualRateio / 100).toFixed(2);

                var valorRestante = 0;
                var somatorioValor = 0;
                var somatorioPercentual = 0;
                var i = arrRateio.length;

                while (i--) {
                    somatorioPercentual += parseFloat(arrRateio[i].Percentual.replace(".", "").replace(",", "") / 100);
                    somatorioValor += parseFloat(arrRateio[i].Valor.replace(".", "").replace(",", "") / 100);
                }

                somatorioPercentual += percentualRateio;
                valorRestante = valorDocumento - somatorioValor;

                if (somatorioPercentual == 100) {
                    valorRateio = valorRestante;
                }

                $("#f_valor_rateio").autoNumeric('set', valorRateio);
            });

            $("#f_valor_rateio").change(function () {
                var valorDocumento = Siga.Decimal.TryParse($("#f_valor").autoNumeric('get'));
                var valorRateio = Siga.Decimal.TryParse($(this).autoNumeric('get'));

                if (valorRateio > valorDocumento) {
                    Siga.UTIL.Mensagem("alerta", Siga.Mensagem.SIS0105, function (e) {
                        setTimeout(function () { $("#f_valor_rateio").focus(); }, 100);
                        return;
                    });
                    return;
                }

                var percentualRateio = ((valorRateio / valorDocumento).toFixed(4) * 100).toFixed(2);

                $("#f_percentual_rateio").autoNumeric('set', percentualRateio);
            });

            $('#f_valor_rateio').on('keydown', function (e) {
                if (e.keyCode == 9 || e.keyCode == 13) //tab - enter
                {
                    $(this).trigger("blur");
                    //Adiciona Item Rateio           
                    AdicionarItemRateio($("#f_despesa_rateio").val(),
                                        $.trim($("#f_despesa_rateio option:selected").html().replace(/&nbsp;/g, "").replace(/" "/g, "")),
                                        $("#f_centrocusto_rateio").val(),
                                        $("#f_centrocusto_rateio").select2('data') != null ? $.trim($("#f_centrocusto_rateio").select2('data').text.replace(/&nbsp;/g, "").replace(/" "/g, "")) : "",
                                        $("#f_percentual_rateio").val(),
                                        $("#f_valor_rateio").val()
                                    );

                    return false;
                }
            });

            function setObjToCurrency(obj) {
                if ($(obj).attr("type") == "text") {
                    $(obj).attr("type", "tel");
                }

                $(obj).css("text-align", "right");

                var _vMax = $(obj).data("vmax") != null ? Siga.Decimal.TryParse($(obj).data("vmax")) : 99999999.99;

                $(obj).autoNumeric(
                    'init',
                    {
                        aSep: sep,
                        aDec: dec,
                        mDec: 2,
                        vMax: _vMax
                    }
                    );
            }
        },

        MudarValor: function (valorDocumento) {
            if (valorDocumento == 0) {
                $("#f_despesa_rateio").select2("enable", false);
                $("#f_centrocusto_rateio").select2("enable", false);
                $("#f_percentual_rateio").prop("disabled", "disabled");
                $("#f_valor_rateio").prop("disabled", "disabled");
            } else {
                $("#f_despesa_rateio").select2("enable", true);
                $("#f_centrocusto_rateio").select2("enable", true);
                $("#f_percentual_rateio").prop('disabled', false);
                $("#f_valor_rateio").prop('disabled', false);

                var percentualUtilizado = 0;
                var valorNovo = 0;
                var somatorioValor = 0;
                var somatorioValorReal = 0;

                var indices = []
                $(".linha_rateio").each(function () {
                    indices.push(parseInt($(this).data("codigo")));
                });

                var i = arrRateio.length;
                while (i--) {
                    var x = indices[i];
                    percentualUtilizado = parseFloat(arrRateio[i].Percentual.replace(".", "").replace(",", "") / 100);
                    valorNovo = percentualUtilizado * valorDocumento / 100;

                    //indice das linhas não editáveis começa e m 0                           
                    $("#g-valor-" + x).autoNumeric("set", parseFloat(valorNovo.toFixed(2)));
                    $("#f_valor_rateio_" + x).val($("#g-valor-" + x).val());
                    arrRateio[i].Valor = valorNovo.toFixed(2);
                    somatorioValor += valorNovo;
                    somatorioValorReal += valorNovo.toFixed(2);
                }

                percentualUtilizado = Siga.Decimal.TryParse($("#f_percentual_rateio").autoNumeric("get"));
                valorNovo = percentualUtilizado * valorDocumento / 100;
                $("#f_valor_rateio").autoNumeric("set", valorNovo.toFixed(2));
                $("#f_percentual_rateio").trigger("change");
            }
        },

        AdicionaItemRateioEditar: function (sep, dec, sequencia, codigoDespesa, nomeDespesa, codigoCentroCusto, nomeCentroCusto, percentual, valor, ultimo) {

            if (!ultimo) {       // Se não é o último rateio
                var valorDocumento = Siga.Decimal.TryParse($("#f_valor").autoNumeric('get'));
                percentual = ((valor / valorDocumento).toFixed(4) * 100).toFixed(2);
                percentual = (percentual + "").replace(".", ",");

                valor = valor.toFixed(2);
                valor = (valor + "").replace(".", ",");

                codigoRateio++
                // Dados do novo rateio
                var rateioInserido = {};
                rateioInserido.Sequencia = parseInt(sequencia);
                rateioInserido.CodigoCentroCusto = codigoCentroCusto;
                rateioInserido.NomeCentroCusto = nomeCentroCusto;
                rateioInserido.Percentual = percentual;
                rateioInserido.Valor = valor;
                rateioInserido.CodigoDespesa = codigoDespesa;
                rateioInserido.NomeDespesa = nomeDespesa;
                rateioInserido.Codigo = codigoRateio;

                arrRateio.push(rateioInserido);

                $.tmpl(
                    $("#row-rateio").text(),
                    rateioInserido
                ).insertBefore("#tr-rateio-mestre");

                setObjToCurrency($("#g-valor-" + codigoRateio));

                $("#b-rateio-excluir-" + codigoRateio).click(function (e) {
                    e.preventDefault();

                    var codigo = $(this).data("codigo");
                    valorDocumento = Siga.Decimal.TryParse($("#f_valor").autoNumeric('get'));
                    var strMensagem = mensagem.exclusao;
                    strMensagem = strMensagem.replace("{centro_custo}", $("#g-nomeCentroCusto-" + codigo).html()).replace("{despesa}", $("#g-nomeDespesa-" + codigo).html());

                    var tr = $(this).closest('tr');

                    Siga.UTIL.Confirmacao(strMensagem, function () {
                        tr.fadeOut(400, function () {
                            tr.remove();

                            i = arrRateio.length;
                            while (i--) {
                                if (arrRateio[i].Codigo == codigo) {
                                    arrRateio.splice(i, 1);
                                    break;
                                }
                            }

                            var somatorioValor = 0;

                            i = arrRateio.length;
                            while (i--) {
                                somatorioValor += parseFloat(arrRateio[i].Valor.replace(".", "").replace(",", "."));//parseFloat(arrRateio[i].Valor.replace(".", "").replace(",", "."));
                            }

                            $("#f_valor_rateio").autoNumeric('set', (valorDocumento - somatorioValor).toFixed(2));
                            $("#f_valor_rateio").trigger("change");

                            var iNewSeq = 1;
                            $(".col-sequencia").each(function () {
                                $(this).html(iNewSeq);
                                iNewSeq++;
                            });
                        });
                    });
                });
            } else { // O último rateio precisa ser editável para o usuário poder alterar
                codigoRateio++;

                $("#td_sequencia_rateio").html(sequencia);
                $("#f_despesa_rateio").val(codigoDespesa);
                $("#f_despesa_rateio").trigger("change");
                $("#f_centrocusto_rateio").val(codigoCentroCusto);
                $("#f_centrocusto_rateio").trigger("change");
                $("#f_valor_rateio").autoNumeric("set", valor);
                $("#f_valor_rateio").trigger("change");
            }

            function setObjToCurrency(obj) {
                if ($(obj).attr("type") == "text") {
                    $(obj).attr("type", "tel");
                }

                $(obj).css("text-align", "right");

                var _vMax = $(obj).data("vmax") != null ? Siga.Decimal.TryParse($(obj).data("vmax")) : 99999999.99;

                $(obj).autoNumeric(
                    'init',
                    {
                        aSep: sep,
                        aDec: dec,
                        mDec: 2,
                        vMax: _vMax
                    }
                    );
            }
        }
    }
}();

Siga.TES.Coleta = function () {
    var servico = "../TES/ColetaWS.asmx";

    return {
        Selecionar: function (codigoColeta, data, callback) {
            var dto = {};
            dto.codigoColeta = codigoColeta;
            dto.data = data;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();