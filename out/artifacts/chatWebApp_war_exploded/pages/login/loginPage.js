$(function () {
    $("#s").append("<p>hey</p>");
    $("#loginForm").submit(function () {
        var name=this[0].value;

        var formData=new FormData();
        formData.append("userName",name);
        $.ajax({
            method:'GET',
            data: formData,
            url: this.action,
            timeout:2000,
            error: function(){
                console.error("Failed to submit");
                $("#s").append("Failed to get result from server");
            },
            success: function(r) {
                if(r!=null) {
                    $("#s").append("<p>r</p>");
                }
                else{
                    $("#s").append("<p>good!</p>");
                }
            }

        });
        return false;
    })
})
