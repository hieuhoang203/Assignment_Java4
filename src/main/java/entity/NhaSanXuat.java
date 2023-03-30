package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NSX")
public class NhaSanXuat implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
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

    @OneToMany(mappedBy = "id_nhaSanXuat", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;

    public NhaSanXuat() {
    }

    public NhaSanXuat(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public NhaSanXuat(String ma, String ten, List<ChiTietSanPham> chiTietSanPhams) {
        this.ma = ma;
        this.ten = ten;
        this.chiTietSanPhams = chiTietSanPhams;
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

    public List<ChiTietSanPham> getChiTietSanPhams() {
        return chiTietSanPhams;
    }

    public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
        this.chiTietSanPhams = chiTietSanPhams;
    }
}
