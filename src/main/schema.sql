-- --------------------------------------------------------
-- Verkkotietokone:              127.0.0.1
-- Palvelinversio:               10.5.19-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Versio:              12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for k2023backend
CREATE DATABASE IF NOT EXISTS `k2023backend` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;
USE `k2023backend`;

-- Dumping structure for taulu k2023backend.manufactorer
CREATE TABLE IF NOT EXISTS `manufactorer` (
  `manufactorerid` bigint(20) NOT NULL,
  `name` bigint(20) NOT NULL,
  PRIMARY KEY (`manufactorerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Dumping data for table k2023backend.manufactorer: ~0 rows (suunnilleen)

-- Dumping structure for taulu k2023backend.product
CREATE TABLE IF NOT EXISTS `product` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` varchar(50) DEFAULT '',
  `size` char(1) DEFAULT '',
  `color` varchar(50) DEFAULT '',
  `price` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `countryofproduction` varchar(50) DEFAULT '0',
  `description` varchar(50) DEFAULT '0',
  `manufactorerid` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `manufactorerid` (`manufactorerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Dumping data for table k2023backend.product: ~0 rows (suunnilleen)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
