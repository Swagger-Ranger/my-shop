<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="../includes/headerNav.jsp"/>

    <jsp:include page="../includes/menu.jsp"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <%--<small>：子标题描述--%>
                <%--<small>Control panel</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">

                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status ==200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>



                    <!-- Horizontal Form -->
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form  cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="username" class="col-sm-4 control-label">姓名</label>
                                            <div class="col-sm-8">
                                                <form:input path="username" cssClass="form-control" placeholder="请输入姓名"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-4 control-label">邮箱</label>
                                            <div class="col-sm-8">
                                                <form:input path="email" cssClass="form-control" placeholder="请输入邮箱地址"></form:input>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-4 control-label">手机</label>
                                            <div class="col-sm-8">
                                                <form:input path="phone" cssClass="form-control " placeholder="请输入手机号"></form:input>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">搜索</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>



                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>


                            <div class="row" style="padding-left: 12px;padding-top: 10px">
                                <div class="col-xs-12">
                                    <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;
                                    <button type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/user/delete')"><i class="fa fa-trash-o"></i>删除</button>&nbsp;&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i>导出</a>&nbsp;&nbsp;
                                    <a type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') :$('.box-info-search').hide('fast')" ><i class="fa fa-search"></i>搜索</a>
                                </div>

                            </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="minimal iCheck_master" /></th>
                                        <th>ID</th>
                                        <th>用户名</th>
                                        <th>手机号</th>
                                        <th>邮箱</th>
                                        <th>更新时间</th>
                                        <th>
                                            操作
                                        </th>
                                    </tr>
                                </thead>

                                <c:forEach items="${tbUsers}" var="tbUser">
                                    <tr>
                                        <td><input id="${tbUser.id}" type="checkbox" class="minimal" /></td>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td>${tbUser.email}</td>
                                        <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-mm-dd hh:mm:ss"/> </td>
                                        <td>
                                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i>查看</a>&nbsp;&nbsp;
                                            <a href="#" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;
                                            <a href="#" type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i>删除</a>&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                </c:forEach>



                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../includes/copyright.jsp"/>

</div>

<jsp:include page="../includes/footer.jsp"/>

<%--引入模态框--%>
<sys:modal></sys:modal>

<%--自定义模态框--%>
<%--<script>
    //定义存放元素ID的数组
    var idArray = new Array();


    // 这个会自动触发，因为是个对象
    $(function () {
        var _checkbox = App.getCheckbox();
        _checkbox.each(function () {
            // console.log($(this).is(":checked"));
        });
    });

    //这种是个事件需要触发
    /**
     * @Description 批量删除
     */
    function deleteMulti() {

        //将ID取到放入数组
        var _checkbox = App.getCheckbox();
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                idArray.push(_id);
            }
        });

        if (idArray.length === 0) {
            $("#modalMsg").html("您还未选择任何数据项，请选择一项！");
        }

        else {
            $("#modalMsg").html("您确定删除选中数据项吗？");
        }
        $("#modal-default").modal("show");
    }

    $(function () {
        $("#modalBtnOK").bind("click",function () {
            del(idArray,"/user/delete")
        });

        function del(idArray, url) {
            if (idArray.length === 0) {
                $("#modal-default").modal("hide");
            }

            else {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data":{"ids": idArray.toString()},
                    "dataType":"JSON",
                    "success": function (data) {
                        console.log(data);
                    }
                });
            }

        }

    });
</script>--%>

</body>
</html>