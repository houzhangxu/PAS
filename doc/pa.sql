# Host: 127.0.0.1  (Version: 5.5.5-10.1.13-MariaDB)
# Date: 2017-01-02 23:52:34
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(18) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `status` int(11) NOT NULL DEFAULT '0',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Data for table "admin"
#


#
# Structure for table "good_types"
#

DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `g_t_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `unit` varchar(255) NOT NULL DEFAULT '',
  `pid` int(11) NOT NULL DEFAULT '0',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`g_t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类型表';

#
# Data for table "good_types"
#


#
# Structure for table "goods"
#

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL DEFAULT '',
  `goods_type` int(11) NOT NULL DEFAULT '0',
  `price` float NOT NULL DEFAULT '0',
  `total` float NOT NULL DEFAULT '0',
  `creator` int(11) NOT NULL DEFAULT '0',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

#
# Data for table "goods"
#


#
# Structure for table "order_detail"
#

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `o_d_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` int(11) NOT NULL DEFAULT '0',
  `t_id` int(11) DEFAULT '0',
  `pay_method` int(11) DEFAULT '0',
  PRIMARY KEY (`o_d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

#
# Data for table "order_detail"
#


#
# Structure for table "order_goods"
#

DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `o_g_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` int(11) NOT NULL DEFAULT '0',
  `g_id` int(11) NOT NULL DEFAULT '0',
  `discount` float NOT NULL DEFAULT '0',
  `total` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`o_g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品表';

#
# Data for table "order_goods"
#


#
# Structure for table "orders"
#

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

#
# Data for table "orders"
#


#
# Structure for table "pay_method"
#

DROP TABLE IF EXISTS `pay_method`;
CREATE TABLE `pay_method` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_name` varchar(255) NOT NULL DEFAULT '',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付方式)';

#
# Data for table "pay_method"
#


#
# Structure for table "shopping_cart"
#

DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `s_c_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) NOT NULL DEFAULT '0',
  `u_id` int(11) NOT NULL DEFAULT '0',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`s_c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

#
# Data for table "shopping_cart"
#


#
# Structure for table "users"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(18) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `status` int(11) NOT NULL DEFAULT '0',
  `create_time` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "users"
#

