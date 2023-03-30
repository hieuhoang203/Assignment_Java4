<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
  <div style="width: auto">
    <a href="/khach-hang/create" class="btn btn-success">Thêm mới</a>
  </div>
  <c:if test="${f:length(list_kh) == 0}">
    <h3 class="alert alert-warning">Không có dữ liệu!</h3>
  </c:if>
  <c:if test="${f:length(list_kh) != 0}">
    <table class="table">
      <thead>
      <tr>
        <th scope="col">Mã</th>
        <th scope="col">Họ</th>
        <th scope="col">Tên đệm</th>
        <th scope="col">Tên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Thành phố</th>
        <th scope="col">Quốc gia</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Thao tác</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${list_kh}" var="kh">
        <tr>
          <td>${kh.ma}</td>
          <td>${kh.ho}</td>
          <td>${kh.ten_dem}</td>
          <td>${kh.ten}</td>
          <td>${kh.ngay_sinh}</td>
          <td>${kh.sdt}</td>
          <td>${kh.dia_chi}</td>
          <td>${kh.thanh_pho}</td>
          <td>${kh.quoc_gia}</td>
          <td>${kh.mat_khau}</td>
          <td>
            <a href="/khach-hang/edit?ma=${kh.ma}" class="btn btn-warning">Cập nhật</a>
            <a href="/khach-hang/delete?ma=${kh.ma}" class="btn btn-danger">Xóa</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>