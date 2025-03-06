package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "k22cnt3_hoangvankhai_prj3.khoahoc")
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
    private Date ngayTao = new Date();

}
