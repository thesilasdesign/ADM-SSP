Siga.SUP = {};

Siga.SUP.Chamado = function () {
    var servico = "../SUP/ChamadoWS.asmx";

    return {
        SelecionarNotificacao: function (codigoUsuario, callback) {
            var dto = {};
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/SelecionarNotificacao", dto, callback);
        },
        SelecionarConteudoNotificacao: function (inicio, tamanho, codigoUsuario, callback) {
            var dto = {};
            dto.inicio = inicio;
            dto.tamanho = tamanho;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/SelecionarConteudoNotificacao", dto, callback);
        },
        VisualizarNotificacao: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/VisualizarNotificacao", dto, callback);
        },
        Seguir: function (codigoChamado, codigoUsuario, callback) {
            var dto = {};
            dto.codigoChamado = codigoChamado;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/Seguir", dto, callback);
        },
        NaoSeguir: function (codigoChamado, codigoUsuario, callback) {
            var dto = {};
            dto.codigoChamado = codigoChamado;
            dto.codigoUsuario = codigoUsuario;

            Siga.UTIL.Ajax(servico + "/NaoSeguir", dto, callback);
        },
        SelecionarHistorico: function (codigoChamado, callback) {
            var dto = {};
            dto.codigoChamado = codigoChamado;

            Siga.UTIL.Ajax(servico + "/SelecionarHistorico", dto, callback);
        },
        SelecionarArvore: function (codigoChamado, transacao, callback) {
            var dto = {};
            dto.codigoChamado = codigoChamado;
            dto.transacao = transacao;

            Siga.UTIL.Ajax(servico + "/SelecionarArvore", dto, callback);
        },
        LimparTodasNotificacoes: function (callback) {
            var dto = {};

            Siga.UTIL.Ajax(servico + "/LimparTodasNotificacoes", dto, callback);
        },
        RemoverNotificacao: function (codigoNotificacao, callback) {
            var dto = {};
            dto.codigoNotificacao = codigoNotificacao;

            Siga.UTIL.Ajax(servico + "/RemoverNotificacao", dto, callback);
        }
    }
}();

Siga.SUP.Area = function () {
    var servico = "../SUP/AreaWS.asmx";

    return {
        Selecionar: function (callback) {
            var dto = {};

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SUP.Status = function () {
    var servico = "../SUP/StatusWS.asmx";

    return {
        Selecionar: function (codigoArea, ativo, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;
            dto.ativo = ativo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarStatusChamadoComplementar: function (codigoStatus, callback) {
            var dto = {};
            dto.codigoStatus = codigoStatus;

            Siga.UTIL.Ajax(servico + "/SelecionarStatusChamadoComplementar", dto, callback);
        },

        SelecionarStatusChamadoOrigem: function (codigoStatus, callback) {
            var dto = {};
            dto.codigoStatus = codigoStatus;

            Siga.UTIL.Ajax(servico + "/SelecionarStatusChamadoOrigem", dto, callback);
        },

        SelecionarPorClassificacao: function (codigoStatus, codigoClassificacao, callback) {
            var dto = {};
            dto.codigoStatus = codigoStatus;
            dto.codigoClassificacao = codigoClassificacao;

            Siga.UTIL.Ajax(servico + "/SelecionarPorClassificacao", dto, callback);
        }
    }
}();

Siga.SUP.Faq = function () {
    var servico = "../SUP/FaqWS.asmx";

    return {
        SelecionarFaqAssunto: function (callback) {
            var dto = {};

            Siga.UTIL.Ajax(servico + "/SelecionarFaqAssunto", dto, callback);
        }
    }
}();

Siga.SUP.Classificacao = function () {
    var servico = "../SUP/ClassificacaoWS.asmx";

    return {
        Selecionar: function (codigoArea, ativo, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;
            dto.ativo = ativo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SUP.Prioridade = function () {
    var servico = "../SUP/PrioridadeWS.asmx";

    return {
        Selecionar: function (codigoArea, ativo, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;
            dto.ativo = ativo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SUP.Processo = function () {
    var servico = "../SUP/ProcessoWS.asmx";

    return {
        Selecionar: function (codigoArea, codigoProcessoSuperior, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;
            dto.codigoProcessoSuperior = codigoProcessoSuperior;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarSuperior: function (codigoArea, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;

            Siga.UTIL.Ajax(servico + "/SelecionarSuperior", dto, callback);
        }
    }
}();

Siga.SUP.CanalAtendimento = function () {
    var servico = "../SUP/CanalAtendimentoWS.asmx";

    return {
        Selecionar: function (codigoArea, ativo, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;
            dto.ativo = ativo;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SUP.RespostaPadrao = function () {
    var servico = "../SUP/RespostaPadraoWS.asmx";

    return {
        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        },
        Selecionar: function (codigoArea, callback) {
            var dto = {};
            dto.codigoArea = codigoArea;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        }
    }
}();

Siga.SUP.SolicitacaoUsuarioItem = function () {
    var servico = "../SUP/SolicitacaoUsuarioItemWS.asmx";

    return {
        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        },
        Selecionar: function (codigoSolicitacao, gerarLogin, verificaDocumentoFederal, callback) {
            var dto = {};
            dto.codigoSolicitacao = codigoSolicitacao;
            dto.gerarLogin = gerarLogin;
            dto.verificaDocumentoFederal = verificaDocumentoFederal;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },
        SelecionarParaAprovacao: function (codigoSolicitacao, gerarLogin, verificaDocumentoFederal, callback) {
            var dto = {};
            dto.codigoSolicitacao = codigoSolicitacao;
            dto.gerarLogin = gerarLogin;
            dto.verificaDocumentoFederal = verificaDocumentoFederal;

            Siga.UTIL.Ajax(servico + "/SelecionarParaAprovacao", dto, callback);
        }
    }
}();

Siga.SUP.SolicitacaoUsuarioItemDetalhe = function () {
    var servico = "../SUP/SolicitacaoUsuarioItemDetalheWS.asmx";

    return {
        Selecionar: function (codigoSolicitacaoUsuarioItem, callback) {
            var dto = {};
            dto.codigoSolicitacaoUsuarioItem = codigoSolicitacaoUsuarioItem;

            Siga.UTIL.Ajax(servico + "/Selecionar", dto, callback);
        },

        SelecionarPorCodigo: function (codigo, callback) {
            var dto = {};
            dto.codigo = codigo;

            Siga.UTIL.Ajax(servico + "/SelecionarPorCodigo", dto, callback);
        }
    }
}();