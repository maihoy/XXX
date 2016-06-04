CREATE TABLE `USER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `email` varchar(45) COLLATE utf8_bin NOT NULL,
  `state` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `VSAdb`.`USER`
(`id`,`password`,`first_name`,`last_name`,`email`,`state`)
VALUES('1', '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam', 'Smith', 'samy@xyz.com', 'Active');
