<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="text-center text-success">ĐĂNG NHẬP</h3>
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <c:if test="${f:length(errorMessage) != 0}">
                <div class="alert alert-danger">${ errorMessage }</div>
            </c:if>
            <form method="post" action="/login">
                <div class="mt-3">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control"/>
                </div>
                <div class="mt-3">
                    <label>Mật khẩu</label>
                    <input type="password" name="mat_khau" class="form-control"/>
                </div>
                <div class="mt-3">
                    <button class="btn btn-primary">Đăng nhập</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/lib/bootstrap.bundle.min.js"></script>
</html>
