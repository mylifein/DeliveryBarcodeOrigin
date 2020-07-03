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
            <h1 class="m-0 text-dark">成品条码</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">条码</a></li>
              <li class="breadcrumb-item active">CT码进度</li>
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
            <h4 class="modal-title">CT品质追溯</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="addUserForm">
              <div class="card-body">
                <div class="form-group row">
                  <label for="name" class="col-sm-2 col-form-label">FQC检验</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name"
                           placeholder="检验OK">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="description" class="col-sm-2 col-form-label">OQC检验</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="description" id="description"
                           placeholder="检验OK">
                  </div>
                </div>
              </div>

            </form>

          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" id="addBtn" class="btn btn-primary">添加</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>


    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Info boxes -->


        <!-- /.row -->

        <!-- Main row -->
        <div class="row">
          <!-- Left col -->
          <div class="col-md-12">
            <!-- MAP & BOX PANE -->


            <!-- TABLE: LATEST Ctcodes -->
            <div class="card">
              <div class="card-header border-transparent">
                <div class="card-title">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <a class="btn btn-navbar" href="${pageContext.request.contextPath}/ct/query.do">
                      <i class="fa fa-refresh"></i> 刷新
                    </a>
                  </div>
                </div>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body p-0">
                <div class="table-responsive">
                  <table class="table m-0">
                    <thead>
                    <tr>
                      <th>
                        #
                      </th>
                      <th>
                        CTNumber
                      </th>
                      <th>
                        工单号
                      </th>
                      <th>
                        工单数量
                      </th>
                      <th>
                        客户名称
                      </th>
                      <th>
                        采购单号
                      </th>
                      <th>
                        销货单号
                      </th>
                      <th>
                        出货料号
                      </th>
                      <th>
                      </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="ctcode">
                      <tr>
                        <td>
                          #
                        </td>
                        <td>
                          <a href="#" data-toggle="modal" data-target="#modal-lg">
                              ${ctcode.ctNumber}
                          </a>
                          <br/>
                          <small>
                              ${ctcode.createDate}
                          </small>
                        </td>
                        <td>
                            ${ctcode.workNo}
                        </td>
                        <td>
                            ${ctcode.woQuantity}
                        </td>
                        <td>
                            ${ctcode.cusName}
                        </td>
                        <td>
                            ${ctcode.cusPo}
                        </td>
                        <td>
                            ${ctcode.soOrder}
                        </td>
                        <td>
                            ${ctcode.delMatno}
                        </td>
                        <td class="project-actions text-right">
                          <a class="btn btn-danger btn-sm" href="#">
                            <i class="fas fa-trash">
                            </i>
                            作废
                          </a>
                        </td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
                <!-- /.table-responsive -->
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                  <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=1&size=${pageInfo.pageSize}">首页</a></li>
                  <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
                  <c:choose>
                    <c:when test="${pageInfo.pages < 6}">
                      <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
                        <c:if test="${pageNum == pageInfo.pageNum}">
                          <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageInfo.pageNum}">
                          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:if>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <c:forEach begin="${pageInfo.pageNum -3 < 1 ? 1 : pageInfo.pageNum -3 }" end="${pageInfo.pageNum + 3 > pageInfo.pages ? pageInfo.pages : pageInfo.pageNum + 3}" var="pageNum" >
                        <c:if test="${pageNum == pageInfo.pageNum}">
                          <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageInfo.pageNum}">
                          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:if>
                      </c:forEach>
                    </c:otherwise>
                  </c:choose>
                  <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
                  <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ct/query.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a></li>
                </ul>
              </div>
              <!-- /.card-footer -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->

        </div>
        <!-- /.row -->
      </div><!--/. container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->


  <!-- Control Sidebar  foot jsp include -->
  <!-- /.control-sidebar -->
  <!-- Main Footer -->
  <%@include file="../footer.jsp"%>
</div>
<!-- ./wrapper -->
<!-- ./wrapper -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/bootTree/js/jquery-2.1.0.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/bootTree/js/bootstrap-treeview.js"></script>
<!-- SweetAlert2 -->
<script src="${pageContext.request.contextPath}/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="${pageContext.request.contextPath}/plugins/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
