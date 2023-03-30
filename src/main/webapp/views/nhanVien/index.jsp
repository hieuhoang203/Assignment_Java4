<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div style="width: auto">
        <a href="/nhan-vien/create" class="btn btn-success">Thêm mới</a>
    </div>
    <c:if test="${f:length(list_nv) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu!</h3>
    </c:if>
    <c:if test="${f:length(list_nv) != 0}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Họ</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Tên</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Cửa hàng</th>
                <th scope="col">Chức vụ</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list_nv}" var="nv">
                <tr>
                    <td>${nv.ma}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.ten_dem}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.gioi_tinh}</td>
                    <td>${nv.ngay_sinh}</td>
                    <td>${nv.dia_chi}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.mat_khau}</td>
                    <td>${nv.id_cuaHang.ten}</td>
                    <td>${nv.id_chucVu.ten}</td>
                    <td>${nv.trang_thai}</td>
                    <td>
                        <a href="/nhan-vien/edit?ma=${nv.ma}" class="btn btn-warning">Cập nhật</a>
                        <a href="/nhan-vien/delete?ma=${nv.ma}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
