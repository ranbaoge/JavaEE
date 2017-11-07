$(function () {

    //隔行变色
    $(".tr:odd").css("background-color","blue");

    //分页
    var page=$("#page").val();
    var lastPage=$("#lastPage").val();
    var ctx=$("#ctx").val();

    //点击首页
    $("#b1").click(function () {
        window.location.href=ctx+"/email/query/1";
    });

    //上一页点击
    $("#b2").click(function () {
        if(page<=1){
            page=1;
        }else {
            page--;
        }
        window.location.href=ctx+"/email/query/"+page;
    });

    //下一页点击
    $("#b3").click(function () {
        if(page>=lastPage){
            page=lastPage;
        }else {
            page++;
        }
        window.location.href=ctx+"/email/query/"+page;
    });

    //尾页点击
    $("#b4").click(function () {
        window.location.href=ctx+"/email/query/"+lastPage;
    });

});