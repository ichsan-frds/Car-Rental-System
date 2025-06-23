-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 23, 2025 at 06:29 AM
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
-- Database: `db_rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id_mobil` varchar(10) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `sewa` bigint(20) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id_mobil`, `jenis`, `sewa`, `stok`) VALUES
('1', 'Sedan', 200000, 0),
('2', 'Pickup', 300000, 4),
('3', 'Electric', 500000, 5),
('4', 'Convertible', 200000, 3),
('5', 'Hatchback', 300000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `cp` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `kode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama`, `alamat`, `cp`, `username`, `password`, `kode`) VALUES
('A001', 'Ichsan', 'Wisbul', '085959808110', 'ichsan', '12345', 1),
('U001', 'Josef', 'Anabela', '0811223344', 'josef', '67890', 0),
('U002', 'Dabur', 'Aminda', '081212121212', 'dabur', '67890', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `cp` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `cp`, `alamat`) VALUES
('1', 'Ichsan', '085959808110', 'Wisbul'),
('2', 'Joseff', '081234567890', 'Anabela');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(10) NOT NULL,
  `id_pegawai` varchar(10) NOT NULL,
  `id_mobil` varchar(10) NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_hrs_kembali` date NOT NULL,
  `lama` int(11) NOT NULL,
  `telat` int(11) DEFAULT NULL,
  `biaya` bigint(20) NOT NULL,
  `denda` bigint(20) DEFAULT NULL,
  `status` enum('Masih Dipinjam','Telah Dikembalikan','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `id_pegawai`, `id_mobil`, `id_pelanggan`, `tgl_pinjam`, `tgl_hrs_kembali`, `lama`, `telat`, `biaya`, `denda`, `status`) VALUES
('1', 'A001', '1', '1', '2023-11-03', '2023-11-10', 7, 1, 1400000, 100000, 'Telah Dikembalikan'),
('10', 'A001', '1', '1', '2023-12-15', '2023-12-22', 7, 0, 1400000, 0, 'Masih Dipinjam'),
('11', 'A001', '1', '1', '2023-12-08', '2023-12-09', 1, 1, 200000, 100000, 'Telah Dikembalikan'),
('12', 'A001', '1', '1', '2023-12-08', '2023-12-15', 7, 0, 1400000, 0, 'Masih Dipinjam'),
('13', 'A001', '2', '1', '2023-12-21', '2023-12-29', 8, 0, 2400000, 0, 'Masih Dipinjam'),
('2', 'A001', '2', '2', '2023-11-08', '2023-11-23', 15, 0, 4500000, 0, 'Telah Dikembalikan'),
('3', 'A001', '1', '1', '2023-11-09', '2023-11-16', 7, 0, 1400000, 0, 'Telah Dikembalikan'),
('4', 'A001', '1', '1', '2023-12-01', '2023-12-30', 29, 0, 5800000, 0, 'Telah Dikembalikan'),
('5', 'A001', '5', '1', '2023-12-15', '2023-12-30', 15, 0, 4500000, 0, 'Telah Dikembalikan'),
('6', 'A001', '5', '1', '2023-12-08', '2023-12-23', 15, 0, 4500000, 0, 'Telah Dikembalikan'),
('7', 'A001', '5', '1', '2023-12-01', '2023-12-15', 14, 1, 4200000, 100000, 'Telah Dikembalikan'),
('8', 'A001', '5', '1', '2023-12-08', '2023-12-30', 22, 0, 6600000, 0, 'Masih Dipinjam'),
('9', 'A001', '1', '1', '2023-12-02', '2023-12-09', 7, 0, 1400000, 0, 'Masih Dipinjam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `id_mobil` (`id_mobil`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_mobil`) REFERENCES `mobil` (`id_mobil`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
