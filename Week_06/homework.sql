CREATE TABLE if not exists `user_acount` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `no` varchar (64) NOT NULL COMMENT DEFAULT '' '用户编码',
  `real_name` varchar (32) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `nick_name` varchar (64) NOT NULL DEFAULT '' COMMENT '昵称',
  `login_name` varchar (32) NOT NULL DEFAULT '' COMMENT '登陆名',
  `password` varchar (64) NOT NULL DEFAULT '' COMMENT '密码（撒盐）',
  `remark` varchar (128) NOT NULL DEFAULT '' COMMENT '备注',
  `gender` tinyint (2) NOT NULL DEFAULT 0 COMMENT '性别 0，未知， 1 男 2 女 3 保密',
  `bind_phone` varchar (64) NOT NULL DEFAULT '' COMMENT '绑定手机号（脱敏处理）',
  `bind_mail` varchar (64) NOT NULL DEFAULT '' COMMENT '绑定邮箱（脱敏处理）',
  `id_no` varchar (32) NOT NULL DEFAULT '' COMMENT '身份证号（脱敏处理）',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
  unique `no_uniq_indx` USING btree (`no`),
  unique `phone_uniq_indx` USING btree (`bind_phone`),
  unique `mail_uniq_indx` USING btree (`bind_mail`),
  unique `login_uniq_indx` USING btree (`login_name`)
) COMMENT = "用户信息表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


CREATE TABLE if not exists `user_shipping_address` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `no` varchar (64) NOT NULL COMMENT DEFAULT '' '地址ID',
  `user_no` varchar (64) NOT NULL COMMENT DEFAULT '' '用户id',
  `receiver_name` varchar (32) NOT NULL DEFAULT '' COMMENT '收件人',
  `phone_area_code_type` varchar (16) NOT NULL DEFAULT '+86' COMMENT '手机区号',
  `receiver_phone` varchar (64) NOT NULL DEFAULT '' COMMENT '收件人手机 （脱敏处理）',
  `region_code` varchar (8) NOT NULL DEFAULT '' COMMENT '地区码',
  `province_code` varchar (8) NOT NULL DEFAULT '' COMMENT '省',
  `city_code` varchar (8) NOT NULL DEFAULT '' COMMENT '市',
  `region_name` varchar (128) NOT NULL DEFAULT '' COMMENT '区域名称',
  `address` varchar (128) NOT NULL DEFAULT '' COMMENT '详细地址',
  `address_status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '地址状态，0， 正常， 1 删除',
  `default_use` tinyint (2) NOT NULL DEFAULT 0 COMMENT '默认使用，0， 非默认， 1 默认',
  `address_tag_id` varchar (64) NOT NULL DEFAULT '' COMMENT '地址标签ID',
  `address_version` int (20) NOT NULL DEFAULT 0 COMMENT '版本',
  `address_available` tinyint (2) NOT NULL DEFAULT 0 COMMENT '是否可用，标注当前可用版本',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "配送地址表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"



 CREATE TABLE if not exists `user_shipping_address_tag` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `no` varchar (64) NOT NULL COMMENT DEFAULT '' '标签id',
  `user_no` varchar (64) NOT NULL COMMENT DEFAULT '' '用户id',
  `tag_name` varchar (16) NOT NULL DEFAULT '' COMMENT '标签名称',
  `tag_type` tinyint (2) NOT NULL DEFAULT 0 COMMENT '类型，0， 系统， 1 自建',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "配送地址标签表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


CREATE TABLE if not exists `goods_wares_category` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `category_code` varchar (64) NOT NULL COMMENT DEFAULT '' '编码',
  `parent_id` int (20) NOT NULL COMMENT DEFAULT 0 '父类型id',
  `category_name` varchar (64) NOT NULL COMMENT DEFAULT '' '分类名称',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT = "商品分类表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


CREATE TABLE if not exists `goods_wares_info` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `wares_no` varchar (64) NOT NULL COMMENT DEFAULT '' '商品编码',
  `wares_simple_name` varchar (128) NOT NULL COMMENT DEFAULT '' '商品名称简称',
  `wares_name` varchar (128) NOT NULL COMMENT DEFAULT '' '商品名称',
  `wares_version` int (20) NOT NULL DEFAULT 0 COMMENT '版本',
  `wares_available` tinyint (2) NOT NULL DEFAULT 0 COMMENT '是否可用，标注当前可用版本',
  `category_category` int (20) NOT NULL COMMENT DEFAULT 0 '类别id',
  `wares_describe` varchar (512) NOT NULL COMMENT DEFAULT '' '商品描述',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "商品表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


CREATE TABLE if not exists `goods_wares_image` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `wares_id` int (20) NOT NULL COMMENT DEFAULT 0 '商品id',
  `path` varchar (128) NOT NULL COMMENT DEFAULT '' '地址',
  `cdnName` varchar (128) NOT NULL COMMENT DEFAULT '' 'cdn地址',
  `image_type` int (20) NOT NULL COMMENT DEFAULT 0 '图片类型',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "商品图片表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"

CREATE TABLE if not exists `order_info` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_no` varchar (64) NOT NULL COMMENT DEFAULT '' '订单编号',
  `customer_id` varchar (64) NOT NULL COMMENT DEFAULT '' '顾客编号',
  `shipping_address_id` int (20) NOT NULL COMMENT DEFAULT 0 '地址id',
  `order_status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '订单状态',
  `pay_info_no` varchar (64) NOT NULL DEFAULT '' COMMENT '支付订单号',
  `logistics_info_no` varchar (64) NOT NULL DEFAULT '' COMMENT '物流订单单号',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `total_price` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '订单价格',
  `actual_price` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '实付价格',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "订单信息" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


CREATE TABLE if not exists `order_wares_relation` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_no` varchar (64) NOT NULL COMMENT DEFAULT '' '订单编号',
  `wares_id` int (20) NOT NULL COMMENT DEFAULT 0 '商品id',
  `wares_quantity` int (8) NOT NULL DEFAULT 0 COMMENT '数量',
  `single_price` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '单价',
  `actual_single_price` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '实付单价价格',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` datetime NOT NULL  COMMENT '修改时间',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "订单与商品关联表信息" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"

