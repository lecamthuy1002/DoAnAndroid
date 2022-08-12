-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Aug 12, 2022 at 05:37 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlykhachsan`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietdatphong`
--

CREATE TABLE `chitietdatphong` (
  `IDCTDP` int(11) NOT NULL,
  `MALOAIPHONG` int(11) NOT NULL,
  `SOLUONGNGUOIO` int(11) NOT NULL,
  `GIODAT` datetime NOT NULL,
  `GIORA` datetime NOT NULL,
  `THANHTIEN` bigint(20) NOT NULL,
  `IDDATPHONG` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `datphong`
--

CREATE TABLE `datphong` (
  `IDDATPHONG` int(11) NOT NULL,
  `IDKHACHHANG` int(11) DEFAULT NULL,
  `GHICHU` varchar(200) DEFAULT NULL,
  `TRANGTHAI` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `IDKHACHHANG` int(11) NOT NULL,
  `HOTEN` varchar(50) NOT NULL,
  `DIENTHOAI` varchar(10) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `HINHANH` varchar(100) DEFAULT NULL,
  `XACNHAN` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khachsan`
--

CREATE TABLE `khachsan` (
  `MAKHACHSAN` varchar(45) NOT NULL,
  `TENKHACHSAN` varchar(100) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `GGMAP` varchar(100) NOT NULL,
  `MOTA` varchar(100) DEFAULT NULL,
  `HANG` int(11) NOT NULL,
  `NGUNGHD` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `loaiphong`
--

CREATE TABLE `loaiphong` (
  `IDLOAIPHONG` int(11) NOT NULL,
  `MAKHACHSAN` int(11) NOT NULL,
  `TENLOAIPHONG` varchar(100) NOT NULL,
  `MOTA` varchar(100) DEFAULT NULL,
  `HINHANH` varchar(100) DEFAULT NULL,
  `GIAPHONG` float NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `TRANGTHAI` bit(1) NOT NULL,
  `NGUNGHD` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `IDTAIKHOAN` int(11) NOT NULL,
  `HOTEN` text NOT NULL,
  `DIENTHOAI` text NOT NULL,
  `DIACHI` text NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `GIOITINH` varchar(10) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`IDTAIKHOAN`, `HOTEN`, `DIENTHOAI`, `DIACHI`, `EMAIL`, `GIOITINH`, `PASSWORD`) VALUES
(1, 'Le Cam Thuy', 'lecamthuy1002@gmail.com', '0784440269', 'Dong Thap', 'Nu', '123456'),
(5, 'a', '0123456789', 'nha Khang', 'a@gmail.com', 'Nữ', '123456'),
(6, 'Tran Thi Ngoc Hien', '123456268', 'Nha trang', 'hien@gmail.com', 'Nữ', '123456');

INSERT INTO `khachsan` (`MAKHACHSAN` ,`TENKHACHSAN` ,`DIACHI` , `GGMAP` ,`MOTA`,`HANG`, `NGUNGHD`) VALUES
('345','Lồng đèn đỏ','60 Hoa Hồng, Phường 7, Phú Nhuận, Thành phố Hồ Chí Minh','https://goo.gl/maps/dUswo6kT5CrWAjTA7','1 nơi tuyệt vời','11','1');

INSERT INTO `loaiphong` (`IDLOAIPHONG`, `MAKHACHSAN`, `TENLOAIPHONG`, `MOTA`, `HINHANH`, `GIAPHONG`, `SOLUONG`,`TRANGTHAI`,`NGUNGHD`) VALUES
(1, '345', 'Vip01', 'Đèn led, giường với gối tình yêu', 'https://s3.go2joy.vn/350w/hotel/3370/4479_1640840154_61cd3bdabd187.jpg', '500.000', '3', '0','1'),
(2, '345', 'Vip02', 'Đèn led, giường với gối tình yêu', 'https://s3.go2joy.vn/350w/hotel/3370/4479_1640840154_61cd3bdabd187.jpg', '500.000', '3', '0','1'),
(3, '345', 'Vip03', 'Đèn led, giường với gối tình yêu, bồn tắm, tủ lạnh', 'https://s3.go2joy.vn/350w/hotel/3370/4479_1640840154_61cd3bdabd187.jpg', '600.000', '2', '0','1'),
(4, '345', 'Vip04', 'Đèn led, giường với gối tình yêu, bồn tắm, tủ lạnh, ghế tình yêu', 'https://s3.go2joy.vn/350w/hotel/3370/4479_1640840154_61cd3bdabd187.jpg', '650.000', '2', '0','1'),
(5, '345', 'Vip05', 'Đèn led, giường với gối tình yêu, bồn tắm, tủ lạnh, ghế tình yêu', 'https://s3.go2joy.vn/350w/hotel/3370/4479_1640840154_61cd3bdabd187.jpg', '650.000', '2', '0','1');
--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdatphong`
--
ALTER TABLE `chitietdatphong`
  ADD PRIMARY KEY (`IDCTDP`);

--
-- Indexes for table `datphong`
--
ALTER TABLE `datphong`
  ADD PRIMARY KEY (`IDDATPHONG`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`IDKHACHHANG`);

--
-- Indexes for table `khachsan`
--
ALTER TABLE `khachsan`
  ADD PRIMARY KEY (`MAKHACHSAN`);

--
-- Indexes for table `loaiphong`
--
ALTER TABLE `loaiphong`
  ADD PRIMARY KEY (`IDLOAIPHONG`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`IDTAIKHOAN`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietdatphong`
--
ALTER TABLE `chitietdatphong`
  MODIFY `IDCTDP` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `datphong`
--
ALTER TABLE `datphong`
  MODIFY `IDDATPHONG` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `IDKHACHHANG` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaiphong`
--
ALTER TABLE `loaiphong`
  MODIFY `IDLOAIPHONG` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `IDTAIKHOAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
