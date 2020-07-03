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
                            <li class="breadcrumb-item active">参数引用管理</li>
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
                        <h4 class="modal-title">模板字段详细信息</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="addUserForm">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="manNo" class="col-sm-2 col-form-label">模板参数编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="manNo" id="manNo" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="manDesc" class="col-sm-2 col-form-label">模板参数描述</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="manDesc" id="manDesc" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <table class="table table-striped projects">
                                        <thead>
                                        <tr>
                                            <th style="width: 1%">
                                                #
                                            </th>
                                            <th style="width: 10%">
                                                字段编号
                                            </th>
                                            <th style="width: 15%">
                                                字段名
                                            </th>
                                            <th style="width: 15%">
                                                字段值
                                            </th>
                                            <th style="width: 20%">
                                                字段描述
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
                            <h4 class="modal-title">参数引用管理详细信息</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="upManNo" class="col-sm-2 col-form-label">参数编号</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="uuid" id="uuid"  hidden>
                                            <input type="text" class="form-control" name="updateBy" id="updateBy"  hidden>
                                            <input type="text" class="form-control" name="manNo" id="upManNo">
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
                    <a class="btn btn-navbar" href="${pageContext.request.contextPath}/field/queryCite.do"><i
                            class="fa fa-refresh"></i>刷新
                    </a>
                    <div class="card-tools">
                        <!-- SEARCH FORM -->
                        <form action="${pageContext.request.contextPath}/field/queryCite.do">
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
                                参数编号
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
                        <c:forEach items="${pageInfo.list}" var="mandCite">
                            <tr>
                                <td>
                                    #
                                </td>
                                <td>
                                    <a href="javascript:void(0)" onclick="queryDetail('${mandCite.manNo}')">
                                        ${mandCite.manNo}
                                    </a>
                                </td>
                                <td>
                                        ${mandCite.cusNo}
                                </td>
                                <td>
                                        ${mandCite.delMatno}
                                </td>
                                <td class="project-state">
                                    <c:if test="${mandCite.boundType == '0'}">
                                        <span class="badge badge-success">CT引用</span>
                                    </c:if>
                                    <c:if test="${mandCite.boundType== '1'}">
                                        <span class="badge badge-warning">装箱单引用</span>
                                    </c:if>
                                    <c:if test="${mandCite.boundType== '2'}">
                                        <span class="badge badge-primary">栈板引用</span>
                                    </c:if>
                                </td>
                                <td>
                                        ${mandCite.createBy}
                                    <br/>
                                    <small>
                                        ${mandCite.createDate}
                                    </small>
                                </td>
                                <td>
                                    ${mandCite.updateBy}
                                    <br/>
                                    <small>
                                        ${mandCite.updateDate}
                                    </small>
                                </td>
                                <td class="project-actions text-right">
                                    <button class="btn btn-info btn-sm"  onclick="edit('${mandCite.uuid}')">
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
                                             href="${pageContext.request.contextPath}/field/queryCite.do?page=1&size=${pageInfo.pageSize}">首页</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                    </li>
                    <c:choose>
                        <c:when test="${pageInfo.pages < 6}">
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <c:if test="${pageNum == pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link"
                                                                    href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
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
                                                                    href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/field/queryCite.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a>
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
                url: '${pageContext.request.contextPath}/field/updateFieldCite.do',
                data: $('#updateForm').serialize(),           //序列化表单数据，格式为name=value
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        window.location.href = '${pageContext.request.contextPath}/field/queryCite.do';
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
            url: '${pageContext.request.contextPath}/field/queryCiteById.do',
            data: {'uuid': uuid},           //序列化表单数据，格式为name=value
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    var fieldCite = data.data;
                    console.log(fieldCite);
                    $("#upManNo").val(fieldCite.manNo);
                    $("#cusNo").val(fieldCite.cusNo);
                    $("#delMatno").val(fieldCite.delMatno);
                    $("#boundType").val(fieldCite.boundType);
                    $("#uuid").val(fieldCite.uuid);
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


    function queryDetail(manNo) {
        $.ajax({
            url: '${pageContext.request.contextPath}/field/queryDetailByNo.do',
            data: {'manNo': manNo},           //序列化表单数据，格式为name=value
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    var mandatoryO = data.data;
                    $('#manNo').val(mandatoryO.manNo);
                    $('#manDesc').val(mandatoryO.manDesc);
                    //拼接字符串innerHtml
                    var innerElement = '';
                    $('#detailBody').html('') ;
                    for (let fieldType of mandatoryO.fieldTypes) {
                        innerElement += '<tr><td>#</td><td>' + fieldType.fieldNo + '</td><td>' + fieldType.fieldName + '</td><td>' + fieldType.fieldValue + '</td><td>' + fieldType.fieldDesc + '</td><td>' + fieldType.createBy+ '<br/><small>' + fieldType.createDate+ '</small></td><td>' + fieldType.updateBy+ '<br/><small>' + fieldType.updateDate+ '</small></td></tr>'
                    }
                    $('#detailBody').html(innerElement);
                    $('#modal-lg').modal();

                } else {
                    Toast.fire({
                        type: 'warning',
                        title: '保存失败,' + data.message
                    })
                }
            },
            error: function () {
                Toast.fire({
                    type: 'warning',
                    title: '保存Error'
                })
            }

        })
    }





</script>
</body>
</html>
