/**
 * 使用Ajax加载书籍种类
 */


$(function(){
	
	$("#bcid").focus(function(){
		
		$.getJSON("queryAll.do",null,fun);
		
		function fun(data){
			var bcid=$("#bcid");
			$("option").remove();
			for(var i=0;i<=data.length;i++){
				bcid.append("<option value='"+data[i].cid+"'>"+data[i].cname+"</option>");
			}
		}
		
	});
});