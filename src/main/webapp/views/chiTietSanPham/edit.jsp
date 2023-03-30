<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="text-center text-danger mb-3">Chi Tiết Sản Phẩm</h2>
    <form action="/chi-tiet-san-pham/update?id=${ctsp.id}" method="post" class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="id" value="${ctsp.id}" id="floatingId" disabled>
                <label for="floatingId">ID</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_nhaSanXuat">
                    <c:forEach items="${list_nsx}" var="nsx">
                        <option value="${nsx.ma}" ${ctsp.id_nhaSanXuat.ma = nsx.ma ? "selected" : ""}>${nsx.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Nhà sản xuất</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_dongSp">
                    <c:forEach items="${list_dsp}" var="dsp">
                        <option value="${dsp.ma}" ${ctsp.id_dongSp.ma = dsp.ma ? "selected" : ""}>${dsp.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Dòng sản phẩm</label>
            </div>
            <div class="form-floating mb-3">
                <textarea class="form-control" name="mo_ta" id="floatingTextarea">${ctsp.mo_ta}</textarea>
                <label for="floatingTextarea">Mô tả</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="gia_nhap" value="${ctsp.gia_nhap}" id="floatingGiaNhap" min="1">
                <label for="floatingGiaNhap">Giá nhập</label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <select class="form-select" name="id_sanPham">
                    <c:forEach items="${list_sp}" var="sp">
                        <option value="${sp.ma}" ${ctsp.id_sanPham.ma = sp.ma ? "selected" : ""}>${sp.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Sản phẩm</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="id_mauSac">
                    <c:forEach items="${list_ms}" var="ms">
                        <option value="${ms.ma}" ${ctsp.id_mauSac.ma = ms.ma ? "selected" : ""}>${ms.ten}</option>
                    </c:forEach>
                </select>
                <label class="form-label">Màu sắc</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="nam_bh" value="${ctsp.nam_bh}" id="floatingBh" min="1000">
                <label for="floatingBh">Năm bảo hành</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="so_luong" value="${ctsp.so_luong}" id="floatingSoluong" min="1">
                <label for="floatingSoluong">Số lượng</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" name="gia_ban" value="${ctsp.gia_ban}" id="floatingGiaBan" min="1">
                <label for="floatingGiaNhap">Giá bán</label>
            </div>
        </div>
        <div class="col-md-3"></div>
        <div class="mb-3 text-center">
            <button class="btn btn-success">Đăng Ký</button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/lib/bootstrap.bundle.min.js"></script>
</body>
</html