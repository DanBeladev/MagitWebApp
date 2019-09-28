$(function () {
    $.ajax({
        method: 'GET',
        url:'/userName',
        success:function (r) {
            $('#welcome').text("welcome "+ r +"!");
        }
    });

    $("#uploadForm").submit(function (event) {
        event.preventDefault();
        var file = this[0].files[0];
        var formData = new FormData();
        formData.append('theFile', file);
        $.ajax({
            method: 'POST',
            data: formData,
            url: '/upload',
            processData: false,
            contentType: false,
            timeout: 4000,
            success: function () {
                console.log("good gooooood");
                $("#repos").append("<li>repo</li>")
            }
        });
        return false;
    })
});