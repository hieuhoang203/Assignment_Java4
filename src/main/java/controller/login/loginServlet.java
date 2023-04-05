package controller.login;

import entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.NhanVienRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/login"
})
public class loginServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public loginServlet() {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String mat_khau = request.getParameter("mat_khau");
        NhanVien nv = this.nvRepo.login(ma, mat_khau);
        HttpSession session = request.getSession();
        ArrayList<String> errMess;
        if (nv == null) {
            String errorMessage = "Sai tài khoản hoặc mật khẩu";
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/nhan-vien/index");
        }
    }
}
