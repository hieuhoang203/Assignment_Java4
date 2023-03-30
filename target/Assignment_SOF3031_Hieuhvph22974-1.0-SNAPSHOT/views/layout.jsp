<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap.min.css">
</head>
<body>
<div class="container">
    <header>
        <div class="row">
            <h3 class="text-center text-success">Hoàng Văn Hiếu - IT17311</h3>
        </div>
        <ul class="nav bg-light">
            <li class="nav-item">
                <a class="nav-link active" href="/cua-hang/index">Cửa hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chuc-vu/index">Chức Vụ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/dong-sp/index">Dòng sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/mau-sac/index">Màu sắc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/nhan-vien/index">Nhân viên</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/san-pham/index">Sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/nha-san-xuat/index">Nhà sản xuất</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/khach-hang/index">Khách hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chi-tiet-san-pham/index">Chi tiết sản phẩm</a>
            </li>
        </ul>
    </header>
    <div class="row mt-5" style="height: 600px">
        <jsp:include page="${ view }"/>
    </div>
    <footer class="row bg-dark text-white p-auto">
        <div class="col-md-3 m-auto p-auto">
            <br><br>
            <p>
                Lorem Ipsum is simply dummy text of
                the printing and typesetting industry.
                Lorem Ipsum has been the industry's standard
                dummy a type specimen book.
            </p>
        </div>
        <div class="col-md-3 m-auto p-auto">
            <h4 class="fw-bolder">Support</h4>
            <br>
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active text-black" aria-current="page" href="#"><span
                            class="text-dark">FAQ</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-black" href="#"><span class="text-dark">Help Center</span></a>
                </li>
                <li class="">
                    <a class="nav-link text-black" href="#"><span class="text-dark">Career</span></a>
                </li>
            </ul>
        </div>
        <div class="col-md-3 m-auto p-auto">
            <h4 class="fw-bolder">Courses</h4>
            <br>
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#"><span
                            class="text-dark">Categories</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="text-dark">Offline Courses</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="text-dark">Vidio Courses</span></a>
                </li>
            </ul>
        </div>
        <div class="col-md-3 m-auto p-auto">
            <h4 class="fw-bolder">Contact Info</h4>
            <br>
            <div>
                <i class="bi bi-person-fill"></i>
                Hoàng Văn Hiếu
            </div>
            <div>
                <i class="bi bi-telephone-fill"></i>
                0966-628-527
            </div>
            <div>
                <i class="bi bi-envelope-fill"></i>
                hieuhv203@gmail.com
            </div>
            <div>
                <i class="bi bi-geo-alt-fill"></i>
                Lý Viên - Bắc Lý - Hiệp Hòa - Bắc Giang
            </div>
        </div>
    </footer>
    <script src="${pageContext.request.contextPath}/lib/bootstrap.bundle.min.js"></script>
</div>
</body>
</html>