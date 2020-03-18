<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>CHENBRO | Barcode</title>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/barcode.ico" type="image/x-icon">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bootTree/css/default.css">
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
            <h1 class="m-0 text-dark">浪潮条码进度</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">条码</a></li>
              <li class="breadcrumb-item active">浪潮条码进度</li>
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

          <div class="card-tools" >
            <!-- SEARCH FORM -->
            <form>
              <div class="input-group input-group-sm">
              <input class="form-control form-control-sm" type="search" placeholder="Search" aria-label="Search">
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
              <th>
                #
              </th>
              <th>
                批次序号
              </th>
              <th>
                工单号
              </th>
              <th>
                客户料号
              </th>
              <th>
                数量
              </th>
              <th>
                批次号
              </th>
              <th>
                栈板号
              </th>
              <th>
                车俩号
              </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="pallet">
              <tr>
                <td>
                  #
                </td>
                <td>
                  <a>
                      ${pallet.itemNo}
                  </a>
                  <br/>
                  <small>
                        <fmt:formatDate value="${pallet.scanTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                  </small>
                </td>
                <td>
                    ${pallet.workOrder}
                </td>
                <td>
                    ${pallet.customerSegment}
                </td>
                <td>
                    ${pallet.amount}
                </td>
                <td>
                    ${pallet.batchNo}
                </td>
                <td>
                    ${pallet.palletNo}
                </td>
                <td>
                    ${pallet.po}
                </td>
                <td>
                    ${pallet.vehicleNo}
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
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=1&size=${pageInfo.pageSize}">首页</a></li>
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
            <c:choose>
              <c:when test="${pageInfo.pages < 6}">
                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
                  <c:if test="${pageNum == pageInfo.pageNum}">
                    <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                  </c:if>
                  <c:if test="${pageNum != pageInfo.pageNum}">
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                  </c:if>
                </c:forEach>
              </c:when>
              <c:otherwise>
                <c:forEach begin="${pageInfo.pageNum -3 < 1 ? 1 : pageInfo.pageNum -3 }" end="${pageInfo.pageNum + 3 > pageInfo.pages ? pageInfo.pages : pageInfo.pageNum + 3}" var="pageNum" >
                  <c:if test="${pageNum == pageInfo.pageNum}">
                    <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                  </c:if>
                  <c:if test="${pageNum != pageInfo.pageNum}">
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                  </c:if>
                </c:forEach>
              </c:otherwise>
            </c:choose>
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/box/queryInspur.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a></li>
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
<script src="${pageContext.request.contextPath}/bootTree/js/jquery-2.1.0.min.js"></script>
</body>

</html>
