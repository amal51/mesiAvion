$(function (){
    $("#suppression").click(function(){
        $(".ui.mini.modal").modal('show');
    });
    $(".ok").click(function (){
    });
    $('select.dropdown')
        .dropdown()
    ;
    $('#date').calendar();
});