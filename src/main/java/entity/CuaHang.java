package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
public class CuaHang implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "dia_chi")
    private String dia_chi;

    @Column(name = "thanh_pho")
    private String thanh_pho;

    @Column(name = "quoc_gia")
    private String quoc_gia;

    @OneToMany(mappedBy = "id_cuaHang")
    private List<NhanVien> nhanViens;

    public CuaHang() {
    }

    public CuaHang(String ma, String ten, String dia_chi, String thanh_pho, String quoc_gia) {
        this.ma = ma;
        this.ten = ten;
        this.dia_chi = dia_chi;
        this.thanh_pho = thanh_pho;
        this.quoc_gia = quoc_gia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getThanh_pho() {
        return thanh_pho;
    }

    public void setThanh_pho(String thanh_pho) {
        this.thanh_pho = thanh_pho;
    }

    public String getQuoc_gia() {
        return quoc_gia;
    }

    public void setQuoc_gia(String quoc_gia) {
        this.quoc_gia = quoc_gia;
    }
}
