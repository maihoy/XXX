CREATE TABLE `COMMENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(500) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

ALTER TABLE `VSAdb`.`COMMENT`
ADD COLUMN `date` DATE NOT NULL AFTER `text`,
ADD COLUMN `creator` INT NOT NULL AFTER `date`,
ADD INDEX `fk_COMMENT_1_idx` (`creator` ASC);
ALTER TABLE `VSAdb`.`COMMENT`
ADD CONSTRAINT `fk_COMMENT_1`
  FOREIGN KEY (`creator`)
  REFERENCES `VSAdb`.`USER` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
