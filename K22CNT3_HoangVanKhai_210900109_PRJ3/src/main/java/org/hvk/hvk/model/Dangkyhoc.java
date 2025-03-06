package org.hvk.hvk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "k22cnt3_hoangvankhai_prj3.dangkyhoc")
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
    private Date ngayDangKy = new Date();

    @Column(name = "TrangThai", nullable = false)
    private String trangThai;

}
