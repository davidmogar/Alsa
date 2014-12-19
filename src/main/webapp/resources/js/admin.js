$(document).ready(function () {
    $('li.collapsible p').click(function (e) {
        var ul = $(this).parent().find('ul');
        ul.is(":visible") ? ul.slideUp() : ul.slideDown();
    })
});