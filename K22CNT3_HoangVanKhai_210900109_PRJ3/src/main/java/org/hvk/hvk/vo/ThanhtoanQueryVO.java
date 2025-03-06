package org.hvk.hvk.vo;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ThanhtoanQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer maThanhToan;

    private Integer maHocVien;

    private Integer maKhoaHoc;

    private BigDecimal soTien;

    private Date ngayThanhToan;

    private String trangThai;

}
