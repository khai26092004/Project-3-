package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "k22cnt3_hoangvankhai_prj3.hocvien")
public class Hocvien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaHocVien", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHocVien;

    @Column(name = "HoTen", nullable = false)
    private String hoTen;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Email")
    private String email;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "NgayTao")
    private Date ngayTao = new Date();

}
