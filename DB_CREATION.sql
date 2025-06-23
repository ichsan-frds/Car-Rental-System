-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 06, 2023 at 05:12 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE DATABASE db_perpustakaan;

USE db_perpustakaan;

CREATE TABLE `buku` (
  `id_buku` varchar(5) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `jenis` enum('Novel','Komik','Jurnal','Kamus','Majalah') NOT NULL,
  `tahun_terbit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `judul`, `jenis`, `tahun_terbit`) VALUES
('J001', 'Jurnal Administrasi Kesehatan Indonesia', 'Jurnal', 2022),
('J002', 'IJEE (Indonesian Journal of English Education)', 'Jurnal', 2022),
('J003', 'Journal of Medical & Healths Studies', 'Jurnal', 2020),
('KA001', 'Kamus Lengkap Bahasa Indonesia', 'Kamus', 2002),
('KA002', 'Kamus Inggris - Indonesia Oleh John M. Echols', 'Kamus', 1993),
('KA003', 'Kamus Bahasa Arab ke Indonesia', 'Kamus', 1990),
('KO001', 'Gundala', 'Komik', 2019),
('KO002', 'Dragon Ball Super', 'Komik', 2015),
('KO003', 'Jujutsu Kaisen', 'Komik', 2018),
('M001', 'Gatra', 'Majalah', 1994),
('M002', 'Geo Energy', 'Majalah', 2010),
('M003', 'Bobo', 'Novel', 1973),
('N001', '172 Days', 'Novel', 2022),
('N002', 'Majnun', 'Novel', 2022),
('N003', 'Gadis Kretek', 'Novel', 2012);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `tgl_pinjam` date DEFAULT NULL,
  `tgl_balik` date DEFAULT NULL,
  `status_peminjaman` enum('sedang dipinjam','sudah dikembalikan') DEFAULT NULL,
  `id_buku` varchar(5) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tgl_pinjam`, `tgl_balik`, `status_peminjaman`, `id_buku`, `username`) VALUES
(1, '2023-12-06', '2023-12-14', 'sudah dikembalikan', 'J001', 'dabur'),
(2, '2023-12-09', '2023-12-10', 'sedang dipinjam', 'N001', 'ichsan'),
(3, '2023-12-09', '2023-12-30', 'sedang dipinjam', 'J001', 'dabur'),
(4, '2023-12-09', '2023-12-15', 'sedang dipinjam', 'KO002', 'ichsan'),
(5, '2023-12-09', '2023-12-23', 'sedang dipinjam', 'M003', 'nugraha12312');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `level` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `pass`, `email`, `level`) VALUES
('admin', '12345', 'admin@gmail.com', '2'),
('admin1', '12345', 'admin@gmail.com', '2'),
('dabur', 'dabur', 'dabur@gmail.com', '1'),
('ichsan', '12345', 'ichsan@gmail.com', '1'),
('nugraha12312', '123456', '140810220039', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_buku` (`id_buku`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
