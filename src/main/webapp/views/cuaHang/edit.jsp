<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13/03/2023
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2 class="text-center text-danger mb-3">Cập Nhật Cửa Hàng</h2>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form method="post" action="/cua-hang/update?ma=${ch.ma}">
                <div class="form-floating mb-3">
                    <input type="number" class="form-control" name="id" value="${ch.id}" id="floatingInput" disabled>
                    <label for="floatingInput">ID</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="ma" value="${ch.ma}" id="floatingMa" disabled>
                    <label for="floatingMa">Mã</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="ten" value="${ch.ten}" id="floatingTen">
                    <label for="floatingTen">Tên</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="dia_chi" value="${ch.dia_chi}" id="floatingDiaChi">
                    <label for="floatingDiaChi">Địa chỉ</label>
                </div>
                <div class="form-floating mb-3">
                    <select class="form-select" name="thanh_pho">
                        <option value="Hà Nội" ${ch.thanh_pho == "Hà Nội" ? "selected" : ""}>Hà Nội</option>
                        <option value="Bắc Giang" ${ch.thanh_pho == "Bắc Giang" ? "selected" : ""}>Bắc Giang</option>
                        <option value="Hồ Chí Minh" ${ch.thanh_pho == "Hồ Chí Minh" ? "selected" : ""}>Hồ Chí Minh</option>
                    </select>
                    <label class="form-label">Thành phố</label>
                </div>
                <div class="form-floating mb-3">
                    <select class="form-select" name="quoc_gia">
                        <option value="Việt Nam" ${ch.quoc_gia == "Việt Nam" ? "selected" : ""}>Việt Nam</option>
                        <option value="Nhật Bản" ${ch.quoc_gia == "Nhật Bản" ? "selected" : ""}>Nhật Bản</option>
                        <option value="Hàn Quốc" ${ch.quoc_gia == "Hàn Quốc" ? "selected" : ""}>Hàn Quốc</option>
                    </select>
                    <label class="form-label">Quốc gia</label>
                </div>
                <div class="mb-3 text-center">
                    <button class="btn btn-success">Cập nhật</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>