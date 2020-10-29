CREATE TABLE `order` (
  `order_id` varchar(32) NOT NULL COMMENT '订单id',
  `product_id` varchar(32) DEFAULT NULL COMMENT '商品id',
  `product_num` int(4) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `storage` (
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `storage` int(8) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;