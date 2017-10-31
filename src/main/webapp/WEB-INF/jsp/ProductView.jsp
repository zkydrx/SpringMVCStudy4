<%--
  Created by IntelliJ IDEA.
  User: Abbot
  Date: 2017-10-29
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
    <style type="text/css">@import url(/css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>${message}</h4>
    <h5>Details:</h5>
    Product Name:${product.name}<br/>
    Description:${product.description}<br/>
    Price:${product.price}
</div>
</body>
</html>
