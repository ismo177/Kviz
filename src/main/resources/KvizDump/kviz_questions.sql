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
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `questions_text` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `fk_categories_id_idx` (`category_id`),
  CONSTRAINT `fk_categories_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'Koja zivotinja ima mladunce štene?'),(2,1,'Najveca životinja na planeti je?'),(3,1,'Najbrza zivotinja je?'),(4,2,'Ko igra glavnu ulogu u filmu Titanik?'),(5,2,'Ko je režiser filma Terminator2?'),(6,2,'Kako se zvao glavni lik u filmu Matrix?'),(7,3,'Kraljica sporta je?'),(8,3,'Ko je osvoji Svjetsko prvenstvo u fudbalu 1998. godine?'),(9,3,'Najpoznatiji košarkaš u bivšoj Jugosaviji je?'),(10,4,'Koliko srca ima hobotnica?'),(11,4,'Koja je najveca molekula koja cini dio ljudskog tijela?'),(12,4,'Koliko grama soli ima u litri tipicne morske vode?'),(13,5,'Koji je pjevac izmedzu ostalog bio poznat kao \'Kralj popa\' i \'Rukavica\'?'),(14,5,'Gdje je otkriven Justin Bieber?'),(15,5,'Ko je bio kralj Narodne muzike?'),(16,6,' Od koje se vrste mesa rade hamburgeri? '),(17,6,'Koji je gazirani napitak bio najpoznatiji 1892. godine? '),(18,6,'Koje voce može omeksati meso?');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
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
