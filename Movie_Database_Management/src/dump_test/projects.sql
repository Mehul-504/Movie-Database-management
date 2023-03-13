-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: projects
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Movie_Name` varchar(1000) NOT NULL,
  `Language` varchar(1000) DEFAULT NULL,
  `Genere` varchar(1000) DEFAULT NULL,
  `Rating` double DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'The Dark Knight','english','action',9.5),(2,'Mr Majnu','telugu','action',9.9),(3,'Jersy','hindi','drama',8.175),(4,'The Silent voice','japanese','sentimental',6.75),(5,'Baazi','bengali','emotional',9.35),(6,'Colombo','sinhalese','comedy',7.7),(7,'Abhimann','bengali','emotional',7.9),(8,'The conjuring','english','horror',6.75),(9,'Butterfly Symphony','sinhalese','drama',8),(10,'Kgf','telugu','action',9.5),(11,'Mahanati','telugu','drama',9),(12,'The conjuring','english','horror',8.5),(13,'3 idiots','hindi','comedy',9),(14,'Squid Game','korean','Thriller',9.266666666666667),(15,'Money Heist','spanish','drama',9.45),(16,'Akhanda','telugu','Fantasy',8.1),(17,'mahanati','telugu','drama',9),(18,'minnale','mamil','romance',9.4),(19,'nanban','tamil','comedy',6.9),(20,'sakhi','telugu','romance',7.9),(21,'tamasha','hindi','drama',9.8),(22,'lucy','english','sci-fi',8.9),(23,'netrikann','tamil','thriller',8.4),(24,'bangalore days','kannada','drama',8),(25,'ninnila ninnila','telugu','comedy',6.9),(26,'shangchi','english','action',0),(27,'eternals','english','action',0),(28,'the matrix','english ','sci-fi',0),(29,'gods of egypt','english','historical',0),(30,'antim ','hindi ','action',0),(31,'skylab','hindi','drama',0),(32,'spiderman','english','action',0),(33,'the physician','english','history',0),(34,'kingdom of heaven','english','history',0),(35,'Kurup','hindi','thriller',0),(36,'encanto','english','comedy',0),(37,'the room','english','mystery',0),(38,'mirage','english','mystery',0),(39,'slenderman','english','horror',0),(40,'IT','english','horror',0);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jhon',1,10),(2,'jim',2,9.8),(3,'kim',3,7.9),(4,'liz',4,5.5),(5,'nak',5,9.7),(6,'Mix',1,9.5),(7,'Foo',4,8),(8,'Mak',5,9),(9,'Mark',6,8.9),(10,'Liz',9,8),(11,'Kim',10,10),(12,'Tim',7,8),(13,'Tom',8,7.9),(14,'Bob',2,10),(15,'Baok',3,6.9),(16,'Lak',10,9),(17,'Nak',11,9),(18,'Bak',12,8.5),(19,'Oliver',13,9),(20,'Baazi',8,5.6),(21,'William',7,7.8),(22,'James',3,8.9),(23,'Lucas',6,6.5),(24,'Sudha',14,10),(25,'Vish',15,9.9),(26,'Aasim',15,10),(27,'Ramya',14,9.8),(28,'Sree',15,9.9),(29,'Noloan',15,8),(30,'Bruno',3,9),(31,'Ava',16,7.3),(32,'Robert',14,8),(33,'Tim',1,9),(34,'Sam',16,8.9),(35,'Dan',17,9),(36,'Ava',18,9.4),(37,'Eva',19,6.9),(38,'Angela',20,7.9),(39,'Myra',21,9.8),(40,'Alena',22,8.9),(41,'Maya',23,7.9),(42,'Vishal',23,8.9),(43,'Bruno',24,8),(44,'Mary',25,6.9);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 21:43:23
