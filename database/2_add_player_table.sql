CREATE TABLE `VSAdb`.`PLAYER` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `surname` VARCHAR(150) NOT NULL,
  `team` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `team`
    FOREIGN KEY (`id`)
    REFERENCES `VSAdb`.`TEAM` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);