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
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <!-- Bootstrap4 Duallistbox -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
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
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>用户</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Barcode</a></li>
              <li class="breadcrumb-item active">用户</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">员工</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fas fa-minus"></i></button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fas fa-times"></i></button>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
            <thead>
            <tr>
              <th style="width: 1%">
                #
              </th>
              <th style="width: 20%">
                工号
              </th>
              <th style="width: 30%">
                用户名
              </th>
              <th>
                电话
              </th>
              <th style="width: 8%" class="text-center">
              启用状态
            </th>
              <th style="width: 8%" class="text-center">
                部门
              </th>
              <th style="width: 20%">
              </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="user">
            <tr>
              <td>
                #
              </td>
              <td>
                <a>
                  ${user.workNumber}
                </a>
                <br/>
                <small>
                  ${user.createDate}
                </small>
              </td>
              <td>
                ${user.username}
              </td>
              <td class="project_progress">
                ${user.mobile}
              </td>
              <td class="project-state">
                <div class="card-body">
                  <input type="checkbox" readonly="readonly" name="my-checkbox" <c:if test="${user.enableState == '1'}">checked</c:if> data-bootstrap-switch data-off-color="danger" data-on-color="success">
                </div>
              </td>
              <td>
                ${user.departmentName}
              </td>
              <td class="project-actions text-right">
                <a class="btn btn-primary btn-sm" href="#">
                  <i class="fas fa-folder">
                  </i>
                  查看
                </a>
                <a class="btn btn-info btn-sm" href="#">
                  <i class="fas fa-pencil-alt">
                  </i>
                  编辑
                </a>
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
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/query.do?page=1&size=${pageInfo.pageSize}">首页</a></li>
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/query.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
          <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/query.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
          </c:forEach>
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/query.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/query.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a></li>
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
<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="${pageContext.request.contextPath}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>

<!-- PAGE PLUGINS -->
<!-- jQuery Mapael -->
<script src="${pageContext.request.contextPath}/plugins/jquery-mousewheel/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jquery-mapael/jquery.mapael.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jquery-mapael/maps/usa_states.min.js"></script>
<!-- ChartJS -->
<script src="${pageContext.request.contextPath}/plugins/chart.js/Chart.min.js"></script>
<!-- Bootstrap Switch -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- PAGE SCRIPTS -->
<script src="${pageContext.request.contextPath}/dist/js/pages/dashboard2.js"></script>
<!--Page Script -->
<script>
  $(function(){
    $("input[data-bootstrap-switch]").each(function(){
      $(this).bootstrapSwitch('state', $(this).prop('checked'));
    });
  })

</script>
</body>
</html>
