CREATE TABLE `USER_ROLE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `VSAdb`.`USER_ROLE`
(`id`,`type`)
VALUE ('1','ADMIN');

INSERT INTO `VSAdb`.`USER_ROLE`
(`id`,`type`)
VALUE ('2','USER');


