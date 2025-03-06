package org.hvk.hvk.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class ThanhtoanVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maThanhToan can not null")
    private Integer maThanhToan;

    @NotNull(message = "maHocVien can not null")
    private Integer maHocVien;

    @NotNull(message = "maKhoaHoc can not null")
    private Integer maKhoaHoc;

    @NotNull(message = "soTien can not null")
    private BigDecimal soTien;

    private Date ngayThanhToan;

    @NotNull(message = "trangThai can not null")
    private String trangThai;

}
