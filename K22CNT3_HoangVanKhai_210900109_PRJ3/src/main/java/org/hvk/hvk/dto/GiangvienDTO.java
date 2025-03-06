package org.hvk.hvk.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GiangvienDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maGiangVien;

    private String hoTen;

    private String email;

    private String soDienThoai;

    private String chuyenMon;

    private Date ngayTao;

}
