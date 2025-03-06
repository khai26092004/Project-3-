package org.hvk.hvk.vo;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class KhoahocQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer maKhoaHoc;

    private String tenKhoaHoc;

    private String moTa;

    private Integer thoiLuong;

    private BigDecimal hocPhi;

    private Date ngayTao;

}
