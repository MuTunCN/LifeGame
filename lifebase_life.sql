CREATE DATABASE  IF NOT EXISTS `lifebase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lifebase`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: lifebase
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `life`
--

DROP TABLE IF EXISTS `life`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `life` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `content` varchar(100) DEFAULT NULL,
  `shortcon` varchar(10) NOT NULL,
  `title` varchar(10) NOT NULL,
  `attr` varchar(10) NOT NULL,
  `buff` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `life`
--

LOCK TABLES `life` WRITE;
/*!40000 ALTER TABLE `life` DISABLE KEYS */;
INSERT INTO `life` VALUES (27,0,'出生在一个厨师家庭，老爸是做快餐的，老妈是卖牛杂的。','厨师家庭','厨师家庭','出生',''),(29,0,'出生的时候把在场的人都吓了一跳。脸部像素非常低，像在脸上打了马赛克一样。','悲惨','天生打码','出生','\0'),(30,0,'用力把葫芦撑破，来到了这个世界。一出生，就会说话，会走路。并机智冷静','葫芦','葫芦娃','出生',''),(31,3,'喜欢玩平板电脑','爱玩平板','幼儿日常','日常','\0'),(32,3,'闯祸了被人追着打的时候，突然学会了走路','学走路','学会走路','日常','\0'),(33,3,'的智力似乎比平均值低。','智商感人','智商捉急','自身','\0'),(34,6,'但是打错了电话，打给了国家主席。但是机智地向主席问了声好。然后挂掉了电话。','与主席通话','与主席通话','日常',''),(35,6,'对现在的教育体系非常不满，然而并没有卵用，只会让成绩越来越差。','不满教育','不满教育','日常','\0'),(36,6,'做广播体操的姿势非常标准，被国家体操协会邀请去做《第一套广播体操》的视频录像','会做操','操帝','日常',''),(37,9,'总是能在试题中蒙中正确答案','精于蒙题','蒙题大师','日常',''),(38,9,'被打劫了，撒地方很淡定地用他的口才说服了强盗。强盗哭着跑去派出所自首。','被打劫','口才感人','日常',''),(39,9,'在一次语文考试的作文题上写了一篇议论文《不好好复习全人类灭亡》','写作文','被毒害的一代','日常','\0'),(40,12,'在上物理课的时候突发奇想使用正常教学器械制造了一台F1赛车','造汽车','乱点天赋点','日常',''),(41,12,'玩网络游戏的时候，有个队友跳出来喷他玩得太菜了，完全不予理会，显得非常有逼格。','素质游戏','素质游戏','日常',''),(42,12,'与女同学一起模仿吸氧羊情节，女同学用平底锅打他的头。当场昏迷送院不治身亡','智商','喜羊羊','die','\0'),(51,15,'电脑修得好，但从来不过夜','爱修电脑','孤独一生','日常','\0'),(52,15,'是个喷子，他经常发表谴责待遇不公的言论。','爱喷人','喷子','日常','\0'),(53,15,'因为沉迷网络游戏，终于被送进了陶教授的电教育机构治疗。鹅在押送的过程中，尝试逃跑，被看守的比卡丘释放十万伏特击中，鹅被电成了黑炭，瞬间死去。','谋杀','天劫','die','\0'),(54,18,'日韩剧严重中毒','日韩流受害者','日韩流受害者','日常','\0'),(55,18,'煮饭把洁厕剂当成了料酒，倒进了锅里炒。吃了之后中毒身亡。。','自杀','瞎了','die','\0'),(56,21,'在学校中与舍友发生了一点口角。他的舍友似乎积怨很深，往宿舍的饮水机内投毒，体会喝了毒水后，立马倒地休克。体会被第一时间送去了医院洗胃，但是毒素已经被身体吸收，回力无天。','谋杀','要加薪','die','\0');
/*!40000 ALTER TABLE `life` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-27  9:01:24
