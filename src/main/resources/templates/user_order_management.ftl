<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
    <!-- Bootstrap Styles-->
    <link href="/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->

    <!-- Custom Styles-->
    <link href="/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='/#css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/user/mainpage">速通</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i><#if Session["user"]?exists>${Session.user.username}</#if></a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/user/log_out"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li class="nav1">
                    <a href=# id="nav1" class="active-menu"><i class="fa fa-dashboard"></i> 历史订单</a>
                </li>
                <li class="nav1">
                    <a href=# id="nav1" ><i class="fa fa-desktop"></i>进行中订单</a>
                </li>
                <li class="nav1">
                    <a href=# id="nav1" ><i class="fa fa-bar-chart-o"></i>寄出订单</a>
                </li>


                <#--<li>-->
                    <#--<a href=# id="nav1" ><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>-->
                    <#--<ul class="nav nav-second-level">-->
                        <#--<li>-->
                            <#--<a href="#">Second Level Link</a>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<a href="#">Second Level Link</a>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<a href="#">Second Level Link<span class="fa arrow"></span></a>-->
                            <#--<ul class="nav nav-third-level">-->
                                <#--<li>-->
                                    <#--<a href="#">Third Level Link</a>-->
                                <#--</li>-->
                                <#--<li>-->
                                    <#--<a href="#">Third Level Link</a>-->
                                <#--</li>-->
                                <#--<li>-->
                                    <#--<a href="#">Third Level Link</a>-->
                                <#--</li>-->

                            <#--</ul>-->

                        <#--</li>-->
                    <#--</ul>-->
                <#--</li>-->
                <#--<li>-->
                    <#--<a href=# id="nav1"><i class="fa fa-fw fa-file"></i> Empty Page</a>-->
                <#--</li>-->
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        欢迎来到订单管理界面 <small>方便的订单管理页面</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default order_table"  id="finished_order_table" >
                        <div class="panel-heading">
                            历史订单
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>订单No.</th>
                                        <th>订单名称</th>
                                        <th>配送区间</th>
                                        <th>订单状态</th>
                                        <th>时间信息</th>
                                        <th>配送信息</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#if finished_orders?exists>
                                    <#list finished_orders as fo>
                                    <#--class="odd gradeX"-->
                                        <>
                                        <tr >
                                            <td><#>${fo.order_id?c}</td>
                                            <td>${fo.order_name}</td>
                                            <td>${fo.sender_province+fo.sender_city}<span class="fa fa-arrow-right"></span>${fo.receiver_province+fo.receiver_city}</td>
                                            <td class="center">${fo.status}</td>
                                            <td class="center">${fo.initial_time+" 经过"+fo.live_time}</td>
                                            <td class="center">${fo.trans_info}</td>
                                        </tr>
                                    </#list>
                                    </#if>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                    <!--  finished_order_table -->
                    <div class="panel panel-default order_table" id="ing_order_table" style="display: none;">
                        <div class="panel-heading">
                            进行中订单
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>订单No.</th>
                                        <th>订单名称</th>
                                        <th>发货地</th>
                                        <th>订单状态</th>
                                        <th>时间信息</th>
                                        <th>配送信息</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#if ing_orders?exists>
                                    <#list  ing_orders as io>
                                    <#--class="odd gradeX"-->
                                        <tr >
                                            <td>${io.order_id?c}</td>
                                            <td>${io.order_name}</td>
                                            <td>${io.sender_province+io.sender_city}</td>
                                            <td>${io.status}</td>
                                            <td>${io.initial_time+" 经过"+io.live_time}</td>
                                            <td>${io.trans_info}</td>
                                        </tr>
                                    </#list>
                                    </#if>

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End finished_order_table -->

                    <div class="panel panel-default order_table" id="sending_order_table" style="display: none;">
                        <div class="panel-heading">
                           寄出订单
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>订单No.</th>
                                        <th>订单名称</th>
                                        <th>目的地</th>
                                        <th>订单状态</th>
                                        <th>时间信息</th>
                                        <th>配送信息</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#if sending_orders?exists>
                                    <#list  sending_orders as so>
                                    <#--class="odd gradeX"-->
                                        <tr >
                                            <td>${so.order_id?c}</td>
                                            <td>${so.order_name}</td>
                                            <td>${so.receiver_province+so.receiver_city}</td>
                                            <td>${so.status}</td>
                                            <td>${so.initial_time+" 经过"+so.live_time}</td>
                                            <td>${so.trans_info}</td>
                                        </tr>
                                    </#list>
                                    </#if>

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--SENDING ORDER-->
                </div>
            </div>


        </div>
        <!-- /. ROW  -->


    </div>
    <!-- /. ROW  -->
</div >
<footer class="center-block"><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://guantaow.taobao.com/">速通公司</a></p></footer>

<!-- /. PAGE INNER  -->
<!--</div>-->
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="/js/jquery-2.1.4.min.js"></script>
<!-- Bootstrap Js -->
<script src="/assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="/assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();

        $(".nav1").click(function () {
            $(".nav1 a").removeClass("active-menu");
            $(this).children("a").addClass("active-menu");
            var index=$(this).index();
             // alert("index:"+index);
            $(".order_table").css("display","none");
            $(".order_table").eq(index).css("display","block");
        })
    });
</script>
<!-- Custom Js -->
<#--<script src="/assets/js/custom-scripts.js"></script>-->


</body>
</html>
