$(function (){
    $("#suppression").click(function(){
        $(".ui.mini.modal").modal('show');
    });
    $(".ok").click(function (){
    });
    $('select.dropdown')
        .dropdown()
    ;
});
jQuery('.datetimepicker').datetimepicker();
$(document).ready(function () {
    $(".ui.toggle.button").click(function () {
        $(".mobile.only.grid .ui.vertical.menu").toggle(100);
    });
function $_GET(param) {
    var vars = {};
    window.location.href.replace( location.hash, '' ).replace(
        /[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
        function( m, key, value ) { // callback
            vars[key] = value !== undefined ? value : '';
        }
    );

    if ( param ) {
        return vars[param] ? vars[param] : null;
    }
    return vars;
}
    // Lecture du paramètre de message
    const message = $_GET('message');
    const err = $_GET('err');
    $('.ui.negative.message').hide();
    $('.ui.positive.message').hide();
    if (message) {
        if (err === "true") {
            $('.ui.negative.message .header').html("Un problème est survenu");
            $('.ui.negative.message').slideDown(10).delay(3000).slideUp(1000);
        } else {
            $('.ui.positive.message .header').html("L'opération s'est bien passée");
            $('.ui.positive.message').slideDown(10).delay(3000).slideUp(1000);
        }
    }
});
