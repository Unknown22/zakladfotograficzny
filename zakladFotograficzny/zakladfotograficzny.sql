-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: zakladfotograficzny
-- ------------------------------------------------------
-- Server version	5.1.73-community

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
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_type` (
  `id_account_type` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_account` varchar(45) NOT NULL,
  PRIMARY KEY (`id_account_type`),
  UNIQUE KEY `id_account_type_UNIQUE` (`id_account_type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` VALUES (1,'admin');
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `city` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `street_number` varchar(45) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  KEY `id_user_idx` (`id_user`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id_department` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `postcode` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `street_number` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_department`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (0,'Siedziba Glowna','Krakow','31-001','Chmieleniec','2B/1','111222333','admin@zakladfotograficzny.pl');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_status` int(11) NOT NULL,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_edit_time` timestamp NULL DEFAULT NULL,
  `adding_information` varchar(100) DEFAULT NULL,
  `id_payment` int(11) NOT NULL,
  `id_shippment` int(11) NOT NULL,
  `id_department` int(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `id_payment_idx` (`id_payment`),
  KEY `id_shipment_idx` (`id_shippment`),
  KEY `id_status_idx` (`id_status`),
  KEY `id_department_idx` (`id_department`),
  CONSTRAINT `id_department` FOREIGN KEY (`id_department`) REFERENCES `department` (`id_department`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_payment` FOREIGN KEY (`id_payment`) REFERENCES `payment` (`id_payment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_shipment` FOREIGN KEY (`id_shippment`) REFERENCES `shipment` (`id_shipment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_status` FOREIGN KEY (`id_status`) REFERENCES `order_status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,'2016-04-02 09:55:34','2016-04-02 09:55:34','Dodatkowe informacje testowe...',1,1,0),(2,1,'2016-04-02 10:24:35','2016-04-02 10:24:35','Tescik...',1,1,0),(3,1,'2016-04-02 10:24:47','2016-04-02 10:24:47','Tescik2...',1,1,0),(4,1,'2016-04-02 10:26:44','2016-04-02 10:26:44','Tescik2...',1,1,0);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_status` varchar(45) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,'Stworzony');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id_payment` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_payment` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_payment`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'Przelew',5);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `id_photo` int(11) NOT NULL AUTO_INCREMENT,
  `id_order` int(11) NOT NULL,
  `file_name` varchar(45) NOT NULL,
  `id_service` int(11) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  `file_size` int(11) NOT NULL,
  PRIMARY KEY (`id_photo`),
  KEY `id_service_idx` (`id_service`),
  KEY `id_order_idx` (`id_order`),
  CONSTRAINT `id_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_service` FOREIGN KEY (`id_service`) REFERENCES `photo_service` (`id_service`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo_format`
--

DROP TABLE IF EXISTS `photo_format`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo_format` (
  `id_photo_format` int(11) NOT NULL AUTO_INCREMENT,
  `format` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_photo_format`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo_format`
--

LOCK TABLES `photo_format` WRITE;
/*!40000 ALTER TABLE `photo_format` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo_format` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo_service`
--

DROP TABLE IF EXISTS `photo_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo_service` (
  `id_service` int(11) NOT NULL AUTO_INCREMENT,
  `copies` int(11) NOT NULL,
  `id_photo_format` int(11) NOT NULL,
  `id_sealing` int(11) NOT NULL,
  `id_retouch` int(11) NOT NULL,
  PRIMARY KEY (`id_service`),
  KEY `id_photo_format_idx` (`id_photo_format`),
  KEY `id_sealing_idx` (`id_sealing`),
  KEY `id_retouch_idx` (`id_retouch`),
  CONSTRAINT `id_photo_format` FOREIGN KEY (`id_photo_format`) REFERENCES `photo_format` (`id_photo_format`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_retouch` FOREIGN KEY (`id_retouch`) REFERENCES `retouch` (`id_retouch`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_sealing` FOREIGN KEY (`id_sealing`) REFERENCES `sealing` (`id_sealing`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo_service`
--

LOCK TABLES `photo_service` WRITE;
/*!40000 ALTER TABLE `photo_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retouch`
--

DROP TABLE IF EXISTS `retouch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retouch` (
  `id_retouch` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_retouch` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_retouch`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retouch`
--

LOCK TABLES `retouch` WRITE;
/*!40000 ALTER TABLE `retouch` DISABLE KEYS */;
/*!40000 ALTER TABLE `retouch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sealing`
--

DROP TABLE IF EXISTS `sealing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sealing` (
  `id_sealing` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_sealing` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_sealing`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sealing`
--

LOCK TABLES `sealing` WRITE;
/*!40000 ALTER TABLE `sealing` DISABLE KEYS */;
/*!40000 ALTER TABLE `sealing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment` (
  `id_shipment` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_shipment` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_shipment`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,'Kurier',14);
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id_account_type` int(11) DEFAULT NULL,
  `id_department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  KEY `id_account_type_idx` (`id_account_type`),
  KEY `id_department_idx` (`id_department`),
  CONSTRAINT `id_account_type` FOREIGN KEY (`id_account_type`) REFERENCES `account_type` (`id_account_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_department2` FOREIGN KEY (`id_department`) REFERENCES `department` (`id_department`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'admin','admin','admin@zakladfotograficzny.pl','admin','admin',1,0);
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

-- Dump completed on 2016-04-02 15:01:19
