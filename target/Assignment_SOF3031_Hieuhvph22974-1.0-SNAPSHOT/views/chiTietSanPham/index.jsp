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
                        <a href="">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
                                <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                            </svg>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
