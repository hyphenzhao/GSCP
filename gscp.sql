-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: gscp
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agentId` int(11) NOT NULL,
  `content` text,
  `degreeId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `title` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `uniId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES (1,'Create the software and games of tomorrow. Through the Bachelor of Engineering Honours (Software) you will learn first hand how to design and develop computer games, business applications, operating systems and network control systems. Combining technical knowledge with industry experience, you will be ready to transform the digital world.','Bachelor of Engineering Honours (Software)',1),(2,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in software engineering, covering all aspects of software production from strategy and design to coding, quality and management.','Master of Engineering (Software)',1),(3,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in civil engineering, and learn about designing and building systems.','Master of Engineering (Civil Engineering)',1),(4,'Create the software and games of tomorrow. Through the Bachelor of Engineering Honours (Software) you will learn first hand how to design and develop computer games, business applications, operating systems and network control systems. Combining technical knowledge with industry experience, you will be ready to transform the digital world.','Bachelor of Engineering Honours (Software)',2),(5,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in software engineering, covering all aspects of software production from strategy and design to coding, quality and management.','Master of Engineering (Software)',2),(6,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in civil engineering, and learn about designing and building systems.','Master of Engineering (Civil Engineering)',2),(7,'Create the software and games of tomorrow. Through the Bachelor of Engineering Honours (Software) you will learn first hand how to design and develop computer games, business applications, operating systems and network control systems. Combining technical knowledge with industry experience, you will be ready to transform the digital world.','Bachelor of Engineering Honours (Software)',3),(8,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in software engineering, covering all aspects of software production from strategy and design to coding, quality and management.','Master of Engineering (Software)',3),(9,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in civil engineering, and learn about designing and building systems.','Master of Engineering (Civil Engineering)',3),(10,'Create the software and games of tomorrow. Through the Bachelor of Engineering Honours (Software) you will learn first hand how to design and develop computer games, business applications, operating systems and network control systems. Combining technical knowledge with industry experience, you will be ready to transform the digital world.','Bachelor of Engineering Honours (Software)',4),(11,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in software engineering, covering all aspects of software production from strategy and design to coding, quality and management.','Master of Engineering (Software)',4),(12,'If you are a qualified engineer seeking to move into a management role or to specialise or update your skills, the Master of Engineering will build on your engineering undergraduate degree. You’ll develop specialised technical knowledge in civil engineering, and learn about designing and building systems.','Master of Engineering (Civil Engineering)',4);
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `first` varchar(50) DEFAULT NULL,
  `last` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `university` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--

LOCK TABLES `university` WRITE;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
INSERT INTO `university` VALUES (1,'The University of Sydney (informally, USyd or USYD) is an Australian public research university in Sydney, Australia. Founded in 1850, it is Australia\'s first university and is regarded as one of the world\'s leading universities.','usyd.jpeg','University of Sydney','https://sydney.edu.au/'),(2,'The University of Oxford (informally Oxford University or simply Oxford) is a collegiate research university located in Oxford, England. It has no known date of foundation, but there is evidence of teaching as far back...','oxford.jpeg','University of Oxford','http://www.ox.ac.uk/'),(3,'The University of Melbourne is a public research university located in Melbourne, Australia. Founded in 1853, it is Australia\'s second oldest university and the oldest in Victoria.','umel.png','University of Melbourne','http://www.unimelb.edu.au/'),(4,'The University of New South Wales is an Australian public research university located in the Sydney suburb of Kensington.','unsw.jpg','University of New South Wales','https://www.unsw.edu.au/');
/*!40000 ALTER TABLE `university` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hiphon@123.com','Haifeng','Zhao','E10ADC3949BA59ABBE56E057F20F883E','+61414900316',32,'Hiphon',NULL);
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

-- Dump completed on 2017-10-08 15:50:55
