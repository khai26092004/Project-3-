-- CREATE DATABASE K22CNT3_HoangVanKhai_PRJ3;
-- USE K22CNT3_HoangVanKhai_PRJ3;

-- Bảng Học Viên
CREATE TABLE HocVien (
    MaHocVien INT AUTO_INCREMENT PRIMARY KEY,
    HoTen VARCHAR(100) NOT NULL,
    NgaySinh DATE,
    Email VARCHAR(100) UNIQUE,
    SoDienThoai VARCHAR(15) UNIQUE,
    DiaChi TEXT,
    NgayTao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng Khóa Học
CREATE TABLE KhoaHoc (
    MaKhoaHoc INT AUTO_INCREMENT PRIMARY KEY,
    TenKhoaHoc VARCHAR(100) NOT NULL,
    MoTa TEXT,
    ThoiLuong INT NOT NULL, -- Thời lượng (giờ)
    HocPhi DECIMAL(10,2) NOT NULL, -- Học phí
    NgayTao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng Giảng Viên
CREATE TABLE GiangVien (
    MaGiangVien INT AUTO_INCREMENT PRIMARY KEY,
    HoTen VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    SoDienThoai VARCHAR(15) UNIQUE,
    ChuyenMon VARCHAR(100),
    NgayTao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng Lớp Học
CREATE TABLE LopHoc (
    MaLopHoc INT AUTO_INCREMENT PRIMARY KEY,
    MaKhoaHoc INT NOT NULL,
    MaGiangVien INT NOT NULL,
    NgayBatDau DATE NOT NULL,
    NgayKetThuc DATE NOT NULL,
    LichHoc VARCHAR(255) NOT NULL, -- Ví dụ: "T2-T5 18h"
    FOREIGN KEY (MaKhoaHoc) REFERENCES KhoaHoc(MaKhoaHoc),
    FOREIGN KEY (MaGiangVien) REFERENCES GiangVien(MaGiangVien)
);

-- Bảng Đăng Ký Học
CREATE TABLE DangKyHoc (
    MaDangKy INT AUTO_INCREMENT PRIMARY KEY,
    MaHocVien INT NOT NULL,
    MaLopHoc INT NOT NULL,
    NgayDangKy TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    TrangThai ENUM('Đang học', 'Hoàn thành', 'Hủy') NOT NULL,
    FOREIGN KEY (MaHocVien) REFERENCES HocVien(MaHocVien),
    FOREIGN KEY (MaLopHoc) REFERENCES LopHoc(MaLopHoc)
);

-- Bảng Thanh Toán
CREATE TABLE ThanhToan (
    MaThanhToan INT AUTO_INCREMENT PRIMARY KEY,
    MaHocVien INT NOT NULL,
    MaKhoaHoc INT NOT NULL,
    SoTien DECIMAL(10,2) NOT NULL,
    NgayThanhToan TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    TrangThai ENUM('Đã thanh toán', 'Chưa thanh toán', 'Hoàn tiền') NOT NULL,
    FOREIGN KEY (MaHocVien) REFERENCES HocVien(MaHocVien),
    FOREIGN KEY (MaKhoaHoc) REFERENCES KhoaHoc(MaKhoaHoc)
);
