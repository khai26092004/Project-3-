package org.hvk.hvk.vo;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;




@Data
public class KhoahocVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maKhoaHoc can not null")
    private Integer maKhoaHoc;

    @NotNull(message = "tenKhoaHoc can not null")
    private String tenKhoaHoc;

    private String moTa;

    @NotNull(message = "thoiLuong can not null")
    private Integer thoiLuong;

    @NotNull(message = "hocPhi can not null")
    private BigDecimal hocPhi;

    private Date ngayTao;

}
