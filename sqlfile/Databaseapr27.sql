-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema StudentRegistration
--

CREATE DATABASE IF NOT EXISTS StudentRegistration;
USE StudentRegistration;

--
-- Definition of table `StudentRegistration`.`classt`
--

DROP TABLE IF EXISTS `StudentRegistration`.`classt`;
CREATE TABLE  `StudentRegistration`.`classt` (
  `classid` int(11) NOT NULL AUTO_INCREMENT,
  `subjectid` int(11) NOT NULL,
  `teacherid` int(11) NOT NULL,
  `scheduleid` int(11) NOT NULL,
  PRIMARY KEY (`classid`),
  KEY `fk_classt_1` (`subjectid`),
  KEY `fk_classt_2` (`teacherid`),
  KEY `fk_classt_3` (`scheduleid`),
  CONSTRAINT `fk_classt_1` FOREIGN KEY (`subjectid`) REFERENCES `subject` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_classt_2` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacherid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_classt_3` FOREIGN KEY (`scheduleid`) REFERENCES `schedule` (`scheduleid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`classt`
--

/*!40000 ALTER TABLE `classt` DISABLE KEYS */;
LOCK TABLES `classt` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `classt` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`daysched`
--

DROP TABLE IF EXISTS `StudentRegistration`.`daysched`;
CREATE TABLE  `StudentRegistration`.`daysched` (
  `dayschedid` int(11) NOT NULL AUTO_INCREMENT,
  `days` varchar(10) NOT NULL,
  PRIMARY KEY (`dayschedid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`daysched`
--

/*!40000 ALTER TABLE `daysched` DISABLE KEYS */;
LOCK TABLES `daysched` WRITE;
INSERT INTO `StudentRegistration`.`daysched` VALUES  (1,'mon-tue'),
 (2,'tue-wed'),
 (3,'wed-thurs'),
 (4,'thurs-fri');
UNLOCK TABLES;
/*!40000 ALTER TABLE `daysched` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`schedule`
--

DROP TABLE IF EXISTS `StudentRegistration`.`schedule`;
CREATE TABLE  `StudentRegistration`.`schedule` (
  `dayschedid` int(11) NOT NULL,
  `timeschedid` int(11) NOT NULL,
  `scheduleid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`scheduleid`),
  KEY `fk_schedule_1` (`dayschedid`),
  KEY `fk_schedule_2` (`timeschedid`),
  CONSTRAINT `fk_schedule_1` FOREIGN KEY (`dayschedid`) REFERENCES `daysched` (`dayschedid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_schedule_2` FOREIGN KEY (`timeschedid`) REFERENCES `timesched` (`timeschedid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`schedule`
--

/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
LOCK TABLES `schedule` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`student`
--

DROP TABLE IF EXISTS `StudentRegistration`.`student`;
CREATE TABLE  `StudentRegistration`.`student` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `studentfirstname` varchar(15) NOT NULL,
  `studentlastname` varchar(15) NOT NULL,
  `studentaddress` varchar(45) NOT NULL,
  `studentcontact` varchar(12) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
LOCK TABLES `student` WRITE;
INSERT INTO `StudentRegistration`.`student` VALUES  (1,'Gian','Lacerna','Quezon City','4162832'),
 (2,'Minerva','Limcaoco','Laguna','4325465');
UNLOCK TABLES;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`studentclasses`
--

DROP TABLE IF EXISTS `StudentRegistration`.`studentclasses`;
CREATE TABLE  `StudentRegistration`.`studentclasses` (
  `studentid` int(11) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  KEY `fk_studentclasses_1` (`studentid`),
  KEY `fk_studentclasses_2` (`classid`),
  CONSTRAINT `fk_studentclasses_1` FOREIGN KEY (`classid`) REFERENCES `classt` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_studentclasses_2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`studentclasses`
--

/*!40000 ALTER TABLE `studentclasses` DISABLE KEYS */;
LOCK TABLES `studentclasses` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `studentclasses` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`subject`
--

DROP TABLE IF EXISTS `StudentRegistration`.`subject`;
CREATE TABLE  `StudentRegistration`.`subject` (
  `subjectid` int(11) NOT NULL AUTO_INCREMENT,
  `subjectname` varchar(5) NOT NULL,
  `subjectdesc` varchar(20) NOT NULL,
  `subjecttypeid` int(11) NOT NULL,
  PRIMARY KEY (`subjectid`),
  KEY `fk_subject_1` (`subjectid`),
  KEY `fk_subject_2` (`subjecttypeid`),
  CONSTRAINT `fk_subject_2` FOREIGN KEY (`subjecttypeid`) REFERENCES `subjecttype` (`subjecttypeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`subject`
--

/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
LOCK TABLES `subject` WRITE;
INSERT INTO `StudentRegistration`.`subject` VALUES  (1,'CS101','JAVA',1),
 (2,'CS102','OOP Concepts',1),
 (3,'CS101','Advanced Java',2),
 (4,'CS102','OOP and TDD',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`subjecttype`
--

DROP TABLE IF EXISTS `StudentRegistration`.`subjecttype`;
CREATE TABLE  `StudentRegistration`.`subjecttype` (
  `subjecttypeid` int(11) NOT NULL AUTO_INCREMENT,
  `subjecttype` varchar(20) NOT NULL,
  PRIMARY KEY (`subjecttypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`subjecttype`
--

/*!40000 ALTER TABLE `subjecttype` DISABLE KEYS */;
LOCK TABLES `subjecttype` WRITE;
INSERT INTO `StudentRegistration`.`subjecttype` VALUES  (1,'Undergraduate'),
 (2,'Graduate');
UNLOCK TABLES;
/*!40000 ALTER TABLE `subjecttype` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`teacher`
--

DROP TABLE IF EXISTS `StudentRegistration`.`teacher`;
CREATE TABLE  `StudentRegistration`.`teacher` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `teacherfirstname` varchar(15) NOT NULL,
  `teacherlastname` varchar(15) NOT NULL,
  PRIMARY KEY (`teacherid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`teacher`
--

/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
LOCK TABLES `teacher` WRITE;
INSERT INTO `StudentRegistration`.`teacher` VALUES  (1,'James','Barbosa'),
 (2,'Richie','Panganiban'),
 (3,'Michael','Jordan'),
 (4,'James','Gosling'),
 (5,'Martin','Fowler'),
 (6,'Theo','Jansen'),
 (7,'Lenart','Green');
UNLOCK TABLES;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`timesched`
--

DROP TABLE IF EXISTS `StudentRegistration`.`timesched`;
CREATE TABLE  `StudentRegistration`.`timesched` (
  `timeschedid` int(11) NOT NULL AUTO_INCREMENT,
  `times` varchar(10) NOT NULL,
  PRIMARY KEY (`timeschedid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`timesched`
--

/*!40000 ALTER TABLE `timesched` DISABLE KEYS */;
LOCK TABLES `timesched` WRITE;
INSERT INTO `StudentRegistration`.`timesched` VALUES  (1,'9am-10am'),
 (2,'10am-11am'),
 (3,'11am-12nn'),
 (4,'12nn-1pm'),
 (5,'1pm-2pm'),
 (6,'2pm-3pm'),
 (7,'3pm-4pm'),
 (8,'4pm-5pm'),
 (9,'5pm-6pm');
UNLOCK TABLES;
/*!40000 ALTER TABLE `timesched` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`useraccount`
--

DROP TABLE IF EXISTS `StudentRegistration`.`useraccount`;
CREATE TABLE  `StudentRegistration`.`useraccount` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `usertypeid` int(1) NOT NULL,
  PRIMARY KEY (`userid`),
  KEY `fk_useraccount_1` (`usertypeid`),
  CONSTRAINT `fk_useraccount_1` FOREIGN KEY (`usertypeid`) REFERENCES `usertype` (`usertypeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`useraccount`
--

/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
LOCK TABLES `useraccount` WRITE;
INSERT INTO `StudentRegistration`.`useraccount` VALUES  (1,'gian','gian',1),
 (2,'mine','mine',1),
 (99999,'admin','admin',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;


--
-- Definition of table `StudentRegistration`.`usertype`
--

DROP TABLE IF EXISTS `StudentRegistration`.`usertype`;
CREATE TABLE  `StudentRegistration`.`usertype` (
  `usertypeid` int(1) NOT NULL AUTO_INCREMENT,
  `usertype` varchar(7) NOT NULL,
  PRIMARY KEY (`usertypeid`),
  KEY `fk_usertype_1` (`usertypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentRegistration`.`usertype`
--

/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
LOCK TABLES `usertype` WRITE;
INSERT INTO `StudentRegistration`.`usertype` VALUES  (1,'student'),
 (2,'admin');
UNLOCK TABLES;
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
