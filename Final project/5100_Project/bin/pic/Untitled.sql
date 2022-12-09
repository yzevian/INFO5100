-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: CarRental
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `CarBrandTable`
--

DROP TABLE IF EXISTS `CarBrandTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CarBrandTable` (
  `id` int NOT NULL,
  `Brand` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CarBrandTable`
--

LOCK TABLES `CarBrandTable` WRITE;
/*!40000 ALTER TABLE `CarBrandTable` DISABLE KEYS */;
INSERT INTO `CarBrandTable` VALUES (1,'Kia'),(2,'Toyota'),(3,'Volvo'),(4,'Honda'),(5,'Audi'),(6,'Tesla');
/*!40000 ALTER TABLE `CarBrandTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carTable`
--

DROP TABLE IF EXISTS `carTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carTable` (
  `id` int NOT NULL,
  `Brand` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Color` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Price` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carTable`
--

LOCK TABLES `carTable` WRITE;
/*!40000 ALTER TABLE `carTable` DISABLE KEYS */;
INSERT INTO `carTable` VALUES (1,'Kia','Black','200','5seat'),(2,'Toyota','Black','200','5seat'),(3,'Volvo','Black','200','5seat'),(4,'Honda','Black','200','5seat'),(5,'Audi','Black','200','5seat'),(6,'Tesla','Black','200','5seat'),(7,'Audi','White','200','5Seat'),(8,'Volvo','Brown','200','5seat');
/*!40000 ALTER TABLE `carTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GuestTable`
--

DROP TABLE IF EXISTS `GuestTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GuestTable` (
  `DL_number` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Guest_Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `User_Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Age` int DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`User_Name`,`DL_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GuestTable`
--

LOCK TABLES `GuestTable` WRITE;
/*!40000 ALTER TABLE `GuestTable` DISABLE KEYS */;
INSERT INTO `GuestTable` VALUES ('1234678','Guestname','User1','1234678',29,'Male'),('7654321','GuestName','User2','7654321',23,'Female'),('1234567','GuestName','User3','1234567',23,'Female'),('1234567','GuestName','User4','1234567',26,'Male'),('123654','GuestName','User5','123654',23,'Female'),('9876543','GuestName','User6','9876543',23,'Female');
/*!40000 ALTER TABLE `GuestTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReservationTable`
--

DROP TABLE IF EXISTS `ReservationTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReservationTable` (
  `id` int NOT NULL,
  `Car_Brand` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `User_Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `Carid` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `price` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Color` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `State` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReservationTable`
--

LOCK TABLES `ReservationTable` WRITE;
/*!40000 ALTER TABLE `ReservationTable` DISABLE KEYS */;
INSERT INTO `ReservationTable` VALUES (1,'Honda','User1','2022-11-26','2022-11-26','4','200','5seat','Black',0),(2,'Kia','User1','2022-11-27','2022-11-27','1','200','5seat','Black',0),(3,'Kia','User2','2022-11-28','2022-11-28','1','200','5seat','Black',0),(4,'Honda','User3','2022-11-28','2022-11-28','4','200','5seat','Black',0),(8,'Tesla','User2','2022-12-04','2022-12-05','6','200','5seat','Black',0),(9,'Toyota','User1','2022-12-01','2022-12-01','2','200','5seat','Black',0),(10,'Toyota','User2','2022-12-03','2022-12-05','2','200','5seat','Black',0),(11,'Honda','User1','2022-12-08','2022-12-09','4','200','5seat','Black',1),(12,'Kia','User1','2022-12-05','2023-01-01','1','200','5seat','Black',1),(13,'Toyota','User1','2022-12-09','2022-12-12','2','200','5seat','Black',0),(14,'Volvo','User2','2022-12-08','2022-12-09','8','200','5seat','Brown',1),(15,'Audi','User1','2022-12-16','2022-12-18','7','200','5Seat','White',1),(16,'Volvo','User3','2022-12-18','2022-12-22','8','200','5seat','Brown',1),(19,'Honda','User1','2022-12-08','2022-12-09','4','200','5seat','Black',1),(20,'Tesla','User2','2022-12-13','2022-12-17','6','200','5seat','Black',1),(21,'Volvo','User3','2022-12-08','2022-12-09','3','200','5seat','Black',1);
/*!40000 ALTER TABLE `ReservationTable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-09  1:09:16
