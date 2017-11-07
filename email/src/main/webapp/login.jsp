<%--
  Created by IntelliJ IDEA.
  User: huangdaye
  Date: 2017/11/4
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/login.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4  col-md-offset-4">

                <form action="user/login" method="post">

                    <div class="form-group">
                        用户名:<input class="form-control" name="username" type="text" placeholder="请输入用户名">
                    </div>

                    <div class="form-group">
                        密码:<input class="form-control" name="password" type="password" placeholder="请输入密码">
                    </div>

                    <div class="form-group">
                        <input type="submit" value="登录" class="btn btn-success">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="重置" class="btn btn-warning">
                    </div>
                </form>
            </div>
        </div>

    </div>
</body>
</html>
