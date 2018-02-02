<%--
  Created by IntelliJ IDEA.
  User: xing
  Date: 2018/2/2
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<h1>上传文件，基于FDFS</h1>
<div>
    <form action="/fdfsupload.op" method="post" enctype="multipart/form-data">
       <label>请选择上传的文件：</label> <input type="file" name="file">
        <input type="submit" value="上传文件">
    </form>
</div>

<h2>上传结果：</h2>
<a href="http://10.0.127.98/${path}">点击</a>
</body>
</html>
