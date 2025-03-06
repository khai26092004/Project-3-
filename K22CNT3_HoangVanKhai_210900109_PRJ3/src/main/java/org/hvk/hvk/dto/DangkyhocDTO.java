package org.hvk.hvk.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DangkyhocDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maDangKy;

    private Integer maHocVien;

    private Integer maLopHoc;

    private Date ngayDangKy;

    private String trangThai;

}
