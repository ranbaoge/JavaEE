<%--
  Created by IntelliJ IDEA.
  User: huangdaye
  Date: 2017/11/3
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
  <head>
    <title>主页</title>
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
      <script type="text/javascript" src="${ctx}/js/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="${ctx}/js/index.js"></script>
    <style type="text/css">
        .container{
          margin-top: 100px;
          border: 1px solid lightblue;
        }

        #delete{
            color: red;
        }

        #add{
            color: greenyellow;
        }
    </style>
  </head>
  <body>
     <div class="container">
       <div>
         <div class="row">
             <div class="col-md-4 col-md-offset-4">
                 <span style="color: #bce8f1;font-size: 20px">欢迎您:${u.username}</span>
             </div>
         </div>
       </div>

         <div class="row">
            <div class="col-md-4 col-md-offset-4">
                 <form action="${ctx}/email/email" method="post" enctype="multipart/form-data">
                   <div class="form-group">
                     发送者:<input class="form-control" name="email" type="text" readonly="readonly" value="${u.email}">
                   </div>

                   <div class="form-group">
                     邮件主题:<input class="form-control" name="subject" type="text" placeholder="请输入主题">
                   </div>

                   <div class="form-group">
                     邮件内容:<textarea rows="4" cols="50" name="content" placeholder="请输入内容" class="form-control">

                   </textarea>
                   </div>

                   <div class="form-group">
                     上传附件:<input class="form-control" name="file" type="file" placeholder="请选择上传的文件">
                   </div>

                   <div class="form-group">
                     接受者:
                       <span class="glyphicon glyphicon-plus" id="add"></span>
                       <span class="glyphicon glyphicon-minus" id="delete"></span>
                   </div>
                   <div class="form-group">
                     <input type="submit" value="上传" class="btn btn-success">
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <input type="reset" value="重置" class="btn btn-warning">
                   </div>
                 </form>
            </div>
         </div>
     </div>
  </body>
</html>

