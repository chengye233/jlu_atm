<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">

  <head>
    <link rel="stylesheet" type="text/css" href="../resources/css/mainpage.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/itemlabel.css" />
    <script src="../resources/js/jquery-3.3.1.slim.js"></script>
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
                    <a href="/manage/edit?id=${commodity.id}">
                      <div class="itemlabel bordered color_admin">
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
          <table>
            <tr>
              <div class="itemlabel bordered">
                <a href="../manage/edit?id=-1">
                  <button class="fill color_admin" style="font-size:100px; color:#FFFFFF">⊕</button>
                </a>
              </div>
            </tr>
          </table>

        </div>
      </div>
    </div>


    <footer class="mainpage_lower bordered">
      <div class="mainpage_lower_desc font20">
        <div style="margin:5px;">
          <span id="time"></span> 管理员模式
        </div>
      </div>
      <div class="mainpage_lower_button">
        <a href="../buy/main">
          <button class="fill bordered color_admin font20">退出管理员模式</button>
        </a>
      </div>
    </footer>
  </body>

</html>