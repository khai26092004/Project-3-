package org.hvk.hvk.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data

public class HocvienDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maHocVien;
    private String hoTen;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngaySinh;
    private String email;
    private String soDienThoai;
    private String diaChi;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayTao;
}
