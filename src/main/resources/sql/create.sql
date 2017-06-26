CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '书名',
  `promontion` varchar(255) DEFAULT NULL COMMENT '促销语',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `publish` varchar(255) DEFAULT NULL COMMENT '出版社',
  `price` varchar(255) DEFAULT NULL COMMENT '价格',
  `brief` varchar(255) DEFAULT NULL COMMENT '简介',
  `author_brief` varchar(255) DEFAULT NULL,
  `catalog` varchar(255) DEFAULT NULL COMMENT '目录',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`ISBN`),
  KEY `quick` (`ISBN`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8