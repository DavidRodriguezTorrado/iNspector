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
-- Table structure for table `inspectores`
--

DROP TABLE IF EXISTS `inspectores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inspectores` (
  `email` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `autorizado` varchar(5) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspectores`
--

LOCK TABLES `inspectores` WRITE;
/*!40000 ALTER TABLE `inspectores` DISABLE KEYS */;
INSERT INTO `inspectores` VALUES ('agustin@gmail.com','Agustin','agus','yes'),('alfonso@gmail.com','Alfonso','alfon','no'),('alfredo@gmail.com','Alfredo','alfredo','no'),('ana@gmail.com','Ana','ana','yes'),('angela@gmail.com','Angela','angela','yes'),('anselmo@gmail.com','Anselmo','ansel','no'),('antonio@gmail.com','Antonio','antonio','no'),('aurora@gmail.com','Aurora','au','no'),('belen@gmail.com','Belen','belen','no'),('blanca@gmail.com','Blanca','blanca','no'),('carlos@gmail.com','Carlos','car','no'),('davidr@gmail.com','David','david','no'),('davidv@gmail.com','David','david','no'),('diego@gmail.com','Diego','diego','no'),('felix@gmail.com','Felix','felix','no'),('fernando@gmail.com','Fernando','fer','no'),('francisco@gmail.com','Francisco','francisco','no'),('gabriel@gmail.com','Gabriel','gabi','no'),('gonzalo@gmail.com','Gonzalo','gon','no'),('hola@g.com','Hola','hello','no'),('hugo@gmail.com','Hugo','hugo','no'),('ines@gmail.com','Ines','ines','no'),('isidro@gmail.com','Isidro','isi','no'),('joaquin@gmail.com','Joaquin','joa','no'),('jorge@gmail.com','Jorge','jorge','no'),('juan@gmail.com','Juan','juan','no'),('lola@gmail.com','Lola','lola','no'),('lucia@gmail.com','lucia','lucia','no'),('luis@gmail.com','Luisito','luis','no'),('manuela@gmail.com','Manuela','manu','no'),('maria@gmail.com','maria','maria','no'),('marta@gmail.com','Marta','marta','no'),('pablo@gmail.com','Pablo','pablo','no'),('patricia@gmail.com','Patricia','patri','no'),('pedro@gmail.com','Pedro','pedro','no'),('pilar@gmail.com','Pilar','pilar','no'),('prueba@gmail.com','Prueba','p1','no'),('santiago@gmail.com','Santiago','santi','no'),('sonsoles@gmail.com','Sonsoles','sonso','no'),('susana@gmail.com','Susana','susana','no'),('teresa@gmail.com','Teresa','tere','no');
/*!40000 ALTER TABLE `inspectores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 12:39:45
