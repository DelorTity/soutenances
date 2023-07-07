
--
-- Current Database: `soutenance`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `soutenance` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `soutenance`;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tel` int NOT NULL,
  `zip` int NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `company` (`company_id`, `address`, `city`, `country`, `email`, `name`, `tel`, `zip`) VALUES

(1, 'Ange Raphael','Douala','Cameroun','delor@gmail.com','SoftWify', 695624691, 1897),
(2, 'maie 18','limbe.','Cameroon','del@gmail.com','PJD', 6951624691, 1097);

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defense`
--

DROP TABLE IF EXISTS `defense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defense` (
  `defense_id` bigint NOT NULL,
  `classroom` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `student_student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`defense_id`),
  KEY `FK9oc5gjfubaglbmx2128k2hx6u` (`student_student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `defense` (`defense_id`, `classroom`,`date`, `student_student_id`) VALUES

(1, 'Amphi 200','2022-07-20',2),
(2, 'B5','2022-07-24',1);
--
-- Dumping data for table `defense`
--

LOCK TABLES `defense` WRITE;
/*!40000 ALTER TABLE `defense` DISABLE KEYS */;
/*!40000 ALTER TABLE `defense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defense_juries`
--

DROP TABLE IF EXISTS `defense_juries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defense_juries` (
  `defense_defense_id` bigint NOT NULL,
  `juries_teacher_id` bigint NOT NULL,
  PRIMARY KEY (`defense_defense_id`,`juries_teacher_id`),
  UNIQUE KEY `UK_qirw8cg3j1j4qb9geemopv9h6` (`juries_teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defense_juries`
--

LOCK TABLES `defense_juries` WRITE;
/*!40000 ALTER TABLE `defense_juries` DISABLE KEYS */;
/*!40000 ALTER TABLE `defense_juries` ENABLE KEYS */;
UNLOCK TABLES;

INSERT INTO `defense_juries` (`defense_defense_id`, `juries_teacher_id`) VALUES

(1, 2),
(2, 1);

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality` (
  `speciality_id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department_head_teacher_id` bigint DEFAULT NULL,
  PRIMARY KEY (`speciality_id`),
  KEY `FKjvje90dpa73bp0628ofm3meue` (`department_head_teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `speciality` (`speciality_id`, `name`, `department_head_teacher_id`) VALUES

(1,'informatique', 2),
(2,'informatique',  1);

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` bigint NOT NULL,
  `age` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `tel` int NOT NULL,
  `zip` int NOT NULL,
  `speciality_speciality_id` bigint DEFAULT NULL,
  `supervisor_teacher_id` bigint DEFAULT NULL,
  `topic_topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FKg7wbogrysx0np6pltxqgnc77v` (`speciality_speciality_id`),
  KEY `FKoeh8qg4rl33sxphj3t3sgsmqc` (`supervisor_teacher_id`),
  KEY `FKs9cek5rrns6mlpgeuny9eslrm` (`topic_topic_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


INSERT INTO `student` (`student_id`, `age`, `city`, `country`, `email`, `first_name`,`last_name`, `tel`, `zip`, `speciality_speciality_id`,`supervisor_teacher_id`, `topic_topic_id`) VALUES

(1, 25,'Douala.','Cameroun','delor@gmail.com','nzima','yvan', 695624691, 1897, 2, 1, 1),
(2, 22,'limbe.','Cameroon','del@gmail.com','mbang','moise', 6951624691, 1097, 1, 2, 2);

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacher_id` bigint NOT NULL,
  `age` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `tel` int NOT NULL,
  `zip` int NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `teacher` (`teacher_id`, `age`, `city`, `country`, `email`, `first_name`,`last_name`, `tel`, `zip`) VALUES

(1, 36,'Douala.','Cameroun','delor@gmail.com','TITY ','DELOR', 695624691, 1897),
(2, 30, 'limbe.','Cameroon','del@gmail.com','Komto','francois', 6951624691, 1097);

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `topic_id` bigint NOT NULL,
  `domain` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `company_company_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `FKiggpgtj2fa6371xc2jhtuxht1` (`company_company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


INSERT INTO `topic` (`topic_id`, `domain`, `duration`, `title`, `company_company_id`) VALUES

(1, 'genie logiciel',30,'Gestion des soutenances',1),
(2, 'genie logiciel',30,'gestion des hopitaux',2);

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!50606 SET GLOBAL INNODB_STATS_AUTO_RECALC=@OLD_INNODB_STATS_AUTO_RECALC */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-07 10:26:29
