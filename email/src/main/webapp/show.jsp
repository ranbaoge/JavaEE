<%--
  Created by IntelliJ IDEA.
  User: huangdaye
  Date: 2017/11/5
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<head>
    <title>数据显示</title>
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/show.css">
    <script type="text/javascript" src="${ctx}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/show.js"></script>
</head>
<body>
    <div class="container">
         <div class="row">
             <div class="col-md-12">

                 <div class="panel panel-default">
                     <div class="panel-heading">
                         <p style="font-size: 20px;text-align: center;color: #31b0d5"> <strong>邮件数据展示</strong>
                             <span>欢迎您${u.username}</span> </p>
                     </div>

                     <table class="table" id="tab">
                         <tr>
                             <td>Image</td>
                             <td>ID</td>
                             <td>邮件主题</td>
                             <td>附件名</td>
                             <td>发送者</td>
                             <td>操作</td>
                         </tr>
                         <c:forEach items="${emails}" var="e">
                             <tr class="tr">
                                 <td><span class="glyphicon glyphicon-envelope"></span></td>
                                 <td>${e.id}</td>
                                 <td>${e.subject}</td>
                                 <td>${e.filename}</td>
                                 <td>${e.user.email}</td>
                                 <td>
                                     <span class="glyphicon glyphicon-trash" id="delete"></span>
                                 </td>
                             </tr>
                         </c:forEach>
                         <tr>
                             <td colspan="7">
                                 <ul class="pager">
                                     <li><a id="b1">首页</a><span style="color: #31b0d5">第${page}页</span></li>
                                     <li><a id="b2">上一页</a></li>
                                     <li><a id="b3">下一页</a><span style="color: #31b0d5">共${lastPage}页</span></li>
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
