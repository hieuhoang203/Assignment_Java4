<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form class="row mt-3" method="post" action="/nhan-vien/store">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ma" id="floatingMa">
                <label for="floatingMa">Mã</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ten_dem" id="floatingTenDem">
                <label for="floatingTenDem">Tên đệm</label>
            </div>
            <div class="mb-3">
                <div>
                    <label class="form-label">Giới tính</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioi_tinh" id="nam" value="Nam">
                    <label class="form-check-label" for="nam">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioi_tinh" id="nu" value="Nữ">
                    <label class="form-check-label" for="nu">Nữ</label>
                </div>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="dia_chi" id="floatingDiaChi">
                <label for="floatingDiaChi">Địa chỉ</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="mat_khau" id="floatingMatKhau">
                <label for="floatingMatKhau">Mật khẩu</label>
            </div>
            <div class="mb-3">
                <label class="form-label">Trạng thái</label>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" role="switch" name="trang_thai" id="trangthai">
                    <label class="form-check-label" for="trangthai">Hoạt động</label>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ho" id="floatingHo">
                <label for="floatingHo">Họ</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ten" id="floatingTen">
                <label for="floatingTen">Tên</label>
            </div>
            <div class="form-floating mb-3">
                <input type="date" class="form-control" name="ngay_sinh" id="floatingNgaySinh">
                <label for="floatingNgaySinh">Ngày sinh</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="sdt" id="floatingSdt">
                <label for="floatingSdt">Số điện thoại</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_cuaHang">
                    <c:forEach items="${list_ch}" var="ch">
                        <option value="${ch.ma}">${ch.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Cửa hàng</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_chucVu">
                    <c:forEach items="${list_cv}" var="cv">
                        <option value="${cv.ma}">${cv.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Chức vụ</label>
            </div>
        </div>
        <div class="col-md-3"></div>
        <div class="mb-3 text-center">
            <button class="btn btn-success">Đăng Ký</button>
        </div>
    </form>
</div>