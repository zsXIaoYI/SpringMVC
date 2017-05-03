
function _hyz(){
    var img = document.getElementById("img");
    var namea = $("#name").val();
    $.ajax({
        cache: false,
        async: false,
        type: "POST",
        dataType: "html",
        data: {name:namea},
        url: "/SpringMVC/ajax/get.do",
        success: function(flag) {
            if(flag=="success"){
                $("#img").attr("src", "/SpringMVC/img/2.png");
            }else{
                $("#img").attr("src", "/SpringMVC/img/1.png");
            }
        }
    });
}