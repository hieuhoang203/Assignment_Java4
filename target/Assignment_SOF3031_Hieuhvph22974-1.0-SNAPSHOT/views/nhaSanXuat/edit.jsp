<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13/03/2023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
  <div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
      <form method="post" action="/nha-san-xuat/store">
        <div class="form-floating mb-3">
          <input type="number" class="form-control" name="id" value="${nsx.id}" id="floatingInput" disabled>
          <label for="floatingInput">ID</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="ma" value="${nsx.ma}" id="floatingMa" disabled>
          <label for="floatingMa">Mã</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="ten" value="${nsx.ten}" id="floatingTen">
          <label for="floatingTen">Tên</label>
        </div>
        <div class="mb-3 text-center">
          <button class="btn btn-success">Cập nhật</button>
        </div>
      </form>
    </div>
    <div class="col-md-4"></div>
  </div>
</div>
