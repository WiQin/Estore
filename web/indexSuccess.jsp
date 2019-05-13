<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=path%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>briup电子商务-首页</title>
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/icons.css" />
    <link rel="stylesheet" href="css/table.css" />
</head>
<body>
<!--顶部-->
<div class="top">
    <div class="top_center">
        <ul class="top_lr">
            <li><a href="login.jsp" style="color: red;">欢迎,${sessionScope.customer.name }</a></li>
        </ul>
        <ul class="top_bars">
            <li><a href="LoginOutServlet">退出</a></li>
            <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="#">网站导航<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>
<!--头部-->
<div class="header3">
    <a href="index.html"><img src="images/logo.png"></a>
    <div class="h3_center">
        <div class="search_box">
            <input type="text" /> <span>搜索</span>
        </div>
        <p>
            <a href="#">文学类</a>|
            <a href="#">教育类</a>|
            <a href="#">计算机</a>|
            <a href="#">儿童类</a>|
            <a href="#">漫画类</a>|
        </p>
    </div>
    <div class="h3_right">
        <div class="myyy">
            <a href="userinfo.jsp">个人信息</a> <span class="sj_down"></span>
        </div>

        <c:if test="${!empty cart.orderlines }">
            <div class="tsc">
                <a href="shopCart.jsp">去购物车结算</a> <span class="sj_right"></span>
            </div>
        </c:if>

        <c:if test="${empty cart.orderlines }">
            <div class="tsc">
                <a href="emptyCar.jsp">去购物车结算</a> <span class="sj_right"></span>
            </div>
        </c:if>

    </div>
</div>
<!--头部导航-->
<div class="nav_top">
    <div class="nav_top_center">
        <div>全部图书分类</div>
        <ul>
            <li><a href="#">文学类</a></li>
            <li><a href="#">教育类</a></li>
            <li><a href="#">计算机</a></li>
            <li><a href="#">儿童类</a></li>
            <li><a href="#">漫画类</a></li>
        </ul>
    </div>
</div>


<div class="container3">
    <div class="c3_b1">
        <div class="c3_b1_left">
            <dl>
                <dd>
                    <h1>文学类</h1>
                    <p>
                        <a href="#">诗歌</a>
                        <a href="#">散文</a>
                        <a href="#">小说</a>
                        <a href="#">剧本</a>
                    </p>
                </dd>
                <dd>
                    <h1>教育类</h1>
                    <p>
                        <a href="#">高中</a>
                        <a href="#">大学</a>
                        <a href="#">考研</a>
                        <a href="#">考公</a>
                    </p>
                </dd>
                <dd>
                    <h1>计算机</h1>
                    <p>
                        <a href="#">硬件</a>
                        <a href="#">编程</a>
                        <a href="#">智能</a>
                    </p>
                </dd>
                <dd>
                    <h1>儿童类</h1>
                    <p>
                        <a href="#">益智</a>
                        <a href="#">生活</a>
                        <a href="#">特长</a>
                        <a href="#">饮食</a>
                    </p>
                </dd>
                <dd>
                    <h1>漫画类</h1>
                    <p>
                        <a href="#">科幻</a>
                        <a href="#">灾难</a>
                        <a href="#">冒险</a>
                        <a href="#">运动</a>
                    </p>
                </dd>
                <dd>
                    <h1>工具书</h1>
                    <p>
                        <a href="#">农业</a>
                        <a href="#">金融</a>
                        <a href="#">医药</a>
                    </p>
                </dd>
                <dd class="last">
                    <h1>期刊</h1>
                    <p>
                        <a href="#">会计</a>
                        <a href="#">煤炭</a>
                        <a href="#">软件</a>
                        <a href="#">图像</a>
                    </p>
                </dd>
            </dl>
        </div>

        <div class="c3_b1_center">
            <div>
                <img src="images/ad1.png">
            </div>

            <div class="c3_b1_c_bottom">
                <ul>
                    <c:forEach items="${sessionScope.books }" var="books">
                        <li><img src="images/p01.png" />
                            <a href="showBookViewServlet?id=${books.id }">${books.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="c3_b1_right">
            <h1>
                杰普快报<a href="#">更多</a>
            </h1>
            <ul>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
                <li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
            </ul>
        </div>

        <div style="clear: both"></div>
    </div>

    <div class="c3_b2">
        <ul>
            <c:forEach items="${sessionScope.books }" var="books">
                <li class="no_mr">
                    <div class="c3_b2_txt">
                        <h1>${books.name}</h1>
                        <p>Java经典</p>
                        <h2>畅销书籍</h2>
                        <p>
                            <a href="showBookViewServlet?id=${books.id }">更多精彩，点击进入</a>
                        </p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="c20"></div>

    <!--脚部-->
    <div class="footer3">
        <div class="f3_top">
            <div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
            <ul class="f3_center">
                <li class="f3_mi_li01">
                    <h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                    <h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                    <h1>客服中心</h1> <img src="images/qrcode_jprj.jpg" width="80px"
                                       height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
        <div class="f3_bottom">
            <p class="f3_links">
                <a href="#">关于我们</a>| <a href="#">联系我们</a>| <a href="#">友情链接</a>| <a
                    href="#">供货商入驻</a>
            </p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司</p>
            <img src="images/police.png">
        </div>
    </div>
</body>
</html>
