<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>CHENBRO | Barcode</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/barcode.ico" type="image/x-icon">
    <!-- SweetAlert2 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootTree/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/v4-shims.min.css">
    <!-- Toastr -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/toastr/toastr.min.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../navBar.jsp"/>
    <!-- /.navbar -->
    <!-- Main Sidebar Container -->
    <jsp:include page="../aside.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">打印程序管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">打印程序管理</a></li>
                            <li class="breadcrumb-item active">编码规则引用管理</li>
                        </ol>
                    </div><!-- /.col -->

                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- /.modal -->

        <div class="modal fade" id="modal-lg">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">编码规则详细信息</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="addUserForm">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="ruleNo" class="col-sm-2 col-form-label">規則编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="ruleNo" id="ruleNo" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="ruleDesc" class="col-sm-2 col-form-label">規則描述</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="ruleDesc" id="ruleDesc" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="ruleCreateBy" class="col-sm-2 col-form-label">创建者</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="ruleCreateBy" id="ruleCreateBy" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="ruleCreateTime" id="ruleCreateTime" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="ruleUpdateBy" class="col-sm-2 col-form-label">修改者</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="ruleUpdateBy" id="ruleUpdateBy" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="ruleUpdateTime" id="ruleUpdateTime" readonly>
                                    </div>
                                </div>
                                <!-- modal table show -->
                                <div class="form-group row">
                                    <table class="table table-striped projects">
                                        <thead>
                                        <tr>
                                            <th style="width: 10%">
                                                #
                                            </th>
                                            <th style="width: 20%">
                                                類型编号
                                            </th>
                                            <th style="width: 15%">
                                                類型描述
                                            </th>
                                            <th style="width: 15%">
                                                規則值
                                            </th>
                                            <th style="width: 15%">
                                                規則長度
                                            </th>
                                            <th style="width: 12%">
                                                创建者
                                            </th>
                                            <th style="width: 12%">
                                                修改者
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody id="detailBody">
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                        </form>
                    </div>

                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>

        <!-- /.modal -->
        <!-- /.modal updateCite  -->

        <div class="modal fade" id="modal-lg1">
            <div class="modal-dialog modal-lg">
                <form class="form-horizontal" id="updateForm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">编码引用管理详细信息</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="upRuleNo" class="col-sm-2 col-form-label">规则编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="uuid" id="uuid"  hidden>
                                        <input type="text" class="form-control" name="updateBy" id="updateBy"  hidden>
                                        <input type="text" class="form-control" name="ruleNo" id="upRuleNo">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="cusNo" class="col-sm-2 col-form-label">客户编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="cusNo" id="cusNo">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="delMatno" class="col-sm-2 col-form-label">出货料号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="delMatno" id="delMatno">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="boundType" class="col-sm-2 col-form-label">绑定类型</label>
                                    <div class="col-sm-10">
                                        <select type="text" class="form-control" name="boundType" id="boundType">
                                            <option value="0">CT引用</option>
                                            <option value="1">装箱单引用</option>
                                            <option value="2">栈板引用</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer justify-content-between">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" id="updateBtn" class="btn btn-primary">修改</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </form>
            </div>
            <!-- /.modal-dialog -->
        </div>

        <!-- /.modal  updateCite -->


        <!-- Main content -->
        <section class="content">


            <!-- Default box -->
            <div class="card">
                <div class="card-header">
                    <button class="btn btn-navbar" data-toggle="modal" data-target="#modal-lg"><i
                            class="fas fa-file"></i>添加
                    </button>
                    <a class="btn btn-navbar" href="${pageContext.request.contextPath}/rule/queryRuleCite.do"><i
                            class="fa fa-refresh"></i>刷新
                    </a>
                    <div class="card-tools">
                        <!-- SEARCH FORM -->
                        <form action="${pageContext.request.contextPath}/rule/queryRuleCite.do">
                            <div class="input-group input-group-sm">
                                <input class="form-control form-control-sm" type="search" name="delMatno" placeholder="Search"
                                       aria-label="Search">
                                <div class="input-group-append">
                                    <button class="btn btn-navbar" type="submit">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="card-body p-0">
                    <table class="table table-striped projects">
                        <thead>
                        <tr>
                            <th style="width: 1%">
                                #
                            </th>
                            <th style="width: 9%">
                                规则编号
                            </th>
                            <th style="width: 15%">
                                客户编号
                            </th>
                            <th style="width: 15%">
                                出货料号
                            </th>
                            <th style="width: 15%" class="text-center">
                                引用类型
                            </th>
                            <th style="width: 15%">
                                创建者
                            </th>
                            <th style="width: 15%">
                                修改者
                            </th>
                            <th style="width: 15%">
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="ruleCite">
                            <tr>
                                <td>
                                    #
                                </td>
                                <td>
                                    <a href="javascript:void(0)" onclick="queryDetail('${ruleCite.ruleNo}')">
                                            ${ruleCite.ruleNo}
                                    </a>
                                </td>
                                <td>
                                        ${ruleCite.cusNo}
                                </td>
                                <td>
                                        ${ruleCite.delMatno}
                                </td>
                                <td class="project-state">
                                    <c:if test="${ruleCite.boundType == '0'}">
                                        <span class="badge badge-success">CT规则引用</span>
                                    </c:if>
                                    <c:if test="${ruleCite.boundType== '1'}">
                                        <span class="badge badge-warning">装箱单规则引用</span>
                                    </c:if>
                                    <c:if test="${ruleCite.boundType== '2'}">
                                        <span class="badge badge-primary">栈板规则引用</span>
                                    </c:if>
                                </td>
                                <td>
                                        ${ruleCite.createBy}
                                    <br/>
                                    <small>
                                            ${ruleCite.createDate}
                                    </small>
                                </td>
                                <td>
                                        ${ruleCite.updateBy}
                                    <br/>
                                    <small>
                                            ${ruleCite.updateDate}
                                    </small>
                                </td>
                                <td class="project-actions text-right">
                                    <button class="btn btn-info btn-sm"  onclick="edit('${ruleCite.uuid}')">
                                        <i class="fas fa-pencil-alt">
                                        </i>
                                        编辑
                                    </button>
                                    <a class="btn btn-danger btn-sm" href="#">
                                        <i class="fas fa-trash">
                                        </i>
                                        删除
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->
            <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=1&size=${pageInfo.pageSize}">首页</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                    </li>
                    <c:choose>
                        <c:when test="${pageInfo.pages < 6}">
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <c:if test="${pageNum == pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link"
                                                                    href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="${pageInfo.pageNum -3 < 1 ? 1 : pageInfo.pageNum -3 }"
                                       end="${pageInfo.pageNum + 3 > pageInfo.pages ? pageInfo.pages : pageInfo.pageNum + 3}"
                                       var="pageNum">
                                <c:if test="${pageNum == pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link"
                                                                    href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/rule/queryRuleCite.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a>
                    </li>
                </ul>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <!-- Control Sidebar  foot jsp include -->
    <!-- /.control-sidebar -->
    <!-- Main Footer -->
    <%@include file="../footer.jsp" %>
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/bootTree/js/jquery-2.1.0.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/bootTree/js/bootstrap-treeview.js"></script>
<!-- SweetAlert2 -->
<script src="${pageContext.request.contextPath}/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="${pageContext.request.contextPath}/plugins/toastr/toastr.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000
    });
    $(function () {
        const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000
        });
        $('#updateBtn').click(function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/rule/updateRuleCite.do',
                data: $('#updateForm').serialize(),           //序列化表单数据，格式为name=value
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        window.location.href = '${pageContext.request.contextPath}/rule/queryRuleCite.do';
                    } else {
                        Toast.fire({
                            type: 'warning',
                            title: '更新失败,' + data.message
                        })
                    }
                },
                error: function () {
                    Toast.fire({
                        type: 'warning',
                        title: '更新Error'
                    })
                }

            })
        })

    });
    function edit(uuid){
        $.ajax({
            url: '${pageContext.request.contextPath}/rule/queryCiteById.do',
            data: {'uuid': uuid},           //序列化表单数据，格式为name=value
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    var ruleCite = data.data;
                    $("#upRuleNo").val(ruleCite.ruleNo);
                    $("#cusNo").val(ruleCite.cusNo);
                    $("#delMatno").val(ruleCite.delMatno);
                    $("#boundType").val(ruleCite.boundType);
                    $("#uuid").val(ruleCite.uuid);
                    var userName = $('#userName').html();
                    $('#updateBy').val(userName);
                    $("#modal-lg1").modal();
                } else {
                    Toast.fire({
                        type: 'warning',
                        title: '信息查詢失敗' + data.message
                    })
                }
            },
            error: function () {
                Toast.fire({
                    type: 'warning',
                    title: '查询详细信息错误'
                })
            }

        })
    }

    function queryDetail(ruleNo) {
        $.ajax({
            url: '${pageContext.request.contextPath}/rule/queryRuleDetailByNo.do',
            data: {'ruleNo': ruleNo},           //序列化表单数据，格式为name=value
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    var ruleInfo = data.data;
                    //  編碼規則 详细信息
                    $('#ruleNo').val(ruleInfo.ruleNo);
                    $('#ruleDesc').val(ruleInfo.ruleDesc);
                    $('#ruleCreateBy').val(ruleInfo.createBy);
                    $('#ruleCreateTime').val(ruleInfo.createDate);
                    $('#ruleUpdateBy').val(ruleInfo.updateBy);
                    $('#ruleUpdateTime').val(ruleInfo.updateDate);
                    // 編碼規則詳細信息

                    //拼接字符串innerHtml
                    var innerElement = '';
                    $('#detailBody').html('');
                    for (let ruleContent of ruleInfo.ruleContents) {
                        var ruleType = ruleContent.ruleType;
                        innerElement += '<tr><td>'+ ruleContent.sequence +'</td><td>' + ruleContent.typeNo + '</td><td>' + ruleType.typeDesc + '</td><td>' + ruleContent.ruleValue + '</td><td>' + ruleContent.ruleLength + '</td><td>' + ruleContent.createBy+ '<br/><small>' + ruleContent.createDate+ '</small></td><td>' + ruleContent.updateBy+ '<br/><small>' + ruleContent.updateDate+ '</small></td></tr>'
                    }
                    $('#detailBody').html(innerElement);
                    $('#modal-lg').modal();

                } else {
                    Toast.fire({
                        type: 'warning',
                        title: '信息查詢失敗' + data.message
                    })
                }
            },
            error: function () {
                Toast.fire({
                    type: 'warning',
                    title: '查询详细信息错误'
                })
            }

        })
    }



</script>
</body>
</html>
