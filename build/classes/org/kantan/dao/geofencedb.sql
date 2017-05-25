-- MySQL dump 10.13  Distrib 5.6.35, for Win32 (AMD64)
--
-- Host: localhost    Database: geofencedb
-- ------------------------------------------------------
-- Server version	5.6.35-log

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
-- Table structure for table `child`
--

DROP TABLE IF EXISTS `child`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `child` (
  `childEmailID` varchar(26) NOT NULL DEFAULT '',
  `parentEmailID` varchar(26) DEFAULT NULL,
  `refCoordinates` varchar(35) DEFAULT NULL,
  `radius` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`childEmailID`),
  KEY `parentEmailID` (`parentEmailID`),
  CONSTRAINT `child_ibfk_1` FOREIGN KEY (`parentEmailID`) REFERENCES `parent` (`emailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child`
--

LOCK TABLES `child` WRITE;
/*!40000 ALTER TABLE `child` DISABLE KEYS */;
INSERT INTO `child` VALUES ('abc@gmail.com','neelakantachari@gmail.com','28.621365, 77.225052',100),('deepaksnandihal@gmail.com','neelakantachari@gmail.com','14.904153, 76.385632',50),('khushi@gmail.com','neelakanta.rvce@gmail.com','123456,432145',100),('neelakanta.rvce@gmail.com','deep.blueblip@gmail.com','12.973922, 77.595181',30),('sagarkh7@gmail.com','deep.blueblip@gmail.com','12.978422, 77.568441',60),('varsha@gmail.com','neelakanta.rvce@gmail.com','123456,432145',10);
/*!40000 ALTER TABLE `child` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationlog`
--

DROP TABLE IF EXISTS `locationlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locationlog` (
  `childEmailID` varchar(26) DEFAULT NULL,
  `coordinates` varchar(35) DEFAULT NULL,
  `loggedAt` varchar(50) DEFAULT NULL,
  KEY `childEmailID` (`childEmailID`),
  CONSTRAINT `locationlog_ibfk_1` FOREIGN KEY (`childEmailID`) REFERENCES `child` (`childEmailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationlog`
--

LOCK TABLES `locationlog` WRITE;
/*!40000 ALTER TABLE `locationlog` DISABLE KEYS */;
INSERT INTO `locationlog` VALUES ('deepaksnandihal@gmail.com','98765431233456789','2017-04-24 00:00:00'),('deepaksnandihal@gmail.com','98765431231212122','2017-04-24 00:00:00'),('deepaksnandihal@gmail.com','12.978422, 77.568441','17-05-17:09:56:218'),('deepaksnandihal@gmail.com','12.978422, 77.568441','17-05-17:09:59:456'),('sagarkh7@gmail.com','12.978422, 77.568441','17-05-17:12:43:706'),('deepaksnandihal@gmail.com','12.971246, 77.606167','17-05-17:13:16:175'),('deepaksnandihal@gmail.com','12.971246, 77.606167','17-05-17:13:25:608'),('sagarkh7@gmail.com','17.331455, 76.8361607','17-05-17:13:56:725'),('sagarkh7@gmail.com','17.331455, 76.8361607','17-05-17:14:09:925'),('abc@gmail.com','17.331455, 76.8361607','17-05-17:16:05:676'),('abc@gmail.com','17.331455, 76.8361607','18-05-17:10:06:894'),('sagarkh7@gmail.com','12.978422, 77.568441','18-05-17:10:21:584'),('sagarkh7@gmail.com','-34.062126, 150.859136','18-05-17:10:28:767'),('sagarkh7@gmail.com','-34.062126, 150.859136','18-05-17:10:38:751'),('sagarkh7@gmail.com','-34.062126, 150.859136','18-05-17:10:38:569'),('abc@gmail.com','17.331455, 76.8361607','18-05-17:10:39:511'),('abc@gmail.com','17.331455, 76.8361607','18-05-17:10:40:838'),('abc@gmail.com','17.331455, 76.8361607','18-05-17:10:41:675'),('abc@gmail.com','17.331455, 76.8361607','18-05-17:10:42:185'),('abc@gmail.com','17.331455, 76.8361607','18-05-17:10:42:381'),('sagarkh7@gmail.com','-34.062126, 150.859136','18-05-17:10:42:853'),('abc@gmail.com','-33.873061, 151.212072','18-05-17:10:51:534');
/*!40000 ALTER TABLE `locationlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent` (
  `emailID` varchar(26) NOT NULL DEFAULT '',
  `mobileNum` bigint(20) DEFAULT NULL,
  `passwd` varchar(16) DEFAULT NULL,
  `verified` bit(1) DEFAULT NULL,
  PRIMARY KEY (`emailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES ('deep.blueblip@gmail.com',999999999,'abcd',''),('gyan123@gmail.com',999999999,'abcd',''),('gyan@gmail.com',999999999,'abcd',''),('kantan',9686526562,'clerk',''),('kantan11',9686526562,'clerk',''),('kantan1134',9686526562,'clerk',''),('kantan2233',9686526562,'clerk',''),('neelakanta.rvce@gmail.com',9964667656,'rvce','\0'),('neelakantachari@gmail.com',9964667656,'neel','\0'),('vadithya1993@gmail.com',999999999,'abcd','');
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verifyuser`
--

DROP TABLE IF EXISTS `verifyuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verifyuser` (
  `emailID` varchar(26) NOT NULL DEFAULT '',
  `otp` int(11) DEFAULT NULL,
  `otpCreatedAt` datetime DEFAULT NULL,
  PRIMARY KEY (`emailID`),
  CONSTRAINT `verifyuser_ibfk_1` FOREIGN KEY (`emailID`) REFERENCES `parent` (`emailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verifyuser`
--

LOCK TABLES `verifyuser` WRITE;
/*!40000 ALTER TABLE `verifyuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `verifyuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-25  8:26:57
