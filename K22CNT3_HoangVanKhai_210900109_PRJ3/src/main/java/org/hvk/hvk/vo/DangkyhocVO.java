package org.hvk.hvk.vo;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
public class DangkyhocVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maDangKy can not null")
    private Integer maDangKy;

    @NotNull(message = "maHocVien can not null")
    private Integer maHocVien;

    @NotNull(message = "maLopHoc can not null")
    private Integer maLopHoc;

    private Date ngayDangKy;

    @NotNull(message = "trangThai can not null")
    private String trangThai;

}
