<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div style="width: auto">
                <a href="/dong-sp/create" class="btn btn-success">Thêm mới</a>
            </div>
            <c:if test="${f:length(list_dsp) == 0}">
                <h3 class="alert alert-warning">Không có dữ liệu!</h3>
            </c:if>
            <c:if test="${f:length(list_dsp) != 0}">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Mã</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list_dsp}" var="dsp">
                        <tr>
                            <td>${dsp.ma}</td>
                            <td>${dsp.ten}</td>
                            <td>
                                <a href="/dong-sp/edit?ma=${dsp.ma}" class="btn btn-warning">Cập nhật</a>
                                <a href="/dong-sp/delete?ma=${dsp.ma}" class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>