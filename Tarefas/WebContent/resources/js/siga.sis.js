Siga.SIS = {}

Siga.SIS.Rotina = function () {
    var servico = "../SIS/RotinaWS.asmx";

    return {
        Selecionar: function (codigoModulo, callback) {
            var dto = {};
            dto.codigoModulo = codigoModulo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.Programa = function () {
    var servico = "../SIS/ProgramaWS.asmx";

    return {
        Selecionar: function (codigoRotina, callback) {
            var dto = {};
            dto.codigoRotina = codigoRotina;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        Executar: function (codigoPrograma, callback) {
            var dto = {};
            dto.codigoPrograma = codigoPrograma;

            Siga.UTIL.Ajax(servico + "/Executar", dto, callback);
        }
    }
}();

Siga.SIS.ChaveParametro = function () {
    var servico = "../SIS/ChaveParametroWS.asmx";

    return {
        Selecionar: function (codigoModulo, callback) {
            var dto = {};
            dto.codigoModulo = codigoModulo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.Parametro = function () {
    var servico = "../SIS/ParametroWS.asmx";

    return {
        Selecionar: function (codigoEmpresa, codigoTipoEstabelecimento, codigoEstabelecimento, codigoModulo, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoModulo = codigoModulo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarPorModulo: function (codigoEmpresa, codigoTipoEstabelecimento, codigoEstabelecimento, codigoModulo, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoTipoEstabelecimento = codigoTipoEstabelecimento;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoModulo = codigoModulo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorModulo", dto, callback);
        }
    }
}();

Siga.SIS.Permissao = function () {
    var servico = "../SIS/PermissaoWS.asmx";

    return {
        Selecionar: function (codigoRotina, callback) {
            var dto = {};
            dto.codigoRotina = codigoRotina;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.PessoaEndereco = function () {
    var servico = "../SIS/PessoaEnderecoWS.asmx";

    return {
        Selecionar: function (codigoPessoa, principal, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.principal = principal;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        },

        SelecionarPorTipo: function (codigoPessoa, codigoTipoEndereco, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.codigoTipoEndereco = codigoTipoEndereco;

            Siga.UTIL.Ajax(servico + "/SelecionarPorTipo", dto, callback);
        },

        SelecionarPorTipoEstabelecimento: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarPorTipoEstabelecimento", dto, callback);
        },

        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        },

        SelecionarCidadeVW: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarCidadeVW", dto, callback);
        },

        SelecionarEmpresa: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/SelecionarEmpresa", dto, callback);
        }
    }
}();

Siga.SIS.PessoaContato = function () {
    var servico = "../SIS/PessoaContatoWS.asmx";

    return {
        Selecionar: function (codigoPessoa, principal, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.principal = principal;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.SIS.UsuarioPerfilBI = function () {
    var servico = "../SIS/UsuarioPerfilBIWS.asmx";

    return {
        Selecionar: function (codigoUsuario, callback) {
            var dto = {};
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        Excluir: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/Excluir", dto, callback);
        }
    }
}();

Siga.SIS.PessoaBanco = function () {
    var servico = "../SIS/PessoaBancoWS.asmx";

    return {
        Selecionar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.CartaoIdentificacao = function () {
    var servico = "../SIS/CartaoIdentificacaoWS.asmx";

    return {
        Selecionar: function (numero, codigoControleAcesso, callback) {
            var dto = {};
            dto.numero = numero;
            dto.codigoControleAcesso = codigoControleAcesso;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.Municipio = function () {
    var servico = "../SIS/MunicipioWS.asmx";

    return {
        Selecionar: function (codigoEstados, callback) {
            var dto = {};
            dto.codigoEstados = codigoEstados;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.Estado = function () {
    var servico = "../SIS/EstadoWS.asmx";

    return {
        Selecionar: function (codigoPais, codigoRegioes, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;
            dto.codigoRegioes = codigoRegioes;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarPorPais: function (codigoPais, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPais", dto, callback);
        },
        SelecionarPorPaisBI: function (codigoPais, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPaisBI", dto, callback);
        }
    }
}();

Siga.SIS.Regiao = function () {
    var servico = "../SIS/RegiaoWS.asmx";

    return {
        Selecionar: function (codigoPais, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarEmLote: function (codigoPais, callback) {
            var dto = {};
            dto.codigoPais = codigoPais;

            Siga.UTIL.Ajax(servico + "/SelecionarEmLote", dto, callback);
        }
    }
}();

Siga.SIS.PessoaCargoMinisterioFuncao = function () {
    var servico = "../SIS/PessoaCargoMinisterioFuncaoWS.asmx";

    return {
        Selecionar: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarAtivos: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarAtivos", dto, callback);
        },

        SelecionarNaoAtivos: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarNaoAtivos", dto, callback);
        },

        SelecionarVWPorCodigo: function (codigoPessoa, codigoEmpresa, codigoEstabelecimento, codigoCargoMinisterioFuncao, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoCargoMinisterioFuncao = codigoCargoMinisterioFuncao;

            Siga.UTIL.Ajax(servico + "/SelecionarVWPorCodigo", dto, callback);
        },

        ExisteCargo: function (codigoPessoa, codigoEstabelecimento, codigoCargoMinisterioFuncao, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoCargoMinisterioFuncao = codigoCargoMinisterioFuncao;

            Siga.UTIL.Ajax(servico + "/ExisteCargo", dto, callback);
        },

        SelecionarPorEstabelecimento: function (codigoEmpresa, codigoEstabelecimento, codigoCargoMinisterioFuncao, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.codigoEstabelecimento = codigoEstabelecimento;
            dto.codigoCargoMinisterioFuncao = codigoCargoMinisterioFuncao;

            Siga.UTIL.Ajax(servico + "/SelecionarPorEstabelecimento", dto, callback);
        },

        SelecionarParaJuridico: function (codigoEmpresa, tipoProcesso, codigoProcesso, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;
            dto.tipoProcesso = tipoProcesso;
            dto.codigoProcesso = codigoProcesso;

            Siga.UTIL.Ajax(servico + "/SelecionarParaJuridico", dto, callback);
        },

        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        }
    }
}();

Siga.SIS.Usuario = function () {
    var servico = "../SIS/UsuarioWS.asmx";

    return {
        ValidaLogin: function (login, codigoUsuario, callback) {
            var dto = {};
            dto.login = login;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/ValidaLogin", dto, callback);
        },

        SelecionarInfinitoChamados: function (campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarInfinitoChamados ",
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

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span12' style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Nome +
                            "       </div>" +
                            "   </div>" +
                            "</div> ";

                    return output;
                }
            );
        },

        SelecionarInfinitoParaFiltro: function(campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjax(
                campo,
                servico + "/SelecionarTermoParaFiltro",
                textoSelecione,
                function (term, page) {
                    return JSON.stringify({
                        termo: term
                    });
                },
                function (item, data) {
                    item.id = data.Codigo;
                    item.text = data.Nome;
                    item.tag = data.Tag;
                    item.disabled = data.Disabled == "S";
                },
                function (option, label, query, escapeMarkup) {
                    return option.tag;
                }
            )
        },

        Selecionar: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarComPermissao: function (codigoEstabelecimento, callback) {
            var dto = {};
            dto.codigoEstabelecimento = codigoEstabelecimento;

            Siga.UTIL.Ajax(servico + "/SelecionarComPermissao", dto, callback);
        },

        SelecionarTermo: function (termo, callback) {
            var dto = {};
            dto.termo = termo;

            Siga.UTIL.Ajax(servico + "/SelecionarTermo", dto, callback);
        },

        SelecionarPorArea: function (codigoArea, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;

            Siga.UTIL.Ajax(servico + "/SelecionarPorArea", dto, callback);
        },

        SelecionarPorAreaAtivo: function (codigoArea, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;

            Siga.UTIL.Ajax(servico + "/SelecionarPorAreaAtivo", dto, callback);
        },

        SelecionarPorAreaUsuario: function (codigoArea, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;

            Siga.UTIL.Ajax(servico + "/SelecionarPorAreaUsuario", dto, callback);
        },

        SelecionarPorAreaUsuarioAbertura: function (codigoArea, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;

            Siga.UTIL.Ajax(servico + "/SelecionarPorAreaUsuarioAbertura", dto, callback);
        },

        ValidaSenhaAtual: function (senha, callback) {
            var dto = {};
            dto.senha = senha;

            Siga.UTIL.Ajax(servico + "/ValidaSenhaAtual", dto, callback);
        },

        ValidaSenha: function (codigoUsuario, senha, callback) {
            var dto = {};
            dto.codigoUsuario = codigoUsuario;
            dto.senha = senha;

            Siga.UTIL.Ajax(servico + "/ValidaSenha", dto, callback);
        },

        GerarSenhaTemporaria: function (callback) {
            var dto = {};
            Siga.UTIL.Ajax(servico + "/GerarSenhaTemporaria", dto, callback);
        },
        ExcluirAcessoGlobal: function (codigoUsuario, callback) {
            var dto = {};
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/ExcluirAcessoGlobal", dto, callback);
        }
    }
}();

Siga.SIS.SolicitacaoSenha = function () {
    var servico = "SIS/SolicitacaoSenhaWS.asmx";

    return {
        ReiniciarSenha: function (login, callback) {
            var dto = {};
            dto.login = login;

            Siga.UTIL.Ajax(servico + "/ReiniciarSenha", dto, callback);
        }
    }
}();

Siga.SIS.Cep = function () {
    var servico = "../SIS/CepWS.asmx";

    return {

        PesquisaCEP: function (campos, callback) {

            var camposTela = $.extend({
                CEP: null,
                Logradouro: null,
                Bairro: null,
                UF: null,
                Localidade: null,
                Complemento: null,
                GuidValue: ''
            }, campos);

            var enabled = !camposTela.CEP.prop('disabled');

            if (enabled) {

                var label = $(camposTela.CEP).closest(".control-group").find(".control-label");
                if (label != null) {
                    $(label).append("<span id='btn-busca-cep-" + camposTela.GuidValue + "' class='hidden-phone blue pull-right'><i class='icon-search' /></span>");
                }

                $("#btn-busca-cep-" + camposTela.GuidValue).click(function () {
                    Siga.UTIL.ShowModal("../SIS/SIS99910.aspx", function (ret, data) {
                        if (ret == true) {
                            camposTela.CEP.val(data.CEP);
                            camposTela.Logradouro.val(data.Logradouro);
                            camposTela.Bairro.val(data.Bairro);
                            camposTela.UF.val(camposTela.UF.find("[data-sigla=" + data.UF + "]").attr("value"));
                            camposTela.UF.attr("selected", true);
                            camposTela.UF.data('sigla', data.UF);
                            camposTela.UF.trigger('change');
                            camposTela.Localidade.val(data.Localidade);
                            camposTela.Localidade.data('text', data.Localidade);
                            camposTela.Localidade.trigger('change');
                            camposTela.Complemento.val(data.Descricao);
                            if (callback != null) {
                                callback();
                            }
                        }
                    }, null, "modal-large");
                });
            }
        },

        ListarCEP: function (uf, cidade, logradouro, callback) {
            var dto = {};
            dto.uf = uf;
            dto.cidade = cidade;
            dto.logradouro = logradouro;

            Siga.UTIL.Ajax(servico + "/ListarCEP", dto, callback);
        },

        ListarCidade: function (uf, callback) {
            var dto = {};
            dto.uf = uf;

            Siga.UTIL.Ajax(servico + "/ListarCidade", dto, callback);
        },

        ListarCidadeInfinito: function (pais, uf, campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/ListarCidadeInfinito",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.pais = pais;
                    dto.uf = uf;
                    dto.term = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var output =
                            "<div class='select2-customresult'>" +
                            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px; padding-top: 4px'>" +
                            "       <div class='span10' " +
                            "            data-text='" + option.detail.Localidade + "' " +
                            "            style='min-height: 24px'>&nbsp;&nbsp;" + option.detail.Localidade +
                            "       </div>" +
                            "       <div class='span2' style='min-height: 24px'>" + option.detail.UF + "</div>" +
                            "   </div>" +
                            "</div> ";
                    return output;
                }
            );
        },

        Selecionar: function (cep, campos, callback) {
            var dto = {};
            dto.cep = cep;

            var camposTela = $.extend({
                CEP: null,
                Logradouro: null,
                Bairro: null,
                UF: null,
                Localidade: null,
                Complemento: null
            }, campos);

            if (cep != "") {
                Siga.UTIL.Ajax(servico + "/Selecionar", dto, function (data) {
                    if (data != null) {
                        camposTela.Logradouro.val(data.Logradouro);
                        camposTela.Bairro.val(data.Bairro);
                        camposTela.UF.val(camposTela.UF.find("[data-sigla=" + data.UF + "]").attr("value"));
                        camposTela.UF.attr("selected", true);
                        camposTela.UF.data('sigla', data.UF);
                        camposTela.UF.trigger('change');
                        camposTela.Localidade.val(data.Localidade);
                        camposTela.Localidade.data('text', data.Localidade);
                        camposTela.Localidade.trigger('change');
                        camposTela.Complemento.val(data.Descricao);
                        if (callback != null) {
                            callback();
                        }
                    }
                    else {
                        Siga.UTIL.Mensagem("alerta", Siga.Mensagem.SIS0101, function () { setTimeout(function () { if (camposTela.CEP != null) camposTela.CEP.focus(); }, 0); });
                    }
                });
            }
        }
    }
}();

Siga.SIS.PessoaHomologacao = function () {
    var servico = "../SIS/PessoaHomologacaoWS.asmx";

    return {
        Persistir: function (codigoPessoa, ids, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            dto.IDs = ids;
            Siga.UTIL.Ajax(servico + "/Persistir", dto, callback);
        }
    }
}();

Siga.SIS.Perfil = function () {
    var servico = "../SIS/PerfilWS.asmx";

    return {
        SelecionarPorNivel: function (listaPerfil, listaNivelPerfil, checkedAutomatico, callback) {
            var dto = {};
            dto.listaPerfil = listaPerfil;
            dto.listaNivelPerfil = listaNivelPerfil;
            dto.checkedAutomatico = checkedAutomatico;

            Siga.UTIL.Ajax(servico + "/SelecionarPorNivel", dto, callback);
        }
    }
}();

Siga.SIS.Acesso = function () {
    var servico = "../SIS/AcessoWS.asmx";

    return {
        QuantidadePorEmpresa: function (codigoEstado, callback) {
            var dto = {};
            dto.codigoEstado = codigoEstado;

            Siga.UTIL.Ajax(servico + "/QuantidadePorEmpresa", dto, callback);
        },

        UsuariosLogados: function (codigoEmpresa, callback) {
            var dto = {};
            dto.codigoEmpresa = codigoEmpresa;

            Siga.UTIL.Ajax(servico + "/UsuariosLogados", dto, callback);
        }
    }
}();

Siga.SIS.UsuarioConfiguracaoAcesso = function () {
    var servico = "../SIS/UsuarioConfiguracaoAcessoWS.asmx";

    return {
        Selecionar: function (codigoUsuario, callback) {
            var dto = {};
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarPorAdministracao: function (codigoUsuario, callback) {
            var dto = {};
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/SelecionarPorAdministracao", dto, callback);
        },
        ExcluirAdministracao: function (codigoAdministracao, codigoUsuario, callback) {
            var dto = {};
            dto.codigoAdministracao = codigoAdministracao;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/ExcluirAdministracao", dto, callback);
        }
    }
}();

Siga.SIS.Fornecedor = function () {
    var servico = "../EST/FornecedorWS.asmx";
    return {
        ValidaFornecedorDANFE: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;
            Siga.UTIL.Ajax(servico + "/ValidaFornecedorDANFE", dto, callback);
        },

        ZerarDANFESession: function (callback) {
            var dto = {};
            Siga.UTIL.Ajax(servico + "/ZerarDANFESession", dto, callback);
        },

        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;
            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        }
    }
}();
/*************************************************************************************
** INICIO - Pesquisa Pessoa - Select2
*************************************************************************************/

function PessoaConfig() {
    var self = this;
    self.MostrarFornecedor = false;
    self.MostrarTransportador = false;
    self.MostrarFornecedorGenerico = false;
    self.MostrarCargo = false;
    self.MostrarProntuario = false;

    self.MostrarEstabelecimentoInterno = false;
    self.MostrarEstabelecimentoInternoTipos = "3,4,5,6,7";

    self.MostrarEstabelecimentoExterno = false;
    self.MostrarEstabelecimentoExternoTipos = "3,4,5,6,7";
    self.MostrarEstabelecimentoExternoIndicadorEmpresa = null;
    self.ExibeInativos = false;
    self.ExibeEstabelecimentoLogado = true;
}

Siga.SIS.Pessoa = function () {
    var servico = "../SIS/ConsultaPessoaWS.asmx";

    return {
        SelecionarPorCodigo: function (codigoPessoa, callback) {
            var dto = {};
            dto.codigoPessoa = codigoPessoa;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        },

        SelecionarPorDocumento: function (documento, callback) {
            var dto = {};
            dto.categoriaPessoa = 4;
            dto.documento = documento;
            Siga.UTIL.Ajax(servico + "/SelecionarPorDocumento", dto, callback);
        },

        SelecionarFornecedorPorDocumento: function (documento, callback) {
            var dto = {};
            dto.categoriaPessoa = 2;
            dto.documento = documento;
            Siga.UTIL.Ajax(servico + "/SelecionarPorDocumento", dto, callback);
        },

        PesquisaTermo: function (campo, textoSelecione, tipo) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/PesquisaTermo",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.tipo = tipo

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = '';
                    var bordercolor = '';

                    switch ($(option.detail)[0].TipoPessoa) {
                        case 1:
                        case 2:
                            classebadge = 'badge-info';
                            bordercolor = '#3a87ad';
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            classebadge = 'badge-warning';
                            bordercolor = '#f89406';
                            break;
                        case 8:
                        case 9:
                            classebadge = 'badge-success';
                            bordercolor = '#82af6f';
                            break;

                    }

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span10' style='min-height: 24px'>" +
                        "           <strong>" + (option.detail.CategoriaPessoa == 1 || option.detail.CategoriaPessoa == 3 || option.detail.TipoPessoa == 1 ? option.text : option.detail.RazaoSocial) + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'><small class='pull-right badge " + classebadge + "'>" + $(option.detail)[0].DescTipoPessoa + "</small></div>" +
                        "   </div>");

                    if (option.detail.TipoPessoa == 2) {
                        if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                            if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                                output +=
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <small>" + option.detail.NomeFantasia + "</small>" +
                                "       </div>" +
                                "   </div>";
                            }
                        } else {
                            if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                                output +=
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <small>" + Siga.Mensagem.SIS0102 + "</small>" +
                                "       </div>" +
                                "   </div>";
                            }
                        }
                    }
                    if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
                        "           <i class='icon-building'></i>&nbsp;" +
                        "           <small>" + $(option.detail)[0].Logradouro + ', ' +
                                                $(option.detail)[0].Numero + ' - ' +
                                                $(option.detail)[0].Cidade + ' - ' +
                                                $(option.detail)[0].Estado + ' - CEP ' +
                                                $(option.detail)[0].CEP + '</small>' +
                        "       </div>";
                    } else {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
                        "       </div>";
                    }

                    if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                        if ($(option.detail)[0].CodigoRelatorio != "") {
                            output +=
                            "       <div class='span2' style='min-height: 20px'>" +
                            "           <span class='pull-right badge badge-important'>" + $(option.detail)[0].CodigoRelatorio + "</span>" +
                            "       </div>";
                        }
                        output +=
                        "   </div>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        ($(option.detail)[0].DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + $(option.detail)[0].DocumentoFederal + "</small></div>" : "") +
                        ($(option.detail)[0].DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>" + $(option.detail)[0].DocumentoEstadual + "</small></div>" : "");
                    }
                    output +=
                    "   </div>" +
                    "</div>";

                    return output;
                }
            );
        },

        DocumentoFiscalFiltro: function (campo, textoSelecione) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/DocumentoFiscalFiltro",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = '';
                    var bordercolor = '';

                    switch ($(option.detail)[0].TipoPessoa) {
                        case 1:
                        case 2:
                            classebadge = 'badge-info';
                            bordercolor = '#3a87ad';
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            classebadge = 'badge-warning';
                            bordercolor = '#f89406';
                            break;
                        case 8:
                        case 9:
                            classebadge = 'badge-success';
                            bordercolor = '#82af6f';
                            break;

                    }

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span10' style='min-height: 24px'>" +
                        "           <strong>" + (option.detail.CategoriaPessoa == 1 || option.detail.CategoriaPessoa == 3 || option.detail.TipoPessoa == 1 ? option.text : option.detail.RazaoSocial) + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'><small class='pull-right badge " + classebadge + "'>" + $(option.detail)[0].DescTipoPessoa + "</small></div>" +
                        "   </div>");

                    if (option.detail.TipoPessoa == 2) {
                        if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                            if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                                output +=
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <small>" + option.detail.NomeFantasia + "</small>" +
                                "       </div>" +
                                "   </div>";
                            }
                        } else {
                            if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                                output +=
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <small>" + Siga.Mensagem.SIS0102 + "</small>" +
                                "       </div>" +
                                "   </div>";
                            }
                        }
                    }
                    if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
                        "           <i class='icon-building'></i>&nbsp;" +
                        "           <small>" + $(option.detail)[0].Logradouro + ', ' +
                                                $(option.detail)[0].Numero + ' - ' +
                                                $(option.detail)[0].Cidade + ' - ' +
                                                $(option.detail)[0].Estado + ' - CEP ' +
                                                $(option.detail)[0].CEP + '</small>' +
                        "       </div>";
                    } else {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
                        "       </div>";
                    }

                    if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                        if ($(option.detail)[0].CodigoRelatorio != "") {
                            output +=
                            "       <div class='span2' style='min-height: 20px'>" +
                            "           <span class='pull-right badge badge-important'>" + $(option.detail)[0].CodigoRelatorio + "</span>" +
                            "       </div>";
                        }
                        output +=
                        "   </div>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        ($(option.detail)[0].DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + $(option.detail)[0].DocumentoFederal + "</small></div>" : "") +
                        ($(option.detail)[0].DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>" + $(option.detail)[0].DocumentoEstadual + "</small></div>" : "");
                    }
                    output +=
                    "   </div>" +
                    "</div>";

                    return output;
                }
            );
        },

        PesquisaTermoTipoEstabelecimento: function (campo, textoSelecione, categoriaPessoa, tipoEstabelecimento) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/PesquisaTermoTipoEstabelecimento",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.term = term;
                    dto.page = page;
                    dto.categoriaPessoa = categoriaPessoa;
                    dto.tipoEstabelecimento = tipoEstabelecimento;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {
                    label.addClass("select2-result-customlabel");

                    var classebadge = '';
                    var bordercolor = '';

                    switch ($(option.detail)[0].TipoPessoa) {
                        case 1:
                        case 2:
                            classebadge = 'badge-info';
                            bordercolor = '#3a87ad';
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            classebadge = 'badge-warning';
                            bordercolor = '#f89406';
                            break;
                        case 8:
                        case 9:
                            classebadge = 'badge-success';
                            bordercolor = '#82af6f';
                            break;

                    }

                    var output = (
                        "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span10' style='min-height: 24px'>" +
                        "           <strong>" + (option.detail.CategoriaPessoa == 1 || option.detail.CategoriaPessoa == 3 || option.detail.TipoPessoa == 1 ? option.text : option.detail.RazaoSocial) + "</strong>" +
                        "       </div>" +
                        "       <div class='span2' style='min-height: 20px'><small class='pull-right badge " + classebadge + "'>" + $(option.detail)[0].DescTipoPessoa + "</small></div>" +
                        "   </div>");

                    if (option.detail.TipoPessoa == 2) {
                        if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                            if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                                output +=
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <small>" + option.detail.NomeFantasia + "</small>" +
                                "       </div>" +
                                "   </div>";
                            }
                        } else {
                            if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                                output +=
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <small>" + Siga.Mensagem.SIS0102 + "</small>" +
                                "       </div>" +
                                "   </div>";
                            }
                        }
                    }
                    if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
                        "           <i class='icon-building'></i>&nbsp;" +
                        "           <small>" + $(option.detail)[0].Logradouro + ', ' +
                                                $(option.detail)[0].Numero + ' - ' +
                                                $(option.detail)[0].Cidade + ' - ' +
                                                $(option.detail)[0].Estado + ' - ' + Siga.Mensagem.SIS0103 + '' +
                                                $(option.detail)[0].CEP + '</small>' +
                        "       </div>";
                    } else {
                        output +=
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
                        "       </div>";
                    }

                    if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                        if ($(option.detail)[0].CodigoRelatorio != "") {
                            output +=
                            "       <div class='span2' style='min-height: 20px'>" +
                            "           <span class='pull-right badge badge-important'>" + $(option.detail)[0].CodigoRelatorio + "</span>" +
                            "       </div>";
                        }
                        output +=
                        "   </div>" +
                        "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                        ($(option.detail)[0].DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + $(option.detail)[0].DocumentoFederal + "</small></div>" : "") +
                        ($(option.detail)[0].DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>" + $(option.detail)[0].DocumentoEstadual + "</small></div>" : "");
                    }
                    output +=
                    "   </div>" +
                    "</div>";

                    return output;
                }
            );
        },

        Pesquisa: function (campo, valorAtual, textoSelecione, config, callback) {
            var dto = {};
            dto.pessoaConfig = config;

            if (jQuery.isFunction(callback)) {
                Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
            }
            else {
                Siga.UTIL.Ajax(servico + "/Selecionar", dto, function (data) {
                    var selected = "";
                    var options = '<option value="">* ' + textoSelecione + ' *</option>';
                    for (var i = 0; i < data.length; i++) {

                        selected = "";
                        if (data[i].Codigo.toString() === valorAtual) {
                            selected = "selected";
                        }

                        var ddd = "";
                        if (data[i].TelefoneDDD != "" && data[i].TelefoneDDD != null) {
                            ddd = "(" + data[i].TelefoneDDD + ")";
                        }

                        options += '<option ' + selected + ' value="' + data[i].Codigo + '"' +
                                   ' data-codigorelatorio="' + data[i].CodigoRelatorio + '"' +
                                   ' data-logradouro="' + data[i].Logradouro + '"' +
                                   ' data-numero="' + data[i].Numero + '"' +
                                   ' data-cidade="' + data[i].Cidade + '"' +
                                   ' data-estado="' + data[i].Estado + '"' +
                                   ' data-cep="' + data[i].CEP + '"' +
                                   ' data-documentofederal="' + data[i].DocumentoFederal + '"' +
                                   ' data-documentoestadual="' + data[i].DocumentoEstadual + '"' +
                                   ' data-tipopessoa="' + data[i].TipoPessoa + '"' +
                                   ' data-desctipopessoa="' + data[i].DescTipoPessoa + '"' +
                                   ' data-email="' + data[i].Email + '"' +
                                   ' data-fone="' + ddd + " " + data[i].TelefoneNumero + '"' +
                                   '>' + data[i].Nome + '</option>';
                    }
                    $("#" + campo).html(options);
                    $("#" + campo).select2({
                        allowClear: true,
                        matcher: function (term, text, obj) {
                            var txt = $(obj).val() + ' ' +
                                      text + ' ' +
                                      $(obj).data("codigorelatorio") + ' ' +
                                      $(obj).data("logradouro") + ' ' +
                                      $(obj).data("numero") + ' ' +
                                      $(obj).data("cidade") + ' ' +
                                      $(obj).data("estado") + ' ' +
                                      $(obj).data("cep") + ' ' +
                                      $(obj).data("documentofederal") + ' ' +
                                      $(obj).data("documentoestadual") + ' ' +
                                      $(obj).data("desctipopessoa");
                            return txt.toUpperCase().indexOf(term.toUpperCase()) >= 0;
                        },
                        formatInputTooShort: function (term, minLength) { return "Informe ao menos " + minLength.toString() + " caracteres"; },
                        formatSearching: function () { return "Buscando... Aguarde."; },
                        formatNoMatches: function (term) { return "Nenhum resultado encontrado."; },
                        formatResult: function (option, label, query, escapeMarkup) {
                            label.addClass("select2-result-customlabel");

                            var classebadge = '';
                            var bordercolor = '';

                            switch ($(option.element).data("tipopessoa")) {
                                case 1:
                                case 2:
                                    classebadge = 'badge-info';
                                    bordercolor = '#3a87ad';
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    classebadge = 'badge-warning';
                                    bordercolor = '#f89406';
                                    break;
                                case 8:
                                case 9:
                                    classebadge = 'badge-success';
                                    bordercolor = '#82af6f';
                                    break;

                            }

                            var output = (
                                "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span10' style='min-height: 24px'>" +
                                "           <strong>" + option.text + "</strong>" +
                                "       </div>" +
                                "       <div class='span2' style='min-height: 20px'><small class='pull-right badge " + classebadge + "'>" + $(option.element).data("desctipopessoa") + "</small></div>" +
                                "   </div>" +
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                                "           <i class='icon-building'></i>&nbsp;" +
                                "           <small>" + $(option.element).data("logradouro") + ', ' +
                                                       $(option.element).data("numero") + ' - ' +
                                                       $(option.element).data("cidade") + ' - ' +
                                                       $(option.element).data("estado") + ' - CEP ' +
                                                       $(option.element).data("cep") + '</small>' +
                                "       </div>" +
                                "       <div class='span4' style='min-height: 20px'>" +
                                "           <span class='pull-right badge badge-important'>" + $(option.element).data("codigorelatorio") + "</span>" +
                                "       </div>" +
                                "   </div>" +
                                "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                                "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + $(option.element).data("documentofederal") + "</small></div>" +
                                "       <div class='span6' style='min-height: 20px'><small>" + $(option.element).data("documentoestadual") + "</small></div>" +
                                "   </div>" +
                                "</div>"
                            );

                            return output;
                        }
                    }).select2('val', valorAtual);
                });
            }
        }
    }
}();

Siga.SIS.Destinatario = function () {
    var servico = "../SIS/ConsultaDestinatarioWS.asmx";
    return {
        Selecionar: function (campo, textoSelecione, codigoOperacao, minimumLength) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/Selecionar",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.termo = term;
                    dto.page = page;
                    dto.codigoOperacao = codigoOperacao;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {

                    return FormatarResultado(option, label, query, escapeMarkup);

                }, minimumLength
            );
        },

        SelecionarParaOperacao: function (codigoOperacao, callback) {
            var dto = {};
            dto.codigoOperacao = codigoOperacao;

            Siga.UTIL.Ajax(servico + "/SelecionarParaOperacao", dto, callback);
        },

        SelecionarPorPrograma: function (campo, textoSelecione, codigoPrograma, minimumLength) {
            Siga.Widgets.Select2.SingleAjaxInfinite(
                campo,
                servico + "/SelecionarPorPrograma",
                "* " + textoSelecione + " *",
                function (term, page) {
                    var dto = {};
                    dto.termo = term;
                    dto.page = page;
                    dto.codigoPrograma = codigoPrograma;

                    return JSON.stringify(dto);
                },
                function (option, label, query, escapeMarkup) {

                    return FormatarResultado(option, label, query, escapeMarkup);

                }, minimumLength
            );
        }
    }


    function FormatarResultado(option, label, query, escapeMarkup) {
        label.addClass("select2-result-customlabel");
        var classebadge = '';
        var bordercolor = '';

        switch ($(option.detail)[0].TipoPessoa) {
            case 1:
            case 2:
                classebadge = 'badge-info';
                bordercolor = '#3a87ad';
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                classebadge = 'badge-warning';
                bordercolor = '#f89406';
                break;
            case 8:
            case 9:
                classebadge = 'badge-success';
                bordercolor = '#82af6f';
                break;

        }

        var output = (
            "<div class='select2-customresult' style='border-left: 4px solid " + bordercolor + "; border-bottom: solid 1px " + bordercolor + "; padding: 4px'>" +
            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
            "       <div class='span10' style='min-height: 24px'>" +
            "           <strong>" + (option.detail.CategoriaPessoa == 1 || option.detail.CategoriaPessoa == 3 || option.detail.TipoPessoa == 1 ? option.text : option.detail.RazaoSocial) + "</strong>" +
            "       </div>" +
            "       <div class='span2' style='min-height: 20px'><small class='pull-right badge " + classebadge + "'>" + $(option.detail)[0].DescTipoPessoa + "</small></div>" +
            "   </div>");

        if (option.detail.TipoPessoa == 2) {
            if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
                if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                    output +=
                    "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                    "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                    "           <small>" + option.detail.NomeFantasia + "</small>" +
                    "       </div>" +
                    "   </div>";
                }
            } else {
                if (option.detail.CategoriaPessoa == 2 || option.detail.CategoriaPessoa == 4 || option.detail.CategoriaPessoa == 5) {
                    output +=
                    "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
                    "       <div class='span8' style='min-height: 20px; padding-left: 20px'>" +
                    "           <small> Fornecedor Genérico </small>" +
                    "       </div>" +
                    "   </div>";
                }
            }
        }
        if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
            output +=
            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
            "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
            "           <i class='icon-building'></i>&nbsp;" +
            "           <small>" + $(option.detail)[0].Logradouro + ', ' +
                                    $(option.detail)[0].Numero + ' - ' +
                                    $(option.detail)[0].Cidade + ' - ' +
                                    $(option.detail)[0].Estado + ' - CEP ' +
                                    $(option.detail)[0].CEP + '</small>' +
            "       </div>";
        } else {
            output +=
            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
            "       <div class='span" + ($(option.detail)[0].CodigoRelatorio == "" ? "12" : "10") + "' style='min-height: 20px; padding-left: 20px'>" +
            "       </div>";
        }

        if (!option.detail.IndicadorGenerico) {//Se o fornecedor não é Genérico
            if ($(option.detail)[0].CodigoRelatorio != "") {
                output +=
                "       <div class='span2' style='min-height: 20px'>" +
                "           <span class='pull-right badge badge-important'>" + $(option.detail)[0].CodigoRelatorio + "</span>" +
                "       </div>";
            }
            output +=
            "   </div>" +
            "   <div class='row-fluid' style='margin-bottom: 0; padding: 0px'>" +
            ($(option.detail)[0].DocumentoFederal != "" ? "       <div class='span6' style='min-height: 20px; padding-left: 20px'><small>" + $(option.detail)[0].DocumentoFederal + "</small></div>" : "") +
            ($(option.detail)[0].DocumentoEstadual != "" ? "       <div class='span6' style='min-height: 20px'><small>" + $(option.detail)[0].DocumentoEstadual + "</small></div>" : "");
        }
        output +=
        "   </div>" +
        "</div>";

        return output;
    }
}();
/*************************************************************************************
** FIM - Pesquisa Pessoa - Select2
*************************************************************************************/

/** Tradução **/
Siga.SIS.ModuloTraducao = function () {
    var servico = "../SIS/ModuloTraducaoWS.asmx";

    return {
        Selecionar: function (codigoModulo, codigoIdioma, callback) {
            var dto = {};
            dto.codigoModulo = codigoModulo;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.RotinaTraducao = function () {
    var servico = "../SIS/RotinaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoRotina, codigoIdioma, callback) {
            var dto = {};
            dto.codigoRotina = codigoRotina;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.ProgramaTraducao = function () {
    var servico = "../SIS/ProgramaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoPrograma, codigoIdioma, callback) {
            var dto = {};
            dto.codigoPrograma = codigoPrograma;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.ComponenteTraducao = function () {
    var servico = "../SIS/ComponenteTraducaoWS.asmx";

    return {
        Selecionar: function (codigoPrograma, codigoIdioma, callback) {
            var dto = {};
            dto.codigoPrograma = codigoPrograma;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.MensagemTraducao = function () {
    var servico = "../SIS/MensagemTraducaoWS.asmx";

    return {
        Selecionar: function (codigoModulo, codigoIdioma, callback) {
            var dto = {};
            dto.codigoModulo = codigoModulo;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarPorPagina: function (codigoPagina, codigoIdioma, callback) {
            var dto = {};
            dto.codigoPagina = codigoPagina;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/SelecionarPorPagina", dto, callback);
        }
    }
}();

Siga.SIS.TextoSistemaTraducao = function () {
    var servico = "../SIS/TextoSistemaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoIdioma, callback) {
            var dto = {};
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SIS.DominioSistemaTraducao = function () {
    var servico = "../SIS/DominioSistemaTraducaoWS.asmx";

    return {
        Selecionar: function (codigoDominioSistema, codigoIdioma, callback) {
            var dto = {};
            dto.codigoDominioSistema = codigoDominioSistema;
            dto.codigoIdioma = codigoIdioma;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();
/** Fim Tradução **/
