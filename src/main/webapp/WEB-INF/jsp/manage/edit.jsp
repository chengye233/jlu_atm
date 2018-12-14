<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/itemdetail.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css"/>
</head>

<body>
<form action="../manage/edit" method="post" enctype="multipart/form-data">
    <div class="itemdetail_left">
        <div style="color: red;" align="center"> ${errorMessage}</div>
        <div align="center" style="margin:5px;">
            <br/>
            <input type="hidden" name="id" value="${commodity.id}"/>
            <input type="hidden" name="picture" value="${commodity.picture}"/>
            <input class="font30" type="text" placeholder="<商品名称>" name="name" value="${commodity.name}"/>
            <br/>
            <br/>
            <span class="font20">售价：¥</span>
            <input class="font20" type="text" placeholder="<售价>" name="price" value="${commodity.price}"/>
            <br/>
            <h5 style="color: grey;"></h5>
            <input id="fileupload" type="file" name="file">
            <div class="itemdetail_thumbnailpic color_admin bordered">

                <img class="fill" src="../images/${commodity.picture}"/>
            </div>
        </div>
    </div>
    </div>
    <div class="itemdetail_right">
        <div align="center" style="margin:5px;">
            <br/>
            <h1>库存</h1>
            <span class="font20">剩余：</span>
            <input class="font20" type="text" placeholder="<库存>" name="number" value="${commodity.number}"/>
            <br/>
            <br/>
            <input class="itemdetail_sumbiteditbutton bordered color_ok font30" type="submit" value="确定编辑"/>
            <br/>
            <br/>
            <a href="../manage/delete?id=${commodity.id}">
                <input class="itemdetail_cancelbutton bordered color_ng font20" type="button" value="删除商品" onclick=""/>
            </a>
            <br/>
            <br/>
            <a href="../manage/main">
                <input class="itemdetail_cancelbutton bordered color_admin font20" type="button" value="放弃编辑"
                       onclick=""/>
            </a>
        </div>
    </div>
</form>
</body>
</html>
