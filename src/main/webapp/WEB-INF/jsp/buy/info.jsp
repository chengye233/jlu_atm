<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/itemdetail.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css"/>
    <title>purchase</title>
</head>

<body onkeypress="insertCoin(event)">
<div class="itemdetail_left">
    <div align="center" style="margin:5px;">
        <br/>
        <div class="font30">${commodity.name}</div>
        <br/>
        <span class="font20">售价：¥</span>
        <span id="priceText" class="font20">${commodity.price}</span>
        <br/>
        <br/>
        <div class="itemdetail_thumbnailpic color_user bordered">
            <img class="fill" onclick="" src="../images/${commodity.picture}"/>
        </div>
    </div>
</div>
<div class="itemdetail_right">
    <div align="center" style="margin:5px;">
        <br/>
        <div class="font30">投币购买</div>
        <br/>
        <div>
            <span class="font30">已投&nbsp;</span>
            <span id="coinText" class="font30" style="color: red;">0.0</span>
            <span class="font30">&nbsp;元</span>
        </div>
        <br/>
        <div>请投入1元、5角或1角硬币</div>
        <br/>
        <form id="form" action="../buy/pay" method="post">
            <input name="id" value="${commodity.id}" type="hidden"/>
            <input id="money" name="money" type="hidden"/>
            <input id="purchaseBtn" class="itemdetail_sumbitpurchasebutton bordered color_notavailable font30"
                   type="button" value="您的投币不足" disabled="disabled"/>
        </form>
        <br/>
        <br/>

        <input id="cancelBtn" class="itemdetail_cancelbutton bordered color_user font20"
               type="button" value="取消并退币"/>

    </div>
</div>

</body>
<script src="../resources/js/itemdetail_purchase.js"></script>
</html>
