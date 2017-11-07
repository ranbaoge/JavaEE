<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据显示</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/show.css">
    <script type="text/javascript" src="${ctx}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/show.js"></script>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
					   <p id="th">书籍数据显示</p>
					</div>

					<div class="panel-body">
						<p align="center">
						  书籍名称:<input type="text" value="${name }" id="name">&nbsp;
						  作者:<input type="text" value="${author }" id="author">&nbsp;
						  出版时间:<input type="date" value="${publishDate}" id="publishDate">&nbsp;
						 <input type="button" value="查询" class="btn btn-info" id="search">
						 <a href="${ctx}/saveBook.jsp" class="btn btn-success">添加</a>
						</p>
					</div>

					<table class="table">
					    <tr>
					       <td>Image</td>
					       <td>书籍名称</td>
					       <td>作者</td>
					       <td>出版社</td>
					       <td>出版时间</td>
					       <td>种类</td>
					       <td>操作</td>
					    </tr>
					    <c:forEach items="${books}" var="b">
					       <tr class="tr">
					       <td><span class="glyphicon glyphicon-book"></span> </td>
					       <td>${b.bname }</td>
					       <td>${b.bauthor }</td>
					       <td>${b.bpublisher }</td>
					       <td>
					         <fmt:formatDate value="${b.bpublishdate }" pattern="yyyy-MM-dd"/>
					       </td>
					       <td>${b.category.cname }</td>
					       <td>
					         <span class="glyphicon glyphicon-trash" onclick="deleteById(${b.bid})">
					         </span>
					       </td>
					       </tr>
					    </c:forEach>

						<tr>
							<td colspan="7">
								<ul class="pager">
									<li><a id="b1">首页</a>
									  <span>第${page }页</span>
									</li>
									<li><a id="b2">上一页</a></li>
									<li><a id="b3">下一页</a>
									   <span>共${lastPage }页</span>
									</li>
									<li><a id="b4">尾页</a>
									 <input type="hidden" value="${page}" id="page">
									 <input type="hidden" value="${lastPage}" id="lastPage">
									 <input type="hidden" value="${ctx}" id="ctx">
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>