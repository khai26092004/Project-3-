package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "hocvien")
public class Hocvien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaHocVien", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHocVien;

    @Column(name = "HoTen", nullable = false)
    private String hoTen;

    @Column(name = "NgaySinh")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngaySinh;

    @Column(name = "NgayTao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayTao = LocalDate.now();

    @Column(name = "Email")
    private String email;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "DiaChi")
    private String diaChi;

}
