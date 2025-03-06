package org.hvk.hvk.dto;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class LophocDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maLopHoc;

    private Integer maKhoaHoc;

    private Integer maGiangVien;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private String lichHoc;

}
