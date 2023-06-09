<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>

<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form method="post" action="/san-pham/store">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="ma" value="${sp.ma}" id="floatingMa">
                    <label for="floatingMa">Mã</label>
                </div>
                <c:if test="${f:length(errMa) != 0}">
                    <div class="alert alert-danger">${errMa}</div>
                </c:if>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="ten" value="${sp.ten}" id="floatingTen">
                    <label for="floatingTen">Tên</label>
                </div>
                <c:if test="${f:length(errTen) != 0}">
                    <div class="alert alert-danger">${errTen}</div>
                </c:if>
                <div class="mb-3 text-center">
                    <button class="btn btn-success">Đăng Ký</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
