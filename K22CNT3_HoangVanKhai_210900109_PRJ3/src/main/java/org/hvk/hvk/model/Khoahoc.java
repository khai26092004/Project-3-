package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "khoahoc")
public class Khoahoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaKhoaHoc", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhoaHoc;

    @Column(name = "TenKhoaHoc", nullable = false)
    private String tenKhoaHoc;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "ThoiLuong", nullable = false)
    private Integer thoiLuong;

    @Column(name = "HocPhi", nullable = false)
    private BigDecimal hocPhi;

    @Column(name = "NgayTao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayTao;

}
