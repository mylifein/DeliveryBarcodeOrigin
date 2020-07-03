<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/barcode.ico" type="image/x-icon">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
  <!-- Navbar -->
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->

  <!-- Content Wrapper. Contains page content -->
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
<%--  <aside class="control-sidebar control-sidebar-dark">--%>
<%--    <!-- Control sidebar content goes here -->--%>
<%--  </aside>--%>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2020 <a href="#">CHENBRO</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 1.0
    </div>
  </footer>

  <!-- REQUIRED SCRIPTS -->
  <!-- jQuery -->
  <script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>

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

  <!-- PAGE SCRIPTS -->
  <script src="${pageContext.request.contextPath}/dist/js/pages/dashboard2.js"></script>
</body>
<!-- ./wrapper -->
</html>

