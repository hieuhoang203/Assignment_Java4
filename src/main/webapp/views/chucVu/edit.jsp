<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2 class="text-center text-danger mb-3">Cập Nhật Chức Vụ</h2>
    <form method="post" action="/chuc-vu/update?ma=${cv.ma}">
        <div class="form-floating mb-3">
            <input type="number" class="form-control" name="id" value="${cv.id}" id="floatingInput" disabled>
            <label for="floatingInput">ID</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="ma" value="${cv.ma}" id="floatingMa" disabled>
            <label for="floatingMa">Mã</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="ten" value="${cv.ten}" id="floatingTen">
            <label for="floatingTen">Tên</label>
        </div>
        <div class="mb-3 text-center">
            <button class="btn btn-success">Cập Nhật</button>
        </div>
    </form>
</div>