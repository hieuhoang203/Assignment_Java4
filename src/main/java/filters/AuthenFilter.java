package filters;

import entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/nhan-vien/*",
        "/khach-hang/*",
        "/chuc-vu/*",
        "/cua-hang/*",
        "/dong-sp/*",
        "/gio-hang/*",
        "/mau-sac/*",
        "/nha-san-xuat/*",
        "/chi-tiet-san-pham/*",
        "/san-pham/*"
})
public class AuthenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        NhanVien nv = (NhanVien) session.getAttribute("nv");
        if (nv == null) {
            res.sendRedirect("/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
