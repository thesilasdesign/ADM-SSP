//Lib para pesquisa de CPF e CNPJ no site da Receita Federal
Siga.RFB = {};

Siga.RFB.Captcha = function () {
    return {
        GerarCNPJ: function ($img) {
            $.ajax({
                type: "POST",
                url: "../UTIL/RFBWS.asmx/RetornaCaptchaCNPJBitmap",
                contentType: "application/json; charset=iso-8859-1",
                dataType: "json",
                success: function (response) {
                    $img.attr("src", "data:image/jpg;base64," + response.d);
                }
            });
        },

        GerarCPF: function ($img) {
            $.ajax({
                type: "POST",
                url: "../UTIL/RFBWS.asmx/RetornaCaptchaCPFBitmap",
                contentType: "application/json; charset=iso-8859-1",
                dataType: "json",
                success: function (response) {
                    $img.attr("src", "data:image/jpg;base64," + response.d);
                }
            });
        }
    }
}();


Siga.RFB.Consulta = function () {
    return {
        CNPJ: function (campos) {

            var camposTela = $.extend({
                CNPJ: null,
                Captcha: null,
                imgCaptcha: null,
                RazaoSocial: null,
                NomeFantasia: null,
                CEP: null,
                Logradouro: null,
                Numero: null,
                Complemento: null,
                Bairro: null,
                Cidade: null,
                Estado: null,
                Observacao: null,
                jqForm: null
            }, campos);


            $.ajax({
                type: "POST",
                url: "../UTIL/RFBWS.asmx/ConsultaCNPJ",
                data: "{ cnpj: '" + camposTela.CNPJ.val() + "', captcha: '" + camposTela.Captcha.val() + "'}",
                contentType: "application/json; charset=iso-8859-1",
                dataType: "json",
                success: function (response) {
                    var consulta = response.d;

                    if (consulta == null)
                        return;

                    if (consulta.DadosCNPJ == null)
                        return;


                    if (consulta.TemErro) {
                        Siga.UTIL.Mensagem("alerta", consulta.ErroDetectado, function () {
                            Siga.RFB.Captcha.GerarCNPJ(camposTela.imgCaptcha);
                            setTimeout(function () {
                                camposTela.Captcha.val('');
                                camposTela.Captcha.focus();
                            }, 500);
                        });
                    }
                    else {

                        if (camposTela.RazaoSocial != null) camposTela.RazaoSocial.val("");
                        if (camposTela.NomeFantasia != null) camposTela.NomeFantasia.val("");
                        if (camposTela.CEP != null) camposTela.CEP.val("");
                        if (camposTela.Logradouro != null) camposTela.Logradouro.val("");
                        if (camposTela.Numero != null) camposTela.Numero.val("");
                        if (camposTela.Complemento != null) camposTela.Complemento.val("");
                        if (camposTela.Bairro != null) camposTela.Bairro.val("");
                        if (camposTela.Cidade != null) camposTela.Cidade.val("");
                        if (camposTela.Estado != null) {
                            camposTela.Estado.val(camposTela.Estado.find("[data-sigla=SP]").attr("value"));
                            camposTela.Estado.trigger('change');
                        }
                        if (camposTela.Observacao != null) camposTela.Observacao.val("");

                        if (consulta.DadosCNPJ.SituacaoCadastral !== 'ATIVA') {
                            var mensagem = Siga.Mensagem.SIS0094 + " <br /><br /><ul>";
                            if (consulta.DadosCNPJ.SituacaoCadastral == null)
                                mensagem = Siga.Mensagem.SIS0095;
                            if (consulta.DadosCNPJ.NumeroInscricao != null)
                                mensagem += "<li><strong>" + Siga.Mensagem.SIS0092 + "</strong> " + consulta.DadosCNPJ.NumeroInscricao + "</li>";
                            if (consulta.DadosCNPJ.RazaoSocial != null)
                                mensagem += "<li><strong>" + Siga.Mensagem.SIS0096 + "</strong> " + consulta.DadosCNPJ.RazaoSocial + "</li>";
                            if (consulta.DadosCNPJ.SituacaoCadastral != null)
                                mensagem += "<li><strong>" + Siga.Mensagem.SIS0097 + "</strong> " + consulta.DadosCNPJ.SituacaoCadastral + "</li>";
                            mensagem += "</ul>";
                            Siga.UTIL.Mensagem("alerta", mensagem, function () {
                                Siga.RFB.Captcha.GerarCNPJ(camposTela.imgCaptcha);
                                setTimeout(function () { camposTela.Captcha.val(""); camposTela.Captcha.focus(); }, 200);
                            });
                        }
                        else {

                            if (camposTela.RazaoSocial != null) camposTela.RazaoSocial.val(consulta.DadosCNPJ.RazaoSocial.substr(0, 80));
                            if (camposTela.NomeFantasia != null) camposTela.NomeFantasia.val(consulta.DadosCNPJ.NomeFantasia.substr(0, 80));
                            if (camposTela.CEP != null) camposTela.CEP.val(consulta.DadosCNPJ.CEP);
                            if (camposTela.Logradouro != null) camposTela.Logradouro.val(consulta.DadosCNPJ.Logradouro.substr(0, 80));
                            if (camposTela.Numero != null) camposTela.Numero.val(consulta.DadosCNPJ.Numero);
                            if (camposTela.Complemento != null) camposTela.Complemento.val(consulta.DadosCNPJ.Complemento.substr(0, 80));
                            if (camposTela.Bairro != null) camposTela.Bairro.val(consulta.DadosCNPJ.Bairro.substr(0, 80));
                            if (camposTela.Cidade != null) camposTela.Cidade.val(consulta.DadosCNPJ.Municipio.substr(0, 80));
                            if (camposTela.Estado != null) {
                                camposTela.Estado.find("[data-sigla=" + consulta.DadosCNPJ.UF + "]").attr("selected", "selected");
                                camposTela.Estado.val(camposTela.Estado.find("[data-sigla=" + consulta.DadosCNPJ.UF + "]").attr("value"));
                                camposTela.Estado.select2().change();
                            }
                            if (camposTela.Observacao != null) camposTela.Observacao.val(consulta.DadosCNPJ.CodigoNaturezaJuridica + '\n' +
                                                                                         consulta.DadosCNPJ.CodigoAtividadeEconomicaPrincipal + '\n' +
                                                                                         consulta.DadosCNPJ.CodigoAtividadeEconomicaSecundaria);

                            Siga.UTIL.CloseModal(camposTela.jqForm, true, null);
                        }
                    }
                }
            });
        },

        CPF: function (campos) {
            var camposTela = $.extend({
                CPF: null,
                DataNascimento: null,
                Captcha: null,
                imgCaptcha: null,
                Nome: null,
                Situacao: null,
                jqForm: null
            }, campos);

            $.ajax({
                type: "POST",
                url: "../UTIL/RFBWS.asmx/ConsultaCPF",
                data: "{ cpf: '" + camposTela.CPF.val() + "', datanascimento: '" + camposTela.DataNascimento.val() + "', captcha: '" + camposTela.Captcha.val() + "' }",
                contentType: "application/json; charset=iso-8859-1",
                dataType: "json",
                success: function (response) {
                    var consulta = response.d;

                    if (consulta == null)
                        return;

                    if (consulta.TemErro) {
                        Siga.UTIL.Mensagem("alerta", consulta.ErroDetectado, function () {
                            Siga.RFB.Captcha.GerarCPF(camposTela.imgCaptcha);
                            setTimeout(function () {
                                camposTela.Captcha.val('');
                                camposTela.Captcha.focus();
                            }, 500);
                        });
                    }
                    else {

                        if (camposTela.Nome != null) camposTela.Nome.val("");
                        if (camposTela.Situacao != null) camposTela.Situacao.val("");

                        if (consulta.DadosCPF.Situacao !== 'REGULAR') {
                            Siga.UTIL.Mensagem("alerta", Siga.Mensagem.SIS0098 + " <br /><br />" +
                                                       "<ul>" +
                                                       "<li><strong>" + Siga.Mensagem.SIS0093 + "</strong> " + camposTela.CPF.val() + "</li>" +
                                                       "<li><strong>" + Siga.Mensagem.SIS0099 + "</strong> " + (consulta.DadosCP != null ? consulta.DadosCPF.Nome : Siga.Mensagem.SIS0100) + "</li>" +
                                                       "<li><strong>" + Siga.Mensagem.SIS0097 + "</strong> " + (consulta.DadosCP != null ? consulta.DadosCPF.Situacao : Siga.Mensagem.SIS0100) + "</li>" +
                                                       "</ul>", function () {
                                                           Siga.RFB.Captcha.GerarCPF(camposTela.imgCaptcha);
                                                           setTimeout(function () { camposTela.Captcha.val(""); camposTela.Captcha.focus(); }, 200);
                                                       });
                        }
                        /*Permite a busca do nome mesmo quando irregular*/
                        if (consulta.DadosCPF != null && consulta.DadosCPF != undefined) {
                            if (camposTela.Nome != null) camposTela.Nome.val(consulta.DadosCPF.Nome != null ? consulta.DadosCPF.Nome.substr(0, 80) : "");
                            if (camposTela.Situacao != null) camposTela.Situacao.val(consulta.DadosCPF.Situacao != null ? consulta.DadosCPF.Situacao : "");
                        }

                        Siga.UTIL.CloseModal(camposTela.jqForm, true, null);
                    }
                }
            });
        }
    }
}();