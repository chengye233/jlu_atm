<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">

  <head>
    <link rel="stylesheet" type="text/css" href="../resources/css/adminlogin.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css" />
  </head>

  <body>
    <div>
      <div align="center"><h1>管理员登录</h1></div>
      <form action="../manage/login" method="post">
        <div style="color: red;" align="center"> ${errorMessage}</div>
        <br/>
        <div align="center">
          <div><label class="adminlogin_label">用户名</label><input name="userid" type="text"></div>
          <br/>
          <div><label class="adminlogin_label">密码</label><input name="pass" type="password"></div>
        </div>
        <p></p>
        <div align="center">
          <input class="adminlogin_submitbox bordered color_ok font30" type="submit" value=" 登录 ">
        </div>
      </form>
      <br/>
      <div align="center"><a href="../buy/main"><button class="adminlogin_cancelbox  bordered color_user font20">放弃登录</button></a></div>
      <br/>
    </div>

  </body>

</html>