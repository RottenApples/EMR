-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adt`
--

DROP TABLE IF EXISTS `adt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adt` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ADT` varchar(9) DEFAULT NULL,
  `AddDateTime` timestamp NULL DEFAULT NULL,
  `TransDateTime` timestamp NULL DEFAULT NULL,
  `DisDateTime` timestamp NULL DEFAULT NULL,
  `Reason` text,
  `LocationID` int DEFAULT NULL,
  `PatientID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_adt` (`ID`,`ADT`,`AddDateTime`,`TransDateTime`,`DisDateTime`,`LocationID`,`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=945 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adt`
--

LOCK TABLES `adt` WRITE;
/*!40000 ALTER TABLE `adt` DISABLE KEYS */;
INSERT INTO `adt` VALUES (587,'Admit','2020-11-16 06:10:00',NULL,NULL,'',9,811),(588,'Admit','2020-11-16 06:10:00',NULL,NULL,'',12,812),(589,'Admit','2020-11-16 06:10:00',NULL,NULL,'',6,813),(590,'Admit','2020-11-16 06:10:01',NULL,NULL,'',16,814),(591,'Admit','2020-11-16 06:10:01',NULL,NULL,'',12,815),(592,'Admit','2020-11-16 06:10:01',NULL,NULL,'',10,816),(593,'Admit','2020-11-16 06:10:01',NULL,NULL,'',11,817),(594,'Admit','2020-11-16 06:10:01',NULL,NULL,'',6,818),(595,'Admit','2020-11-16 06:10:01',NULL,NULL,'',15,819),(596,'Admit','2020-11-16 06:10:01',NULL,NULL,'',5,820),(597,'Admit','2020-11-16 06:10:01',NULL,NULL,'',11,821),(598,'Admit','2020-11-16 06:10:01',NULL,NULL,'',10,822),(599,'Admit','2020-11-16 06:10:01',NULL,NULL,'',16,823),(600,'Admit','2020-11-16 06:10:01',NULL,NULL,'',17,824),(601,'Admit','2020-11-16 06:10:01',NULL,NULL,'',8,825),(602,'Admit','2020-11-16 06:10:01',NULL,NULL,'',2,826),(603,'Admit','2020-11-16 06:10:01',NULL,NULL,'',16,827),(604,'Admit','2020-11-16 06:10:01',NULL,NULL,'',9,828),(605,'Admit','2020-11-16 06:10:01',NULL,NULL,'',9,829),(606,'Admit','2020-11-16 06:10:01',NULL,NULL,'',15,830),(607,'Admit','2020-11-16 06:10:01',NULL,NULL,'',3,831),(608,'Admit','2020-11-16 06:10:01',NULL,NULL,'',15,832),(609,'Admit','2020-11-16 06:10:01',NULL,NULL,'',3,833),(610,'Admit','2020-11-16 06:10:01',NULL,NULL,'',7,834),(611,'Admit','2020-11-16 06:10:01',NULL,NULL,'',5,835),(612,'Admit','2020-11-16 06:10:01',NULL,NULL,'',7,836),(613,'Admit','2020-11-16 06:10:01',NULL,NULL,'',5,837),(614,'Admit','2020-11-16 06:10:01',NULL,NULL,'',10,838),(615,'Admit','2020-11-16 06:10:02',NULL,NULL,'',8,839),(616,'Admit','2020-11-16 06:10:02',NULL,NULL,'',2,840),(617,'Admit','2020-11-16 06:10:02',NULL,NULL,'',12,841),(618,'Admit','2020-11-16 06:10:02',NULL,NULL,'',4,842),(619,'Admit','2020-11-16 06:10:02',NULL,NULL,'',12,843),(620,'Admit','2020-11-16 06:10:02',NULL,NULL,'',13,844),(621,'Admit','2020-11-16 06:10:02',NULL,NULL,'',1,845),(622,'Admit','2020-11-16 06:10:02',NULL,NULL,'',17,846),(623,'Admit','2020-11-16 06:10:02',NULL,NULL,'',11,847),(624,'Admit','2020-11-16 06:10:02',NULL,NULL,'',13,848),(625,'Admit','2020-11-16 06:10:02',NULL,NULL,'',13,849),(626,'Admit','2020-11-16 06:10:02',NULL,NULL,'',10,850),(627,'Admit','2020-11-16 06:10:02',NULL,NULL,'',13,851),(628,'Admit','2020-11-16 06:10:02',NULL,NULL,'',7,852),(629,'Admit','2020-11-16 06:10:02',NULL,NULL,'',2,853),(630,'Admit','2020-11-16 06:10:02',NULL,NULL,'',10,854),(631,'Admit','2020-11-16 06:10:02',NULL,NULL,'',6,855),(632,'Admit','2020-11-16 06:10:02',NULL,NULL,'',10,856),(633,'Admit','2020-11-16 06:10:02',NULL,NULL,'',14,857),(634,'Admit','2020-11-16 06:10:02',NULL,NULL,'',1,858),(635,'Admit','2020-11-16 06:10:02',NULL,NULL,'',13,859),(636,'Admit','2020-11-16 06:10:02',NULL,NULL,'',9,860),(637,'Admit','2020-11-16 06:10:02',NULL,NULL,'',2,861),(638,'Admit','2020-11-16 06:10:02',NULL,NULL,'',7,862),(639,'Admit','2020-11-16 06:10:02',NULL,NULL,'',16,863),(640,'Admit','2020-11-16 06:10:02',NULL,NULL,'',12,864),(641,'Admit','2020-11-16 06:10:02',NULL,NULL,'',5,865),(642,'Admit','2020-11-16 06:10:02',NULL,NULL,'',9,866),(643,'Admit','2020-11-16 06:10:02',NULL,NULL,'',16,867),(644,'Admit','2020-11-16 06:10:03',NULL,NULL,'',9,868),(645,'Admit','2020-11-16 06:10:03',NULL,NULL,'',17,869),(646,'Admit','2020-11-16 06:10:03',NULL,NULL,'',5,870),(647,'Admit','2020-11-16 06:10:03',NULL,NULL,'',5,871),(648,'Admit','2020-11-16 06:10:03',NULL,NULL,'',17,872),(649,'Admit','2020-11-16 06:10:03',NULL,NULL,'',6,873),(650,'Admit','2020-11-16 06:10:03',NULL,NULL,'',6,874),(651,'Admit','2020-11-16 06:10:03',NULL,NULL,'',3,875),(652,'Admit','2020-11-16 06:10:03',NULL,NULL,'',12,876),(653,'Admit','2020-11-16 06:10:03',NULL,NULL,'',3,877),(654,'Admit','2020-11-16 06:10:03',NULL,NULL,'',14,878),(655,'Admit','2020-11-16 06:10:03',NULL,NULL,'',14,879),(656,'Admit','2020-11-16 06:10:03',NULL,NULL,'',10,880),(657,'Admit','2020-11-16 06:10:03',NULL,NULL,'',8,881),(658,'Admit','2020-11-16 06:10:03',NULL,NULL,'',3,882),(659,'Admit','2020-11-16 06:10:03',NULL,NULL,'',6,883),(660,'Admit','2020-11-16 06:10:03',NULL,NULL,'',4,884),(661,'Admit','2020-11-16 06:10:03',NULL,NULL,'',10,885),(662,'Admit','2020-11-16 06:10:03',NULL,NULL,'',16,886),(663,'Admit','2020-11-16 06:10:03',NULL,NULL,'',6,887),(664,'Admit','2020-11-16 06:10:03',NULL,NULL,'',5,888),(665,'Admit','2020-11-16 06:10:03',NULL,NULL,'',3,889),(666,'Admit','2020-11-16 06:10:03',NULL,NULL,'',3,890),(667,'Admit','2020-11-16 06:10:03',NULL,NULL,'',15,891),(668,'Admit','2020-11-16 06:10:03',NULL,NULL,'',8,892),(669,'Admit','2020-11-16 06:10:03',NULL,NULL,'',10,893),(670,'Admit','2020-11-16 06:10:03',NULL,NULL,'',15,894),(671,'Admit','2020-11-16 06:10:03',NULL,NULL,'',14,895),(672,'Admit','2020-11-16 06:10:03',NULL,NULL,'',3,896),(673,'Admit','2020-11-16 06:10:03',NULL,NULL,'',14,897),(674,'Admit','2020-11-16 06:10:04',NULL,NULL,'',5,898),(675,'Admit','2020-11-16 06:10:04',NULL,NULL,'',15,899),(676,'Admit','2020-11-16 06:10:04',NULL,NULL,'',7,900),(677,'Admit','2020-11-16 06:10:04',NULL,NULL,'',14,901),(678,'Admit','2020-11-16 06:10:04',NULL,NULL,'',5,902),(679,'Admit','2020-11-16 06:10:04',NULL,NULL,'',12,903),(680,'Admit','2020-11-16 06:10:04',NULL,NULL,'',2,904),(681,'Admit','2020-11-16 06:10:04',NULL,NULL,'',8,905),(682,'Admit','2020-11-16 06:10:04',NULL,NULL,'',5,906),(683,'Admit','2020-11-16 06:10:04',NULL,NULL,'',12,907),(684,'Admit','2020-11-16 06:10:04',NULL,NULL,'',1,908),(685,'Admit','2020-11-16 06:10:04',NULL,NULL,'',16,909),(686,'Admit','2020-11-16 06:10:04',NULL,NULL,'',14,910),(935,'Transfer',NULL,'2020-11-22 07:38:47',NULL,NULL,1,831),(936,'Transfer',NULL,'2020-11-26 10:29:36',NULL,NULL,17,831),(937,'Admit','2020-12-02 01:18:24',NULL,NULL,'',1,1111),(938,'Admit','2020-12-02 01:31:24',NULL,NULL,'',1,1112),(939,'Admit','2020-12-02 01:34:07',NULL,NULL,'',1,1113),(940,'Admit','2020-12-02 01:34:09',NULL,NULL,'',1,1114),(941,'Admit','2020-12-02 01:38:06',NULL,NULL,'',1,1115),(942,'Admit','2020-12-02 01:43:56',NULL,NULL,'',1,1116),(943,'Admit','2020-12-02 02:39:22',NULL,NULL,'',1,1117),(944,'Transfer',NULL,'2020-12-02 02:41:44',NULL,NULL,2,817);
/*!40000 ALTER TABLE `adt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `adtview`
--

DROP TABLE IF EXISTS `adtview`;
/*!50001 DROP VIEW IF EXISTS `adtview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `adtview` AS SELECT 
 1 AS `ID`,
 1 AS `ADT`,
 1 AS `AddDateTime`,
 1 AS `TransDateTime`,
 1 AS `DisDateTime`,
 1 AS `Reason`,
 1 AS `LocationID`,
 1 AS `PatientID`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `appID` int NOT NULL AUTO_INCREMENT,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `patientID` int DEFAULT NULL,
  `physicianID` int DEFAULT NULL,
  `Category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`appID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (41,'2020-11-26 13:00:00','2020-11-26 20:00:00',811,51,'Consult'),(44,'2020-11-29 13:00:00','2020-11-29 16:00:00',815,54,'Blood Test'),(49,'2020-12-01 15:00:00','2020-12-01 16:30:00',811,56,'Consult'),(55,'2020-12-04 13:00:00','2020-12-04 15:00:00',815,56,'Consult');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloodtest`
--

DROP TABLE IF EXISTS `bloodtest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bloodtest` (
  `TestID` int NOT NULL AUTO_INCREMENT,
  `WBC` double(3,1) DEFAULT NULL,
  `RBC` double(3,1) DEFAULT NULL,
  `HGB` double(3,1) DEFAULT NULL,
  `HCT` double(3,1) DEFAULT NULL,
  `PLATELET` int DEFAULT NULL,
  `Time` timestamp NULL DEFAULT NULL,
  `PatientID` int DEFAULT NULL,
  PRIMARY KEY (`TestID`),
  KEY `PatientID` (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloodtest`
--

LOCK TABLES `bloodtest` WRITE;
/*!40000 ALTER TABLE `bloodtest` DISABLE KEYS */;
INSERT INTO `bloodtest` VALUES (1,2.3,2.3,2.3,2.3,2,'2020-11-19 08:59:04',858),(2,2.5,2.5,2.5,2.5,2,'2020-11-19 09:00:07',858),(3,2.3,2.3,2.3,2.5,2,'2020-11-19 09:00:32',845),(4,4.0,13.2,4.3,40.0,140,'2020-12-02 02:27:59',817),(5,4.0,4.3,4.3,40.0,150,'2020-12-02 02:44:05',814);
/*!40000 ALTER TABLE `bloodtest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demographics`
--

DROP TABLE IF EXISTS `demographics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demographics` (
  `PatientID` int DEFAULT NULL,
  `OHIP` varchar(10) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Sex` varchar(6) DEFAULT NULL,
  `Height` varchar(4) DEFAULT NULL,
  `Weight` int DEFAULT NULL,
  `BloodType` char(3) DEFAULT NULL,
  `Contact` tinytext,
  KEY `idx_demographic` (`PatientID`,`OHIP`,`DOB`,`Sex`,`Height`,`Weight`,`BloodType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demographics`
--

LOCK TABLES `demographics` WRITE;
/*!40000 ALTER TABLE `demographics` DISABLE KEYS */;
INSERT INTO `demographics` VALUES (811,'4742573367','1985-07-01','Female','6',211,'A+','7 Grasett Crescent North Bay N1G1P1'),(812,'6265660111','1975-11-27','Male','7',105,'A-','4 Hopkins Road Quinte West E3G7W5'),(813,'5064864633','1956-01-20','Female','7',271,'A-','6 Geddes Crescent London  R8D7C7'),(814,'7698601777','1980-08-16','Male','5',117,'AB-','1 Longman Drive Thunder Bay S8Z8K4'),(815,'9765391012','1988-06-16','Female','7',265,'O+','3 Gallie Court Kenora K6X3Q8'),(816,'5480548857','1974-01-12','Male','6',118,'O+','1 Lake Crescent Stratford C4Q7Z7'),(817,'8241712202','1991-05-11','Female','5',275,'O-','8 Longman Drive Thunder Bay T8E0M8'),(818,'8952753706','1993-12-19','Male','5',200,'O+','8 McDonald Street Mary Street Waterloo S7F6O5'),(819,'7327711576','1961-06-27','Female','7',268,'A+','9 Irene Drive Sarnia K1W6Q2'),(820,'4480319548','1993-08-19','Male','6',146,'AB+','3 Danielle Crescent Clarence-Rockland M0L0I1'),(821,'4966043731','1993-11-03','Female','5',161,'O-','7 Hopkins Road Quinte West D2U4N2'),(822,'2700406339','1992-08-14','Male','5',122,'B+','6 Fox Run Kawartha Lakes J1N0B5'),(823,'3341233392','1957-07-04','Female','5',285,'B+','2 Barrett Crescent Brampton W7W0G7'),(824,'7753697799','1990-07-29','Male','6',188,'AB-','7 Merganser Court Windsor F4D3G8'),(825,'1492335184','1961-06-15','Female','5',153,'B+','4 High Street Port Colborne V3N7U4'),(826,'2388373496','1991-10-03','Male','5',155,'B+','9 Lake Crescent Stratford B0N2A0'),(827,'4751428664','1952-05-20','Female','5',195,'O-','1 Barre Drive Belleville M3M1B4'),(828,'4255896687','1994-02-11','Male','5',158,'A+','8 Edge Water Drive Haldimand County  N3X5B2'),(829,'7457524566','1967-10-07','Female','5',115,'O+','3 Golden Eagle Way Mississauga I0S5E2'),(830,'2027919007','1954-05-27','Male','6',100,'O+','2 Majesty Boulevard Toronto D3A7F4'),(831,'7549127316','1983-09-17','Female','6',161,'O-','5 Geddes Crescent London  I8Z3L4'),(832,'1467036968','1980-02-08','Male','6',287,'O+','3 Majesty Boulevard Toronto L3G8D8'),(833,'2257739240','1964-08-20','Female','7',264,'A+','1 Geddes Crescent London  S5D1Z7'),(834,'7360067968','1989-05-04','Male','6',173,'O-','4 Hanmer Street East Owen Sound G7T0M8'),(835,'2014714671','1974-03-21','Female','6',150,'O-','3 McDonald Street Mary Street Waterloo O7E0V4'),(836,'3365713577','1968-01-19','Male','7',281,'A+','7 McIntyre Drive Welland O4B7D2'),(837,'6291318586','1994-11-04','Female','7',273,'AB-','1 Bayshore Boulevard County of Brant W6X8E7'),(838,'4699265258','1988-04-13','Male','5',278,'A+','7 Dickens Drive Cornwall H5T7I7'),(839,'3753566175','1981-01-03','Female','5',130,'B+','4 McIntyre Drive Welland P6P4L0'),(840,'7051381957','1991-04-15','Male','7',124,'A-','3 Grasett Crescent North Bay H5V8Q1'),(841,'9306933438','1975-12-28','Female','5',181,'A-','8 Danielle Crescent Clarence-Rockland H4L1Z8'),(842,'3857508781','1983-02-28','Male','6',288,'O+','1 Hopkins Road Quinte West K3K4O7'),(843,'4199509139','1980-07-09','Female','5',183,'AB-','9 Edge Water Drive Haldimand County  A7N8V2'),(844,'4656465769','1981-09-01','Male','6',120,'O-','5 Gray Lane Orillia  P8E2Q6'),(845,'9854389269','1979-08-24','Female','6',270,'B+','1 Edge Water Drive Haldimand County  I0W7S8'),(846,'6723940177','1953-01-04','Male','5',116,'AB+','9 Edge Water Drive Haldimand County  B5I0G7'),(847,'8912512809','1969-11-14','Female','5',156,'AB+','2 Gallie Court Kenora S1V4Z8'),(848,'1877556878','1974-09-11','Male','5',246,'AB+','6 High Street Port Colborne T7C7A5'),(849,'1625743483','1992-07-07','Female','7',196,'AB+','5 Irene Drive Sarnia K1F0H4'),(850,'8528977508','1989-12-10','Male','6',178,'O+','8 Gray Lane Orillia  C4S4N7'),(851,'6177472500','1957-12-14','Female','5',259,'A-','3 Heather Street Peterborough S2K5O7'),(852,'3924818206','1950-10-16','Male','6',214,'O-','9 Geddes Crescent London  N6D2U6'),(853,'6295652309','1964-02-28','Female','7',160,'AB-','4 Doris Drive Dryden R1N0P1'),(854,'7557421923','1963-04-01','Male','5',195,'B+','1 Garden Drive Kingston Z0M4F1'),(855,'6122871601','1990-12-22','Female','7',243,'O+','1 Hanmer Street West Pembroke  C4E0E7'),(856,'7939660878','1969-05-01','Male','5',225,'O+','9 Janice Drive Sault Ste. Marie Q7E0T6'),(857,'1322405607','1962-03-16','Female','6',185,'AB-','5 Doris Drive Dryden E8Z3T5'),(858,'3091576832','1989-10-03','Male','5',230,'AB+','3 Adam Street Barrie L2W6V3'),(859,'5821260330','1993-11-25','Female','5',118,'A+','6 Hill Court Prince Edward County X2D2Z8'),(860,'7963007424','1984-03-07','Male','5',152,'A+','4 Hanmer Street West Pembroke  W7W3V0'),(861,'4054891816','1964-10-25','Female','7',265,'A-','2 Hopkins Road Quinte West S8R3B7'),(862,'1663268186','1991-06-13','Male','7',253,'A+','9 Edge Water Drive Guelph E8C3C8'),(863,'2607916549','1951-08-11','Female','7',147,'B+','9 Geddes Crescent London  D4N5T1'),(864,'8349919816','1958-08-09','Male','6',266,'A+','6 Garden Drive Kingston V0W5B8'),(865,'3405781658','1970-05-25','Female','5',151,'AB+','8 Majesty Boulevard Toronto H8V7W8'),(866,'2272751810','1950-08-18','Male','7',249,'A-','1 Grasett Crescent North Bay B8I0H7'),(867,'6159705593','1962-10-18','Female','6',203,'AB+','1 Edge Water Drive Haldimand County  J0D8N7'),(868,'9121104828','1976-05-20','Male','7',256,'A+','9 Mapleview Drive East Vaughan T8X4U3'),(869,'1297499399','1994-11-29','Female','6',102,'O+','8 Chalmers Drive Brockville X6W4Y8'),(870,'8092852906','1967-04-06','Male','6',152,'A-','6 Chalmers Drive Brockville K7G2V6'),(871,'1713080234','1989-12-30','Female','5',175,'B+','8 Hemlock Court Pickering P4E7O3'),(872,'7117777805','1984-05-26','Male','5',179,'AB-','7 Golden Eagle Way Mississauga P7N5J0'),(873,'5065099024','1980-08-12','Female','6',212,'O-','3 Hambly Court Ottawa F1G5H7'),(874,'9318278436','1990-04-08','Male','7',93,'AB-','6 Adam Street Barrie S3U0E1'),(875,'1168317487','1980-07-09','Female','6',240,'A+','6 Barrett Crescent Brampton C8I2B0'),(876,'6983601372','1991-09-30','Male','7',132,'AB+','8 Garrett Crescent Kitchener F2E2J7'),(877,'1008942417','1969-04-14','Female','5',274,'O-','2 Longman Drive Thunder Bay J0H8C3'),(878,'4242896038','1975-03-07','Male','7',144,'A-','4 Doris Drive Dryden L2T0B3'),(879,'1726511853','1963-02-08','Female','5',196,'A-','2 Longman Drive Thunder Bay S0C3F6'),(880,'8935885535','1961-12-06','Male','5',235,'A-','7 Adam Street Barrie J8I5T0'),(881,'9330123594','1952-02-10','Female','7',130,'O-','8 Dunsmore Lane Elliot Lake W6O1O1'),(882,'5351876657','1987-12-20','Male','7',136,'A-','4 Dunsmore Lane Elliot Lake N6V5Z0'),(883,'5136499643','1989-08-13','Female','7',215,'B+','2 Castle Drive Brantford P0L7E5'),(884,'8007964699','1968-12-19','Male','7',207,'A+','6 Dickens Drive Cornwall Y7T4O2'),(885,'1752866976','1952-07-27','Female','5',123,'B+','7 Mollard Court Woodstock S6N7F1'),(886,'1200947465','1975-05-13','Male','5',167,'A-','4 Ferndale Drive South Hamilton P5Q1M8'),(887,'1590809447','1961-12-18','Female','5',118,'AB+','4 Grasett Crescent North Bay C2K3P2'),(888,'3945643382','1972-07-07','Male','7',275,'A-','1 Gray Lane Orillia  G0V5B7'),(889,'6240669725','1960-03-11','Female','6',245,'AB+','7 McDonald Street Mary Street Waterloo F7V8F5'),(890,'4121602604','1980-10-12','Male','6',158,'B+','1 Bayshore Boulevard County of Brant I4U1D5'),(891,'7802896661','1952-10-11','Female','6',124,'O+','5 Cassandra Drive Cambridge E8A6O6'),(892,'8222830075','1966-10-06','Male','6',246,'AB-','9 Longman Drive Thunder Bay J5J6H1'),(893,'4346743367','1990-09-10','Female','6',187,'O+','1 Mollard Court Woodstock J2M3N2'),(894,'5338976852','1991-09-04','Male','7',259,'AB+','3 Grand Place Norfolk County M1V5E5'),(895,'4822331202','1956-03-04','Female','7',233,'O+','8 Fox Run Kawartha Lakes Z6G5E8'),(896,'8704952114','1953-09-04','Male','5',120,'O-','1 Golden Eagle Way Mississauga G1S3H0'),(897,'8904356418','1965-08-02','Female','5',171,'O+','6 Majesty Boulevard Toronto U4N3H4'),(898,'7918176576','1973-07-04','Male','5',153,'AB-','2 Gadwall Avenue Onta F8U2N8'),(899,'9700274590','1956-11-06','Female','7',229,'AB-','3 Hill Court Prince Edward County V5S2X8'),(900,'2333476391','1983-03-06','Male','7',276,'A+','5 Eccles Street North Greater Sudbury R3M2L4'),(901,'4958958260','1978-11-10','Female','7',231,'AB+','5 MacAllister Court Timmins T3D5P8'),(902,'9065229647','1953-09-27','Male','6',224,'A+','5 Hurst Drive Richmond Hill Y2F8Y3'),(903,'6204495972','1986-11-13','Female','5',249,'A+','1 Barre Drive Belleville Q4M6I2'),(904,'9830830069','1992-03-05','Male','7',127,'A+','5 Hambly Court Ottawa Y3R4Z7'),(905,'8071513878','1994-10-03','Female','5',270,'A+','6 Eccles Street North Greater Sudbury R3Q2A6'),(906,'8700403633','1956-04-10','Male','7',199,'B+','6 Lake Crescent Stratford I7L7T4'),(907,'6401340127','1977-08-09','Female','5',92,'O+','6 MacAllister Court Timmins F8M2Z5'),(908,'1832248752','1959-03-24','Male','5',157,'B+','7 High Street Port Colborne F2I8Q1'),(909,'1381261398','1987-03-30','Female','7',282,'A-','9 Adam Street Barrie W8Q7L1'),(910,'2894501509','1992-12-23','Male','5',120,'AB-','9 Cedar Crescent Burlington P0H7Q2'),(1111,'1234567892','1972-11-12','Male','5',180,'B+','3 Chester RD Capreol P0L1L4'),(1112,'1444444444','1998-11-12','Male','5',170,'A-','4 Durbin Northshore P8M1G3'),(1113,'1111111111','1999-12-11','Female','4',180,'A+','4 Orange St. Capreol P9M2J2'),(1114,'1111111111','1999-12-11','Female','4',180,'A+','4 Orange St. Capreol P9M2J2'),(1115,'2222222222','1998-05-05','Female','4',120,'AB-','2 Bell St ParrySound K2L3F3'),(1116,'7777777777','1962-11-19','Male','6',180,'A+','2 James Sudbury P1P2D2'),(1117,'2222222222','1980-11-12','Male','4',170,'A+','4 Aspen Sudbury P0M1H2');
/*!40000 ALTER TABLE `demographics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `demographicview`
--

DROP TABLE IF EXISTS `demographicview`;
/*!50001 DROP VIEW IF EXISTS `demographicview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `demographicview` AS SELECT 
 1 AS `PatientID`,
 1 AS `OHIP`,
 1 AS `DOB`,
 1 AS `Sex`,
 1 AS `Height`,
 1 AS `Weight`,
 1 AS `BloodType`,
 1 AS `Contact`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `LocationID` int NOT NULL,
  `LocationName` varchar(255) DEFAULT NULL,
  `UrgencyLevel` int DEFAULT NULL,
  `GuaranteedTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`LocationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'CCU',NULL,NULL),(2,'ER',NULL,NULL),(3,'ICU',NULL,NULL),(4,'MICU',NULL,NULL),(5,'NICU',NULL,NULL),(6,'Oncology',NULL,NULL),(7,'Open-Heart Recovery',NULL,NULL),(8,'OR',NULL,NULL),(9,'PACU',NULL,NULL),(10,'Hospice',NULL,NULL),(11,'PICU',NULL,NULL),(12,'Pre-Op',NULL,NULL),(13,'Rehabilitation',NULL,NULL),(14,'SICU',NULL,NULL),(15,'Step-Down Unit',NULL,NULL),(16,'The Floor',NULL,NULL),(17,'TICU',NULL,NULL);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationpatient`
--

DROP TABLE IF EXISTS `locationpatient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locationpatient` (
  `PatientID` int NOT NULL,
  `LocationID` int DEFAULT NULL,
  `Time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`PatientID`),
  KEY `idx_locationpatient` (`PatientID`,`LocationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationpatient`
--

LOCK TABLES `locationpatient` WRITE;
/*!40000 ALTER TABLE `locationpatient` DISABLE KEYS */;
INSERT INTO `locationpatient` VALUES (812,12,'2020-11-16 06:10:00'),(814,16,'2020-11-16 06:10:01'),(816,10,'2020-11-16 06:10:01'),(818,13,'2020-11-17 09:29:50'),(819,15,'2020-11-16 06:10:01'),(820,5,'2020-11-16 06:10:01'),(821,11,'2020-11-16 06:10:01'),(822,10,'2020-11-16 06:10:01'),(823,16,'2020-11-16 06:10:01'),(824,17,'2020-11-16 06:10:01'),(825,8,'2020-11-16 06:10:01'),(826,2,'2020-11-16 06:10:01'),(827,16,'2020-11-16 06:10:01'),(828,9,'2020-11-16 06:10:01'),(829,9,'2020-11-16 06:10:01'),(830,15,'2020-11-16 06:10:01'),(831,17,'2020-11-26 10:29:36'),(832,15,'2020-11-16 06:10:01'),(833,3,'2020-11-16 06:10:01'),(834,7,'2020-11-16 06:10:01'),(835,5,'2020-11-16 06:10:01'),(836,7,'2020-11-16 06:10:01'),(837,5,'2020-11-16 06:10:01'),(838,10,'2020-11-16 06:10:01'),(839,8,'2020-11-16 06:10:02'),(840,2,'2020-11-16 06:10:02'),(841,12,'2020-11-16 06:10:02'),(842,4,'2020-11-16 06:10:02'),(843,12,'2020-11-16 06:10:02'),(844,13,'2020-11-16 06:10:02'),(845,1,'2020-11-16 06:10:02'),(846,17,'2020-11-16 06:10:02'),(847,11,'2020-11-16 06:10:02'),(848,13,'2020-11-16 06:10:02'),(849,13,'2020-11-16 06:10:02'),(850,10,'2020-11-16 06:10:02'),(851,13,'2020-11-16 06:10:02'),(852,7,'2020-11-16 06:10:02'),(853,2,'2020-11-16 06:10:02'),(854,10,'2020-11-16 06:10:02'),(856,10,'2020-11-16 06:10:02'),(857,14,'2020-11-16 06:10:02'),(859,13,'2020-11-16 06:10:02'),(860,9,'2020-11-16 06:10:02'),(861,2,'2020-11-16 06:10:02'),(862,7,'2020-11-16 06:10:02'),(863,16,'2020-11-16 06:10:02'),(864,12,'2020-11-16 06:10:02'),(865,5,'2020-11-16 06:10:02'),(866,9,'2020-11-16 06:10:02'),(867,16,'2020-11-16 06:10:02'),(868,9,'2020-11-16 06:10:03'),(869,17,'2020-11-16 06:10:03'),(870,5,'2020-11-16 06:10:03'),(871,5,'2020-11-16 06:10:03'),(872,17,'2020-11-16 06:10:03'),(873,6,'2020-11-16 06:10:03'),(874,6,'2020-11-16 06:10:03'),(875,3,'2020-11-16 06:10:03'),(876,12,'2020-11-16 06:10:03'),(877,3,'2020-11-16 06:10:03'),(878,14,'2020-11-16 06:10:03'),(879,14,'2020-11-16 06:10:03'),(880,10,'2020-11-16 06:10:03'),(881,8,'2020-11-16 06:10:03'),(882,3,'2020-11-16 06:10:03'),(883,6,'2020-11-16 06:10:03'),(884,4,'2020-11-16 06:10:03'),(885,10,'2020-11-16 06:10:03'),(886,16,'2020-11-16 06:10:03'),(887,6,'2020-11-16 06:10:03'),(888,5,'2020-11-16 06:10:03'),(889,3,'2020-11-16 06:10:03'),(890,3,'2020-11-16 06:10:03'),(891,15,'2020-11-16 06:10:03'),(892,8,'2020-11-16 06:10:03'),(893,10,'2020-11-16 06:10:03'),(894,15,'2020-11-16 06:10:03'),(895,14,'2020-11-16 06:10:03'),(896,3,'2020-11-16 06:10:03'),(897,14,'2020-11-16 06:10:03'),(898,5,'2020-11-16 06:10:04'),(899,15,'2020-11-16 06:10:04'),(900,7,'2020-11-16 06:10:04'),(901,14,'2020-11-16 06:10:04'),(902,5,'2020-11-16 06:10:04'),(903,12,'2020-11-16 06:10:04'),(904,2,'2020-11-16 06:10:04'),(905,8,'2020-11-16 06:10:04'),(906,5,'2020-11-16 06:10:04'),(907,12,'2020-11-16 06:10:04'),(908,1,'2020-11-17 05:40:36'),(909,16,'2020-11-16 06:10:04'),(910,14,'2020-11-16 06:10:04');
/*!40000 ALTER TABLE `locationpatient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `locationpatientview`
--

DROP TABLE IF EXISTS `locationpatientview`;
/*!50001 DROP VIEW IF EXISTS `locationpatientview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `locationpatientview` AS SELECT 
 1 AS `patientID`,
 1 AS `locationID`,
 1 AS `time`,
 1 AS `treatment`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nurse` (
  `NurseID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `flag` int DEFAULT NULL,
  PRIMARY KEY (`NurseID`),
  KEY `idx_nurse` (`NurseID`,`FirstName`,`LastName`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` VALUES (1,'Antoinette','Clark',0),(2,'Kerry','Rosas',0),(3,'Jorden','Horne',1),(4,'Arbaaz','Jimenez',1),(5,'Autumn','Clayton',1),(6,'Rocky','Muir',1),(7,'Mica','Sharples',1),(8,'Jazmin','O\'Reilly',1),(9,'Maddy','Davenport',1),(10,'Shawn','Wyatt',1),(11,'Bianka','Blair',1),(12,'Nansi','Ball',1),(13,'Raj','Rooney',1),(14,'Sulayman','Knox',1),(15,'Asif','Curran',1),(16,'Antoni','Stafford',1),(17,'Rania','Thompson',1),(18,'Zaid','Knapp',1),(19,'Levison','Hayes',1),(20,'Latoya','Alford',1),(21,'Ashanti','Sheppard',1),(22,'Bella-Rose','Stanton',1),(23,'Maisy','Leigh',1),(24,'Moses','Hester',1),(25,'Katrina','Kaufman',1),(26,'Rafe','Moss',1),(27,'Kobe','Wooten',1),(28,'Sharon','Lennon',1),(29,'Martyna','Townsend',1),(30,'Matei','Paine',1),(31,'Elodie','Turnbull',1),(32,'Dylan','Hinton',1),(33,'Jez','Wiggins',1),(34,'Diesel','Patton',1),(35,'Luisa','Preston',1),(36,'Amar','Devlin',1),(37,'Saad','Kavanagh',1),(38,'Mahad','Mcgregor',1),(39,'Suhail','Moon',1),(40,'Sommer','Adams',1),(41,'Khia','Munro',1),(42,'Devante','Calvert',1),(43,'Marwa','Salt',1),(44,'June','Vickers',1),(45,'Amber-Rose','Finley',1),(46,'Fatima','Miles',1),(47,'Anisah','Blevins',1),(48,'Ameera','England',1),(49,'Lyra','Mayo',1),(50,'Hibah','Sharma',1);
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `nurseview`
--

DROP TABLE IF EXISTS `nurseview`;
/*!50001 DROP VIEW IF EXISTS `nurseview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `nurseview` AS SELECT 
 1 AS `NurseID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `flag`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `PatientID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Flag` int DEFAULT NULL,
  PRIMARY KEY (`PatientID`),
  KEY `idx_patient` (`PatientID`,`FirstName`,`LastName`)
) ENGINE=InnoDB AUTO_INCREMENT=1118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (811,'Maia','Newsome',1),(812,'Lupe','Speakman',1),(813,'Verlene','Magruder',1),(814,'Arthur','Benda',1),(815,'Rivka','Skillman',1),(816,'Truman','Metzgar',1),(817,'Lashaun','Hermes',1),(818,'Chauncey','Lindow',1),(819,'Jackeline','Brannigan',1),(820,'Agustin','Buttars',1),(821,'Sherley','Augustyn',1),(822,'Zachariah','Crumbley',1),(823,'Avelina','Deslauriers',1),(824,'Carroll','Mallette',1),(825,'Nery','Hilburn',1),(826,'John','Burritt',1),(827,'Rubie','Goldberg',1),(828,'Lacy','Gochenour',1),(829,'Delphia','Hardiman',1),(830,'Jesse','Athey',1),(831,'Holly','Herrada',1),(832,'Desmond','Losey',1),(833,'Glory','Orlandi',1),(834,'Dillon','Thedford',1),(835,'Kathyrn','Molinari',1),(836,'Harland','Lagunas',1),(837,'Neely','Familia',1),(838,'Valentin','Bennetts',1),(839,'Delora','Hardee',1),(840,'Reuben','Arno',1),(841,'Kacy','Riccardi',1),(842,'Willis','Munez',1),(843,'Tonja','Collar',1),(844,'Felipe','Lafuente',1),(845,'Verona','Reifsteck',1),(846,'Marion','Bulluck',1),(847,'Chantay','Winsor',1),(848,'Jack','Colletti',1),(849,'Kiera','Akana',1),(850,'Yong','Clary',1),(851,'Doris','Plascencia',1),(852,'Edmundo','Wickline',1),(853,'Tiffiny','Axel',1),(854,'Nigel','Watrous',1),(855,'Charlotte','Kothari',1),(856,'Beau','Pinkett',1),(857,'Carmina','Paden',1),(858,'Rueben','Edgin',1),(859,'Fabiola','Zanders',1),(860,'Granville','Hole',1),(861,'Charolette','Rexroad',1),(862,'Gregorio','Cifuentes',1),(863,'Lenna','To',1),(864,'Nolan','Giffin',1),(865,'Theda','Dollar',1),(866,'Erich','Boudreau',1),(867,'Vena','Jonason',1),(868,'Ron','Holmquist',1),(869,'Syreeta','Bonetti',1),(870,'Houston','Castanon',1),(871,'Judith','Mccaffrey',1),(872,'Numbers','Denton',1),(873,'Kayla','Stillings',1),(874,'Darrell','Bautista',1),(875,'Lieselotte','Wittman',1),(876,'Stan','Broaden',1),(877,'Katina','Ratner',1),(878,'Boyd','Gibbs',1),(879,'Hyo','Blocker',1),(880,'Guy','Shofner',1),(881,'Destiny','Buras',1),(882,'Blair','Hornberger',1),(883,'Latonia','Lowery',1),(884,'Emil','Espitia',1),(885,'Marcie','Nova',1),(886,'Omar','Hepler',1),(887,'Taunya','Grief',1),(888,'Patricia','Dacus',1),(889,'Aimee','Derrico',1),(890,'Jayson','Lauderback',1),(891,'Shaunna','Hecht',1),(892,'Lewis','Poulos',1),(893,'Marivel','Goodnight',1),(894,'Randal','Milne',1),(895,'Reyna','Burdo',1),(896,'Jose','Kropf',1),(897,'Suzi','Ganz',1),(898,'Osvaldo','Barajas',1),(899,'Ronni','Iddings',1),(900,'Conrad','Cockett',1),(901,'Antionette','Cramer',1),(902,'Chet','Triana',1),(903,'Charlsie','Mackin',1),(904,'Esteban','Rhines',1),(905,'Ludivina','Gearhart',1),(906,'Levi','Ambriz',1),(907,'Zoila','Mcgahey',1),(908,'Heriberto','Morrisette',1),(909,'Caroline','Mleczko',1),(910,'Mauricio','Varn',1),(1111,'John','Smith',1),(1112,'Jim','Smith',1),(1113,'Cathy','Smith',1),(1114,'Cathy','Smith',1),(1115,'Jane','Smith',1),(1116,'Adam','West',1),(1117,'John','Smith',0);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientphysician`
--

DROP TABLE IF EXISTS `patientphysician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patientphysician` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FirstDateTime` datetime DEFAULT NULL,
  `PatientID` int DEFAULT NULL,
  `PhysicianID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PatientID` (`PatientID`),
  KEY `PhysicianID` (`PhysicianID`),
  CONSTRAINT `patientphysician_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`),
  CONSTRAINT `patientphysician_ibfk_2` FOREIGN KEY (`PhysicianID`) REFERENCES `physician` (`PhysicianID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientphysician`
--

LOCK TABLES `patientphysician` WRITE;
/*!40000 ALTER TABLE `patientphysician` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientphysician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `patientview`
--

DROP TABLE IF EXISTS `patientview`;
/*!50001 DROP VIEW IF EXISTS `patientview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `patientview` AS SELECT 
 1 AS `PatientID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `Flag`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `physician`
--

DROP TABLE IF EXISTS `physician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `physician` (
  `PhysicianID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `flag` int DEFAULT NULL,
  PRIMARY KEY (`PhysicianID`),
  KEY `idx_physician` (`PhysicianID`,`FirstName`,`LastName`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physician`
--

LOCK TABLES `physician` WRITE;
/*!40000 ALTER TABLE `physician` DISABLE KEYS */;
INSERT INTO `physician` VALUES (51,'Evelyn','Stein',0),(52,'Zayan','Pennington',0),(53,'Aliesha','Duncan',0),(54,'Davina','Ratcliffe',0),(55,'Eben','Stark',0),(56,'Holly','Buchanan',1),(57,'Shanay','Ramsey',1),(58,'Rowan','Paterson',1),(59,'Wilma','Tran',1),(60,'Jayda','Bowes',1),(61,'Ibrar','Amin',1),(62,'Nick','Torres',1),(63,'Samual','Hoover',1),(64,'Jaylen','Ferguson',1),(65,'Taliyah','Richmond',1),(66,'Crystal','Hogan',1),(67,'Ruari','Gilliam',1),(68,'Bella','Finney',1),(69,'Stan','Whitworth',1),(70,'Leoni','Richard',1),(71,'Daria','Gardner',1),(72,'Mina','North',1),(73,'Fahad','Talley',1),(74,'Jak','Jones',1),(75,'Manha','Mcdougall',1),(76,'Lochlan','Olsen',1),(77,'Marshall','Thomson',1),(78,'Jazmine','Frazier',1),(79,'Malaikah','Fitzgerald',1),(80,'Donna','Alvarado',1),(81,'Nazifa','Perez',1),(82,'Isla-Rae','Sanford',1),(83,'Ella','Petty',1),(84,'Alessia','Terry',1),(85,'Viaan','Knowles',1),(86,'Storm','Bates',1),(87,'Ayaz','Lindsay',1),(88,'Faiza','Horn',1),(89,'Austen','Neville',1),(90,'Campbell','Mcconnell',1),(91,'Frederic','Pugh',1),(92,'Joely','Wong',1),(93,'Shaunna','Rowland',1),(94,'Ava-Mae','Zuniga',1),(95,'Melissa','Plummer',1),(96,'Stella','Henson',1),(97,'Louie','Arnold',1),(98,'Kole','Cabrera',1),(99,'Bertram','Lane',1),(100,'Archer','Mellor',1);
/*!40000 ALTER TABLE `physician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `physicianview`
--

DROP TABLE IF EXISTS `physicianview`;
/*!50001 DROP VIEW IF EXISTS `physicianview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `physicianview` AS SELECT 
 1 AS `PhysicianID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `flag`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `PrescriptionID` int NOT NULL AUTO_INCREMENT,
  `PrescriptionName` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Dosage` int DEFAULT NULL,
  `Refill` int DEFAULT NULL,
  `Description` text,
  `PatientID` int DEFAULT NULL,
  `PhysicianID` int DEFAULT NULL,
  `Flag` int DEFAULT NULL,
  PRIMARY KEY (`PrescriptionID`),
  KEY `PatientID` (`PatientID`),
  KEY `PhysicianID` (`PhysicianID`),
  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`),
  CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`PhysicianID`) REFERENCES `physician` (`PhysicianID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'Xerox','2020-11-22',50,0,'Take 1 a day',811,56,0),(2,'Xerox','2020-11-22',20,2,'Take 2 a day',815,55,0),(3,'some','2020-11-22',2,0,'Take 1 a day',811,51,0),(4,'Lithium','2020-11-29',5,0,'Take 1 a day',815,58,1),(5,'Advil','2020-12-01',5,0,'Take 1 one a day',817,56,NULL);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `search`
--

DROP TABLE IF EXISTS `search`;
/*!50001 DROP VIEW IF EXISTS `search`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `search` AS SELECT 
 1 AS `patientID`,
 1 AS `locationID`,
 1 AS `ohip`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `TreatmentID` int NOT NULL AUTO_INCREMENT,
  `Treatment` varchar(255) DEFAULT NULL,
  `PatientID` int DEFAULT NULL,
  `PhysicianID` int DEFAULT NULL,
  PRIMARY KEY (`TreatmentID`),
  KEY `PatientID` (`PatientID`),
  KEY `PhysicianID` (`PhysicianID`),
  CONSTRAINT `treatment_ibfk_1` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`),
  CONSTRAINT `treatment_ibfk_2` FOREIGN KEY (`PhysicianID`) REFERENCES `physician` (`PhysicianID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (11,'Aortic Valve Replacements',811,51),(12,'Cardioversion',811,59),(13,NULL,811,60),(14,'Heart Bypass Surgery',811,60),(15,'Heart Bypass Surgery',812,56),(16,'Epilepsy Surgery',817,60);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urinetest`
--

DROP TABLE IF EXISTS `urinetest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urinetest` (
  `TestID` int NOT NULL AUTO_INCREMENT,
  `pH` int DEFAULT NULL,
  `specificGravity` double(4,3) DEFAULT NULL,
  `protein` int DEFAULT NULL,
  `bilirubin` double(2,1) DEFAULT NULL,
  `urobilinogen` double(2,1) DEFAULT NULL,
  `blood` int DEFAULT NULL,
  `glucose` int DEFAULT NULL,
  `ketone` double(3,1) DEFAULT NULL,
  `nitrite` double(3,2) DEFAULT NULL,
  `leukocyte` int DEFAULT NULL,
  `Time` timestamp NULL DEFAULT NULL,
  `PatientID` int DEFAULT NULL,
  PRIMARY KEY (`TestID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urinetest`
--

LOCK TABLES `urinetest` WRITE;
/*!40000 ALTER TABLE `urinetest` DISABLE KEYS */;
INSERT INTO `urinetest` VALUES (1,6,1.030,6,0.2,0.2,5,40,2.5,0.50,25,'2020-12-01 09:26:54',811),(2,6,1.030,6,0.2,0.2,5,40,2.5,0.50,25,'2020-12-01 09:27:42',812),(3,5,1.000,5,0.2,0.2,5,40,10.0,0.50,25,'2020-12-01 10:53:48',817);
/*!40000 ALTER TABLE `urinetest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `adtview`
--

/*!50001 DROP VIEW IF EXISTS `adtview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `adtview` AS select `adt`.`ID` AS `ID`,`adt`.`ADT` AS `ADT`,`adt`.`AddDateTime` AS `AddDateTime`,`adt`.`TransDateTime` AS `TransDateTime`,`adt`.`DisDateTime` AS `DisDateTime`,`adt`.`Reason` AS `Reason`,`adt`.`LocationID` AS `LocationID`,`adt`.`PatientID` AS `PatientID` from `adt` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `demographicview`
--

/*!50001 DROP VIEW IF EXISTS `demographicview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `demographicview` AS select `demographics`.`PatientID` AS `PatientID`,`demographics`.`OHIP` AS `OHIP`,`demographics`.`DOB` AS `DOB`,`demographics`.`Sex` AS `Sex`,`demographics`.`Height` AS `Height`,`demographics`.`Weight` AS `Weight`,`demographics`.`BloodType` AS `BloodType`,`demographics`.`Contact` AS `Contact` from `demographics` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `locationpatientview`
--

/*!50001 DROP VIEW IF EXISTS `locationpatientview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `locationpatientview` AS select `locationpatient`.`PatientID` AS `patientID`,`locationpatient`.`LocationID` AS `locationID`,`locationpatient`.`Time` AS `time`,`treatment`.`Treatment` AS `treatment` from (`locationpatient` left join `treatment` on((`locationpatient`.`PatientID` = `treatment`.`PatientID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nurseview`
--

/*!50001 DROP VIEW IF EXISTS `nurseview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nurseview` AS select `nurse`.`NurseID` AS `NurseID`,`nurse`.`FirstName` AS `FirstName`,`nurse`.`LastName` AS `LastName`,`nurse`.`flag` AS `flag` from `nurse` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `patientview`
--

/*!50001 DROP VIEW IF EXISTS `patientview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `patientview` AS select `patient`.`PatientID` AS `PatientID`,`patient`.`FirstName` AS `FirstName`,`patient`.`LastName` AS `LastName`,`patient`.`Flag` AS `Flag` from `patient` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `physicianview`
--

/*!50001 DROP VIEW IF EXISTS `physicianview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `physicianview` AS select `physician`.`PhysicianID` AS `PhysicianID`,`physician`.`FirstName` AS `FirstName`,`physician`.`LastName` AS `LastName`,`physician`.`flag` AS `flag` from `physician` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `search`
--

/*!50001 DROP VIEW IF EXISTS `search`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `search` AS select `locationpatientview`.`patientID` AS `patientID`,`locationpatientview`.`locationID` AS `locationID`,`demographicview`.`OHIP` AS `ohip` from (`locationpatientview` join `demographicview` on((`locationpatientview`.`patientID` = `demographicview`.`PatientID`))) order by `locationpatientview`.`locationID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-05  0:51:07
