<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div style="width: auto">
        <a href="/chuc-vu/create" class="btn btn-success">Thêm mới</a>
    </div>
    <c:if test="${f:length(list_cv) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu!</h3>
    </c:if>
    <c:if test="${f:length(list_cv) != 0}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list_cv}" var="cv">
                <tr>
                    <td>${cv.ma}</td>
                    <td>${cv.ten}</td>
                    <td>
                        <a href="/chuc-vu/edit?ma=${cv.ma}" class="btn btn-warning">Cập nhật</a>
                        <a href="/chuc-vu/delete?ma=${cv.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
