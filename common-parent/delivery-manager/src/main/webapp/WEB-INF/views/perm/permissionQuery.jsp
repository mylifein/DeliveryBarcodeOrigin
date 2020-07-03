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

  <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-treegrid/0.2.0/css/jquery.treegrid.min.css">
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
              <li class="breadcrumb-item"><a href="#">用户管理</a></li>
              <li class="breadcrumb-item active">权限管理</li>
            </ol>
          </div><!-- /.col -->

        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- /.modal menu -->
    <div class="modal fade" id="modal-lg">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">新增菜单权限</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="addPermForm">
              <div class="card-body">
                <div class="form-group row">
                  <label for="name" class="col-sm-2 col-form-label">权限名称</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name">
                    <input type="text" class="form-control" name="parentId" id="parentId" hidden>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="code" class="col-sm-2 col-form-label">权限标识</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="code" id="code">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="description" class="col-sm-2 col-form-label">权限描述</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="description" name="description" >
                  </div>
                </div>
                <div class="form-group row">
                  <label for="menuOrder" class="col-sm-2 col-form-label">菜单顺序</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuOrder" id="menuOrder">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="menuIcon" class="col-sm-2 col-form-label">菜单Icon</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuIcon" id="menuIcon">
                    <input type="text" class="form-control" name="type" id="type" value=1 hidden>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" id="withdraw" class="btn btn-default">取消</button>
            <button type="button" id="addBtn" class="btn btn-primary">添加</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>


    <!-- /.modal point -->
    <div class="modal fade" id="modal-lg1">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">新增按钮权限</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="addPermForm2">
              <div class="card-body">
                <div class="form-group row">
                  <label for="pointName" class="col-sm-2 col-form-label">权限名称</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="pointName">
                    <input type="text" class="form-control" name="parentId" id="pointParentId" hidden>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="pointCode" class="col-sm-2 col-form-label">权限标识</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="code" id="pointCode">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="pointDescription" class="col-sm-2 col-form-label">权限描述</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="pointDescription" name="description" >
                  </div>
                </div>
                <div class="form-group row">
                  <label for="pointClass" class="col-sm-2 col-form-label">按钮样式</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pointClass" id="pointClass">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="pointIcon" class="col-sm-2 col-form-label">按钮Icon</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pointIcon" id="pointIcon">
                    <input type="text" class="form-control" name="type" id="pointType" value="2" hidden>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="pointStatus" class="col-sm-2 col-form-label">按钮状态</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pointStatus" id="pointStatus">
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" id="withdrawPoint" class="btn btn-default">取消</button>
            <button type="button" id="addPointBtn" class="btn btn-primary">添加</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>


    <!-- /.modal update menu -->
    <div class="modal fade" id="modal-lg2">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">修改菜单权限</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="updatePermForm1">
              <div class="card-body">
                <div class="form-group row">
                  <label for="upName" class="col-sm-2 col-form-label">权限名称</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="upName">
                    <input type="text" class="form-control" name="parentId" id="upParentId" hidden>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="upCode" class="col-sm-2 col-form-label">权限标识</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="code" id="upCode">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="upDescription" class="col-sm-2 col-form-label">权限描述</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="upDescription" name="description" >
                  </div>
                </div>
                <div class="form-group row">
                  <label for="upMenuOrder" class="col-sm-2 col-form-label">菜单顺序</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuOrder" id="upMenuOrder">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="upMenuIcon" class="col-sm-2 col-form-label">菜单Icon</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuIcon" id="upMenuIcon">
                    <input type="text" class="form-control" name="type" value=1 hidden>
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" id="upWithdraw" class="btn btn-default">取消</button>
            <button type="button" id="updateBtn" class="btn btn-primary">添加</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>

    <!-- /.modal update point -->
    <div class="modal fade" id="modal-lg3">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">修改按钮权限</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" id="updatePermForm2">
              <div class="card-body">
                <div class="form-group row">
                  <label for="upPointName" class="col-sm-2 col-form-label">权限名称</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="upPointName">
                    <input type="text" class="form-control" name="parentId" id="updatePointParentId" hidden>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="updatePointCode" class="col-sm-2 col-form-label">权限标识</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="code" id="updatePointCode">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="updatePointDescription" class="col-sm-2 col-form-label">权限描述</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="updatePointDescription" name="description" >
                  </div>
                </div>
                <div class="form-group row">
                  <label for="updatePointClass" class="col-sm-2 col-form-label">按钮样式</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pointClass" id="updatePointClass">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="updatePointIcon" class="col-sm-2 col-form-label">按钮Icon</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pointIcon" id="updatePointIcon">
                    <input type="text" class="form-control" name="type" value="2" hidden>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="updatePointStatus" class="col-sm-2 col-form-label">按钮状态</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="pointStatus" id="updatePointStatus">
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" id="withdrawUpdatePoint" class="btn btn-default">取消</button>
            <button type="button" id="updatePointBtn" class="btn btn-primary">修改</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>




    <!-- Main content -->
    <section class="content">
      <div class="card">
        <div class="card-header">
          <div class="card-title">
            <div class="input-group input-group-sm" style="width: 150px;">
            </div>
          </div>
          <div class="card-tools">
            <div class="input-group input-group-sm" style="width: 150px;">
              <div class="input-group-append">
                <button type="button" data-toggle="modal" data-target="#modal-lg" class="btn btn-info"><i class="fas fa-pencil-alt">添加</i></button>
              </div>
            </div>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects" id="table"></table>
          <br/>
          <button onclick="test()">选择</button>
        </div>
        <!-- /.card-body -->
        <div class="card-footer">
        </div>
      </div>
      <!-- /.card -->


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
<%--<script src="${pageContext.request.contextPath}/bootTree/js/jquery-2.1.0.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/bootTree/js/bootstrap-treeview.js"></script>
<!-- SweetAlert2 -->
<script src="${pageContext.request.contextPath}/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="${pageContext.request.contextPath}/plugins/toastr/toastr.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.12.0/extensions/treegrid/bootstrap-table-treegrid.js"></script>
<script src="https://cdn.bootcss.com/jquery-treegrid/0.2.0/js/jquery.treegrid.min.js"></script>
<script>
  var $table = $('#table');

  $(function() {
    const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });
    queryPerms();

    $('#withdraw').click(function () {
      $('#addPermForm')[0].reset();
      $('#modal-lg').modal("hide");
    });

    $('#withdrawPoint').click(function () {
      $('#addPermForm2')[0].reset();
      $('#modal-lg1').modal("hide");
    });

    $('#addBtn').click(function () {
      $.ajax({
        url:'${pageContext.request.contextPath}/perm/add.do',
        data:$('#addPermForm').serialize(),           //序列化表单数据，格式为name=value
        type:'POST',
        dataType:'json',
        success:function (data) {
          if(data.success){
            $table.bootstrapTable('destroy');
            queryPerms();
            $('#addPermForm')[0].reset();
            $('#modal-lg').modal("hide");
          }else{
            Toast.fire({
              type: 'warning',
              title: data.message
            })
          }
        },
        error:function () {
          Toast.fire({
            type: 'warning',
            title: '查詢Error'
          })
        }

      })
    })

    $('#addPointBtn').click(function () {
      $.ajax({
        url:'${pageContext.request.contextPath}/perm/add.do',
        data:$('#addPermForm2').serialize(),           //序列化表单数据，格式为name=value
        type:'POST',
        dataType:'json',
        success:function (data) {
          if(data.success){
            $table.bootstrapTable('destroy');
            queryPerms();
            $('#addPermForm2')[0].reset();
            $('#modal-lg1').modal("hide");
          }else{
            Toast.fire({
              type: 'warning',
              title: data.message
            })
          }
        },
        error:function () {
          Toast.fire({
            type: 'warning',
            title: '查詢Error'
          })
        }

      })
    })
  });

  // 格式化按钮
  function operateFormatter(value, row, index) {
    if(row.type === 1){
      return [
        '<button type="button" class="RoleOfadd btn btn-warning btn-sm" style="margin-right:15px;"><i class="fas fa-plus" ></i>&nbsp;新增菜单</button>',
        '<button type="button" class="RoleOfBtn btn btn-success btn-sm" style="margin-right:15px;"><i class="fas fa-plus" ></i>&nbsp;新增按钮</button>',
        '<button type="button" class="RoleOfedit btn btn-info btn-sm" style="margin-right:15px;"><i class="fas fa-pencil-alt" ></i>&nbsp;修改</button>',
        '<button type="button" class="RoleOfApi btn btn-primary btn-sm" style="margin-right:15px;"><i class="fas fa-pencil-alt" ></i>&nbsp;查看API权限</button>',
        '<button type="button" class="RoleOfdelete btn btn-danger btn-sm" style="margin-right:15px;"><i class="fas fa-trash" ></i>&nbsp;删除</button>'
      ].join('');
    }else{
      return [
        '<button type="button" class="RoleOfedit btn btn-info btn-sm" style="margin-right:15px;"><i class="fas fa-pencil-alt" ></i>&nbsp;修改</button>',
        '<button type="button" class="RoleOfApi btn btn-primary btn-sm" style="margin-right:15px;"><i class="fas fa-pencil-alt" ></i>&nbsp;查看API权限</button>',
        '<button type="button" class="RoleOfdelete btn btn-danger btn-sm" style="margin-right:15px;"><i class="fas fa-trash" ></i>&nbsp;删除</button>'
      ].join('');
    }

  }
  // 格式化类型
  function typeFormatter(value, row, index) {
    if (value === 'menu') {  return '菜单';  }
    if (value === 'button') {  return '按钮'; }
    if (value === 'api') {  return '接口'; }
    return '-';
  }
  // 格式化状态
  function statusFormatter(value, row, index) {
    if (value === 1) {
      return '<span class="badge badge-success">菜单</span>';
    } else {
      return '<span class="badge badge-info">按钮</span>';
    }
  }

  function queryPerms(){
    $.ajax({
      url: '${pageContext.request.contextPath}/perm/nodes.do',
      type: 'GET',
      dataType: 'json',
      success: function (data) {
        if (data.success) {
          var nodes = data.data;
          $table.bootstrapTable({
            data:nodes,
            idField: 'uuid',
            dataType:'jsonp',
            columns: [
              { field: 'check',  checkbox: true, formatter: function (value, row, index) {
                  if (row.check == true) {
                    // console.log(row.serverName);
                    //设置选中
                    return {  checked: true };
                  }
                }
              },
              { field: 'name',  title: '名称' },
              // {field: 'id', title: '编号', sortable: true, align: 'center'},
              // {field: 'pid', title: '所属上级'},
              { field: 'type',  title: '类型', align: 'center', formatter: 'statusFormatter'  },
              { field: 'code', title: '权限代码'  },
              { field: 'operate', title: '操作', align: 'center', events : operateEvents, formatter: 'operateFormatter' },
            ],

            // bootstrap-table-treegrid.js 插件配置 -- start

            //在哪一列展开树形
            treeShowField: 'name',
            //指定父id列
            parentIdField: 'parentId',

            onResetView: function(data) {
              //console.log('load');
              $table.treegrid({
                initialState: 'collapsed',// 所有节点都折叠
                // initialState: 'expanded',// 所有节点都展开，默认展开
                treeColumn: 1,
                // expanderExpandedClass: 'glyphicon glyphicon-minus',  //图标样式
                // expanderCollapsedClass: 'glyphicon glyphicon-plus',
                onChange: function() {
                  $table.bootstrapTable('resetWidth');
                }
              });

              //只展开树形的第一级节点
              $table.treegrid('getRootNodes').treegrid('expand');

            },
            onCheck:function(row){
              var datas = $table.bootstrapTable('getData');
              // 勾选子类
              selectChilds(datas,row,"uuid","parentId",true);

              // 勾选父类
              selectParentChecked(datas,row,"uuid","parentId")

              // 刷新数据
              $table.bootstrapTable('load', datas);
            },

            onUncheck:function(row){
              var datas = $table.bootstrapTable('getData');
              selectChilds(datas,row,"uuid","parentId",false);
              $table.bootstrapTable('load', datas);
            },
            // bootstrap-table-treetreegrid.js 插件配置 -- end
          });
        } else {
          Toast.fire({
            type: 'warning',
            title: '查询失败,' + data.message
          })
        }
      },
      error: function () {
        Toast.fire({
          type: 'warning',
          title: '查询Error'
        })
      }

    });
  }
  //初始化操作按钮的方法
  window.operateEvents = {
    'click .RoleOfadd': function (e, value, row, index) {
      add(row.uuid);
    },
    'click .RoleOfBtn': function (e, value, row, index) {
      addBtn(row.uuid);
    },
    'click .RoleOfdelete': function (e, value, row, index) {
      del(row.uuid);
    },
    'click .RoleOfedit': function (e, value, row, index) {
      update(row.uuid,row.type,row);
    },
    'click .RoleOfApi': function (e, value, row, index) {
      apis(row.uuid);
    }
  };

  /**
   * 选中父项时，同时选中子项
   * @param datas 所有的数据
   * @param row 当前数据
   * @param id id 字段名
   * @param pid 父id字段名
   */
  function selectChilds(datas,row,id,pid,checked) {
    for(var i in datas){
      if(datas[i][pid] == row[id]){
        datas[i].check=checked;
        selectChilds(datas,datas[i],id,pid,checked);
      };
    }
  }

  function selectParentChecked(datas,row,id,pid){
    for(var i in datas){
      if(datas[i][id] == row[pid]){
        datas[i].check=true;
        selectParentChecked(datas,datas[i],id,pid);
      };
    }
  }

  function test() {
    var selRows = $table.bootstrapTable("getSelections");
    if(selRows.length == 0){
      alert("请至少选择一行");
      return;
    }

    var postData = "";
    $.each(selRows,function(i) {
      postData +=  this.id;
      if (i < selRows.length - 1) {
        postData += "， ";
      }
    });
    alert("你选中行的 id 为："+postData);

  }

  function add(id) {
    //設置parentId
    $('#parentId').val(id);
    console.log($('#parentId').val());
    $('#modal-lg').modal("show");
  }
  function addBtn(id) {
    //設置parentId
    $('#pointParentId').val(id);
    console.log($('#pointParentId').val());
    $('#modal-lg1').modal("show");
  }
  function del(id) {
      $.ajax({
          url: '${pageContext.request.contextPath}/perm/delete.do?id=' +id,
          type: 'GET',
          dataType: 'json',
          success:function (data) {
          if(data.success){
            $table.bootstrapTable('destroy');
            queryPerms();
          }else{
            Toast.fire({
              type: 'warning',
              title: data.message
            })
          }
        },
          error:function () {
          Toast.fire({
            type: 'warning',
            title: '查詢Error'
          })
        }


      });
  }
  function update(id,type,row) {

    alert("id:" + id +　"type:" + type + "row:" + row);
    alert("row.id:" + row.id +　"row.type:" + row.type);
    if(type == 1){

    }else {

    }
    alert("update 方法 , id = " + id);
  }
  function apis(id) {
    alert("apis 方法 , id = " + id);
  }



</script>

</body>
</html>
