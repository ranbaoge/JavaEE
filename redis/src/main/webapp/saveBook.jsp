<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/saveBook.js"></script>
    <style type="text/css">
        .row{
          margin-top: 100px;
        }
        
    
    </style>
</head>
<body>
     <div class="container">
        <div class="row">
             <div class="col-md-4 col-md-offset-3">
                <form action="save.do" method="post" class="form-horizontal">
  <div class="form-group">
    <label for="exampleInputEmail1">书籍名称:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入书籍名称" name="bname" size="20">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">书籍作者:</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入书籍作者" name="bauthor" size="20">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">出版社:</label>
    <input type="text" class="form-control" id="exampleInputFile" name="bpublisher">
  </div>

    <div class="form-group">
    <label for="exampleInputFile">出版时间:</label>
    <input type="date" class="form-control" id="exampleInputFile" name="bpublishdate">
  </div>
  
  <!-- 种类需要通过Ajax加载进来 -->
   <div class="form-group">
    <label for="bcid">数据种类:</label>
      <select id="bcid" name="bcid" class="form-control">
     
       </select><br>
  </div>
  
  <input type="submit" value="提交" class="btn btn-info">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" value="重置" class="btn btn-success">
</form>
             </div>
        </div>
     </div>
</body>
</html>