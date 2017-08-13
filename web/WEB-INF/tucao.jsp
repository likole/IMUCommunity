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
    <title>吐槽管理 | IMUCommunity</title>
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
                        <!-- BEGIN QUICK SIDEBAR TOGGLER --> <a href="logout"
                                                                class="btn btn-link quick-sidebar-toggler"> <span
                            class="sr-only">Logout</span> <i class="icon icon-logout"></i> </a>
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
                                <li>
                                    <a href="dash">
                                        <i class="icon-graph"></i> 总览 </a>
                                </li>
                                <li>
                                    <a href="user">
                                        <i class="icon-user"></i> 用户管理 </a>
                                </li>
                                <li   class="active">
                                    <a>
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
                <h1>吐槽管理</h1>
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
            <div class="content">
                <table class="table table-striped table-hover" id="tucaoTable">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>时间</th>
                        <th>用户</th>
                        <th>内容</th>
                        <th>喜欢/评论</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="tucaoAdminDtos" id="t">
                        <tr>
                            <td><s:property value="#t.tid"/></td>
                            <td><s:property value="#t.time"/></td>
                            <td><a onclick="$.searchTable('<s:property value="#t.name"/>')"> <img class="avatar" src="http://imucommunity-1252858792.image.myqcloud.com/avatar/<s:property value="#t.avatar"/>" width="30px"><s:property value="#t.name"/>(<s:property value="#t.uid" />)</a></td>
                            <td><s:property value="#t.content"/></td>
                            <td><a  data-toggle="modal" href="#modallike<s:property value="#t.tid"/>"><s:property value="#t.like_num"/></a>/<a  data-toggle="modal" href="#modalcomment<s:property value="#t.tid"/>"><s:property value="#t.comment_num"/></a></td>
                            <td>
                                <a class="btn red btn-outline" data-btnOkClass="btn btn-danger" data-btn-ok-label="确认删除" data-btn-cancel-label="取消" data-btnCancelClass="btn btn-info" data-toggle="confirmation" data-href="tucao_delete?tid=<s:property value="#t.tid"/>" data-title="确认删除？">删除</a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
            <!-- begin modal-->
            <s:iterator value="tucaoAdminDtos" id="t">
                <div id="modallike<s:property value="#t.tid"/>" class="modal fade modal-scroll" tabindex="-1" data-replace="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                <h4 class="modal-title">喜欢列表</h4>
                            </div>
                            <div class="modal-body">
                                <s:iterator value="#t.like" id="l">
                                    <s:property value="#l.name"/>
                                </s:iterator>
                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn dark btn-outline">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="modalcomment<s:property value="#t.tid"/>" class="modal fade modal-scroll" tabindex="-1" data-replace="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                <h4 class="modal-title">评论列表</h4>
                            </div>
                            <div class="modal-body">
                                <s:iterator value="#t.comments" id="c">
                                    <table class="table table-striped table-hovor">
                                        <tr>
                                            <td><s:property value="#c.cid"/></td>
                                            <td><s:property value="#c.content"/></td>
                                        </tr>
                                    </table>
                                </s:iterator>
                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn dark btn-outline">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </s:iterator>
            <!--end modal-->
            <button class="btn default m-icon" id="cancelBtn" style="display: none" onclick="$.cancelSearch()">
                取消过滤
            </button>
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
<%--<script src="../assets/global/scripts/datatable.js" type="text/javascript"></script>--%>
<script src="../assets/global/plugins/bootstrap-confirmation/bootstrap-confirmation.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="../assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js"
        type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="../assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script>
    $(document).ready(function () {
        $('#tucaoTable').DataTable({
            "order": [[0, "desc"]],
            "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",
            "buttons": [
                { extend: 'print', className: 'btn dark btn-outline' },
                { extend: 'pdf', className: 'btn green btn-outline' },
                { extend: 'csv', className: 'btn purple btn-outline ' },
            ],
            "pageLength":50,
            language: {
                "processing": "处理中...",
                "lengthMenu": "显示 _MENU_ 项结果",
                "zeroRecords": "没有匹配结果",
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "infoFiltered": "(由 _MAX_ 项结果过滤)",
                "infoPostFix": "",
                "search": "搜索:",
                "url": "",
                "emptyTable": "表中数据为空",
                "loadingRecords": "载入中...",
                "infoThousands": ",",
                "paginate": {
                    "first": "首页",
                    "previous": "上页",
                    "next": "下页",
                    "last": "末页"
                },
                "aria": {
                    "sortAscending": ": 以升序排列此列",
                    "sortDescending": ": 以降序排列此列"
                }
            }
        });

        $.searchTable=function (key){
            $('#tucaoTable').DataTable().column(2).search(key).draw();
            $('#cancelBtn').css("display","block");
        };

        $.cancelSearch=function () {
            $('#tucaoTable').DataTable().column(2).search('').draw();
            $('#cancelBtn').css("display","none");
        }
    });
</script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="../assets/layouts/layout5/scripts/layout.min.js" type="text/javascript"></script>
<script src="../assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
</body>
</html>