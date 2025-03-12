package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "thanhtoan")
public class Thanhtoan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaThanhToan", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThanhToan;

    @Column(name = "MaHocVien", nullable = false)
    private Integer maHocVien;

    @Column(name = "MaKhoaHoc", nullable = false)
    private Integer maKhoaHoc;

    @Column(name = "SoTien", nullable = false)
    private BigDecimal soTien;

    @Column(name = "NgayThanhToan")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayThanhToan;

    @Column(name = "TrangThai", nullable = false)
    private String trangThai;

}
