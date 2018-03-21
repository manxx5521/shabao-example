/*
Navicat MySQL Data Transfer

Source Server         : aliyun-master
Source Server Version : 50721
Source Host           : 47.91.220.42:3306
Source Database       : shabao_example

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-02 14:25:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test_demo
-- ----------------------------
DROP TABLE IF EXISTS `test_demo`;
CREATE TABLE `test_demo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1025 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_demo
-- ----------------------------
INSERT INTO `test_demo` VALUES ('1001', '张三');
INSERT INTO `test_demo` VALUES ('1002', '王二');
INSERT INTO `test_demo` VALUES ('1003', '李四');
