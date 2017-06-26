/*
 Navicat Premium Data Transfer

 Source Server         : locahost
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : localhost
 Source Database       : emptystudy

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : utf-8

 Date: 06/26/2017 21:48:46 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '书名',
  `image` varchar(255) NOT NULL COMMENT '图片地址',
  `promontion` varchar(255) DEFAULT NULL COMMENT '促销语',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `publisher` varchar(255) DEFAULT NULL COMMENT '出版社',
  `price` varchar(255) DEFAULT NULL COMMENT '价格',
  `brief` longtext COMMENT '内容简介',
  `author_brief` longtext COMMENT '作者简介',
  `catalog` longtext COMMENT '目录',
  `digest` longtext COMMENT '书摘',
  `url` varchar(255) DEFAULT NULL COMMENT '源网页',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `validate` int(4) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ISBN` (`ISBN`),
  KEY `quick` (`ISBN`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2605 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
