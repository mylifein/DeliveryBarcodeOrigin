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
  <!-- treeview -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bootTree/css/bootstrap-treeview.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <style type="text/css">
    .thumb-image{
      width:120px;
      height:120px;
      position:relative;
      padding:5px;
      border: #0b2e13;
    }
  </style>
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
            <h1 class="m-0 text-dark">用户管理</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/user/query.do">用户管理</a></li>
              <li class="breadcrumb-item active">用户详细信息</li>
            </ol>
          </div><!-- /.col -->

        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->


    <!-- Main content -->
    <section class="content">
<%--      <button class="btn btn-navbar" data-toggle="modal" data-target="#modal-lg"><i class="fas fa-file"></i>添加</button>--%>
      <!-- Default box -->
  <form class="form-horizontal" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/update.do" method="post">
      <div class="card">
        <div class="card card-info">
          <div class="card-header">
            <h3 class="card-title">用户详细信息</h3>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
            <tr>
              <td>
                <div class="form-group row">
                  <!-- left column -->

                  <label for="username" class="col-sm-2 col-form-label">用户名</label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control" id="username" name="username" readonly value="${user.username}">
                      <input type="text" hidden id="uuid" name="uuid"  value="${user.uuid}">
                  </div>
                </div>
              </td>
              <td>
                <div class="form-group row">
                <label for="workNumber" class="col-sm-2 col-form-label">工号</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="workNumber" name="workNumber" value="${user.workNumber}">
                </div>
                </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form-group row">
                  <!-- left column -->
                  <label for="email" class="col-sm-2 col-form-label">电子邮箱</label>
                  <div class="col-sm-8">
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                  </div>
                </div>
              </td>
              <td>
                <div class="form-group row">
                  <label for="mobile" class="col-sm-2 col-form-label">手机号</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="mobile" name="mobile" value="${user.mobile}">
                  </div>
                </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form-group row">
                  <label for="mobile" class="col-sm-2 col-form-label">性别</label>
                  <div class="col-sm-10">
                    <div class="icheck-primary d-inline">
                      <input type="radio" id="radioPrimary1" name="gender" value="1" ${user.gender == 1?'checked':''}>
                      <label for="radioPrimary1">
                        男
                      </label>
                    </div>
                    <div class="icheck-primary d-inline">
                      <input type="radio" id="radioPrimary2" name="gender" value="0" ${user.gender == 0?'checked':''}>
                      <label for="radioPrimary2">
                        女
                      </label>
                    </div>
                  </div>
                </div>
              </td>
              <td>
                <div class="form-group row">
                  <label for="departmentName" class="col-sm-2 col-form-label">部门</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="departmentName" id="departmentName" value="${user.departmentName}" readonly placeholder="部门选择" onclick="$('#treeview').show()">
                    <input type="text" name="departmentId" id="departmentId" hidden value="${user.departmentId}">
                    <div id="treeview" style="display: none"></div>
                  </div>
                </div>
              </td>
            </tr>
            <tr>
              <td>
              <div class="form-group row">
                <label for="mobile" class="col-sm-2 col-form-label">启用状态</label>
                <div class="col-sm-10">
                  <input type="checkbox" name="enableState" data-bootstrap-switch data-off-color="danger" value="1" data-on-color="success" ${user.enableState == '1'?'checked':''}>
                </div>
              </div>
              </td>
              <td rowspan="2">
                <div class="form-group row">
                  <label for="image-holder" class="col-sm-2 col-form-label">图片预览</label>
                  <img id="image-holder" class="thumb-image" src="${user.staffPhoto}"/>
                </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form-group row">
                  <!-- left column -->
                  <label for="stuffPhoto" class="col-sm-2 col-form-label">用户头像</label>
                  <div class="col-sm-8">
                    <div class="custom-file">
                      <input type="file" class="custom-file-input" id="stuffPhoto" name="stuffPhoto">
                        <input type="text" hidden id="staffPhoto" name="staffPhoto">
                      <label class="custom-file-label" for="stuffPhoto">用户头像</label>
                    </div>
                  </div>
                </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form-group row">
                  <!-- left column -->
                  <label for="createBy" class="col-sm-2 col-form-label">创建者</label>
                  <div class="col-sm-8">
                    <input type="email" class="form-control" id="createBy" name="createBy" value="${user.createBy}" readonly>
                  </div>
                </div>
              </td>
              <td>
                <div class="form-group row">
                  <label for="createTime" class="col-sm-2 col-form-label">创建时间</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="createTime" name="createTime" value="${user.createDate}" readonly>
                  </div>
                </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form-group row">
                  <!-- left column -->
                  <label for="updateByUser" class="col-sm-2 col-form-label">更新者</label>
                  <div class="col-sm-8">
                    <input type="email" class="form-control" id="updateByUser" name="updateByUser" value="${user.updateBy}" readonly>
                  </div>
                </div>
              </td>
              <td>
                <div class="form-group row">
                  <label for="updateTimeBan" class="col-sm-2 col-form-label">更新时间</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="updateTimeBan" name="updateTimeBan" value="${user.updateDate}" readonly>
                  </div>
                </div>
              </td>
            </tr>
            <tr>
            </tr>

          </table>
        </div>
        <!-- /.card-body -->
        <div class="card-footer">
          <button type="submit" class="btn btn-primary">保存</button>
        </div>
      </div>
      <!-- /.card -->
  </form>

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
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- SweetAlert2 -->
<script src="${pageContext.request.contextPath}/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="${pageContext.request.contextPath}/plugins/toastr/toastr.min.js"></script>
<!-- select treeview -->
<script src="${pageContext.request.contextPath}/bootTree/js/bootstrap-treeview.js"></script>
<!-- bs-custom-file-input -->
<script src="${pageContext.request.contextPath}/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<script>
  var jsonTree;
  $(function() {
    bsCustomFileInput.init();
    const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });
    $.ajax({
      type : "post",
      url : "${pageContext.request.contextPath}/department/deparmentTree.do",
      success : function(data, status) {
        if (status == "success") {
          jsonTree = data;
        }
      },
      error : function() {
        toastr.error('Error');
      },
    });
    $("#stuffPhoto").on('change', function () {
      var filePath = $("#stuffPhoto").val();
      var extractStart = filePath.lastIndexOf(".");
      var fileType = filePath.substring(extractStart, filePath.length).toUpperCase();
      if (fileType != ".BMP" && fileType != ".PNG" && fileType != ".GIF" && fileType != ".JPG" && fileType != ".JPEG"){
        Toast.fire({
          type: 'warning',
          title: '图片限于bmp,png,gif,jpeg,jpg格式'
        })

      }else{

      if (typeof (FileReader) != "undefined") {

        var image_holder = $("#image-holder");
        image_holder.empty();

        var reader = new FileReader();
        reader.onload = function (e) {
          image_holder.attr("src",e.target.result);
          $('#staffPhoto').val(e.target.result);

        }
        reader.readAsDataURL($(this)[0].files[0]);
      } else {
        Toast.fire({
          type: 'warning',
          title: '图片限于bmp,png,gif,jpeg,jpg格式'
        })
      }
      }
    });

    $('#addBtn').click(function () {
      $.ajax({
        url:'${pageContext.request.contextPath}/user/add.do',
        data:$('#addUserForm').serialize(),           //序列化表单数据，格式为name=value
        type:'POST',
        dataType:'json',
        success:function (data) {
          console.log(data);
          if(data.success){
            // Toast.fire({
            //   type: 'warning',
            //   title: '保存成功'
            // });
            window.location.href = '${pageContext.request.contextPath}/user/query.do';
          }else{
            Toast.fire({
              type: 'warning',
              title: '保存失败,' + data.message
            })
          }
        },
        error:function () {
          Toast.fire({
            type: 'warning',
            title: '保存Error'
          })
        }

      })
    })
    $('#departmentName').click(function(){
      var options = {
        bootstrap2 : false,
        showTags : true,
        levels : 5,
        showCheckbox : true,
        color: "#428bca",
        expandIcon: "fas fa-plus",
        collapseIcon: "fas fa-minus",
        nodeIcon: "fas fa-user",
        data : jsonTree,
        onNodeSelected : function(event, data) {
          $("#departmentName").val(data.text);
          $("#departmentId").val(data.id);
          $("#treeview").hide();
        }
      };
      $('#treeview').treeview(options);
    })
  });




</script>
</body>
</html>
