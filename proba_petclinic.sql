-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2020 at 12:16 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proba_petclinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `diagnosis`
--

CREATE TABLE `diagnosis` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diagnosis`
--

INSERT INTO `diagnosis` (`id`, `name`) VALUES
(1, 'Cataracts'),
(2, 'Arthritis'),
(3, 'Ear Infection'),
(4, 'Fleas'),
(5, 'Ticks'),
(6, 'Heartworm'),
(7, 'Broken Bones'),
(8, 'Obesity'),
(9, 'Cancer'),
(10, 'Healty'),
(11, 'Diabetes'),
(12, 'Rabies'),
(13, 'Ringworm'),
(14, 'Upper Respitory Infection'),
(15, 'Worms'),
(16, 'Nutritional Deficiencies'),
(17, 'Overgrown Teeth'),
(26, 'Cancer'),
(27, 'Healty'),
(28, 'Diabetes'),
(29, 'Rabies'),
(30, 'Ringworm'),
(31, 'Upper Respitory Infection'),
(32, 'Worms'),
(33, 'Nutritional Deficiencies'),
(34, 'Overgrown Teeth');

-- --------------------------------------------------------

--
-- Table structure for table `examination`
--

CREATE TABLE `examination` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `totalcost` float NOT NULL,
  `id_diagnosis` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examination`
--

INSERT INTO `examination` (`id`, `date`, `totalcost`, `id_diagnosis`, `id_patient`) VALUES
(1, '2020-06-17', 1000, 10, 1),
(2, '2020-06-20', 2600, 11, 2);

-- --------------------------------------------------------

--
-- Table structure for table `examination_item`
--

CREATE TABLE `examination_item` (
  `id` int(11) NOT NULL,
  `id_examination` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `id_treatment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examination_item`
--

INSERT INTO `examination_item` (`id`, `id_examination`, `amount`, `id_treatment`) VALUES
(1, 1, 1, 8),
(2, 2, 1, 3),
(3, 2, 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `petname` varchar(45) NOT NULL,
  `ownername` varchar(45) NOT NULL,
  `number` varchar(45) NOT NULL,
  `id_veterinarian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `petname`, `ownername`, `number`, `id_veterinarian`) VALUES
(1, 'Dona', 'Danijela Bozic', '063405222', 1),
(2, 'Lana', 'Veljko Bozic', '0634052332', 2);

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE `treatment` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `treatment`
--

INSERT INTO `treatment` (`id`, `name`, `price`) VALUES
(1, 'Teeth  Cleaning', 500),
(2, 'Treatment For Ear Infection', 1500),
(3, 'Diet', 600),
(4, 'complete blood count', 1200.65),
(5, 'cataract surgery', 4000),
(6, 'tumor surgery', 6000),
(7, 'ultrasound', 2000),
(8, 'vaccination', 1000),
(9, 'heartworm treatment', 6000),
(10, 'parasite treatment', 2000),
(11, 'arthroscopy', 2500);

-- --------------------------------------------------------

--
-- Table structure for table `veterinarian`
--

CREATE TABLE `veterinarian` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `number` varchar(45) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `veterinarian`
--

INSERT INTO `veterinarian` (`id`, `name`, `number`, `username`, `password`) VALUES
(1, 'Maja Ivanovic', '063405088', 'maja@gmail.com', '$2a$10$YfZgySJqupQhqI/EPeP/veO6VAJ80w6zhU5cmuYcItPLx9NfI0nwW'),
(2, 'Sara Nedic', '025896332', 'sara@gmail.com', '$2a$10$H52U2DwO.A/Zl9wQBiECHOWLCGHjkz3yhOMkA5uBzGYtAc5XF1Lbu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diagnosis`
--
ALTER TABLE `diagnosis`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `examination`
--
ALTER TABLE `examination`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_examination_1` (`id_diagnosis`),
  ADD KEY `fk_examination_2` (`id_patient`);

--
-- Indexes for table `examination_item`
--
ALTER TABLE `examination_item`
  ADD PRIMARY KEY (`id`,`id_examination`),
  ADD KEY `fk_examinationitem_2` (`id_treatment`),
  ADD KEY `fk_examinationitem_3` (`id_examination`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_patientid_1` (`id_veterinarian`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `veterinarian`
--
ALTER TABLE `veterinarian`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diagnosis`
--
ALTER TABLE `diagnosis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `examination`
--
ALTER TABLE `examination`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `examination_item`
--
ALTER TABLE `examination_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `treatment`
--
ALTER TABLE `treatment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `veterinarian`
--
ALTER TABLE `veterinarian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `examination`
--
ALTER TABLE `examination`
  ADD CONSTRAINT `fk_examination_1` FOREIGN KEY (`id_diagnosis`) REFERENCES `diagnosis` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_examination_2` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `examination_item`
--
ALTER TABLE `examination_item`
  ADD CONSTRAINT `fk_examinationitem_2` FOREIGN KEY (`id_treatment`) REFERENCES `treatment` (`id`),
  ADD CONSTRAINT `fk_examinationitem_3` FOREIGN KEY (`id_examination`) REFERENCES `examination` (`id`);

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `fk_patientid_1` FOREIGN KEY (`id_veterinarian`) REFERENCES `veterinarian` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
