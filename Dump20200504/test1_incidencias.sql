-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: test1
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `incidencias`
--

DROP TABLE IF EXISTS `incidencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidencias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` varchar(25) NOT NULL,
  `local` int NOT NULL,
  `customer` varchar(50) NOT NULL,
  `inspector` varchar(50) NOT NULL,
  `inspected` varchar(3) NOT NULL,
  `comentarios` varchar(255) NOT NULL,
  `resultado` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `local` (`local`),
  KEY `customer` (`customer`),
  KEY `inspector` (`inspector`),
  CONSTRAINT `incidencias_ibfk_1` FOREIGN KEY (`local`) REFERENCES `locales` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `incidencias_ibfk_2` FOREIGN KEY (`customer`) REFERENCES `customers` (`email`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `incidencias_ibfk_3` FOREIGN KEY (`inspector`) REFERENCES `inspectores` (`email`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencias`
--

LOCK TABLES `incidencias` WRITE;
/*!40000 ALTER TABLE `incidencias` DISABLE KEYS */;
INSERT INTO `incidencias` VALUES (1,'2020/05/02',1285,'maria@gmail.com','alfredo@gmail.com','no','vaya kk',''),(2,'2020-05-02 19:18:22',2861,'simba@gmail.com','aurora@gmail.com','no','hab�a cucarachas',''),(3,'2020-05-03 14:28:53',5113,'maria@gmail.com','belen@gmail.com','no','este sitio no me ha molado',''),(4,'2020-05-03 14:32:36',4536,'maria@gmail.com','juan@gmail.com','no','shit','');
/*!40000 ALTER TABLE `incidencias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 12:39:46
