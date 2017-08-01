<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8"/>
    <title>总览 | IMUCommunity</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <!-- BEGIN LAYOUT FIRST STYLES -->
    <!--<link href="//fonts.googleapis.com/css?family=Oswald:400,300,700" rel="stylesheet" type="text/css" />-->
    <!-- END LAYOUT FIRST STYLES -->
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <!--<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />-->
    <link href="../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="../assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="../assets/global/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link href="../assets/pages/css/contact.min.css" rel="stylesheet" type="text/css"/>
    <!-- END PAGE LEVEL STYLES -->
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="../assets/layouts/layout5/css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/layouts/layout5/css/custom.min.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME LAYOUT STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo">
<!-- BEGIN CONTAINER -->
<div class="wrapper">
    <!-- BEGIN HEADER -->
    <header class="page-header">
        <nav class="navbar mega-menu" role="navigation">
            <div class="container-fluid">
                <div class="clearfix navbar-fixed-top">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="toggle-icon">
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </span>
                    </button>
                    <!-- End Toggle Button -->
                    <!-- BEGIN LOGO -->
                    <a id="index" class="page-logo" href="#">
                        <img src="../assets/layouts/layout5/img/logo.png" alt="Logo"> </a>
                    <!-- END LOGO -->
                    <!-- BEGIN TOPBAR ACTIONS -->
                    <div class="topbar-actions">
                        <!-- BEGIN QUICK SIDEBAR TOGGLER -->
                        <a href="logout" class="btn btn-link quick-sidebar-toggler">
                            <span class="sr-only">Logout</span>
                            <i class="icon icon-logout"></i>
                        </a>
                        <!-- END QUICK SIDEBAR TOGGLER -->
                    </div>
                    <!-- END TOPBAR ACTIONS -->
                </div>
                <!-- BEGIN HEADER MENU -->
                <div class="nav-collapse collapse navbar-collapse navbar-responsive-collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown dropdown-fw active open">
                            <a href="javascript:;" class="text-uppercase">
                                <i class="icon-home"></i> 内容管理 </a>
                            <ul class="dropdown-menu dropdown-menu-fw">
                                <li class="active">
                                    <a>
                                        <i class="icon-graph"></i> 总览 </a>
                                </li>
                                <li>
                                    <a href="user">
                                        <i class="icon-user"></i> 用户管理 </a>
                                </li>
                                <li>
                                    <a href="tucao">
                                        <i class="icon-bubble"></i> 吐槽管理 </a>
                                </li>
                                <li>
                                    <a href="ask">
                                        <i class="icon-directions"></i> 咨询管理 </a>
                                </li>
                                <li class="dropdown more-dropdown-sub" >
                                    <a>
                                        <i class="icon-info"></i> 通知管理 </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="office">
                                                <i class="icon-briefcase"></i> 官方帐号管理 </a>
                                        </li>
                                        <li>
                                            <a href="notification">
                                                <i class="icon-info"></i> 通知管理 </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown dropdown-fw">
                            <a href="javascript:;" class="text-uppercase">
                                <i class="icon-home"></i> 系统管理 </a>
                            <ul class="dropdown-menu dropdown-menu-fw">
                                <li>
                                    <a href="status">
                                        <i class="icon-bar-chart"></i> 运行状态 </a>
                                </li>
                            </ul>
                        </li>


                    </ul>
                </div>
                <!-- END HEADER MENU -->
            </div>
            <!--/container-->
        </nav>
    </header>
    <!-- END HEADER -->
    <div class="container-fluid">
        <div class="page-content">
            <!-- BEGIN BREADCRUMBS -->
            <div class="breadcrumbs">
                <h1>总览</h1>
                <!--<ol class="breadcrumb">-->
                <!--<li>-->
                <!--<a href="#">Home</a>-->
                <!--</li>-->
                <!--<li>-->
                <!--<a href="#">Pages</a>-->
                <!--</li>-->
                <!--<li class="active">General</li>-->
                <!--</ol>-->
            </div>
            <!-- END BREADCRUMBS -->
            <!-- BEGIN PAGE BASE CONTENT -->
            <!-- begin dash board-->
            <div class="row widget-row">
                <div class="col-md-3">
                    <!-- BEGIN WIDGET THUMB -->
                    <a href="user" style="text-decoration: none">
                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                        <h4 class="widget-thumb-heading">用户管理</h4>
                        <div class="widget-thumb-wrap">
                            <i class="widget-thumb-icon bg-green  icon-user"></i>
                            <div class="widget-thumb-body">
                                <span class="widget-thumb-subtitle">用户数量</span>
                                <span class="widget-thumb-body-stat" data-counter="counterup" data-value="<s:property value="dashDto.user_num" />"><s:property value="dashDto.user_num" /></span>
                            </div>
                        </div>
                    </div></a>
                    <!-- END WIDGET THUMB -->
                </div>
                <div class="col-md-3">
                    <!-- BEGIN WIDGET THUMB -->
                    <a href="tucao"  style="text-decoration: none">
                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                        <h4 class="widget-thumb-heading">吐槽管理</h4>
                        <div class="widget-thumb-wrap">
                            <i class="widget-thumb-icon bg-red  icon-bubble"></i>
                            <div class="widget-thumb-body">
                                <span class="widget-thumb-subtitle">吐槽数量/喜欢数量/评论数量</span>
                                <span class="widget-thumb-body-stat">
                                    <span data-counter="counterup" data-value="<s:property value="dashDto.tucao_num" />"><s:property value="dashDto.tucao_num" /></span> /
                                    <span data-counter="counterup" data-value="<s:property value="dashDto.like_num" />"><s:property value="dashDto.like_num" />3</span> /
                                   <span data-counter="counterup" data-value="<s:property value="dashDto.comment_num" />"><s:property value="dashDto.comment_num" /></span>
                                </span>
                            </div>
                        </div>
                    </div>
                        <!-- END WIDGET THUMB --></a>
                </div>
                <div class="col-md-3">
                    <!-- BEGIN WIDGET THUMB -->
                    <a href="ask" style="text-decoration: none">
                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                        <h4 class="widget-thumb-heading">咨询管理</h4>
                        <div class="widget-thumb-wrap">
                            <i class="widget-thumb-icon bg-purple icon-directions"></i>
                            <div class="widget-thumb-body">
                                <span class="widget-thumb-subtitle">咨询数量/回答数量</span>
                                <span class="widget-thumb-body-stat">
                                    <span data-counter="counterup" data-value="<s:property value="dashDto.ask_num" />"><s:property value="dashDto.ask_num" /></span> /
                                   <span data-counter="counterup" data-value="<s:property value="dashDto.answer_num" />"><s:property value="dashDto.answer_num" /></span>
                                </span>
                            </div>
                        </div>
                    </div>
                        <!-- END WIDGET THUMB --></a>
                </div>
                <div class="col-md-3">
                    <!-- BEGIN WIDGET THUMB -->
                    <a href="notification" style="text-decoration: none">
                    <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                        <h4 class="widget-thumb-heading">通知管理</h4>
                        <div class="widget-thumb-wrap">
                            <i class="widget-thumb-icon bg-blue icon-info"></i>
                            <div class="widget-thumb-body">
                                <span class="widget-thumb-subtitle">官方号/通知数</span>
                                <span class="widget-thumb-body-stat">
                                    <span data-counter="counterup" data-value="<s:property value="dashDto.office_num" />"><s:property value="dashDto.office_num" /></span> /
                                   <span data-counter="counterup" data-value="<s:property value="dashDto.notification_num" />"><s:property value="dashDto.notification_num" /></span>
                                </span>
                            </div>
                        </div>
                    </div>
                    </a>
                    <!-- END WIDGET THUMB -->
                </div>
            </div>
            <!-- end dash board-->
            <div class="row">
                <div class="col-md-12">
                    <h3>数据统计暂时就不做了<img src="../assets/layouts/layout5/img/xjj.gif" width="32px"/></h3>
                    <p>毕竟后端一个，不太会做界面= =</p>
                </div>
            </div>
            <!-- END PAGE BASE CONTENT -->
        </div>
        <!-- BEGIN FOOTER -->
        <p class="copyright pull-right">2017 © IMUCommunity by Likole</p>
        <a href="#index" class="go2top">
            <i class="icon-arrow-up"></i>
        </a>
        <!-- END FOOTER -->
    </div>
</div>
<!-- END CONTAINER -->
<!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js"></script>
<script src="../assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="../assets/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/counterup/jquery.counterup.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="../assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="../assets/layouts/layout5/scripts/layout.min.js" type="text/javascript"></script>
<script src="../assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
</body>
</html>