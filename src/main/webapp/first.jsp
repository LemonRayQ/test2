<%--
  Created by IntelliJ IDEA.
  User: Lemon-grass
  Date: 2018/10/2
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <script type="text/javascript" src="myJS.js"></script>
</head>
<script>
    function ckname() {
        var name = document.getElementsByTagName("input")[0];
        var req=getXMLHttpRequest();
        req.open("get","servletThird?name="+name.value);
        req.send(null);
        req.onreadystatechange=function() {
            if (req.readyState == 4) {
                if (req.status == 200) {
                    var msg = document.getElementById("msg");
                    alert(req.responseText);
                    if (req.responseText == "true") {
                        msg.innerHTML = "用户已存在";
                    } else {
                        msg.innerHTML = "可以使用该用户名";
                    }
                }
            }
        }

    }

</script>
<body>
    用户名：<input type="text" name="username" onblur="ckname()"/><span id="msg"></span><br/>
    密码：<input type="password" name="password"/>
</body>
</html>
