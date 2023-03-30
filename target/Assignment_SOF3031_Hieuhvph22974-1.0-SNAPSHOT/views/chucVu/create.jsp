<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <h2 class="text-center text-danger mb-3">Thêm Chức Vụ</h2>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form method="post" action="/chuc-vu/store">
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
                <div class="mb-3 text-center">
                    <button class="btn btn-success">Đăng Ký</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div