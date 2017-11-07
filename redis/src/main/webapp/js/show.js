/**
 * 
 */

$(function(){
	
	//获取页面隐藏域中当前页的值
	var page=$("#page").val();
	//获取页面隐藏域中绝对路径的值
	var ctx=$("#ctx").val();
	//获取页面隐藏域中尾页的值
	var lastPage=$("#lastPage").val();
	
	//隔行变色
	$(".tr:odd").css("background-color","#E6E6FA");
	
	//点击首页
	$("#b1").click(function(){
		var name=$("#name").val();
		var author=$("#author").val();
		var publishDate=$("#publishDate").val();
		window.location.href=ctx+"/query/1.do?name="+name+"&author="+author+"&publishDate="+publishDate;
	});
	
	//上一页点击
	$("#b2").click(function(){
		var name=$("#name").val();
		var author=$("#author").val();
		var publishDate=$("#publishDate").val();
		if(page<=1){
			page=1;
		}else{
			page--;
		}
		window.location.href=ctx+"/query/"+page+".do?name="+name+"&author="+author+"&publishDate="+publishDate;
	});
	
	//下一页
	$("#b3").click(function(){
		var name=$("#name").val();
		var author=$("#author").val();
		var publishDate=$("#publishDate").val();
		if(page>=lastPage){
			page=lastPage;
		}else{
			page++;
		}
		window.location.href=ctx+"/query/"+page+".do?name="+name+"&author="+author+"&publishDate="+publishDate;
	});
	
	//尾页
	$("#b4").click(function(){
		var name=$("#name").val();
		var author=$("#author").val();
		var publishDate=$("#publishDate").val();
		window.location.href=ctx+"/query/"+lastPage+".do?name="+name+"&author="+author+"&publishDate="+publishDate;
	});
	
	
	//分页模糊查询
	$("#search").click(function(){
		var name=$("#name").val();
		var author=$("#author").val();
		var publishDate=$("#publishDate").val();
		window.location.href=ctx+"/query/1.do?name="+name+"&author="+author+"&publishDate="+publishDate;
	});
	
	
});

//删除点击事件
function deleteById(id){
	if(confirm("是否删除该条数据?")){
		window.location.href="/bookDemo/delete/"+id+".do";
	}
}