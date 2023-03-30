<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2 class="text-center text-danger mb-3">Thêm Khách Hàng</h2>
    <form method="post" action="/khach-hang/store" class="row">
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
            <div class="form-floating mb-3">
                <input type="date" class="form-control" name="ngay_sinh" id="floatingNgaySinh">
                <label for="floatingNgaySinh">Ngày sinh</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="dia_chi" id="floatingDiaChi">
                <label for="floatingDiaChi">Địa chỉ</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="quoc_gia">
                    <option value="Việt Nam">Việt Nam</option>
                    <option value="Nhật Bản">Nhật Bản</option>
                    <option value="Hàn Quốc">Hàn Quốc</option>
                </select>
                <label class="form-label">Quốc gia</label>
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
                <input type="text" class="form-control" name="sdt" id="floatingSdt">
                <label for="floatingSdt">Số điện thoại</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" name="thanh_pho">
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Bắc Giang">Bắc Giang</option>
                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                </select>
                <label class="form-label">Thành phố</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="mat_khau" id="floatingMatKhau">
                <label for="floatingMatKhau">Mật khẩu</label>
            </div>
        </div>
        <div class="col-md-3"></div>
        <div class="mb-3 text-center">
            <button class="btn btn-success">Đăng Ký</button>
        </div>
    </form>
</div>