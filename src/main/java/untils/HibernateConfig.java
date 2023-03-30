package untils;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateConfig {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2008Dialect");
        props.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        props.put(Environment.URL, "jdbc:sqlserver://DieuThuy:1433;databaseName=Assignment_Java4");
        props.put(Environment.USER, "sa");
        props.put(Environment.PASS, "123456");
        props.put(Environment.SHOW_SQL, "true");

        conf.setProperties(props);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(DongSp.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(ChucVu.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
