package org.hvk.hvk.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "nguoidung")
public class Nguoidung implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "tendangnhap", nullable = false)
    private String tendangnhap;

    @Size(max = 255)
    @NotNull
    @Column(name = "tennguoidung", nullable = false)
    private String tennguoidung;

    @Size(max = 255)
    @NotNull
    @Column(name = "matkhau", nullable = false)
    private String matkhau;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vaitro", nullable = false, columnDefinition = "ENUM('ADMIN', 'STUDENT') DEFAULT 'STUDENT'")
    private VaiTro vaitro;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+vaitro.name()));
    }

    @Override
    public String getPassword() {
        return matkhau;
    }

    @Override
    public String getUsername() {
        return tendangnhap;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}