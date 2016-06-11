CREATE TABLE `ACTION` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `code` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `VSAdb`.`ACTION`(`id`,`name`,`code`)
VALUES('1', 'Serve', 'SERVE');
INSERT INTO `VSAdb`.`ACTION`(`id`,`name`,`code`)
VALUES('2', 'Reception', 'RECEPTION');
INSERT INTO `VSAdb`.`ACTION`(`id`,`name`,`code`)
VALUES('3', 'Attack', 'ATTACK');
INSERT INTO `VSAdb`.`ACTION`(`id`,`name`,`code`)
VALUES('4', 'Block', 'BLOCK');
INSERT INTO `VSAdb`.`ACTION`(`id`,`name`,`code`)
VALUES('5', 'Pass', 'PASS');





