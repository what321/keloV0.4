-- MySQL dump 10.13  Distrib 8.2.0, for Linux (x86_64)
--
-- Host: localhost    Database: keloDB
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CylinderInfo`
--

DROP TABLE IF EXISTS `CylinderInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CylinderInfo` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `factory` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rightUnit` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gasType` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tareWeight` int DEFAULT NULL,
  `maxWeight` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CylinderInfo`
--

LOCK TABLES `CylinderInfo` WRITE;
/*!40000 ALTER TABLE `CylinderInfo` DISABLE KEYS */;
INSERT INTO `CylinderInfo` VALUES ('0001','钢瓶一厂','工业职业技术学院','氮气',5,500),('0002','钢瓶二厂','工业职业技术学院','氧气',10,800);
/*!40000 ALTER TABLE `CylinderInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OperateRecord`
--

DROP TABLE IF EXISTS `OperateRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OperateRecord` (
  `id` int NOT NULL AUTO_INCREMENT,
  `operaterId` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cylinderId` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gasType` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `beginWeight` int DEFAULT NULL,
  `endWeight` int DEFAULT NULL,
  `operateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OperateRecord`
--

LOCK TABLES `OperateRecord` WRITE;
/*!40000 ALTER TABLE `OperateRecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `OperateRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OperaterInfo`
--

DROP TABLE IF EXISTS `OperaterInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OperaterInfo` (
  `id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tel` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `addr` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `delFlag` bit(1) DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OperaterInfo`
--

LOCK TABLES `OperaterInfo` WRITE;
/*!40000 ALTER TABLE `OperaterInfo` DISABLE KEYS */;
INSERT INTO `OperaterInfo` VALUES ('001','张三','13913913913','xxxxx',NULL,'49ba59abbe56e057'),('002','李四','13813813813','yyyyyy',NULL,'6449df565f93c607');
/*!40000 ALTER TABLE `OperaterInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'keloDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-19  2:47:38
