-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: gestiontribunal
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `affaire`
--

DROP TABLE IF EXISTS `affaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affaire` (
  `numaf` varchar(50) NOT NULL,
  `datedebut` date DEFAULT NULL,
  `nature` varchar(100) DEFAULT NULL,
  `typeaf` varchar(50) DEFAULT NULL,
  `idmag` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numaf`),
  KEY `idmag` (`idmag`),
  CONSTRAINT `affaire_ibfk_1` FOREIGN KEY (`idmag`) REFERENCES `magistrat` (`idmag`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affaire`
--

LOCK TABLES `affaire` WRITE;
/*!40000 ALTER TABLE `affaire` DISABLE KEYS */;
INSERT INTO `affaire` VALUES ('A001','2026-07-01','Vol','Crime','M001'),('A002','2026-07-15','Litige commercial','Civil','M002'),('A003','2026-08-10','Meurtre','crime','M002'),('A004',NULL,'crime','civil','M003'),('AF05','2026-09-22','Meurtre ','Crime','M001');
/*!40000 ALTER TABLE `affaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magistrat`
--

DROP TABLE IF EXISTS `magistrat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magistrat` (
  `idmag` varchar(50) NOT NULL,
  `nommag` varchar(100) DEFAULT NULL,
  `prenommag` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idmag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magistrat`
--

LOCK TABLES `magistrat` WRITE;
/*!40000 ALTER TABLE `magistrat` DISABLE KEYS */;
INSERT INTO `magistrat` VALUES ('M001','Diallo','Moussa'),('M002','Traore','Aminata'),('M003','Bagayogo','Yacouba');
/*!40000 ALTER TABLE `magistrat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participer`
--

DROP TABLE IF EXISTS `participer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participer` (
  `idpartie` varchar(50) NOT NULL DEFAULT '',
  `numaf` varchar(50) NOT NULL DEFAULT '',
  `rolepartie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idpartie`,`numaf`),
  KEY `numaf` (`numaf`),
  CONSTRAINT `participer_ibfk_1` FOREIGN KEY (`idpartie`) REFERENCES `partie` (`idpartie`) ON DELETE CASCADE,
  CONSTRAINT `participer_ibfk_2` FOREIGN KEY (`numaf`) REFERENCES `affaire` (`numaf`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participer`
--

LOCK TABLES `participer` WRITE;
/*!40000 ALTER TABLE `participer` DISABLE KEYS */;
INSERT INTO `participer` VALUES ('P001','A001','Plaignant'),('P002','A002','Défendeur'),('P003','A002','Assisteur');
/*!40000 ALTER TABLE `participer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partie`
--

DROP TABLE IF EXISTS `partie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partie` (
  `idpartie` varchar(50) NOT NULL,
  `libpartie` varchar(100) DEFAULT NULL,
  `adrpartie` varchar(200) DEFAULT NULL,
  `telpartie` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpartie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partie`
--

LOCK TABLES `partie` WRITE;
/*!40000 ALTER TABLE `partie` DISABLE KEYS */;
INSERT INTO `partie` VALUES ('P001','Société Alpha','Rue 123 Bamako','70000001'),('P002','Individu Beta','Quartier Y Bamako','70000002'),('P003','LAh et Frere','Z Bamako','80000009');
/*!40000 ALTER TABLE `partie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` varchar(20) NOT NULL,
  `nomuser` varchar(50) NOT NULL,
  `prenomuser` varchar(50) NOT NULL,
  `motdepasse` varchar(100) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ID01','Coulibaly','Aboubacar','798828');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-02 16:47:14
