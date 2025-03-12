package org.hvk.hvk.dto;


import lombok.Data;
import org.hvk.hvk.model.DangKyHocTrangThai;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DangkyhocDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maDangKy;
    private Integer maHocVien;
    private Integer maLopHoc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime ngayDangKy;
    private DangKyHocTrangThai trangThai;
}