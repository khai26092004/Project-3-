package org.hvk.hvk.vo;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;



@Data
public class HocvienVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maHocVien can not null")
    private Integer maHocVien;

    @NotNull(message = "hoTen can not null")
    private String hoTen;

    private Date ngaySinh;

    private String email;

    private String soDienThoai;

    private String diaChi;

    private java.util.Date ngayTao;

}
