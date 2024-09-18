-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: kviz
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `quizItems`
--

DROP TABLE IF EXISTS `quizItems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quizItems` (
  `answer_id` int NOT NULL AUTO_INCREMENT,
  `question_id` int DEFAULT NULL,
  `is_correct` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `answer_text1` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `answer_text3` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `answer_text4` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `answer_text2` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `fk_question_id_idx` (`question_id`),
  CONSTRAINT `fk_question_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizItems`
--

LOCK TABLES `quizItems` WRITE;
/*!40000 ALTER TABLE `quizItems` DISABLE KEYS */;
INSERT INTO `quizItems` VALUES (1,1,'Pas','Macka','Konj','Pas','Patka'),(2,2,'Kit','Žirafa','Kit','Vuk','Krava'),(3,3,'Konj','Konj','Lisica','Slon','Gepard'),(4,4,'Leonardo Di Caprio','Kate Winslet','Victor Garber','BillY Zane','Leonardo Di Caprio'),(5,5,'James Cameron','Jack Nicholson','James Cameron','Morgan Freeman','Oliver Stone'),(6,6,'Keanu Reeves','Tom Hanks','Al Pacino','Vin Diesel','Keanu Reeves'),(7,7,'Atletika','Košarka','Bejzbol','Atletika','Fudbal'),(8,8,'Francuska','Francuska','Njemačka','Brazil','Italija'),(9,9,'Drazen Petrovic','Vlade Divac','Drazen Petrovic','Mirza Delibasic','Dule Savic'),(10,10,'3','1','2','5','3'),(11,11,'Hromosom1','Krv','Hromosom1','Meso','Atom'),(12,12,'Nijedan','Dva','Šest','Nijedan','4'),(13,13,'Michael Jackson','Michael Jackson','Justin Bieber','James Brown','Elvis Presley'),(14,14,'Youtube','Youtube','Tik Tok','Instagram','America got Talent'),(15,15,'Saban Saulic','Miroslav Ilic','Halid Beslic','Ljuba Alicic','Saban Saulic'),(16,16,'Govedina','Piletina','Svinjetina','Govedina','Riba'),(17,17,'Coca Cola','Pepsi','Dr Peper','Mountain Dew','Coca Cola'),(18,18,'Ananas','Naranca','Jabuka','Ananas','Jagoda');
/*!40000 ALTER TABLE `quizItems` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-06 18:14:11
