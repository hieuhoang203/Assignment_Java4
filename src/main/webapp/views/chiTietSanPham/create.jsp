<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2 class="text-center text-danger mb-3">Chi Tiết Sản Phẩm</h2>
    <form action="/chi-tiet-san-pham/store" method="post" class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <select class="form-select" name="id_nhaSanXuat">
                    <c:forEach items="${list_nsx}" var="nsx">
                        <option value="${nsx.ma}">${nsx.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Nhà sản xuất</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_dongSp">
                    <c:forEach items="${list_dsp}" var="dsp">
                        <option value="${dsp.ma}">${dsp.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Dòng sản phẩm</label>
            </div>
            <div class="form-floating mb-3">
                <textarea class="form-control" name="mo_ta" id="floatingTextarea"></textarea>
                <label for="floatingTextarea">Mô tả</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="gia_nhap" id="floatingGiaNhap" min="1">
                <label for="floatingGiaNhap">Giá nhập</label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <select class="form-select" name="id_sanPham">
                    <c:forEach items="${list_sp}" var="sp">
                        <option value="${sp.ma}">${sp.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Sản phẩm</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_mauSac">
                    <c:forEach items="${list_ms}" var="ms">
                        <option value="${ms.ma}">${ms.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Màu sắc</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="nam_bh" id="floatingBh" min="1000">
                <label for="floatingBh">Năm bảo hành</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="so_luong" id="floatingSoluong" min="1">
                <label for="floatingSoluong">Số lượng</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="gia_ban" id="floatingGiaBan" min="1">
                <label for="floatingGiaNhap">Giá bán</label>
            </div>
        </div>
        <div class="col-md-3"></div>
        <div class="mb-3 text-center">
            <button class="btn btn-success">Đăng Ký</button>
        </div>
    </form>
</div>