package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "dangkyhoc")
public class Dangkyhoc implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaDangKy", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDangKy;

    @Column(name = "MaHocVien", nullable = false)
    private Integer maHocVien;

    @Column(name = "MaLopHoc", nullable = false)
    private Integer maLopHoc;

    @Column(name = "NgayDangKy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime ngayDangKy;

    @Enumerated(EnumType.STRING)
    @Column(name = "TrangThai", nullable = false)
    private DangKyHocTrangThai trangThai;

}
