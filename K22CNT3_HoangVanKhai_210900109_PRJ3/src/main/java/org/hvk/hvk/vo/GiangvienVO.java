package org.hvk.hvk.vo;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
public class GiangvienVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maGiangVien can not null")
    private Integer maGiangVien;

    @NotNull(message = "hoTen can not null")
    private String hoTen;

    private String email;

    private String soDienThoai;

    private String chuyenMon;

    private Date ngayTao;

}
