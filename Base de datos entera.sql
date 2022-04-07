-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: concesionario2
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `camion`
--

DROP TABLE IF EXISTS `camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camion` (
  `numBastidor` varchar(20) NOT NULL,
  `carga` int NOT NULL,
  `tipoMercancia` varchar(20) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `color` varchar(10) NOT NULL,
  `numAsientos` int NOT NULL,
  `precio` double NOT NULL,
  `numSerie` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`numBastidor`),
  UNIQUE KEY `vehiculo_numBastidor_UNIQUE` (`numBastidor`),
  KEY `fk_camion_vehiculo1_idx` (`numBastidor`),
  KEY `numSerie_idx` (`numSerie`),
  CONSTRAINT `numSerie` FOREIGN KEY (`numSerie`) REFERENCES `serie` (`numSerie`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camion`
--

LOCK TABLES `camion` WRITE;
/*!40000 ALTER TABLE `camion` DISABLE KEYS */;
INSERT INTO `camion` VALUES ('1111111',500,'Tierra','6789423','Rojo',5,10000,3),('12346655',500,'Arena','90989989','Rogo',5,10000,4);
/*!40000 ALTER TABLE `camion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coche`
--

DROP TABLE IF EXISTS `coche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coche` (
  `numBastidor` varchar(20) NOT NULL,
  `numPuertas` int NOT NULL,
  `capacidadMaletero` int NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `color` varchar(10) NOT NULL,
  `numAsientos` varchar(10) NOT NULL,
  `precio` double NOT NULL,
  `numSerie` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`numBastidor`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_coche_vehiculo1_idx` (`numBastidor`),
  KEY `numSerie_idx` (`numSerie`),
  CONSTRAINT `numSerie2` FOREIGN KEY (`numSerie`) REFERENCES `serie` (`numSerie`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coche`
--

LOCK TABLES `coche` WRITE;
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` VALUES ('12349996',3333,3333,'90989980','3333','3333',3333,2),('12349997',5,500,'90989900','Rogo','5',10000,2);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numBastidor` varchar(20) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `color` varchar(10) NOT NULL,
  `numAsientos` int NOT NULL,
  `numSerie` int NOT NULL,
  `precio` double NOT NULL,
  `fecha` date NOT NULL,
  `tipocambio` varchar(20) NOT NULL,
  `tipovehículo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (1,'12349995','90989989','Rogo',5,1,10000,'2022-04-07','Compra','Coche'),(2,'12349996','90989980','Rogo',5,2,10000,'2022-04-07','Compra','Coche'),(3,'12349997','90989900','Rogo',5,2,10000,'2022-04-07','Compra','Coche'),(4,'1111111','6789423','Rojo',5,3,10000,'2022-04-07','Compra','Camión'),(5,'12346655','90989989','Rogo',5,4,10000,'2022-04-07','Compra','Camión'),(6,'12349995','90989989','Rogo',5,1,10000,'2022-04-07','Vender','Coche'),(7,'123','123','123',123,5,123,'2022-04-07','Compra','Coche'),(8,'123','123','123',123,5,123,'2022-04-07','Vender','Coche'),(9,'12349996','90989980','3333',3333,2,3333,'2022-04-07','Modificacion','Coche');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie` (
  `numSerie` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(20) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `añoFabricacion` int NOT NULL,
  PRIMARY KEY (`numSerie`),
  UNIQUE KEY `Dos` (`modelo`,`marca`,`añoFabricacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` VALUES (5,'123','123',123),(4,'CamionPegaso','Pegaso',1993),(3,'CamionScania','Scania',1968),(1,'Impreza','Ferrari',2003),(2,'Puigdemont','Fiat',2005);
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 12:34:18
