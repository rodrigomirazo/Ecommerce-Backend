CREATE DATABASE  IF NOT EXISTS `Eclothe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Eclothe`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: Eclothe
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(110) DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  `color_id` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `original_price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `description` text,
  `fleet_cost` double DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `last_level_category_id` int DEFAULT NULL,
  `transaction_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `status_id_idx` (`status_id`),
  CONSTRAINT `item_status_id` FOREIGN KEY (`status_id`) REFERENCES `item_status_cat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Tenis Nike 1',1,85,1,499,499,0,'Tenis Nike 1 description',-1,1,5,-1,NULL),(2,'Tenis Nike 2',1,85,1,499,499,0,'Tenis Nike 2 description',-1,1,5,-1,NULL),(3,'Tenis Puma 3',1,85,1,499,499,0,'Tenis Nike 3 description',-1,1,20,-1,NULL),(4,'Tenis Puma 4',1,85,1,499,499,0,'Tenis Nike 4 description',-1,1,20,-1,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_category`
--

DROP TABLE IF EXISTS `item_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_type_id` int DEFAULT NULL,
  `sub_cat_level` int DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `cat_name` varchar(45) DEFAULT NULL,
  `sub_cat_name` varchar(45) DEFAULT NULL,
  `sub_cat_name_esp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_category`
--

LOCK TABLES `item_category` WRITE;
/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
INSERT INTO `item_category` VALUES (1,-1,0,NULL,'type','clothe','ropa'),(2,-1,0,NULL,'type','accesories','accesorios'),(3,-1,0,NULL,'type','shoes','zapatos'),(4,-1,0,NULL,'type','cosmetics','cosmeticos'),(21,1,1,1,'category','shirts','camisas'),(22,1,1,1,'category','jackets','chamarras'),(23,1,1,1,'category','lingering','lenceria'),(24,1,2,21,'subcategory','casual shirts','Camisas casuales'),(25,1,2,21,'subcategory','printed shirts','Camisas con estampa'),(26,1,2,21,'subcategory','denim shirts','Camisas de mezclill'),(27,1,2,21,'subcategory','dress shirts','Camisas de vestir'),(28,1,2,21,'subcategory','formal shirts','Camisas formales'),(29,1,2,21,'subcategory','polo shirts','Camisas tipo polo'),(30,1,2,22,'subcategory','blazers','blazers'),(31,1,2,22,'subcategory','bombers','bombers'),(32,1,2,22,'subcategory','denim jackets','chamarras de mezclilla'),(33,1,2,22,'subcategory','fur jackets','chamarras de pelo'),(34,1,2,22,'subcategory','leather jackets','chamarras de piel'),(35,1,2,22,'subcategory','down jackets','chamarras de plumas'),(36,1,2,22,'subcategory','waterproof jackets','chamarras de impermeable');
/*!40000 ALTER TABLE `item_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_color_cat`
--

DROP TABLE IF EXISTS `item_color_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_color_cat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `name_esp` varchar(45) DEFAULT NULL,
  `HEX` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_color_cat`
--

LOCK TABLES `item_color_cat` WRITE;
/*!40000 ALTER TABLE `item_color_cat` DISABLE KEYS */;
INSERT INTO `item_color_cat` VALUES (1,'Amaranth','Amaranto','#51114'),(2,'Amber','Ámbar','#FFBF00'),(3,'Amethyst','Amatista','#9966CC'),(4,'Apricot','Albaricoque','#FBCEB1'),(5,'Aquamarine','Aguamarina','#7FFFD4'),(6,'Azure','Azur','#007FFF'),(7,'Baby blue','Bebe azul','#89CFF0'),(8,'Beige','Beige','#F5F5DC'),(9,'Black','Negro','#000000'),(10,'Blue','Azul','#0000FF'),(11,'Blue-green','Azul verde','#0095B6'),(12,'Blue-violet','Violeta Azul','#8A2BE2'),(13,'Blush','Sonrojo','#DE5D83'),(14,'Bronze','Bronce','#CD7F32'),(15,'Brown','marrón','#964B00'),(16,'Burgundy','borgoña','#800020'),(17,'Byzantium','Bizancio','#702963'),(18,'Carmine','Carmín','#960018'),(19,'Cerise','Cereza','#DE3163'),(20,'Cerulean','Azul claro','#007BA7'),(21,'Champagne','champán','#F7E7CE'),(22,'Chartreuse green','Chartreuse verde','#7FFF00'),(23,'Chocolate','Chocolate','#7B3F00'),(24,'Cobalt blue','Azul cobalto','#0047AB'),(25,'Coffee','café','#6F4E37'),(26,'Copper','Cobre','#B87333'),(27,'Coral','Coral','#FF7F50'),(28,'Crimson','carmesí','#DC143C'),(29,'Cyan','Cian','#00FFFF'),(30,'Desert sand','Arena del desierto','#EDC9Af'),(31,'Electric blue','Azul eléctrico','#7DF9FF'),(32,'Emerald','Esmeralda','#50C878'),(33,'Erin','Irlanda','#00FF3F'),(34,'Gold','Oro','#FFD700'),(35,'Gray','gris','#808080'),(36,'Green','Verde','#00FF00'),(37,'Harlequin','Arlequín','#3FFF00'),(38,'Indigo','Índigo','#4B0082'),(39,'Ivory','Marfil','#FFFFF0'),(40,'Jade','Jade','#00A86B'),(41,'Jungle green','Verde de la selva','#29AB87'),(42,'Lavender','Lavanda','#B57EDC'),(43,'Lemon','Limón','#FFF700'),(44,'Lilac','Lila','#C8A2C8'),(45,'Lime','Lima','#BFFF00'),(46,'Magenta','Magenta','#FF00FF'),(47,'Magenta rose','Rosa magenta','#FF00AF'),(48,'Maroon','Granate','#800000'),(49,'Mauve','Color de malva','#E0B0FF'),(50,'Navy blue','azul marino','#000080'),(51,'Ochre','Ocre','#CC7722'),(52,'Olive','Aceituna','#808000'),(53,'Orange','naranja','#FF6600'),(54,'Orange-red','Rojo naranja','#FF4500'),(55,'Orchid','Orquídea','#DA70D6'),(56,'Peach','melocotón','#FFE5B4'),(57,'Pear','Pera','#D1E231'),(58,'Periwinkle','Bígaro','#CCCCFF'),(59,'Persian blue','Azul persa','#1C39BB'),(60,'Pink','Rosado','#FD6C9E'),(61,'Plum','ciruela','#8E4585'),(62,'Prussian blue','azul de Prusia','#003153'),(63,'Puce','Pardo rojizo','#CC8899'),(64,'Purple','Púrpura','#800080'),(65,'Raspberry','Frambuesa','#E30B5C'),(66,'Red','rojo','#FF0000'),(67,'Red-violet','Rojo violáceo','#C71585'),(68,'Rose','Rosa','#FF007F'),(69,'Ruby','Rubí','#E0115F'),(70,'Salmon','Salmón','#FA8072'),(71,'Sangria','Sangría','#92000A'),(72,'Sapphire','Zafiro','#0F52BA'),(73,'Scarlet','Escarlata','#FF2400'),(74,'Silver','Plata','#C0C0C0'),(75,'Slate gray','Gris pizarra','#708090'),(76,'Spring bud','Brote de primavera','#A7FC00'),(77,'Spring green','Primavera verde','#00FF7F'),(78,'Tan','Bronceado','#D2B48C'),(79,'Taupe','Gris pardo','#483C32'),(80,'Teal','Verde azulado','#008080'),(81,'Turquoise','Turquesa','#40E0D0'),(82,'Ultramarine','Ultramarino','#3F00FF'),(83,'Violet','Violeta','#7F00FF'),(84,'Viridian','Viridiano','#40826D'),(85,'White','Blanco','#FFFFFF'),(86,'Yellow','Amarillo','#FFFF00');
/*!40000 ALTER TABLE `item_color_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_comments`
--

DROP TABLE IF EXISTS `item_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `item_id` int DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id`),
  KEY `user_comment_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_comments`
--

LOCK TABLES `item_comments` WRITE;
/*!40000 ALTER TABLE `item_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_img_urls`
--

DROP TABLE IF EXISTS `item_img_urls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_img_urls` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `img_url` text,
  `img_server` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_img_urls`
--

LOCK TABLES `item_img_urls` WRITE;
/*!40000 ALTER TABLE `item_img_urls` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_img_urls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_size_cat`
--

DROP TABLE IF EXISTS `item_size_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_size_cat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_type_id` varchar(45) DEFAULT NULL,
  `size_mx` varchar(45) DEFAULT NULL,
  `size_us` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_size_cat`
--

LOCK TABLES `item_size_cat` WRITE;
/*!40000 ALTER TABLE `item_size_cat` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_size_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_status_cat`
--

DROP TABLE IF EXISTS `item_status_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_status_cat` (
  `id` int NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_status_cat`
--

LOCK TABLES `item_status_cat` WRITE;
/*!40000 ALTER TABLE `item_status_cat` DISABLE KEYS */;
INSERT INTO `item_status_cat` VALUES (-1,'returned'),(1,'on_sale'),(2,'saled');
/*!40000 ALTER TABLE `item_status_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_transaction`
--

DROP TABLE IF EXISTS `item_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `user_vendor_id` int DEFAULT NULL,
  `user_buyer_id` int DEFAULT NULL,
  `transaction_status` varchar(45) DEFAULT NULL,
  `buyer_address_id` int DEFAULT NULL,
  `vendor_address_id` int DEFAULT NULL,
  `payment_method` varchar(45) DEFAULT NULL,
  `total_payment` varchar(45) DEFAULT NULL,
  `tracking_number` varchar(255) DEFAULT NULL,
  `rate` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_vendor_id_idx` (`user_vendor_id`),
  KEY `user_buyer_id_idx` (`user_buyer_id`),
  CONSTRAINT `user_buyer_transaction_id` FOREIGN KEY (`user_buyer_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_vendor_transaction_id` FOREIGN KEY (`user_vendor_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_transaction`
--

LOCK TABLES `item_transaction` WRITE;
/*!40000 ALTER TABLE `item_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_transaction_history`
--

DROP TABLE IF EXISTS `item_transaction_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_transaction_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `transaction_id` int DEFAULT NULL,
  `action` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `transaction_id_idx_idx` (`transaction_id`),
  CONSTRAINT `transaction_id_idx` FOREIGN KEY (`transaction_id`) REFERENCES `item_transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_transaction_history`
--

LOCK TABLES `item_transaction_history` WRITE;
/*!40000 ALTER TABLE `item_transaction_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_transaction_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_type_cat`
--

DROP TABLE IF EXISTS `item_type_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_type_cat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_type_cat`
--

LOCK TABLES `item_type_cat` WRITE;
/*!40000 ALTER TABLE `item_type_cat` DISABLE KEYS */;
INSERT INTO `item_type_cat` VALUES (1,'clothe'),(2,'accesories'),(3,'shoes'),(4,'cosmetics');
/*!40000 ALTER TABLE `item_type_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_profile_img` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tania Romero','lorero@voguish.com','123456789','2020-06-18 01:27:42','image.png'),(2,'Rodrigo Mirazo','rodrigomirazo@voguish.com','123456789','2020-06-18 01:27:42','image.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastnames` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `int_number` varchar(45) DEFAULT NULL,
  `ext_number` varchar(45) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `suburb` varchar(45) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_balance_history`
--

DROP TABLE IF EXISTS `user_balance_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_balance_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `transaction_id` int DEFAULT NULL,
  `total_payment` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_balance_id_idx` (`user_id`),
  KEY `transaction_history_id_idx_idx` (`transaction_id`),
  CONSTRAINT `transaction_history_id_idx` FOREIGN KEY (`transaction_id`) REFERENCES `item_transaction` (`id`),
  CONSTRAINT `user_balance_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_balance_history`
--

LOCK TABLES `user_balance_history` WRITE;
/*!40000 ALTER TABLE `user_balance_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_balance_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rate_history`
--

DROP TABLE IF EXISTS `user_rate_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_rate_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `transaction_id` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_rate_id_idx` (`user_id`),
  CONSTRAINT `user_rate_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rate_history`
--

LOCK TABLES `user_rate_history` WRITE;
/*!40000 ALTER TABLE `user_rate_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_rate_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-27 23:01:30
