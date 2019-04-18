<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login Page - Ace Admin</title>
    <link rel="stylesheet" href="<c:url value="/template/assets/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/template/assets/font-awesome/4.5.0/css/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<c:url value="/template/assets/css/fonts.googleapis.com.css" />"/>
    <link rel="stylesheet" href="<c:url value="/template/assets/css/ace.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/template/assets/css/ace-part2.min.css"/>" />
    <![endif]-->
    <link rel="stylesheet" href="<c:url value="/template/assets/css/ace-rtl.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/template/assets/css/ace-ie.min.css"/>" />
    <![endif]-->
    <script src="<c:url value="/template/assets/js/html5shiv.min.js"/>"></script>
    <script src="<c:url value="/template/assets/js/respond.min.js"/>"></script>
    <![endif]-->
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <dec:body></dec:body>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.main-content -->
</div><!-- /.main-container -->
<script src="<c:url value="/template/assets/js/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/template/assets/js/jquery-1.11.3.min.js"/>"></script>
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/template/assets/js/jquery.mobile.custom.min.js"/>'>"+"<"+"/script>");
</script>

<script type="text/javascript">
    jQuery(function($) {
        $(document).on('click', '.toolbar a[data-target]', function(e) {
            e.preventDefault();
            var target = $(this).data('target');
            $('.widget-box.visible').removeClass('visible');//hide others
            $(target).addClass('visible');//show target
        });
    });

    jQuery(function($) {
        $('#btn-login-dark').on('click', function(e) {
            $('body').attr('class', 'login-layout');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-light').on('click', function(e) {
            $('body').attr('class', 'login-layout light-login');
            $('#id-text2').attr('class', 'grey');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-blur').on('click', function(e) {
            $('body').attr('class', 'login-layout blur-login');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'light-blue');

            e.preventDefault();
        });

    });
</script>
</body>
</html>