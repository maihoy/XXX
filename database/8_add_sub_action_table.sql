CREATE TABLE `SUB_ACTION` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `code` varchar(45) COLLATE utf8_bin NOT NULL,
  `action` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ACTON_KEY_idx` (`action`),
  CONSTRAINT `ACTON_KEY` FOREIGN KEY (`action`) REFERENCES `ACTION` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `VSAdb`.`SUB_ACTION`(`id`,`name`,`code`,`action`)
VALUES('1', 'Serve SubAction', 'SERVE_SUB_ACTION', '1');
INSERT INTO `VSAdb`.`SUB_ACTION`(`id`,`name`,`code`,`action`)
VALUES('2', 'Reception SubAction', 'RECEPTION_SUB_ACTION', '2');
INSERT INTO `VSAdb`.`SUB_ACTION`(`id`,`name`,`code`,`action`)
VALUES('3', 'Attack SubAction', 'ATTACK_SUB_ACTION', '3');
INSERT INTO `VSAdb`.`SUB_ACTION`(`id`,`name`,`code`,`action`)
VALUES('4', 'Block SubAction', 'BLOCK_SUB_ACTION', '4');
INSERT INTO `VSAdb`.`SUB_ACTION`(`id`,`name`,`code`,`action`)
VALUES('5', 'Pass SubAction', 'PASS_SUB_ACTION', '5');





