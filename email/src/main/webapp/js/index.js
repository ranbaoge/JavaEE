
//点击按钮添加接受者标签

$(function () {
    
    $("#add").click(function () {
        var input=$("<input class=\"form-control\" name=\"aemail\" type=\"text\" placeholder=\"请输入接受者邮箱地址\">");
        $("#delete").after(input);
    });

    $("#delete").click(function () {
        $("[name=aemail]")[0].remove();
    });
});