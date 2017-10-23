-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: GSCP
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
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (16,2,'This is content',10,1,'This is title',1),(17,2,'Thank you',4,1,'Thanks',1),(18,2,'i want to apply',8,1,' hello',1),(19,2,'hhhhhhh',8,3,'let\'s go',0),(20,2,'LOL',2,3,'USYD YEAH!!!!!',0),(21,5,'HELP',11,3,'I am a graduate',0);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` text,
  `edition` int(11) DEFAULT NULL,
  `owner` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `title` text,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Ramakrishnan Ragh',3,3,40,'Post','computer','Database Management System',2003),(2,'Hayek Friedrich',4,3,15,'Post','Business','Business and Society',1982),(3,'Kamien Poger',3,4,40,'Post','Music','Music : an appreciation',2001),(4,'Anderson H',2,4,30,'Host','Math','An introduction to Linear algorithm',1996),(5,'Google',1,3,100,'Post','Spring','How to build a website?',2017),(6,'Youtube',2,4,100,'Post','Spring','MVC website design',2017),(7,'jeremy',1,6,100,'Host','computer','How to build a website ',2017),(8,'programmer',1,4,20,'Post','Spring','how to search the books?',2000),(9,'jeremy',1,4,20,'Post','Hibernate','how to update the database?',2017),(10,'jeremy',1,3,40,'Post','ELEC5619','Demo',2017),(11,'group GSCP',1,6,50,'Post','computer','elec5619demo',2017);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
  `applicationId` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (11,14,'Screen Shot 2017-10-10 at 1.01.51 pm.png','6OI31L1QYP3EW6FLAL.png'),(12,15,'Screen Shot 2017-10-10 at 1.17.11 pm.png','S6ITY5G3XQVO9YSZY9.png'),(13,16,'Screen Shot 2017-10-10 at 1.17.11 pm.png','0PB0BKN5VCNTISYHUX.png'),(14,17,'Screen Shot 2017-09-30 at 2.30.18 am.png','SZVDBN06XXLEF03HAW.png'),(15,18,'art 5622.docx','FKU0GQ90DYUVLHM3M8.docx'),(16,19,'','FMDHKBBS3FNXK8X0GK.'),(17,20,'','7I7ZKMTFA70WMET52M.'),(18,21,'','OCGX8JSSGJBS2FWIDI.');
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
-- Table structure for table `forumcomment`
--

DROP TABLE IF EXISTS `forumcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forumcomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `contentId` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `title` text,
  `userId` int(11) NOT NULL,
  `visability` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forumcomment`
--

LOCK TABLES `forumcomment` WRITE;
/*!40000 ALTER TABLE `forumcomment` DISABLE KEYS */;
INSERT INTO `forumcomment` VALUES (1,'Hello this is a comment example',2,'2017-10-12','Hello',1,''),(2,'Hello this is another comment example',2,'2017-10-12','Hello again',1,''),(3,'Delete TEST',3,'2017-10-12','Delete TEST',2,''),(4,'HH',2,'2017-10-12','Yo',2,'\0'),(5,'HAHhaha',2,'2017-10-12','YOOYOY',2,'\0'),(6,'lkjlk',5,'2017-10-12','hjkhkj',2,'\0'),(7,'kjljkl',3,'2017-10-13','jhkjhk',2,'\0'),(8,';lkl;',3,'2017-10-13','lk;lk',2,''),(9,'hhhhhhhhh',6,'2017-10-15','How does My comments works?',3,'\0'),(10,'hhhhhhhh',6,'2017-10-17','Second comment',3,'\0'),(11,'hhhhhhhh',8,'2017-10-18','testing update',3,''),(12,'I HOPE',8,'2017-10-18','Does it work?',3,'\0'),(13,'I HOPE',8,'2017-10-18','Does it work?',3,'');
/*!40000 ALTER TABLE `forumcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forumcontent`
--

DROP TABLE IF EXISTS `forumcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forumcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `date` date DEFAULT NULL,
  `title` text,
  `userId` int(11) NOT NULL,
  `visability` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forumcontent`
--

LOCK TABLES `forumcontent` WRITE;
/*!40000 ALTER TABLE `forumcontent` DISABLE KEYS */;
INSERT INTO `forumcontent` VALUES (2,'Hello this is a topic example','2017-10-12','Hello',1,''),(3,'Delete TEST','2017-10-12','Delete TEST',2,''),(4,'Hyphen zhao content','2017-10-12','Hyphen Zhao',2,''),(5,'kjkljkljl','2017-10-12','jlkjlk',2,'\0'),(6,'jlkjlkjnlknlkn','2017-10-13','ljkljklj',2,''),(7,'any issues about trading second-books','2017-10-14','trading',1,''),(8,'testing my comments','2017-10-15','First Topic',3,'');
/*!40000 ALTER TABLE `forumcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bedroom` int(11) DEFAULT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `postcode` int(11) DEFAULT NULL,
  `pricePw` int(11) DEFAULT NULL,
  `suburb` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES (1,1,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','1.jpg',2042,240,'newtown','house'),(2,1,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','2.jpg',2007,260,'ultimal','house'),(3,1,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','3.jpeg',2050,350,'comperdown','house'),(4,2,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','4.jpg',2050,475,'comperdown','apartment'),(5,3,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','5.jpeg',2008,255,'darlington','unit'),(6,2,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','6.jpg',2042,303,'newtown','unit'),(7,1,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','7.jpg',2042,311,'newtown','apartment'),(8,2,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','8.jpg',2037,450,'glebe','apartment'),(9,5,'Available : 10th November\nLease Period:From Minimum 6 months\n\nThis apartment features:\n- Quality Three Bedroom Apartment with security parking\n- Bedroom with Built Ins\n- Internal Laundry with Dryer\n- Island benches in most kitchens\n\nFeatures\nIntercom\nAir Conditioning\nBuilt-In Wardrobes\nClose to Schools\nClose to Transport\nSecurity Access\nHow to apply:\ncontact with Mr.Pan. email:aaa@aaa.com\n','9.png',2037,670,'glebe','house');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `item` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `seller` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (13,3,'2017-10-23',2,'Completed',4),(14,6,'2017-10-23',7,'Completed',3);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hiphon@123.com','Haifeng','Zhao','E10ADC3949BA59ABBE56E057F20F883E','+61414900316',32,'Hiphon',NULL),(2,'hzha7521@uni.sydney.edu.au','Hyphen','Zhao','E10ADC3949BA59ABBE56E057F20F883E','+61412345678',16,'Hyphen',NULL),(3,'jili4373@uni.sydney.edu.au','jeremy','li','F30AA7A662C728B7407C54AE6BFD27D1','123456',32,'jeremy',NULL),(4,'test@gmail.com','test','hhh','F30AA7A662C728B7407C54AE6BFD27D1','123456',0,'test',NULL),(5,'agent@gmail.com','agent','agent','F30AA7A662C728B7407C54AE6BFD27D1','123456',16,'agent',NULL),(6,'demo@uni.sydney.edu.au','jinhe','li','F30AA7A662C728B7407C54AE6BFD27D1','123456',0,'demo',NULL);
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

-- Dump completed on 2017-10-23 20:50:12
