CREATE DATABASE  IF NOT EXISTS `k22cnt3_hoangvankhai_prj3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `k22cnt3_hoangvankhai_prj3`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: k22cnt3_hoangvankhai_prj3
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dangkyhoc`
--

DROP TABLE IF EXISTS `dangkyhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dangkyhoc` (
  `MaDangKy` int NOT NULL AUTO_INCREMENT,
  `MaHocVien` int NOT NULL,
  `MaLopHoc` int NOT NULL,
  `NgayDangKy` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `TrangThai` enum('DANG_HOC','HOAN_THANH','HUY') NOT NULL,
  PRIMARY KEY (`MaDangKy`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dangkyhoc`
--

LOCK TABLES `dangkyhoc` WRITE;
/*!40000 ALTER TABLE `dangkyhoc` DISABLE KEYS */;
INSERT INTO `dangkyhoc` VALUES (1,1,1,'2025-03-09 13:37:14','DANG_HOC'),(2,2,2,'2025-03-08 13:37:14','HOAN_THANH'),(3,3,3,'2025-03-08 13:37:14','HUY'),(4,4,4,'2025-03-08 13:37:14','DANG_HOC'),(5,1,1,'2025-03-10 18:09:00','DANG_HOC'),(6,1,1,'2025-03-08 15:06:00','HOAN_THANH'),(11,1,1,'2025-03-08 17:37:00','HOAN_THANH'),(12,1,1,'2025-03-22 02:26:00','HOAN_THANH');
/*!40000 ALTER TABLE `dangkyhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvien`
--

DROP TABLE IF EXISTS `giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giangvien` (
  `MaGiangVien` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(255) DEFAULT NULL,
  `ChuyenMon` varchar(255) DEFAULT NULL,
  `NgayTao` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`MaGiangVien`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES (1,'Nguyen Van A','a@gmail.com','0123456789','AI',NULL),(2,'Le Thi B','b@gmail.com','0987654321','Web Development',NULL),(3,'Tran Van C','c@gmail.com','0123987456','Data Science',NULL),(4,'Pham Thi D','d@gmail.com','0123459999','Mobile Development',NULL),(5,'Lan','meomeosieucute@gmail.com','039176741','Hóa',NULL);
/*!40000 ALTER TABLE `giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocvien`
--

DROP TABLE IF EXISTS `hocvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocvien` (
  `MaHocVien` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(255) NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `NgayTao` date DEFAULT NULL,
  PRIMARY KEY (`MaHocVien`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocvien`
--

LOCK TABLES `hocvien` WRITE;
/*!40000 ALTER TABLE `hocvien` DISABLE KEYS */;
INSERT INTO `hocvien` VALUES (1,'Nguyen Van E','2000-01-01','e@gmail.com','0123012301','1233',NULL),(2,'Le Thi F','1999-02-02','f@gmail.com','0987098709',NULL,NULL),(3,'Tran Van G','1998-03-03','g@gmail.com','0123012312',NULL,NULL),(4,'Pham Thi H','2001-04-04','h@gmail.com','0987098710',NULL,NULL);
/*!40000 ALTER TABLE `hocvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoahoc`
--

DROP TABLE IF EXISTS `khoahoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoahoc` (
  `MaKhoaHoc` int NOT NULL AUTO_INCREMENT,
  `TenKhoaHoc` varchar(255) NOT NULL,
  `ThoiLuong` int NOT NULL,
  `HocPhi` decimal(38,2) NOT NULL,
  `MoTa` varchar(255) DEFAULT NULL,
  `NgayTao` date DEFAULT NULL,
  PRIMARY KEY (`MaKhoaHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoahoc`
--

LOCK TABLES `khoahoc` WRITE;
/*!40000 ALTER TABLE `khoahoc` DISABLE KEYS */;
INSERT INTO `khoahoc` VALUES (1,'Lap trinh Java',30,3000000.00,NULL,NULL),(2,'Lap trinh Web',40,4000000.00,NULL,NULL),(3,'AI can ban',50,5000000.00,NULL,NULL),(4,'Data Science',60,6000000.00,NULL,NULL);
/*!40000 ALTER TABLE `khoahoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophoc`
--

DROP TABLE IF EXISTS `lophoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophoc` (
  `MaLopHoc` int NOT NULL AUTO_INCREMENT,
  `MaKhoaHoc` int NOT NULL,
  `MaGiangVien` int NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `LichHoc` varchar(255) NOT NULL,
  PRIMARY KEY (`MaLopHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophoc`
--

LOCK TABLES `lophoc` WRITE;
/*!40000 ALTER TABLE `lophoc` DISABLE KEYS */;
INSERT INTO `lophoc` VALUES (1,1,1,'2025-01-01','2025-03-01',''),(2,2,2,'2025-02-01','2025-04-01',''),(3,3,3,'2025-03-01','2025-05-01',''),(4,4,4,'2025-04-01','2025-06-01','');
/*!40000 ALTER TABLE `lophoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tendangnhap` varchar(255) NOT NULL,
  `tennguoidung` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `vaitro` enum('ADMIN','STUDENT','TEACHER') NOT NULL DEFAULT 'STUDENT',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'user1','Nguyen Van User1','','user1@gmail.com','ADMIN'),(2,'user2','Le Thi User2','pass2','user2@gmail.com','STUDENT'),(3,'user3','Tran Van User3','pass3','user3@gmail.com','STUDENT'),(4,'user4','Pham Thi User4','pass4','user4@gmail.com','STUDENT'),(5,'long123','Anh Long','$2a$10$BkBjXZhetEY.EM7KoT7/j.iC2WW.UbB77C/mVykUUnne7mHAjm/N.','longlala@gmail.com','STUDENT'),(6,'long1234','Anh Long123','$2a$10$PkzS9BFVVraypMs/qRAuTeMUkZZTPmvhYjmx.m0t.ua7dUIArOov6','long1lala@gmail.com','STUDENT'),(7,'long','Anh Long123','$2a$10$KOaQfpgFgIi1btrhdIBO9uZMGiJJj4cPxXIL3Wnja3XIDaeGlo7B6','long@gmail.com','STUDENT'),(8,'luc','luc ngu','$2a$10$9aYMC/WTkjFA1ofGvvg6o.RX.QrMRtYAeXx6ZWHtnExuaBs6Tr6M.','luc@gmail.com','STUDENT'),(9,'luc1','luc ngu1','$2a$10$NIoRw5FAARy.WEZeA9KJgugm4v74oQUeEH81r9GKMjU4f3XfExuyW','luc1@gmail.com','STUDENT'),(10,'lan','lan','$2a$10$5Q1o4kRKqiKOlqiuKQl/GOKYFBcihIKdayDl8pN3UpFvFUG5PqDaa','lan@gmail.com','ADMIN');
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhtoan`
--

DROP TABLE IF EXISTS `thanhtoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhtoan` (
  `MaThanhToan` int NOT NULL AUTO_INCREMENT,
  `MaHocVien` int NOT NULL,
  `MaKhoaHoc` int NOT NULL,
  `SoTien` decimal(38,2) NOT NULL,
  `TrangThai` varchar(255) NOT NULL,
  `NgayThanhToan` date DEFAULT NULL,
  PRIMARY KEY (`MaThanhToan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhtoan`
--

LOCK TABLES `thanhtoan` WRITE;
/*!40000 ALTER TABLE `thanhtoan` DISABLE KEYS */;
INSERT INTO `thanhtoan` VALUES (1,1,1,3000000.00,'Đã thanh toán',NULL),(2,2,2,4000000.00,'Chưa thanh toán',NULL),(3,3,3,5000000.00,'Hoàn tiền',NULL),(4,4,4,6000000.00,'Đã thanh toán',NULL);
/*!40000 ALTER TABLE `thanhtoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'k22cnt3_hoangvankhai_prj3'
--

--
-- Dumping routines for database 'k22cnt3_hoangvankhai_prj3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-12 11:06:18
