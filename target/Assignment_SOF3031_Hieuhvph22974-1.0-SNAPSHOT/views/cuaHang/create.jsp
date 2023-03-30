<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13/03/2023
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
  <h2 class="text-center text-danger mb-3">Thêm Cửa Hàng</h2>
  <div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
      <form method="post" action="/cua-hang/store">
        <div class="form-floating mb-3">
          <input type="number" class="form-control" name="id" id="floatingInput" disabled>
          <label for="floatingInput">ID</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="ma" id="floatingMa">
          <label for="floatingMa">Mã</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="ten" id="floatingTen">
          <label for="floatingTen">Tên</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="dia_chi" id="floatingDiaChi">
          <label for="floatingDiaChi">Địa chỉ</label>
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
          <select class="form-select" name="quoc_gia">
            <option value="Việt Nam">Việt Nam</option>
            <option value="Nhật Bản">Nhật Bản</option>
            <option value="Hàn Quốc">Hàn Quốc</option>
          </select>
          <label class="form-label">Quốc gia</label>
        </div>
        <div class="mb-3 text-center">
          <button class="btn btn-success">Đăng Ký</button>
        </div>
      </form>
    </div>
    <div class="col-md-4"></div>
  </div>
</div>