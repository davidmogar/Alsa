$(document).ready(function () {
    $('li.collapsible').click(function (e) {
        var ul = $(this).find('ul');
        ul.is(":visible") ? ul.slideUp() : ul.slideDown();
    })

    $(function () {
        $('.navbar-toggle').click(function () {
            $('.navbar-nav').toggleClass('slide-in');
            $('.side-body').toggleClass('body-slide-in');
            $('#search').removeClass('in').addClass('collapse').slideUp(200);

            /// uncomment code for absolute positioning tweek see top comment in css
            //$('.absolute-wrapper').toggleClass('slide-in');

        });

        // Remove menu for searching
        $('#search-trigger').click(function () {
            $('.navbar-nav').removeClass('slide-in');
            $('.side-body').removeClass('body-slide-in');

            /// uncomment code for absolute positioning tweek see top comment in css
            //$('.absolute-wrapper').removeClass('slide-in');

        });
    });

    setAutocomplete($('#origin'), "/api/places", "name");
    setAutocomplete($('#destination'), "/api/places", "name");
    setAutocomplete($('#bus'), "/api/buses", "licensePlate");
    setAutocomplete($('#route'), "/api/routes", "name");
});

function setAutocomplete(input, path, property) {
    input.autocomplete({
        source: function (request, response) {
            $.getJSON(ctx + path, {
                term: request.term
            }, response);
        },
        select: function (event, ui) {
            input.val(ui.item[property]);
            return false;
        },
        focus: function (event, ui) {
            input.val(ui.item[property]);
            return false;
        }
    }).autocomplete("instance")._renderItem = function (ul, item) {
        return $('<li>').append('<a>' + item[property] + '</a>').appendTo(ul);
    };
}