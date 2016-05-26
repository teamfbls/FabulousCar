-- MySQL dump 10.13  Distrib 5.6.19, for Win64 (x86_64)
--
-- Host: localhost    Database: autover
-- ------------------------------------------------------
-- Server version	5.6.19-log

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
-- Table structure for table `auto`
--
create database autover;
use autover;

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Verkaufspreis` int(11) DEFAULT NULL,
  `HerstellerModellid` int(11) DEFAULT NULL,
  `Baujahrid` int(11) DEFAULT NULL,
  `Farbeid` int(11) DEFAULT NULL,
  `Tuerenid` int(11) DEFAULT NULL,
  `Leistungid` int(11) DEFAULT NULL,
  `Kilometerzahl` int(11) DEFAULT NULL,
  `Kraftstoffid` int(11) DEFAULT NULL,
  `Zustandid` int(11) DEFAULT NULL,
  `Beschreibung` varchar(255) DEFAULT NULL,
  `Erstellungsdatum` datetime DEFAULT NULL,
  `pic_path` varchar(2083) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fg_auto_modell` (`HerstellerModellid`),
  KEY `fg_auto_baujahr` (`Baujahrid`),
  KEY `fg_auto_farbe` (`Farbeid`),
  KEY `fg_auto_tueren` (`Tuerenid`),
  KEY `fg_auto_leistung` (`Leistungid`),
  KEY `fg_auto_karftstoff` (`Kraftstoffid`),
  KEY `fg_auto_zustand` (`Zustandid`),
  CONSTRAINT `fg_auto_baujahr` FOREIGN KEY (`Baujahrid`) REFERENCES `baujahr` (`Baujahrid`),
  CONSTRAINT `fg_auto_farbe` FOREIGN KEY (`Farbeid`) REFERENCES `farbe` (`Farbeid`),
  CONSTRAINT `fg_auto_karftstoff` FOREIGN KEY (`Kraftstoffid`) REFERENCES `kraftstoff` (`Kraftstoffid`),
  CONSTRAINT `fg_auto_leistung` FOREIGN KEY (`Leistungid`) REFERENCES `leistung` (`Leistungid`),
  CONSTRAINT `fg_auto_modell` FOREIGN KEY (`HerstellerModellid`) REFERENCES `modell` (`HerstellerModellid`),
  CONSTRAINT `fg_auto_tueren` FOREIGN KEY (`Tuerenid`) REFERENCES `tueren` (`Tuerenid`),
  CONSTRAINT `fg_auto_zustand` FOREIGN KEY (`Zustandid`) REFERENCES `zustand` (`Zustandid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,154754,1,12,1,1,11,55000,2,2,'FFFFF','2015-11-10 19:45:24',NULL),(2,50004,7,8,1,1,5,45454,1,2,'','2015-12-02 21:36:29',NULL),(5,4541,22,22,1,1,11,5464,1,1,'','2016-04-23 15:30:33','null'),(6,343453,22,22,1,1,11,34535,1,1,'','2016-04-23 15:38:17','null'),(7,453155,22,22,1,1,11,543122,1,1,'','2016-04-24 14:19:16',''),(8,45312,22,22,1,1,11,876451,1,1,'','2016-04-24 14:20:34',''),(9,45312,22,22,1,1,11,421254,1,1,'','2016-04-24 14:25:48','C:\\Users\\Thaskioglu\\Documents\\NetBeansProjects\\mavenproject1\\mavenproject1\\src\\main\\webapp\\upload_images\\Dijkstra.jpg');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baujahr`
--

DROP TABLE IF EXISTS `baujahr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baujahr` (
  `Baujahrid` int(11) NOT NULL AUTO_INCREMENT,
  `Baujahr` int(11) DEFAULT NULL,
  PRIMARY KEY (`Baujahrid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baujahr`
--

LOCK TABLES `baujahr` WRITE;
/*!40000 ALTER TABLE `baujahr` DISABLE KEYS */;
INSERT INTO `baujahr` VALUES (1,1990),(2,1991),(3,1992),(4,1993),(5,1994),(6,1995),(7,1996),(8,1997),(9,1998),(10,1999),(11,2000),(12,2001),(13,2002),(14,2003),(15,2004),(16,2005),(17,2006),(18,2007),(19,2008),(20,2009),(21,2010),(22,2011),(23,2012),(24,2013),(25,2014),(26,2015);
/*!40000 ALTER TABLE `baujahr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farbe`
--

DROP TABLE IF EXISTS `farbe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farbe` (
  `Farbeid` int(11) NOT NULL AUTO_INCREMENT,
  `Farbe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Farbeid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farbe`
--

LOCK TABLES `farbe` WRITE;
/*!40000 ALTER TABLE `farbe` DISABLE KEYS */;
INSERT INTO `farbe` VALUES (1,'Schwarz'),(2,'Rot'),(3,'Blau'),(4,'Gelb'),(5,'Weiß'),(6,'Grün'),(7,'Grau'),(8,'Silber');
/*!40000 ALTER TABLE `farbe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hersteller`
--

DROP TABLE IF EXISTS `hersteller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hersteller` (
  `Herstellerid` int(11) NOT NULL AUTO_INCREMENT,
  `Hersteller_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Herstellerid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hersteller`
--

LOCK TABLES `hersteller` WRITE;
/*!40000 ALTER TABLE `hersteller` DISABLE KEYS */;
INSERT INTO `hersteller` VALUES (1,'BMW'),(2,'Audi'),(3,'Fiat'),(4,'Ford'),(5,'Honda'),(6,'Mercedes'),(7,'Opel'),(8,'VW'),(9,'Crysler'),(10,'Porsche'),(11,'Skoda'),(12,'Volvo');
/*!40000 ALTER TABLE `hersteller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kraftstoff`
--

DROP TABLE IF EXISTS `kraftstoff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kraftstoff` (
  `Kraftstoffid` int(11) NOT NULL AUTO_INCREMENT,
  `Kraftstofftyp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Kraftstoffid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kraftstoff`
--

LOCK TABLES `kraftstoff` WRITE;
/*!40000 ALTER TABLE `kraftstoff` DISABLE KEYS */;
INSERT INTO `kraftstoff` VALUES (1,'Diesel'),(2,'Benzin'),(3,'Autogas'),(4,'Hybrid');
/*!40000 ALTER TABLE `kraftstoff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leistung`
--

DROP TABLE IF EXISTS `leistung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leistung` (
  `Leistungid` int(11) NOT NULL AUTO_INCREMENT,
  `Leistung_in_ps` int(11) DEFAULT NULL,
  PRIMARY KEY (`Leistungid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leistung`
--

LOCK TABLES `leistung` WRITE;
/*!40000 ALTER TABLE `leistung` DISABLE KEYS */;
INSERT INTO `leistung` VALUES (1,34),(2,50),(3,60),(4,75),(5,90),(6,101),(7,118),(8,131),(9,150),(10,200),(11,252),(12,303);
/*!40000 ALTER TABLE `leistung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modell`
--

DROP TABLE IF EXISTS `modell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modell` (
  `HerstellerModellid` int(11) NOT NULL AUTO_INCREMENT,
  `Herstellerid` int(11) DEFAULT NULL,
  `Modell` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`HerstellerModellid`),
  KEY `fg_modell_hersteller` (`Herstellerid`),
  CONSTRAINT `fg_modell_hersteller` FOREIGN KEY (`Herstellerid`) REFERENCES `hersteller` (`Herstellerid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modell`
--

LOCK TABLES `modell` WRITE;
/*!40000 ALTER TABLE `modell` DISABLE KEYS */;
INSERT INTO `modell` VALUES (1,1,'116'),(2,1,'118'),(3,1,'120'),(4,1,'123'),(5,1,'125'),(6,1,'315'),(7,1,'316'),(8,1,'318'),(9,1,'320'),(10,1,'323'),(11,1,'518'),(12,1,'520'),(13,1,'523'),(14,1,'528'),(15,1,'530'),(16,2,'A1'),(17,2,'A2'),(18,2,'A3'),(19,2,'A4'),(20,2,'A5'),(21,2,'A6'),(22,2,'A7'),(23,2,'A8'),(24,3,'500'),(25,3,'Panda'),(26,3,'Punto'),(27,4,'B-Max'),(28,4,'C-Max'),(29,4,'Focus'),(30,4,'Cougar'),(31,5,'Integra'),(32,5,'Element'),(33,5,'Element');
/*!40000 ALTER TABLE `modell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tueren`
--

DROP TABLE IF EXISTS `tueren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tueren` (
  `Tuerenid` int(11) NOT NULL AUTO_INCREMENT,
  `Tuerenanzahl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Tuerenid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tueren`
--

LOCK TABLES `tueren` WRITE;
/*!40000 ALTER TABLE `tueren` DISABLE KEYS */;
INSERT INTO `tueren` VALUES (1,'2/3'),(2,'4/5'),(3,'6/7');
/*!40000 ALTER TABLE `tueren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zustand`
--

DROP TABLE IF EXISTS `zustand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zustand` (
  `Zustandid` int(11) NOT NULL AUTO_INCREMENT,
  `Zustand` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Zustandid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zustand`
--

LOCK TABLES `zustand` WRITE;
/*!40000 ALTER TABLE `zustand` DISABLE KEYS */;
INSERT INTO `zustand` VALUES (1,'Neuwagen'),(2,'Gebraucht'),(3,'Tageszulassung');
/*!40000 ALTER TABLE `zustand` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-26 21:23:44
