$(document).ready(function () {
    $('.carousel').carousel({
        interval: 6000
    })

    /* Enable datepickers and set date */
    $('#datepicker').datepicker();

    var date = new Date();
    $("#datepicker").val(getCurrentDate());

    setPlacesAutocomplete($('#origin'));
    setPlacesAutocomplete($('#destination'));

    /* Enable sortable tables */
    $("#schedulesTable").tablesorter( {selectorHeaders: 'thead th.sortable'} );
});

function getCurrentDate() {
    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (day < 10) {
        day = '0' + day;
    }

    if (month < 10) {
        month = '0' + month;
    }

    return month + '/' + day + '/' + year;
}

function setPlacesAutocomplete(input) {
    input.autocomplete({
        source: function (request, response) {
            $.getJSON(ctx + "/api/places", {
                term: request.term
            }, response);
        },
        select: function (event, ui) {
            input.val(ui.item.name);
            return false;
        },
        focus: function (event, ui) {
            input.val(ui.item.name);
            return false;
        }
    }).autocomplete("instance")._renderItem = function (ul, item) {
        return $('<li>').append('<a>' + item.name + '</a>').appendTo(ul);
    };
}