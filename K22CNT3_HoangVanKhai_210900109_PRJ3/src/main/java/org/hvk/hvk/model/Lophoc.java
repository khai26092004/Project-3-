package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "lophoc")
public class Lophoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaLopHoc", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLopHoc;

    @Column(name = "MaKhoaHoc", nullable = false)
    private Integer maKhoaHoc;

    @Column(name = "MaGiangVien", nullable = false)
    private Integer maGiangVien;

    @Column(name = "NgayBatDau", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayKetThuc;

    @Column(name = "LichHoc", nullable = false)
    private String lichHoc;

}
