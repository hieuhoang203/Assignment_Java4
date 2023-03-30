<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div style="width: auto">
        <a href="/chi-tiet-san-pham/create" class="btn btn-success">Thêm mới</a>
    </div>
    <c:if test="${f:length(list_ctsp) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu!</h3>
    </c:if>
    <c:if test="${f:length(list_ctsp) != 0}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Sản phẩm</th>
                <th scope="col">Màu sắc</th>
                <th scope="col">Dòng sản phẩm</th>
                <th scope="col">Nhà sản xuất</th>
                <th scope="col">Năm bảo hành</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Giá nhập</th>
                <th scope="col">Giá bán</th>
                <th scope="col">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list_ctsp}" var="ctsp">
                <tr>
                    <td>${ctsp.id_sanPham.ten}</td>
                    <td>${ctsp.id_mauSac.ten}</td>
                    <td>${ctsp.id_dongSp.ten}</td>
                    <td>${ctsp.id_nhaSanXuat.ten}</td>
                    <td>${ctsp.nam_bh}</td>
                    <td>${ctsp.mo_ta}</td>
                    <td>${ctsp.so_luong}</td>
                    <td>${ctsp.gia_nhap}</td>
                    <td>${ctsp.gia_ban}</td>
                    <td>
                        <a href="/chi-tiet-san-pham/edit?id=${ctsp.id}" class="btn btn-warning">Cập nhật</a>
                        <a href="/chi-tiet-san-pham/delete?id=${ctsp.id}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
