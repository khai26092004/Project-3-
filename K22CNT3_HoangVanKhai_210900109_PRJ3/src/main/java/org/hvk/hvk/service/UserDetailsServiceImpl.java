package org.hvk.hvk.service;

import org.hvk.hvk.model.Nguoidung;
import org.hvk.hvk.repository.NguoiDungRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final NguoiDungRepository userRepository;

    public UserDetailsServiceImpl(NguoiDungRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nguoidung user = userRepository.findByTendangnhap(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        System.out.println("DEBUG: User found - Username: " + user.getTendangnhap() +
                ", Role: " + user.getVaitro().name());

        // Thêm tiền tố "ROLE_" vào vai trò
        return new org.springframework.security.core.userdetails.User(
                user.getTendangnhap(),
                user.getMatkhau(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getVaitro().name()))
        );
    }
}
