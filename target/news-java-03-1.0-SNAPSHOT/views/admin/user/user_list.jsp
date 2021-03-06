<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý tài khoản</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul>
        </div>
        <div class="page-content">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                        ${message}
                </div>
            </c:if>
            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box table-filter">
                        <div class="table-btn-controls">
                            <div class="pull-right tableTools-container">
                                <div class="dt-buttons btn-overlap btn-group">
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                       data-toggle="tooltip"
                                       title='Thêm tài khoản' href="/admin/user?type=create">
<span>
<i class="fa fa-plus-circle bigger-110 purple"></i>
</span>
                                    </a>
                                    <button id="btnDelete" type="button" disabled
                                            class="dt-button buttons-html5 btn btn-white btn-primary btn-bold">
<span>
<i class="fa fa-trash-o bigger-110 pink"></i>
</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <td>Số thứ tự</td>
                                        <th>UserName</th>
                                        <th>Họ</th>
                                        <th>Tên</th>
                                        <th>Email</th>
                                        <th>Giới tính</th>
                                        <th>Quyền</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${userModelList}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <th>${item.userName}</th>
                                            <th>${item.firstName}</th>
                                            <th>${item.lastName}</th>
                                            <th>${item.email}</th>
                                            <c:if test="${item.sex == 1}">
                                                <th>nam</th>
                                            </c:if>
                                            <c:if test="${item.sex == 2}">
                                                <th>nữ</th>
                                            </c:if>
                                            <c:forEach var="role" items="${roleModelList}">
                                                <c:if test="${item.roleID == role.id}">
                                                    <th>${role.roleName}</th>
                                                </c:if>
                                            </c:forEach>
                                            <th>
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                   title="Cập nhập bài viết"
                                                   href="/admin/user?type=edit&id=${item.id}">
                                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                </a>
                                            </th>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>