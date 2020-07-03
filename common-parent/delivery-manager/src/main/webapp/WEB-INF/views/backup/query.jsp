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
            <h1 class="m-0 text-dark">条码</h1>
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


    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
          <div class="card-header">
          </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
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
                客户编号
              </th>
              <th>
                采购单号
              </th>
              <th>
                销货单号
              </th>
              <th>
                采购单数量
              </th>
              <th>
                出货料号
              </th>
              <th>
                客户料号
              </th>
              <th>
                版本号
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
                  <a href="#">
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
                    ${ctcode.woQuantity}
                </td>
                <td>
                  ${ctcode.cusName}
              </td>
                <td>
                    ${ctcode.cusPo}
                </td>
                <td>
                    ${ctcode.poQty}
                </td>
                <td>
                    ${ctcode.soOrder}
                </td>
                <td>
                    ${ctcode.poQty}
                </td>
                <td>
                  ${ctcode.delMatno}
              </td>
                <td>
                    ${ctcode.cusMatno}
                </td>
                <td>
                    ${ctcode.verNo}
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
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
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
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<!-- SweetAlert2 -->
<script src="${pageContext.request.contextPath}/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="${pageContext.request.contextPath}/plugins/toastr/toastr.min.js"></script>
</body>

</html>
