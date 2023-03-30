<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div style="width: auto">
                <a href="/mau-sac/create" class="btn btn-success">Thêm mới</a>
            </div>
            <c:if test="${f:length(list_ms) == 0}">
                <h3 class="alert alert-warning">Không có dữ liệu!</h3>
            </c:if>
            <c:if test="${f:length(list_ms) != 0}">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Mã</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list_ms}" var="ms">
                        <tr>
                            <td>${ms.ma}</td>
                            <td>${ms.ten}</td>
                            <td>
                                <a href="/mau-sac/edit?ma=${ms.ma}" class="btn btn-warning">Cập nhật</a>
                                <a href="/mau-sac/delete?ma=${ms.ma}" class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>