var normal_map = [
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa___',
    'aa___',
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa_aa',
    'aa_aa',
];

var supra_map = [
    'a__aa',
    'a__aa',
    'a__aa',
    'a__aa',
    'a__aa',
    'a__aa',
    'a____',
    'a____',
    'a__aa',
    'a__aa',
    'a__aa',
    'a__aa',
    'a__aa',
    'a__aa',
];

var seatChartOneWay;
var seatChartReturn;

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
    $("#schedulesTable").tablesorter({selectorHeaders: 'thead th.sortable'});

    $("#scheduleSelectionButton").click(function() {
        var oneWaySchedule = $('input[name=oneWaySchedule]:checked', '#oneWaySchedulesTable').val();
        var returnSchedule = $('input[name=returnSchedule]:checked', '#returnSchedulesTable').val();

        if (returnSchedule != undefined) {
            location.replace(ctx + "/journey/book?oneWayId=" + oneWaySchedule + "&returnId=" + returnSchedule);
        } else {
            location.replace(ctx + "/journey/book?oneWayId=" + oneWaySchedule);
        }
    });
});

function initializeOneWaySeatMap(supra) {
    seatChartOneWay = $('#seat-map-one-way').seatCharts({
        legend: {
            node: $('#legend'),
            items: [
                ['a', 'available', 'Available'],
                ['a', 'selected', 'Selected'],
                ['a', 'unavailable', 'Already Booked']
            ]
        },
        map: supra? supra_map : normal_map,
        naming: {top: false},
        seats: {
            a: {
                price: 99.99
            }

        },
        click: function () {
            if (this.status() == 'available') {
                return 'selected';
            } else if (this.status() == 'selected') {
                return 'available';
            } else if (this.status() == 'unavailable') {
                return 'unavailable';
            } else {
                return this.style();
            }
        }
    });
}

function initializeReturnSeatMap(supra) {
    seatChartReturn = $('#seat-map-return').seatCharts({
        map: supra? supra_map : normal_map,
        naming: {top: false},
        seats: {
            a: {
                price: 99.99
            }

        },
        click: function () {
            if (this.status() == 'available') {
                return 'selected';
            } else if (this.status() == 'selected') {
                return 'available';
            } else if (this.status() == 'unavailable') {
                return 'unavailable';
            } else {
                return this.style();
            }
        }
    });
}

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