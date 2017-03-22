-- MySQL dump 10.13  Distrib 5.5.28, for Win64 (x86)
--
-- Host: localhost    Database: Ecommerce
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `Email` varchar(50) DEFAULT NULL,
  `Item_Number` varchar(100) DEFAULT NULL,
  `Price` varchar(20) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `Time` varchar(20) DEFAULT NULL,
  `SrNo` int(6) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`SrNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companyaddress`
--

DROP TABLE IF EXISTS `companyaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companyaddress` (
  `Address` varchar(100) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Fax` varchar(20) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `FollowOn` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companyaddress`
--

LOCK TABLES `companyaddress` WRITE;
/*!40000 ALTER TABLE `companyaddress` DISABLE KEYS */;
INSERT INTO `companyaddress` VALUES ('500 Lorem Ipsum Dolor Sit,22-56-2-9 Sit Amet,Lorem,USA','(00) 222 666 444',' (000) 000 00 00 0','info@mycompany.com','Facebook,Twitter'),('500 Lorem Ipsum Dolor Sit,22-56-2-9 Sit Amet,Lorem,USA','(00) 222 666 444',' (000) 000 00 00 0','info@mycompany.com','Facebook,Twitter');
/*!40000 ALTER TABLE `companyaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactus`
--

DROP TABLE IF EXISTS `contactus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactus` (
  `Name` varchar(100) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Message` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactus`
--

LOCK TABLES `contactus` WRITE;
/*!40000 ALTER TABLE `contactus` DISABLE KEYS */;
INSERT INTO `contactus` VALUES ('rashika','rashika.eck@gmail.com','please keep up the good work'),('','',''),('','','');
/*!40000 ALTER TABLE `contactus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemdetails`
--

DROP TABLE IF EXISTS `itemdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemdetails` (
  `CodeNum` varchar(20) NOT NULL,
  `Image` varchar(100) DEFAULT NULL,
  `Details` varchar(1000) DEFAULT NULL,
  `Price` varchar(20) DEFAULT NULL,
  `Stock` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`CodeNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemdetails`
--

LOCK TABLES `itemdetails` WRITE;
/*!40000 ALTER TABLE `itemdetails` DISABLE KEYS */;
INSERT INTO `itemdetails` VALUES ('MOD101','MOD101','4.2\'Screen  snap-dragon processor 1GB RAM 4GB internal Memory','Rs 5000','5'),('MOD102','MOD102','4.2\' Screen, snap-dragon processor, 1.5GB RAM, 4GB internal Memory','Rs 7869','3'),('MOD103','MOD103','4.2\' Screen, snap-dragon processor, 1GB RAM, 2GB internal Memory','Rs 2999','4'),('MOD104','MOD104','4.2\' Screen, snap-dragon processor, 1.5 GB RAM, 4GB internal Memory','Rs 5789',' 3 '),('MOD105','MOD105','4.2\' Screen, snap-dragon processor, 2GB RAM, 2GB internal Memory','Rs 6879',' 4 '),('MOD106','MOD106','4.2\' Screen, snap-dragon processor, 1GB RAM, 4GB internal Memory','Rs 4579',' 3 ');
/*!40000 ALTER TABLE `itemdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `Email` varchar(100) NOT NULL,
  `Password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('neha69@gmail.com','neha'),('null','null'),('rashika.eck@gmail.com','rashika10$'),('vratikavishu1@gmail.com',''),('vratikavishu@gmail.com','');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signup` (
  `Name` varchar(100) DEFAULT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(10) DEFAULT NULL,
  `Contact` varchar(15) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('neha','neha69@gmail.com','neha','7737305612','delhi','shastri market'),('null','null','null','null','null','null'),('rashika','rashika.eck@gmail.com','rashika10$','7737305112','Kota','shrinathpuram'),('vratika','vratikavishu1@gmail.com','','7737394567','jaipur','nayapura'),('vratika','vratikavishu@gmail.com','','7737394567','jaipur','nayapura');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-17  8:55:05
