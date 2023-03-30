<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <form method="post" action="/khach-hang/update?ma=${kh.ma}" class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ma" value="${kh.ma}" id="floatingMa" disabled>
                <label for="floatingMa">Mã</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ten_dem" value="${kh.ten_dem}" id="floatingTenDem">
                <label for="floatingTenDem">Tên đệm</label>
            </div>
            <div class="form-floating mb-3">
                <input type="date" class="form-control" name="ngay_sinh" value="${kh.ngay_sinh}" id="floatingNgaySinh">
                <label for="floatingNgaySinh">Ngày sinh</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="dia_chi" value="${kh.dia_chi}" id="floatingDiaChi">
                <label for="floatingDiaChi">Địa chỉ</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="quoc_gia">
                    <option value="Việt Nam" ${kh.quoc_gia == "Việt Nam" ? "selected" : ""}>Việt Nam</option>
                    <option value="Nhật Bản" ${kh.quoc_gia == "Nhật Bản" ? "selected" : ""}>Nhật Bản</option>
                    <option value="Hàn Quốc" ${kh.quoc_gia == "Hàn Quốc" ? "selected" : ""}>Hàn Quốc</option>
                </select>
                <label class="form-label">Quốc gia</label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ho" value="${kh.ho}" id="floatingHo">
                <label for="floatingHo">Họ</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="ten" value="${kh.ten}" id="floatingTen">
                <label for="floatingTen">Tên</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="sdt" value="${kh.sdt}" id="floatingSdt">
                <label for="floatingSdt">Số điện thoại</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="thanh_pho" >
                    <option value="Hà Nội" ${kh.quoc_gia == "Hà Nội" ? "selected" : ""}>Hà Nội</option>
                    <option value="Bắc Giang" ${kh.quoc_gia == "Bắc Giang" ? "selected" : ""}>Bắc Giang</option>
                    <option value="Hồ Chí Minh" ${kh.quoc_gia == "Hồ Chí Minh" ? "selected" : ""}>Hồ Chí Minh</option>
                </select>
                <label class="form-label">Thành phố</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="mat_khau" value="${kh.mat_khau}" id="floatingMatKhau">
                <label for="floatingMatKhau">Mật Khẩu</label>
            </div>
        </div>
        <div class="col-md-3"></div>
        <div class="mb-3 text-center">
            <button class="btn btn-success">Cập nhật</button>
        </div>
    </form>
</div>