$(document).ready(function () {

    $('#saveContact').submit(function (e) {

        $.post('/spring-ajax/contact/save', $(this).serialize(), function(contact) {
            $('#contactTableResponse').last().append(
                '<tr>' +
                    '<td>' + contact.id + '</td>' +
                    '<td>' + contact.firstName + '</td>' +
                    '<td>' + contact.lastName + '</td>' +
                    '<td>' + contact.age + '</td>' +
                '</tr>'
            );
        });

        clearInputs();

        e.preventDefault();
    });

});

function clearInputs() {
    $('input[id*="Input"]').each(function () {
        $(this).val('');
    });
}

$(document).ready(function () {
    $('#button').click(function () {

        var first = $('#firstInput').val();
        
        alert("Contact " + textStatus + " " + errorThrown + " !");

        $.ajax({
            type:'GET',
            url:"/Tarefas/getJSON/" + first,
            dataType:'json',
            success:function (result) {

                var contact =
                    "id : " + result.seguroId +
                    " | name : " + result.nome;

                $("#theJson").html(contact);
                
                clearInputs();

            },
            error:function (jqXHR, textStatus, errorThrown) {
                alert("Contact " + textStatus + " " + errorThrown + " !");
            }

        });
    });
});

$(document).ready(function () {
    $('#search').keyup(function (e) {
        var filter = $('#search').val();
        if (filter.length > 0) {
            loadTable(filter);
        } else {
            $('tr[id*="tr_"]').remove();
        }
    });
});

function loadTable(filter) {
    var url = "/spring-ajax/contact/load/" + filter;

    $('#tbody').load(url, function (response, status, xhr) {
        if (status == "error") {
            var msg = "Sorry but there was an error: ";
            $("#info").html(msg + xhr.status + " " + xhr.statusText);
        }
    });

    return false;
}