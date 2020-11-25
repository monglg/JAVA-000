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
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
  unique `no_uniq_indx` USING btree (`no`),
  unique `phone_uniq_indx` USING btree (`bind_phone`),
  unique `mail_uniq_indx` USING btree (`bind_mail`),
  unique `login_uniq_indx` USING btree (`login_name`)
) COMMENT = "用户信息表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


CREATE TABLE if not exists `shipping_address` (
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
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "配送地址表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"


 CREATE TABLE if not exists `shipping_address_tag` (
  `id` int (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `no` varchar (64) NOT NULL COMMENT DEFAULT '' '标签id',
  `user_no` varchar (64) NOT NULL COMMENT DEFAULT '' '用户id',
  `tag_name` varchar (16) NOT NULL DEFAULT '' COMMENT '标签名称',
  `tag_type` tinyint (2) NOT NULL DEFAULT 0 COMMENT '类型，0， 系统， 1 自建',
  `status` tinyint (2) NOT NULL DEFAULT 0 COMMENT '数据状态，0 正常 ，1 删除',
  PRIMARY KEY (`id`)
) COMMENT = "配送地址标签表" ENGINE = innodb DEFAULT CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci"
