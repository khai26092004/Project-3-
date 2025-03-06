package org.hvk.hvk.dto;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class HocvienDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maHocVien;

    private String hoTen;

    private Date ngaySinh;

    private String email;

    private String soDienThoai;

    private String diaChi;

    private java.util.Date ngayTao;

}
