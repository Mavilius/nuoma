-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2021 at 08:30 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nuoma`
--

-- --------------------------------------------------------

--
-- Table structure for table `irankiai`
--

CREATE TABLE `irankiai` (
  `id` int(10) UNSIGNED NOT NULL,
  `pavadinimas` varchar(255) NOT NULL,
  `tipas` varchar(255) NOT NULL,
  `pirkimo_data` int(10) UNSIGNED NOT NULL,
  `kaina` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `irankiai_klientai`
--

CREATE TABLE `irankiai_klientai` (
  `id_irankiai` int(10) UNSIGNED NOT NULL,
  `id_klientai` int(10) UNSIGNED NOT NULL,
  `paemimo_data` date NOT NULL,
  `grazinimo_data` date NOT NULL,
  `irankio_bukle` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `klientai`
--

CREATE TABLE `klientai` (
  `id` int(10) UNSIGNED NOT NULL,
  `vardas` varchar(255) NOT NULL,
  `tipas` int(10) UNSIGNED NOT NULL,
  `kontaktai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `irankiai`
--
ALTER TABLE `irankiai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klientai`
--
ALTER TABLE `klientai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `irankiai`
--
ALTER TABLE `irankiai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `klientai`
--
ALTER TABLE `klientai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
