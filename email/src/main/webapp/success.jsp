<%--
  Created by IntelliJ IDEA.
  User: huangdaye
  Date: 2017/11/5
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<head>
    <title>Success</title>
</head>
<body>
   <h3 style="color: greenyellow;font-size: 20px">恭喜${u.username}邮件发送成功</h3>
   <a href="${ctx}/email/query/1">查询邮件信息</a>
</body>
</html>
