package org.hvk.hvk.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hvk.hvk.model.VaiTro;

import java.io.Serializable;

@Data
public class NguoidungDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    @Size(max = 255)
    @NotNull(message = "Tên đăng nhập không được để trống")
    private String tendangnhap;

    @Size(max = 255)
    @NotNull(message = "Tên người dùng không được để trống")
    private String tennguoidung;

    @Size(max = 255)
    @NotNull(message = "Mật khẩu không được để trống")
    private String matkhau;

    @Size(max = 255)
    @NotNull(message = "Email không được để trống")
    private String email;

    @NotNull(message = "Vai trò không được để trống")
    private VaiTro vaitro;
}