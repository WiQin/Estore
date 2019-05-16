<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script type="text/javascript">
        function addShopCart(bookname) {
            alert(bookname + "  加入购物车成功!");
        }

        //数量减少
        function reduceCount() {
            //文本框
            var numObj = document.getElementsByName("num")[0];
            if (parseInt(numObj.value) <= 1) {
                document.getElementById("dd").removeAttribute("onclick");
            }else{
                numObj.value = parseInt(numObj.value)-1;
            }
        }

        //数量增加
        function addCount() {
            var numObj = document.getElementsByName("num")[0];
            numObj.value = parseInt(numObj.value) + 1;
        }
    </script>

</head>
<body>
<!--顶部-->
<div class="top">
    <div class="top_center">
        <ul class="top_bars">
            <li><a href="login.jsp">退出</a>|</li>
            <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="#">网站导航<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>
<!--头部-->
<div class="header3">
    <a href="#"><img src="images/logo.png"></a>
    <div class="h3_center">
        <div class="search_box">
            <input type="text" /> <span>搜索</span>
        </div>
        <p>
            <a href="#">文学类</a>| <a href="#">教育类</a>| <a href="#">计算机</a>| <a
                href="#">儿童类</a>| <a href="#">漫画类</a>|
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

<div class="container5">
    <div class="cn5_top">
        <div class="cn5_top_x center01">
            <a class="font20" href="BookServlet">返回</a>><a class="font20"
                                                           href="#">书籍</a>><a href="#">计算机类</a>
        </div>
        <div class="cn5_top_y center01">
            <div class="cn5topy_1">
                <div class="cn5topy_imgview">
                    <img src="images/viewBook.png" />
                    <ul class="cn5topy_imglist">
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li class="current"><a href="#"><img
                                src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                        <li><a href="#"><img src="images/viewBook.png"></a></li>
                    </ul>
                </div>
            </div>
            <div class="cn5topy_2">
                <h1 class="pro_title font15">${sessionScope.book.name }</h1>
                <div class="pro_price">
                    <div class="pro_price_x">
                        <p>
                            briup价：<b>￥${sessionScope.book.price}</b> <a href="#">(降价通知)</a>
                        </p>
                    </div>

                </div>
                <div class="pro_ship">
                    <div>
                        <div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
                        <ul class="pro_service f1">
                            <li class="service_fq">分期付款</li>
                            <li class="service_myf">免运费</li>
                            <li class="service_zt">自提</li>
                            <li class="service_th">7天无理由退换货</li>
                        </ul>
                    </div>
                </div>
                <div class="pro_selects">
                    <div class="pro_select">
                        <div class="pro_key pro_key_vertical fl">选择版本：</div>
                        <ul class="pro_select_vals">
                            <li>精装版</li>
                            <li>简装版</li>
                            <li>收藏版</li>
                        </ul>
                    </div>
                </div>

                <form action="AddShopCarServlet" method="post">
                    <!--隐藏框传送书的id值  -->
                    <input type="hidden" name="id" value="${sessionScope.book.id }">
                    <div class="pro_buy">
                        <div class="pro_buy_nums">
                            <!--书的num值  -->
                            <input type="text" value="1" name="num" />
                            <dl>
                                <dd onclick="addCount();" id="dd">+</dd>
                                <dd onclick="reduceCount();">-</dd>
                            </dl>
                        </div>
                        <div class="pro_addshop">
                            <a href="javascript:void(0)" onclick="addShopCart('当前书')">
                                <input type="submit" value="加入购物车">
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="c5_b2">

        <div class="c5_b2_right">
            <!--选项卡-->
            <ul class="c5_b2_tabs">
                <li>商品介绍</li>
                <li class="current">规格参数</li>
                <li>包装清单</li>
                <li>商品评价</li>
            </ul>
            <!--内容-->
            <div class="c5_b2_right_1 box">
                <div class="introduce_item">
                    <ul>
                        <li>商品名称：${sessionScope.book.name }</li>
                        <li>商品编号：${sessionScope.book.id }</li>
                        <li class="fr"><a class="color_link1" href="#">更多参数>></a></li>
                    </ul>
                </div>
            </div>
            <div class="intro_pics">
                <img class="intro_pic" src="images/viewBook.png">
            </div>
        </div>


        <div class="c5_b2_right">
            <div class="c5_b2_right_2">
                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

            </div>
        </div>

        <!--左侧栏-->
        <div class="c5_b2_left_container">
            <div class="c5_b2_left box">
                <h1>服务时间 早9：00~凌晨1：00</h1>
                <p>
                    <a href="#"> <img class="callmebyqq"
                                      src="images/icon_qq_03.png" />
                    </a>
                </p>
            </div>

            <div class="c5_b2_left box">
                <h1>其他种类</h1>
                <dl>
                    <dd>文学类</dd>
                    <dd>漫画类</dd>
                    <dd>通书类</dd>
                </dl>
                <dl>
                    <dd>文学类</dd>
                    <dd>漫画类</dd>
                    <dd>通书类</dd>
                </dl>
            </div>
        </div>
    </div>
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
