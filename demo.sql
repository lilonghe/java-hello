CREATE SCHEMA `java-demo` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `java-demo`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `description` TEXT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` DATETIME NULL,
  PRIMARY KEY (`id`));


INSERT INTO `java-demo`.`product` (`name`) VALUES ('C1');
INSERT INTO `java-demo`.`product` (`name`) VALUES ('C2');

CREATE TABLE `java-demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(245) NULL,
  `password` VARCHAR(245) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

INSERT INTO `java-demo`.`user` (`id`, `username`, `password`) VALUES ('1', 'lilonghe', 'E10ADC3949BA59ABBE56E057F20F883E');

