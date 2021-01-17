/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.11-MariaDB : Database - fpis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fpis` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `fpis`;

/*Table structure for table `cenovnik` */

DROP TABLE IF EXISTS `cenovnik`;

CREATE TABLE `cenovnik` (
  `sifracenovnika` int(11) NOT NULL,
  `datum` date DEFAULT NULL,
  `sifraDrzave` int(11) DEFAULT NULL,
  `sifraradnika` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sifracenovnika`),
  KEY `FKtpjwnjxuvqwxl5o39cj3kscv0` (`sifraDrzave`),
  KEY `FKormy4yxsj5jkkmjuu50smtvak` (`sifraradnika`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `cenovnik` */

insert  into `cenovnik`(`sifracenovnika`,`datum`,`sifraDrzave`,`sifraradnika`) values 
(1,'2021-01-19',1,'1'),
(6,'2021-01-15',1,'1'),
(11,'2021-01-29',3,'1'),
(15,'2021-01-13',3,'1'),
(19,'2021-01-21',4,'1');

/*Table structure for table `drzava` */

DROP TABLE IF EXISTS `drzava`;

CREATE TABLE `drzava` (
  `sifraDrzave` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifraDrzave`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `drzava` */

insert  into `drzava`(`sifraDrzave`,`naziv`) values 
(1,'SRBIJA'),
(2,'BIH'),
(3,'HRVATSKA'),
(4,'MAKEDONIJA');

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `postanskiBroj` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `sifraDrzave` int(11) DEFAULT NULL,
  PRIMARY KEY (`postanskiBroj`),
  KEY `FK41917v5lwn4d9c1bs9yyshecq` (`sifraDrzave`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `grad` */

insert  into `grad`(`postanskiBroj`,`naziv`,`sifraDrzave`) values 
(11000,'BEOGRAD',1),
(11090,'NOVI SAD',1),
(12000,'NIS',1),
(12001,'PRISTINA',1),
(1,'TUZLA',2),
(2,'BANJALUKA',2),
(3,'MOSTAR',2),
(11,'HVAR',3),
(12,'ISTRA',3),
(13,'ZAGREB',3),
(21,'KUMANOVO',4),
(22,'SKOPLJE',4),
(23,'TETOVO',4),
(24,'VELES',4);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(25);

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `sifraproizvoda` varchar(10) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifraproizvoda`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `proizvod` */

insert  into `proizvod`(`sifraproizvoda`,`model`) values 
('1','1st proizvod'),
('2','2nd proizvod'),
('3','3rd proizvod'),
('4','4th proizvod'),
('5','5th proizvod');

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `sifraradnika` varchar(10) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `imePrezime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sifraradnika`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `radnik` */

insert  into `radnik`(`sifraradnika`,`email`,`imePrezime`) values 
('1','1','1'),
('2','2','2');

/*Table structure for table `spediter` */

DROP TABLE IF EXISTS `spediter`;

CREATE TABLE `spediter` (
  `sifraSpeditera` int(11) NOT NULL AUTO_INCREMENT,
  `brojTelefona` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `ulicaIBroj` varchar(255) DEFAULT NULL,
  `postanskiBroj` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifraSpeditera`),
  KEY `FK96tk3vbbrk4676tvercwvurc2` (`postanskiBroj`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `spediter` */

insert  into `spediter`(`sifraSpeditera`,`brojTelefona`,`email`,`fax`,`naziv`,`ulicaIBroj`,`postanskiBroj`) values 
(1,'2322100','mm1@gmail.com','asdfer','Marko','Tuzlanska 22',11),
(2,'2322100','jj@jj.com','Marko@markovic.com','Jovan','sadf',23),
(3,'232210012','mutavdzicmilos','asdf','Milos','Tuzlanska 22',12001);

/*Table structure for table `stavkacenovnika` */

DROP TABLE IF EXISTS `stavkacenovnika`;

CREATE TABLE `stavkacenovnika` (
  `rb` int(11) NOT NULL,
  `vrednost` varchar(255) DEFAULT NULL,
  `vrednostBezPdv` varchar(255) DEFAULT NULL,
  `sifracenovnika` int(11) NOT NULL,
  `sifraproizvoda` varchar(10) NOT NULL,
  PRIMARY KEY (`rb`),
  KEY `FKh6t9slncu0m8ece79d06dqrtr` (`sifraproizvoda`),
  KEY `FKt9osj8pf9rercagdbyjja84ec` (`sifracenovnika`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkacenovnika` */

insert  into `stavkacenovnika`(`rb`,`vrednost`,`vrednostBezPdv`,`sifracenovnika`,`sifraproizvoda`) values 
(4,'3','3',1,'3'),
(3,'2','2',1,'2'),
(2,'1','1',1,'1'),
(10,'4','4',6,'4'),
(12,'1','1',11,'1'),
(16,'1','1',15,'1'),
(14,'3','3',11,'3'),
(18,'23','23',15,'3'),
(24,'33','33',19,'3'),
(23,'200','200',19,'1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
