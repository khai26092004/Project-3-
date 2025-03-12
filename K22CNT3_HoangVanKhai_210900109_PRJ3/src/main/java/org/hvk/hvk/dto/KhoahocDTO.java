package org.hvk.hvk.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class KhoahocDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maKhoaHoc;

    private String tenKhoaHoc;

    private String moTa;

    private Integer thoiLuong;

    private BigDecimal hocPhi;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayTao;

}
