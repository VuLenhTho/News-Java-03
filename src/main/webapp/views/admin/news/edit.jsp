<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}">
                            ${message}
                    </div>
                </c:if>
                <form id="formUpdateOrCreate">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="code" name="code">
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.id}" > ${category.name} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="thumbnail" name="thumbnail"
                                   value="${model.thumbNail}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="shortDescription" name="shortDescription"
                                   value="${model.shortDescription}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="content" name="content"
                                   value="${model.content}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">

                        <input type="hidden" class="form-control" id="id" name="id"/>

                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <%--<div class="col-sm-12">--%>
                        <%--<c:if test="${not empty model.id}">--%>
                        <%--<input type="button" class="btn btn-white btn-warning btn-bold"--%>
                        <%--value="Cập nhật bài viết"--%>
                        <%--id="btnAddOrUpdate"/>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${empty model.id}">--%>
                        <%--<input type="button" class="btn btn-white btn-warning btn-bold"--%>
                        <%--value="Thêm mới bài viết"--%>
                        <%--id="btnAddOrUpdate"/>--%>
                        <%--</c:if>--%>
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>