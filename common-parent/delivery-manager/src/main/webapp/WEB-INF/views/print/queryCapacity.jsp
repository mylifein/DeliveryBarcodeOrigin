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
                            <li class="breadcrumb-item active">容量管理</li>
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
                        <h4 class="modal-title">模板引用管理详细信息</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="addUserForm">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="modelNo" class="col-sm-2 col-form-label">模板编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="modelNo" id="modelNo" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="modelName" class="col-sm-2 col-form-label">模板名</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="modelName" id="modelName" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="modelDesc" class="col-sm-2 col-form-label">模板描述</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="modelDesc" id="modelDesc" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="modelCreateBy" class="col-sm-2 col-form-label">创建者</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="modelCreateBy" id="modelCreateBy" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="modelCreateTime" id="modelCreateTime" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="modelUpdateBy" class="col-sm-2 col-form-label">修改者</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="modelUpdateBy" id="modelUpdateBy" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="modelUpdateTime" id="modelUpdateTime" readonly>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-header">
                        <h4 class="modal-title">标签模板参数详细信息</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="addUserForm2">
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
                                    <label for="manCreateBy" class="col-sm-2 col-form-label">创建者</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="manCreateBy" id="manCreateBy" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="manCreateTime" id="manCreateTime" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="manUpdateBy" class="col-sm-2 col-form-label">修改者</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="manUpdateBy" id="manUpdateBy" readonly>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" name="manUpdateTime" id="manUpdateTime" readonly>
                                    </div>
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

        <div class="modal fade" id="modal-lg2">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">修改角色</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="updateUserForm">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="name" class="col-sm-2 col-form-label">角色名</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="name" id="name"
                                               placeholder="仓库管理员">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="description" class="col-sm-2 col-form-label">角色描述</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="description" id="description"
                                               placeholder="负责管理出入库">
                                    </div>
                                </div>
                            </div>

                        </form>

                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" id="updateBtn" class="btn btn-primary">修改</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>

        <!-- Main content -->
        <section class="content">


            <!-- Default box -->
            <div class="card">
                <div class="card-header">
                    <button class="btn btn-navbar" data-toggle="modal" data-target="#modal-lg"><i
                            class="fas fa-file"></i>添加
                    </button>
                    <a class="btn btn-navbar" href="${pageContext.request.contextPath}/print/queryCapacity.do"><i
                            class="fa fa-refresh"></i>刷新
                    </a>
                    <div class="card-tools">
                        <!-- SEARCH FORM -->
                        <form>
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
                                容量编号
                            </th>
                            <th style="width: 15%">
                                容量
                            </th>
                            <th style="width: 15%">
                                容量描述
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
                        <c:forEach items="${pageInfo.list}" var="capacity">
                            <tr>
                                <td>
                                    #
                                </td>
                                <td>
                                    <a href="javascript:void(0)">
                                            ${capacity.capacityNo}
                                    </a>
                                </td>
                                <td>
                                        ${capacity.capacityQty}
                                </td>
                                <td>
                                        ${capacity.capacityDesc}
                                </td>
                                <td>
                                        ${capacity.createBy}
                                    <br/>
                                    <small>
                                        ${capacity.createDate}
                                    </small>
                                </td>
                                <td>
                                    ${capacity.updateBy}
                                    <br/>
                                    <small>
                                        ${capacity.updateDate}
                                    </small>
                                </td>
                                <td class="project-actions text-right">
                                    <button class="btn btn-info btn-sm"  onclick="edit('${modelCite.uuid}')">
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
                                             href="${pageContext.request.contextPath}/print/queryCapacity.do?page=1&size=${pageInfo.pageSize}">首页</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                    </li>
                    <c:choose>
                        <c:when test="${pageInfo.pages < 6}">
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <c:if test="${pageNum == pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link"
                                                                    href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
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
                                                                    href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/print/queryCapacity.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a>
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
        $('#addBtn').click(function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/role/add.do',
                data: $('#addUserForm').serialize(),           //序列化表单数据，格式为name=value
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                    if (data.success) {
                        window.location.href = '${pageContext.request.contextPath}/role/query.do';
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
        })


    });
    function edit(uuid){
        <%--$.get("${pageContext.request.contextPath}/role/find.do?" ,function (data,status) {--%>

        <%--});--%>
        console.log("进入edit method" + uuid);
        $.ajax({
            url: '${pageContext.request.contextPath}/role/find.do',
            data:{'uuid':uuid},           //序列化表单数据，格式为name=value
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                if (data.success) {

                    console.log("success");
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

    function queryDetail(uuid) {
        $.ajax({
            url: '${pageContext.request.contextPath}/print/queryDetail.do',
            data: {'uuid': uuid},           //序列化表单数据，格式为name=value
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    var modelInfo = data.data;
                    //model 详细信息
                    $('#modelNo').val(modelInfo.fileNo);
                    $('#modelName').val(modelInfo.fileName);
                    $('#modelDesc').val(modelInfo.fileDescription);
                    $('#modelCreateBy').val(modelInfo.createBy);
                    $('#modelCreateTime').val(modelInfo.createDate);
                    $('#modelUpdateBy').val(modelInfo.updateBy);
                    $('#modelUpdateTime').val(modelInfo.updateDate);
                    //madatory 详细信息
                    var manInfo = modelInfo.mandatoryField;
                    if(manInfo != null){
                    $('#manNo').val(manInfo.manNo);
                    $('#manDesc').val(manInfo.manDesc);
                    $('#manCreateBy').val(manInfo.createBy);
                    $('#manCreateTime').val(manInfo.createDate);
                    $('#manUpdateBy').val(manInfo.updateBy);
                    $('#manUpdateTime').val(manInfo.updateDate);
                    }
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
