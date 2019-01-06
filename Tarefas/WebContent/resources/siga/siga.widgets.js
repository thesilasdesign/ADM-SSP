Siga.Widgets = {};

Siga.Widgets.Select2 = function () {
    function select2Focus() {
        if (/^focus/.test(event.type)) {
            $(this).select2('open');
        }
    }

    return {
        SingleAjax: function (obj, postUrl, textoSistema, callbackDTO, callbackItem, callbackFormatResult) {
            $("#" + obj).select2({
                autocapitalize: false,
                autocorrect: false,
                autocomplete: false,
                spellcheck: false,
                allowClear: true,
                autofocus: true,
                placeholder: textoSistema,
                minimumInputLength: 2,
                ajax: {
                    url: postUrl,
                    type: "POST",
                    dataType: "json",
                    params: {
                        contentType: "application/json; charset=iso-8859-1"
                    },
                    quietMillis: 1000,
                    data: callbackDTO,
                    results: function (data, page) {
                        var lista = new Array();
                        for (var i = 0; i < data.d.length; i++) {
                            lista[i] = {};
                            callbackItem(lista[i], data.d[i]);
                        }
                        return {
                            results: lista
                        }
                    }
                },
                initSelection: function (element, callback) {
                    var id = $(element).val();
                    if (id !== "") {
                        var data = {};
                        data.id = id;
                        data.text = $(element).data("text");
                        callback(data);
                    }
                },
                formatInputTooShort: function (term, minLength) { return Siga.Mensagem.SIS0077.replace("@QuantidadeMinima", minLength.toString()); },
                formatSearching: function () { return Siga.Mensagem.SIS0078; },
                formatNoMatches: function (term) { return Siga.Mensagem.SIS0079; },
                formatResult: callbackFormatResult
            }).one('select2-focus', select2Focus).on("select2-blur", function () {
                $(this).one('select2-focus', select2Focus)
            });
        },

        SingleAjaxInfinite: function (obj, postUrl, textoSistema, callbackDTO, callbackFormatResult, minimumLength) {
            $("#" + obj).select2({
                autocapitalize: false,
                autocorrect: false,
                autocomplete: false,
                spellcheck: false,
                allowClear: true,
                autofocus: true,
                placeholder: textoSistema,
                minimumInputLength: 0,
                ajax: {
                    url: postUrl,
                    type: "POST",
                    dataType: "json",
                    params: {
                        contentType: "application/json; charset=iso-8859-1"
                    },
                    quietMillis: 500,
                    data: callbackDTO,
                    results: function (data, page) {
                        var more = (page * 15) < data.d.total_count;

                        return {
                            results: data.d.items,
                            more: more
                        }
                    }
                },
                initSelection: function (element, callback) {
                    var id = $(element).val();
                    if (id !== "") {
                        var data = {};
                        data.id = id;
                        data.text = $(element).data("text");
                        callback(data);
                    }
                },
                formatInputTooShort: function (term, minLength) { return Siga.Mensagem.SIS0077.replace("@QuantidadeMinima", minLength.toString()); },
                formatSearching: function () { return Siga.Mensagem.SIS0078; },
                formatLoadMore: function () { return Siga.Mensagem.SIS0080; },
                formatNoMatches: function (term) { return Siga.Mensagem.SIS0079; },
                formatResult: callbackFormatResult
            }).one('select2-focus', select2Focus).on("select2-blur", function () {
                $(this).one('select2-focus', select2Focus)
            });
        },

        SingleAjaxInfinite2: function (obj, postUrl, textoSistema, callbackDTO) {
            $("#" + obj).select2({
                autocapitalize: false,
                autocorrect: false,
                autocomplete: false,
                spellcheck: false,
                allowClear: true,
                autofocus: true,
                placeholder: textoSistema,
                minimumInputLength: 0,
                ajax: {
                    url: postUrl,
                    type: "POST",
                    dataType: "json",
                    params: {
                        contentType: "application/json; charset=iso-8859-1"
                    },
                    quietMillis: 500,
                    data: callbackDTO,
                    results: function (data, page) {
                        var more = (page * 15) < data.d.total_count;

                        return {
                            results: data.d.items,
                            more: more
                        }
                    }
                },
                initSelection: function (element, callback) {
                    var id = $(element).val();
                    if (id !== "") {
                        var data = {};
                        data.id = id;
                        data.text = $(element).data("text");
                        callback(data);
                    }
                },
                formatInputTooShort: function (term, minLength) { return Siga.Mensagem.SIS0077.replace("@QuantidadeMinima", minLength.toString()); },
                formatSearching: function () { return Siga.Mensagem.SIS0078; },
                formatLoadMore: function () { return Siga.Mensagem.SIS0080; },
                formatNoMatches: function (term) { return Siga.Mensagem.SIS0079; }
            }).one('select2-focus', select2Focus).on("select2-blur", function () {
                $(this).one('select2-focus', select2Focus)
            });
        },

        Single: function (id, callbackFormatResult, callbackFormatSelection, callbackMatcher) {
            var multiple = ($("#" + id).attr("multiple") != null);

            var placeholder = $("#" + id).attr("placeholder");
            if ((placeholder == null || placeholder == "") && multiple) {
                placeholder = Siga.Mensagem.Todos;
            }

            if (multiple) {
                $("#" + id).select2({
                    placeholder: placeholder,
                    formatInputTooShort: function (term, minLength) { return Siga.Mensagem.SIS0077.replace("@QuantidadeMinima", minLength.toString()); },
                    formatSearching: function () { return Siga.Mensagem.SIS0078; },
                    formatNoMatches: function (term) { return Siga.Mensagem.SIS0079; }
                }).one('select2-focus', select2Focus).on("select2-blur", function () {
                    $(this).one('select2-focus', select2Focus)
                });
            }
            else {
                $("#" + id).select2({
                    autocapitalize: false,
                    autocorrect: false,
                    autocomplete: false,
                    spellcheck: false,
                    allowClear: true,
                    autofocus: true,
                    closeOnSelect: true,
                    placeholder: placeholder,
                    formatInputTooShort: function (term, minLength) { return Siga.Mensagem.SIS0077.replace("@QuantidadeMinima", minLength.toString()); },
                    formatSearching: function () { return Siga.Mensagem.SIS0078; },
                    formatNoMatches: function (term) { return Siga.Mensagem.SIS0079; },
                    formatResult: callbackFormatResult,
                    formatSelection: callbackFormatSelection,
                    matcher: callbackMatcher
                }).one('select2-focus', select2Focus).on("select2-blur", function () {
                    $(this).one('select2-focus', select2Focus)
                });
            }
        }
    }
}();

Siga.Widgets.Multiselect = function () {
    function select2Focus() {
        if (/^focus/.test(event.type)) {
            $(this).select2('open');
        }
    }

    return {
        Single: function (id, textoTodos, textoNenhum, tamanho) {

            var jqueryElement = $("#" + id)
            $("#" + id).select2("destroy");
            $("#" + id).multiselect({
                enableHTML: true,
                optionLabel: function (element) {
                    return '&nbsp;' + $(element).text();
                },
                buttonClass: 'align-left  btn ',
                inheritClass: false,
                buttonWidth: '100%',
                buttonContainer: '<div class="btn-group" />',
                dropRight: false,
                // Maximum height of the dropdown menu.
                // If maximum height is exceeded a scrollbar will be displayed.
                maxHeight: 200,
                checkboxName: false,
                includeSelectAllOption: true,
                includeSelectAllIfMoreThan: 0,
                selectAllText: Siga.Mensagem.SIS0081,
                selectAllValue: 'multiselect-all',
                selectAllName: false,
                selectAllNumber: true,
                enableCaseInsensitiveFiltering: true,
                enableClickableOptGroups: false,
                filterPlaceholder: '',
                // possible options: 'text', 'value', 'both'
                filterBehavior: 'text',
                includeFilterClearBtn: true,
                preventInputChangeEvent: false,
                nonSelectedText: textoNenhum,
                nSelectedText: Siga.Mensagem.SIS0082,
                allSelectedText: textoTodos,
                numberDisplayed: tamanho,
                disableIfEmpty: false,
                delimiterText: ', ',
                templates: {
                    button: '<button style="height:30px; border-width: 1px!important;background-color:#ffffff !important; border-color:rgb(170, 170, 170);color: #858585!important; text-shadow:0px !important;" type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"><span class="multiselect-selected-text black align-right"></span> <b style="border-top-color: #858585;" class="caret pull-right"></b></button>',
                    ul: '<ul style="width:99.7%" class="multiselect-container dropdown-menu"></ul>',
                    filter: '<li class="multiselect-item filter"><div class="input-group"><div class="input-icon input-icon-right"><span class="icon icon-search"></span><input class="input-block-level multiselect-search" type="text"></div></div></li>',
                    filterClearBtn: '',
                    li: '<li><a tabindex="0"><label style="padding: 2px 20px 6px 3px"></label></a></li>',
                    divider: '<li class="multiselect-item divider"></li>',
                    liGroup: '<li class="multiselect-item multiselect-group"><label></label></li>'
                }
            });
        }
    }
}();