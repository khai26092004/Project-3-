package org.hvk.hvk.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class LophocDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maLopHoc;

    private Integer maKhoaHoc;

    private Integer maGiangVien;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayBatDau;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayKetThuc;


    private String lichHoc;

}
