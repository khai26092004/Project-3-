package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "giangvien")
public class Giangvien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaGiangVien", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGiangVien;

    @Column(name = "HoTen", nullable = false)
    private String hoTen;

    @Column(name = "Email")
    private String email;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "ChuyenMon")
    private String chuyenMon;

    @Column(name = "NgayTao")
    private Date ngayTao = new Date();

    @PrePersist
    protected void onCreate() {
        this.ngayTao = new Date();
    }


}
