<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/mainpage.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/itemlabel.css"/>
    <script src="../resources/js/jquery-3.3.1.min.js"></script>
    <title>mainpage</title>
    <script type="text/javascript">

        <%-- 时间更新 --%>
        var serverTime = new Date();

        function updateTime() {
            /// Increment serverTime by 1 second and update the html for '#time'
            serverTime = new Date(serverTime.getTime() + 1000);
            $('#time').html(serverTime.toLocaleDateString() + " " + serverTime.toLocaleTimeString());
        }

        $(function () {
            updateTime();
            setInterval(updateTime, 1000);
        });
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
                                <a href="/buy/info?id=${commodity.id}">
                                    <div class="itemlabel bordered color_user">
                                            <%-- 图片 --%>
                                        <div class="itemlabel_thumbnailpic bordered">
                                            <img class="fill"
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
        <div style="margin:5px;">
            <span id="time"></span> 欢迎使用自动售货机，请选择商品
        </div>
    </div>
    <div class="mainpage_lower_button">
        <a href="../manage/login">
            <button class="fill bordered color_user font20">管理员补货</button>
        </a>
    </div>
</footer>
</body>

</html>
