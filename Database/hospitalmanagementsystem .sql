-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2022 at 12:58 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitalmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_doctor`
--

CREATE TABLE `admin_doctor` (
  `did` varchar(15) NOT NULL,
  `dfname` varchar(50) NOT NULL,
  `dlname` varchar(50) NOT NULL,
  `daddress` varchar(100) NOT NULL,
  `dage` int(3) NOT NULL,
  `dgender` varchar(10) NOT NULL,
  `dmnum` int(12) NOT NULL,
  `dblood` varchar(6) NOT NULL,
  `dmaritial` varchar(10) NOT NULL,
  `djdate` varchar(100) NOT NULL,
  `dvtime` varchar(100) NOT NULL,
  `dvdays` varchar(100) NOT NULL,
  `dqualification` varchar(200) NOT NULL,
  `dvaccinedetail` varchar(5) NOT NULL,
  `dvaccinetype` varchar(15) NOT NULL,
  `duname` varchar(50) NOT NULL,
  `dpass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_doctor`
--

INSERT INTO `admin_doctor` (`did`, `dfname`, `dlname`, `daddress`, `dage`, `dgender`, `dmnum`, `dblood`, `dmaritial`, `djdate`, `dvtime`, `dvdays`, `dqualification`, `dvaccinedetail`, `dvaccinetype`, `duname`, `dpass`) VALUES
('D0001', 'Nipun', 'Madaya', 'Colombo, Sri Lanka', 28, 'Male', 71123456, 'O+', 'Married', '2019.05.01', '4.30 p.m. - 8.00 p.m.', 'Week Days', 'M.B.B.S', 'Yes', 'Fizer', 'Nipun', 'nipun'),
('D0002', 'Geethma ', 'Sathsarani', 'Kandy,Sri Lanka', 30, 'Female', 77123123, 'O+', 'Single', '2018.04.20', '4.00 p.m - 8.00 p.m', 'Week Days', 'M.B.B.S', 'Yes', 'Moderna', 'Geethma', 'geethma'),
('D0003', 'Himahsa', 'Rajapura', 'Galle,Sri Lanka', 30, 'Female', 71123123, 'A+', 'Single', '2019.02.08', '7.00 p.m - 10.00 p.m', 'Saturday,Sunday', 'M.B.B.S', 'Yes', 'Fizer', 'Himasha', 'himasha'),
('D0005', 'missaka', 'pramod', 'colombo', 22, 'Male', 123456789, 'A+', 'Single', '2022.01.01', '4.30 p.m.', 'weekdays', 'M.B.B.S', 'Yes', 'Fizer', 'missaka', 'missaka');

-- --------------------------------------------------------

--
-- Table structure for table `admin_patient`
--

CREATE TABLE `admin_patient` (
  `pid` varchar(10) NOT NULL,
  `pfname` varchar(50) NOT NULL,
  `plname` varchar(50) NOT NULL,
  `paddress` varchar(100) NOT NULL,
  `page` int(3) NOT NULL,
  `pgender` varchar(7) NOT NULL,
  `pmobilenumber` int(12) NOT NULL,
  `pvaccinedetail` varchar(15) NOT NULL,
  `pvaccinetype` varchar(10) NOT NULL,
  `admitdate` varchar(20) NOT NULL,
  `proom` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_patient`
--

INSERT INTO `admin_patient` (`pid`, `pfname`, `plname`, `paddress`, `page`, `pgender`, `pmobilenumber`, `pvaccinedetail`, `pvaccinetype`, `admitdate`, `proom`) VALUES
('P0001', 'Pramod', 'Manupriya', 'Colombo, Sri Lanka', 15, 'Male', 71456753, 'Yes', 'Moderna', '2022.01.05', 'R0001'),
('P0002', 'Missaka', 'Pramod', 'Colombo, Sri Lanka', 30, 'Male', 1234567, 'Yes', 'Phizer', '2022.01.03', 'Select');

-- --------------------------------------------------------

--
-- Table structure for table `admin_pharmacy`
--

CREATE TABLE `admin_pharmacy` (
  `hpid` varchar(20) NOT NULL,
  `hpfname` varchar(100) NOT NULL,
  `hplname` varchar(100) NOT NULL,
  `hpaddress` varchar(200) NOT NULL,
  `hpage` int(5) NOT NULL,
  `hpgender` varchar(8) NOT NULL,
  `hpmnum` varchar(15) NOT NULL,
  `hpuname` varchar(20) NOT NULL,
  `hppass` varchar(20) NOT NULL,
  `hpvaccintype` varchar(50) NOT NULL,
  `hpvaccinedetails` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_pharmacy`
--

INSERT INTO `admin_pharmacy` (`hpid`, `hpfname`, `hplname`, `hpaddress`, `hpage`, `hpgender`, `hpmnum`, `hpuname`, `hppass`, `hpvaccintype`, `hpvaccinedetails`) VALUES
('PH0001', 'Sadun', 'Bhagya', 'Puttalam, Sri Lanka', 25, 'Male', '076423489', 'Sadun', 'sadun', 'Phizer', 'Yes'),
('PH0002', 'Sewwandi', 'Gunasinghe', 'Colombo, Sri Lanka', 22, 'Female', '071475126', 'Sewwandi', 'sewwandi', 'Moderna', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `admin_receptionist`
--

CREATE TABLE `admin_receptionist` (
  `rid` varchar(10) NOT NULL,
  `rfname` varchar(50) NOT NULL,
  `rlname` varchar(50) NOT NULL,
  `raddress` varchar(100) NOT NULL,
  `rage` int(3) NOT NULL,
  `rgender` varchar(6) NOT NULL,
  `rmobilenum` int(10) NOT NULL,
  `rvaccinedetail` varchar(15) NOT NULL,
  `rvaccinetype` varchar(15) NOT NULL,
  `runame` varchar(50) NOT NULL,
  `rpass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_receptionist`
--

INSERT INTO `admin_receptionist` (`rid`, `rfname`, `rlname`, `raddress`, `rage`, `rgender`, `rmobilenum`, `rvaccinedetail`, `rvaccinetype`, `runame`, `rpass`) VALUES
('R0001', 'Missaka', 'Pramod', 'Colombo, Sri Lanka', 30, 'Male', 76159123, 'Yes', 'Sinopharm', 'micky', '123456'),
('R0002', 'Chanura', 'Kushan', 'Colombo, Sri Lanka', 22, 'Male', 71789456, 'Yes', 'Sinopharm', 'Chanura', 'chanura');

-- --------------------------------------------------------

--
-- Table structure for table `appoinment`
--

CREATE TABLE `appoinment` (
  `cnum` varchar(15) NOT NULL,
  `cdate` varchar(15) NOT NULL,
  `cdoc` varchar(100) NOT NULL,
  `cpatient` varchar(100) NOT NULL,
  `croom` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appoinment`
--

INSERT INTO `appoinment` (`cnum`, `cdate`, `cdoc`, `cpatient`, `croom`) VALUES
('CH0001', '2022.01.12', 'Nipun', 'Pramod', 'R0001'),
('CH0002', '2022.01.12', 'Himahsa', 'Kasun', 'R0001'),
('CH0003', '2022.01.15', 'Geethma ', 'Pramod', 'R0001'),
('CH0004', '2022.02.01', 'missaka', 'Pramod', 'R0001');

-- --------------------------------------------------------

--
-- Table structure for table `bed_details`
--

CREATE TABLE `bed_details` (
  `bid` varchar(10) NOT NULL,
  `brooms` int(5) NOT NULL,
  `bcategory` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bed_details`
--

INSERT INTO `bed_details` (`bid`, `brooms`, `bcategory`) VALUES
('R0001', 5, 'ICU'),
('R0002', 4, 'Normal'),
('R0003', 6, 'Normal'),
('R0004', 3, 'ICU');

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `billnum` varchar(20) NOT NULL,
  `billdate` varchar(20) NOT NULL,
  `scharge` varchar(20) NOT NULL,
  `dcharge` varchar(20) NOT NULL,
  `rcharge` varchar(20) NOT NULL,
  `roomdays` varchar(20) NOT NULL,
  `rtcharge` varchar(20) NOT NULL,
  `paymantmethod` varchar(20) NOT NULL,
  `tcharge` varchar(20) NOT NULL,
  `pid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`billnum`, `billdate`, `scharge`, `dcharge`, `rcharge`, `roomdays`, `rtcharge`, `paymantmethod`, `tcharge`, `pid`) VALUES
('B0001', '2022.01.12', '3000', '4000', '1500', '7', '10500.0', 'Debit Card', '17500.0', 'P0001'),
('B0002', '2022.01.12', '2000', '2000', '1000', '7', '7000.0', 'Debit Card', '11000.0', 'P0001');

-- --------------------------------------------------------

--
-- Table structure for table `patientdischarge`
--

CREATE TABLE `patientdischarge` (
  `pid` varchar(20) NOT NULL,
  `admitdate` varchar(20) NOT NULL,
  `dischargedate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patientdischarge`
--

INSERT INTO `patientdischarge` (`pid`, `admitdate`, `dischargedate`) VALUES
('P0001', '2022.01.05', '2022.01.12');

-- --------------------------------------------------------

--
-- Table structure for table `pharm_item`
--

CREATE TABLE `pharm_item` (
  `itemid` varchar(10) NOT NULL,
  `itemname` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `sellprice` varchar(10) NOT NULL,
  `buyprice` varchar(10) NOT NULL,
  `quentity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pharm_item`
--

INSERT INTO `pharm_item` (`itemid`, `itemname`, `description`, `sellprice`, `buyprice`, `quentity`) VALUES
('I0001', 'Panadol', '3 times per day', '30', '20', 100),
('I0002', 'Piriton', '3 times per day', '10', '5', 200);

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `prsid` varchar(20) NOT NULL,
  `chnlid` varchar(20) NOT NULL,
  `docname` varchar(100) NOT NULL,
  `detype` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`prsid`, `chnlid`, `docname`, `detype`, `description`) VALUES
('PR0006', 'CH0001', '2022.01.12', 'Fever', '5 Panadols');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `spid` int(20) NOT NULL,
  `sapresid` varchar(20) NOT NULL,
  `stotal` int(20) NOT NULL,
  `spay` int(20) NOT NULL,
  `sbalance` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`spid`, `sapresid`, `stotal`, `spay`, `sbalance`) VALUES
(1, '', 105, 150, 45),
(2, 'PR0003', 210, 250, 40),
(3, 'PR0002', 147, 200, 53),
(4, 'PR0001', 210, 300, 90),
(5, 'PR0001', 105, 150, 45),
(6, 'PR0005', 315, 400, 85),
(7, 'PR0006', 180, 200, 20);

-- --------------------------------------------------------

--
-- Table structure for table `sale_product`
--

CREATE TABLE `sale_product` (
  `id` int(20) NOT NULL,
  `spresid` varchar(20) NOT NULL,
  `itemid` varchar(20) NOT NULL,
  `itemname` varchar(20) NOT NULL,
  `qty` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sale_product`
--

INSERT INTO `sale_product` (`id`, `spresid`, `itemid`, `itemname`, `qty`) VALUES
(5, 'PR0001', 'I0001', 'sfaaf', 5),
(14, 'PR0001', '', '', 0),
(15, 'PR0005', '', '', 0),
(16, 'PR0005', '', '', 0),
(17, 'PR0006', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `sale_product1`
--

CREATE TABLE `sale_product1` (
  `spresid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_doctor`
--
ALTER TABLE `admin_doctor`
  ADD PRIMARY KEY (`did`,`duname`,`dpass`);

--
-- Indexes for table `admin_patient`
--
ALTER TABLE `admin_patient`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `admin_pharmacy`
--
ALTER TABLE `admin_pharmacy`
  ADD PRIMARY KEY (`hpid`,`hpuname`,`hppass`);

--
-- Indexes for table `admin_receptionist`
--
ALTER TABLE `admin_receptionist`
  ADD PRIMARY KEY (`rid`,`runame`,`rpass`);

--
-- Indexes for table `appoinment`
--
ALTER TABLE `appoinment`
  ADD PRIMARY KEY (`cnum`);

--
-- Indexes for table `bed_details`
--
ALTER TABLE `bed_details`
  ADD PRIMARY KEY (`bid`);

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`billnum`);

--
-- Indexes for table `patientdischarge`
--
ALTER TABLE `patientdischarge`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `pharm_item`
--
ALTER TABLE `pharm_item`
  ADD PRIMARY KEY (`itemid`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`prsid`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`spid`);

--
-- Indexes for table `sale_product`
--
ALTER TABLE `sale_product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `spid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sale_product`
--
ALTER TABLE `sale_product`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
