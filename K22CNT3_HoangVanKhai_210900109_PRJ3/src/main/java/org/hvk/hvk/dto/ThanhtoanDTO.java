package org.hvk.hvk.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ThanhtoanDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maThanhToan;

    private Integer maHocVien;

    private Integer maKhoaHoc;

    private BigDecimal soTien;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayThanhToan;

    private String trangThai;

}
