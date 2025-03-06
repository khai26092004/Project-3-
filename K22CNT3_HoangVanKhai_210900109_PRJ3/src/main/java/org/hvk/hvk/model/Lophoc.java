package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "k22cnt3_hoangvankhai_prj3.lophoc")
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
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc", nullable = false)
    private Date ngayKetThuc;

    @Column(name = "LichHoc", nullable = false)
    private String lichHoc;

}
