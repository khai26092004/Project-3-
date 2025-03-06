package org.hvk.hvk.vo;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;



@Data
public class LophocVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maLopHoc can not null")
    private Integer maLopHoc;

    @NotNull(message = "maKhoaHoc can not null")
    private Integer maKhoaHoc;

    @NotNull(message = "maGiangVien can not null")
    private Integer maGiangVien;

    @NotNull(message = "ngayBatDau can not null")
    private Date ngayBatDau;

    @NotNull(message = "ngayKetThuc can not null")
    private Date ngayKetThuc;

    @NotNull(message = "lichHoc can not null")
    private String lichHoc;

}
