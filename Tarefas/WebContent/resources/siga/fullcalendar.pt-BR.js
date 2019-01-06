var calendarOptions = {
    ignoreTimezone: false,

    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],

    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],

    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado'],

    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],

    titleFormat: {
        month: 'MMMM yyyy',
        week: "d[ MMMM][ yyyy]{ - d MMMM yyyy}",
        day: 'dddd, d MMMM yyyy'
    },

    columnFormat: {
        month: 'ddd',
        week: 'ddd d',
        day: ''
    },

    axisFormat: 'HH:mm',

    timeFormat: {
        '': 'HH:mm',
        agenda: 'HH:mm'
    },

    buttonText: {
        today: "Hoje",
        month: "Mês",
        week: "Semana",
        day: "Dia"
    },

    header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    },

    selectable: true,

    selectHelper: true
};