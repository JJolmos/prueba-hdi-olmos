-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: hdisegurostest
-- ------------------------------------------------------
-- Server version	8.4.6

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
-- Table structure for table `polizas`
--

DROP TABLE IF EXISTS `polizas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polizas` (
  `noPoliza` int NOT NULL AUTO_INCREMENT,
  `asegurado` varchar(255) NOT NULL,
  `beneficiario` varchar(255) DEFAULT NULL,
  `fechaemision` datetime(6) NOT NULL,
  `finVigencia` datetime(6) NOT NULL,
  `idPoliza` varchar(255) NOT NULL,
  `inicioVigencia` datetime(6) NOT NULL,
  `liNeanegocio` varchar(50) NOT NULL,
  `oficinaEmision` int NOT NULL,
  `periodicidad` varchar(10) NOT NULL,
  `vehiculoAsegurado` varchar(30) NOT NULL,
  PRIMARY KEY (`noPoliza`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polizas`
--

LOCK TABLES `polizas` WRITE;
/*!40000 ALTER TABLE `polizas` DISABLE KEYS */;
INSERT INTO `polizas` VALUES (1,'Juan Jose Olmos Manriquez','Angelica Manriquez Ayala','2021-04-11 16:21:00.000000','2027-04-11 16:21:00.000000','11','2021-04-11 16:21:00.000000','Autos',1,'Anual','Ibiza Cupra'),(2,'Miguel Angel Ruiz Duran','Juan Jose Olmos Manriquez','2026-04-11 16:21:00.000000','2026-05-11 16:21:00.000000','12','2026-04-11 16:21:00.000000','Autos',1,'Mensual','Toyota Supra'),(3,'Carlos Alejandro Ramirez','Miguel Angel Ruiz Duran','2026-04-11 16:21:00.000000','2026-06-11 16:21:00.000000','23','2026-04-11 16:21:00.000000','Autos',2,'Bimestral','Subaru Impreza '),(4,'Luis Angel Adriano','Miguel Angel Ruiz Duran','2026-04-11 16:21:00.000000','2027-04-11 16:21:00.000000','14','2026-04-11 16:21:00.000000','Daños',1,'Anual','N/A'),(5,'Pedro Antonio Fernandez','Luis Angel Adriano','2026-04-11 16:21:00.000000','2026-10-11 16:21:00.000000','35','2026-04-11 16:21:00.000000','Autos',3,'Semestral','Tsuru II'),(6,'Marco Antonio Solis','Luis Angel Adriano','2026-04-11 16:21:00.000000','2027-04-11 16:21:00.000000','16','2026-04-11 16:21:00.000000','Autos',1,'Anual','Volkswagen Golf'),(7,'Ricardo Arjona','Marco Antonio Solis','2026-04-11 16:21:00.000000','2027-04-11 16:21:00.000000','17','2026-04-11 16:21:00.000000','Autos',1,'Anual','Audi TT'),(8,'Ricardo Salinas Pliego','Ricardo Arjona','2026-04-11 16:21:00.000000','2027-04-11 16:21:00.000000','18','2026-04-11 16:21:00.000000','Autos',1,'Anual','Lamborghini Diablo');
/*!40000 ALTER TABLE `polizas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportes`
--

DROP TABLE IF EXISTS `reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportes` (
  `idReporte` int NOT NULL AUTO_INCREMENT,
  `color` varchar(10) NOT NULL,
  `correoElectronico` varchar(50) NOT NULL,
  `descripcionSiniestro` varchar(100) NOT NULL,
  `fechaOcurrencia` datetime(6) NOT NULL,
  `lugarSiniestro` varchar(100) NOT NULL,
  `nombreAjustador` varchar(100) NOT NULL,
  `nombreReporta` varchar(100) NOT NULL,
  `observaciones` varchar(100) DEFAULT NULL,
  `placas` varchar(10) NOT NULL,
  `telefonoContacto` varchar(10) NOT NULL,
  `correo` int DEFAULT NULL,
  `idPoliza` int DEFAULT NULL,
  PRIMARY KEY (`idReporte`),
  KEY `FKsssr0cenyththsp9jhmfjktgp` (`correo`),
  KEY `FK85r53fakcjaqbcjymmdj1k7wh` (`idPoliza`),
  CONSTRAINT `FK85r53fakcjaqbcjymmdj1k7wh` FOREIGN KEY (`idPoliza`) REFERENCES `polizas` (`noPoliza`),
  CONSTRAINT `FKsssr0cenyththsp9jhmfjktgp` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
INSERT INTO `reportes` VALUES (2,'Gris','olmosmanriquez@gmail.com','Choque por invasion de carril','2026-04-12 12:40:36.897000','Leon, Gto.','Salomon Martinez','Juan Jose Olmos',NULL,'GHF456','4776775568',6,1),(3,'BLANCO','olmosmanriquez@gmail.com','CHOQUE','2026-04-12 13:08:36.647000','Leon, Gto.','Juan Jose Olmos','Juan jose',NULL,'GFH456','4776775568',1,3),(4,'AZUL','olmos_jj@hotmail.com','choque','2026-04-12 13:08:36.647000','SILAO, GTO.','Juan Jose Olmos','MANUEL','HOLA','GFH345','4777889965',1,1),(5,'Blanco','olmos_jj@hotmail.com','choque','2026-04-12 14:57:02.385000','Leon','Juan Manuel Riva','Manuel','ninguna','GFH456','4777777777',2,5),(6,'GRIS','olmos_jj@hotmail.com','NADA','2026-04-12 15:01:45.608000','Leon','Juan Manuel Riva','Angel','NADA','GHJ456','4778552200',2,8),(7,'FFFFF','olmos_jj@hotmail.com','FFFFF','2026-04-12 15:03:02.416000','LEON','Juan Manuel Riva','SUBARU','FFFFF','GHF345','4777777799',2,3),(8,'TTTT','olmos_jj@hotmail.com','TTTT','2026-04-12 15:06:46.995000','LEON','Juan Manuel Riva','TEST','TTTT','LEO098','4774889975',2,4),(9,'DDD','olmos_jj@hotmail.com','DDD','2026-04-12 15:08:13.352000','DDD','Juan Manuel Riva','DDDD','DDDD','DDDD','4777777777',2,7),(10,'ROJO','olmos_jj@hotmail.com','dddd','2026-04-12 15:13:56.746000','LEON','Juan Jose Olmos','optro',NULL,'OMH345','4776775568',1,1),(11,'ROJO','olmos_jj@hotmail.com','NADA','2026-04-12 15:17:54.314000','LEON','Juan Jose Olmos','manuel',NULL,'GFT654','4778996320',1,2),(12,'RED','olmos_jj@hotmail.com','ddd','2026-04-12 15:26:23.188000','LEON','Juan Jose Olmos','ALEJANDRO',NULL,'HGF678','4771178609',1,7),(13,'ROJO','olmos_jj@hotmail.com','HOLA','2026-04-12 15:27:43.224000','LEON','Salomon Martinez','IMPRESA','ALGO','GHF098','4776775520',6,3),(14,'FLAI','olmos_jj@hotmail.com','DFF','2028-04-12 00:00:00.000000','LEON','Juan Jose Olmos','TEST',NULL,'HGF567','4000000000',1,5),(15,'ROJO','olmos_jj@hotmail.com','NADA','2026-04-12 18:52:25.554000','Leon Gto','Juan Jose Olmos','Juan Antonio',NULL,'GHF567','5555555555',1,1),(16,'Verde','olmos_jj@hotmail.com','choque','2026-04-12 00:00:00.000000','Silao Gto','Juan Jose Olmos','Simon Baggins',NULL,'GTO786','0000000000',1,1),(17,'ROJO','olmos_jj@hotmail.com','NADA','2025-03-12 00:00:00.000000','Leon','Juan Jose Olmos','Test',NULL,'GHF567','4775558999',1,1);
/*!40000 ALTER TABLE `reportes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(100) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `UKfv720wvq06bliryy0o51irrpc` (`nombreRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'Ajustador'),(1,'Asesor');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siniestros`
--

DROP TABLE IF EXISTS `siniestros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siniestros` (
  `numeroSiniestro` int NOT NULL AUTO_INCREMENT,
  `fechaRegistro` datetime(6) NOT NULL,
  `nombreAjustador` varchar(100) NOT NULL,
  `correo` int DEFAULT NULL,
  `idReporte` int DEFAULT NULL,
  PRIMARY KEY (`numeroSiniestro`),
  KEY `FKi64c1dhap6nsw77hcsryo59do` (`correo`),
  KEY `FK8hf198qu8farpsrmvbon1bigm` (`idReporte`),
  CONSTRAINT `FK8hf198qu8farpsrmvbon1bigm` FOREIGN KEY (`idReporte`) REFERENCES `reportes` (`idReporte`),
  CONSTRAINT `FKi64c1dhap6nsw77hcsryo59do` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siniestros`
--

LOCK TABLES `siniestros` WRITE;
/*!40000 ALTER TABLE `siniestros` DISABLE KEYS */;
INSERT INTO `siniestros` VALUES (1,'2026-04-12 12:40:36.897000','Salomon Martinez',6,2),(2,'2026-04-12 13:08:36.647000','Juan Jose Olmos',1,3),(3,'2026-04-12 13:08:36.647000','Juan Jose Olmos',1,4),(4,'2026-04-12 14:57:43.441000','Juan Manuel Riva',2,5),(5,'2026-04-12 15:02:15.916000','Juan Manuel Riva',2,6),(6,'2026-04-12 15:03:34.402000','Juan Manuel Riva',2,7),(7,'2026-04-12 15:07:13.377000','Juan Manuel Riva',2,8),(8,'2026-04-12 15:08:29.318000','Juan Manuel Riva',2,9),(9,'2026-04-12 15:14:16.523000','Juan Jose Olmos',1,10),(10,'2026-04-12 15:18:20.752000','Juan Jose Olmos',1,11),(11,'2026-04-12 15:26:48.375000','Juan Jose Olmos',1,12),(12,'2026-04-12 15:28:09.061000','Salomon Martinez',6,13),(13,'2026-04-12 15:36:22.776000','Juan Jose Olmos',1,14),(14,'2026-04-12 18:52:56.954000','Juan Jose Olmos',1,15),(15,'2026-04-12 18:55:30.558000','Juan Jose Olmos',1,16),(16,'2026-04-12 18:56:47.017000','Juan Jose Olmos',1,17);
/*!40000 ALTER TABLE `siniestros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(25) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `estatus` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idRol` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `UKcdmw5hxlfj78uf4997i3qyyw5` (`correo`),
  KEY `FK86ctfwhy85rqr9npi3u5eqwo3` (`idRol`),
  CONSTRAINT `FK86ctfwhy85rqr9npi3u5eqwo3` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Pa55word','olmos@hdi.com',1,'Juan Jose Olmos',1),(2,'Pa55word','juan@hdi.com',1,'Juan Manuel Riva',2),(3,'Pa55word','jose@hdi.com',1,'Jose Miguel Andares',1),(4,'Pa55word','miguel@hdi.com',0,'Miguel Miguel Anasterian',2),(5,'Pa55word','angel@hdi.com',1,'Angel de Dios Leyva',2),(6,'Pa55word','salomon@hdi.com',1,'Salomon Martinez',1),(7,'Pa55word','victor@hdi.com',0,'Victor Salmuera',1),(8,'Pa55word','margo@hdi.com',1,'Margo Rocha',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-12 19:15:50
