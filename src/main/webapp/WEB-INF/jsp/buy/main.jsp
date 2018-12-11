<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/mainpage.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/itemlabel.css"/>
    <title>mainpage</title>
    <%-- 表单提交 --%>
    <script type="text/javascript">
        function submitForm() {
            $('#info').submit();
        }
    </script>
</head>

<body>
<div class="fill">
    <div class="mainpage_upper">
        <div class="mainpage_upper_content bordered">
            <%-- 商品列表 --%>
            <table>
                <c:forEach items="${commodityLists}" var="commodityList">
                    <tr>
                        <c:forEach items="${commodityList}" var="commodity">
                            <th>
                                <form id="info" action="../buy/info" method="post">
                                    <input type="hidden" name="id" value="${commodity.id}">
                                    <a href="#" onclick="submitForm()">
                                        <div class="itemlabel bordered color_user">
                                            <%-- 图片 --%>
                                            <div class="itemlabel_thumbnailpic bordered">
                                                <img class="greyfade fill"
                                                     src="../images/${commodity.picture}"/>
                                            </div>
                                            <div>
                                                <%-- 价钱 --%>
                                                <div class="itemlabel_price">
                                                    ¥${commodity.price}
                                                </div>
                                                <%-- 数量 --%>
                                                <c:if test="${commodity.number > 0}">
                                                    <div class="itemlabel_outofstock">
                                                            ${commodity.number}
                                                    </div>
                                                </c:if>
                                                <c:if test="${commodity.number <= 0}">
                                                    <div class="itemlabel_outofstock">
                                                        缺货
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </a>
                                </form>
                            </th>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
<footer class="mainpage_lower bordered">
    <div class="mainpage_lower_desc font20">
        <div style="margin:5px;">16:00 欢迎使用自动售货机，请选择商品</div>
    </div>
    <div class="mainpage_lower_button">
        <a href="adminlogin.html">
            <button class="fill bordered color_user font20">管理员补货</button>
        </a>
    </div>
</footer>
</body>
<script src="../resources/js/jquery-3.3.1.min.js"></script>
</html>
