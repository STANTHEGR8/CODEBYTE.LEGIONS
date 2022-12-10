-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: login
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_info` (
  `FullName` varchar(64) NOT NULL,
  `UID` int NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Mobile` int NOT NULL,
  `BloodGroup` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`FullName`),
  UNIQUE KEY `UID_UNIQUE` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES ('AHMED HASHIM ELMI',22104045,'ahmethashem1551@gmail.com',1871236242,'O+'),('AHNAF TAIYEB',22104032,'ahnaftaiyeb1@gmail.com',1884373051,'A+'),('ANIKA SANJANA KHAN',22104027,'moushiprincess@gmail.com',1631575196,'B+'),('ASHRAFUL ALAM DEWAN ',22104031,'ashrafuldewan111@gmail.com',1915632567,'B+'),('ASIF BIN SAMAD TAHSAN',22104013,'asifshahriar55@gmail.com',1753871789,'B+'),('FATMA KABIR LUVNA',21304038,'lubna.kbr@gmail.com',1796133868,'B+'),('FAYAAZ HASSAN',22104044,'fayaaz.hassan316@gmail.com',1707539040,'O+'),('ISRAFUL ISLAM SIUM',22104012,'rsisraful@gmail.com',1742671655,'O+'),('KAZI ABU EHSAN ',22104046,'ehsan005006@gmail.com',1852883387,'B+'),('KHALID SAIFULLAH',22104048,'khalideofficial@gmail.com',1787463481,'A+'),('MD AL AMIN',22104009,'biswasalamin001@gmail.com',1793628461,'A+'),('MD NADIM MEHMUD SIJAN',22104055,'sijankhan6@gmail.com',1864183313,'O+'),('MD SIFAT ISLAM',22104043,'ak00018855@gmail.com',1885513438,'O-'),('MD ZAHID ALAM',20104019,'alamzahid322@gmail.com',1792829878,'O+'),('MD. SHAMSUDDOHA TUSHAR',22104018,'shamsuddoha500@gmail.com',1792407345,'A+'),('Mohammed Ahsan Meah',22104020,'hasanrahat977@gmail.com',1625935620,'AB+'),('NAVID BIN WASIM ',21304039,'navidwasim143@gmail.com',1407727334,'A+'),('NAZMUS SAQIB',22104021,'nazmussaqibofficial@gmail.com',1989668207,'O+'),('RAFIN HOSSAIN',22104001,'savageboomer141@gmail.com',1731805780,'A+'),('RAIYAN RASHIK',22104037,'rashik225@gmail.com',1988200181,'B+'),('SADAT ASIF AHMED',22104002,'scorpio1234561@gmail.com',1832244716,'O+'),('SADIA ISLAM SHAYNA',22104005,'sadia_islam1998@yahoo.com',1873049134,'B+'),('SADIK REHAN',22104053,'sadikrehan17@gmail.com',1950029876,'B+'),('SAMEEHA IFTEKHAR ',22104003,'sameehaiftekhar29@gmail.com',1730084435,'B+'),('SAMIRA AKTER',22104024,'samiraakterbarsha@gmail.com',1615332272,'B+'),('SAZID KHAN',22104016,'khansazid902@gmail.com',1979020798,'AB+'),('SHAFQAT SHAHRIAR AREFIN',22104033,'shafqatarefin@gmail.com',1914724925,'B+'),('SHAHARIAR ALIF ORONNO ',22104014,'beatheart116@gmail.com',1768365647,'A+'),('SHEIKH MOHAMMAD OBAIDUR RAHMAN MARUF',22104049,'smobaidurrahmanmaruf@gmail.com',1816599853,'O+'),('Stanly Swagato Halder',22104030,'stanlyhalder@gmail.com',1639702307,'O-'),('SYEDA FABLIHA ZAMAN ',22104023,'anushazaman19@gmail.com',1612335838,'AB+');
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-10 22:53:43
