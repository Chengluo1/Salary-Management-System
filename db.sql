/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-06-13 14:17:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `account` varchar(90) DEFAULT NULL,
  `password` varchar(90) DEFAULT NULL,
  `type` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123456', 'admin');

-- ----------------------------
-- Table structure for allowancetable
-- ----------------------------
DROP TABLE IF EXISTS `allowancetable`;
CREATE TABLE `allowancetable` (
  `staffcode` varchar(30) DEFAULT NULL,
  `date1` varchar(30) DEFAULT NULL,
  `bonus` bigint(20) DEFAULT NULL,
  `overtimepays` bigint(20) DEFAULT NULL,
  `chargebacks` bigint(20) DEFAULT NULL,
  `fulltimewage` bigint(20) DEFAULT NULL,
  `lunchsubsidy` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of allowancetable
-- ----------------------------
INSERT INTO `allowancetable` VALUES ('st03', '2019.1', '3000', '0', '0', '0', '200');
INSERT INTO `allowancetable` VALUES ('st04', '2019.1', '3200', '0', '200', '0', '200');
INSERT INTO `allowancetable` VALUES ('st05', '2019.1', '6000', '1200', '0', '100', '200');
INSERT INTO `allowancetable` VALUES ('st06', '2019.1', '7000', '0', '0', '0', '200');
INSERT INTO `allowancetable` VALUES ('st07', '2019.1', '3000', '800', '0', '100', '200');
INSERT INTO `allowancetable` VALUES ('st08', '2019.1', '3800', '0', '0', '0', '200');
INSERT INTO `allowancetable` VALUES ('st09', '2019.1', '2000', '0', '0', '0', '200');
INSERT INTO `allowancetable` VALUES ('st03', '2019.2', '4000', '0', '0', '0', '100');
INSERT INTO `allowancetable` VALUES ('st04', '2019.2', '6000', '0', '0', '0', '0');
INSERT INTO `allowancetable` VALUES ('st05', '2019.2', '6000', '1200', '0', '0', '0');
INSERT INTO `allowancetable` VALUES ('st06', '2019.2', '6522', '0', '20', '100', '0');
INSERT INTO `allowancetable` VALUES ('st07', '2019.2', '4200', '0', '0', '0', '0');
INSERT INTO `allowancetable` VALUES ('st08', '2019.2', '4100', '0', '0', '0', '0');
INSERT INTO `allowancetable` VALUES ('st09', '2019.2', '4000', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for attendtable
-- ----------------------------
DROP TABLE IF EXISTS `attendtable`;
CREATE TABLE `attendtable` (
  `staffcode` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `normal` bigint(20) DEFAULT NULL,
  `actual` bigint(20) DEFAULT NULL,
  `overattendence` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendtable
-- ----------------------------
INSERT INTO `attendtable` VALUES ('st03', '2019.1', '21', '21', '0');
INSERT INTO `attendtable` VALUES ('st03', '2019.2', '18', '18', '4');
INSERT INTO `attendtable` VALUES ('st04', '2019.1', '21', '21', '0');
INSERT INTO `attendtable` VALUES ('st04', '2019.2', '18', '15', '0');
INSERT INTO `attendtable` VALUES ('st05', '2019.1', '21', '21', '4');
INSERT INTO `attendtable` VALUES ('st05', '2019.2', '18', '16', '0');
INSERT INTO `attendtable` VALUES ('st06', '2019.1', '21', '18', '0');
INSERT INTO `attendtable` VALUES ('st06', '2019.2', '18', '17', '1');
INSERT INTO `attendtable` VALUES ('st07', '2019.1', '21', '21', '2');
INSERT INTO `attendtable` VALUES ('st07', '2019.2', '18', '18', '0');
INSERT INTO `attendtable` VALUES ('st08', '2019.1', '21', '20', '0');
INSERT INTO `attendtable` VALUES ('st08', '2019.2', '18', '15', '0');
INSERT INTO `attendtable` VALUES ('st09', '2019.1', '21', '18', '0');
INSERT INTO `attendtable` VALUES ('st09', '2019.2', '18', '16', '0');

-- ----------------------------
-- Table structure for debittable
-- ----------------------------
DROP TABLE IF EXISTS `debittable`;
CREATE TABLE `debittable` (
  `staffcode` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `common` bigint(20) DEFAULT NULL,
  `insurance` bigint(20) DEFAULT NULL,
  `taxation` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of debittable
-- ----------------------------
INSERT INTO `debittable` VALUES ('st03', '2019.1', '650', '624', '6');
INSERT INTO `debittable` VALUES ('st03', '2019.2', '787', '756', '39');
INSERT INTO `debittable` VALUES ('st04', '2019.1', '675', '648', '12');
INSERT INTO `debittable` VALUES ('st04', '2019.2', '1025', '984', '96');
INSERT INTO `debittable` VALUES ('st05', '2019.1', '1212', '1164', '141');
INSERT INTO `debittable` VALUES ('st05', '2019.2', '1212', '1164', '141');
INSERT INTO `debittable` VALUES ('st06', '2019.1', '1187', '1140', '135');
INSERT INTO `debittable` VALUES ('st06', '2019.2', '1138', '1092', '123');
INSERT INTO `debittable` VALUES ('st07', '2019.1', '750', '720', '30');
INSERT INTO `debittable` VALUES ('st07', '2019.2', '800', '768', '42');
INSERT INTO `debittable` VALUES ('st08', '2019.1', '750', '720', '30');
INSERT INTO `debittable` VALUES ('st08', '2019.2', '787', '756', '39');
INSERT INTO `debittable` VALUES ('st09', '2019.1', '500', '480', '0');
INSERT INTO `debittable` VALUES ('st09', '2019.2', '762', '732', '33');

-- ----------------------------
-- Table structure for dptable
-- ----------------------------
DROP TABLE IF EXISTS `dptable`;
CREATE TABLE `dptable` (
  `dpcode` varchar(30) DEFAULT NULL,
  `dpname` varchar(30) DEFAULT NULL,
  `dpleastwage` bigint(20) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  KEY `dpname` (`dpname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dptable
-- ----------------------------
INSERT INTO `dptable` VALUES ('dp03', '开发部', '2500', '2');
INSERT INTO `dptable` VALUES ('dp04', '测试部', '2200', '2');

-- ----------------------------
-- Table structure for stafftable
-- ----------------------------
DROP TABLE IF EXISTS `stafftable`;
CREATE TABLE `stafftable` (
  `code` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  `age` bigint(20) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `staff_dp` (`department`),
  CONSTRAINT `stafftable_ibfk_1` FOREIGN KEY (`department`) REFERENCES `dptable` (`dpname`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stafftable
-- ----------------------------
INSERT INTO `stafftable` VALUES ('st03', '王五', null, '36', '女', '江苏');
INSERT INTO `stafftable` VALUES ('st04', '陈六', null, '29', '女', '江西');
INSERT INTO `stafftable` VALUES ('st05', '钱七', '开发部', '31', '男', '广东');
INSERT INTO `stafftable` VALUES ('st06', '孙八', '开发部', '26', '男', '上海');
INSERT INTO `stafftable` VALUES ('st07', '郑九', '测试部', '23', '女', '浙江');
DROP TRIGGER IF EXISTS `del_code`;
DELIMITER ;;
CREATE TRIGGER `del_code` AFTER DELETE ON `stafftable` FOR EACH ROW BEGIN
DELETE FROM allowancetable WHERE allowancetable.`staffcode`=OLD.code;
DELETE FROM attendtable WHERE attendtable.`staffcode`=OLD.code;
DELETE FROM debittable WHERE debittable.`staffcode`=OLD.code;
END
;;
DELIMITER ;
