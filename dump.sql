-- MySQL Script generated by MySQL Workbench
-- ср, 20-сер-2014 23:30:45 +0300
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PhotoLibrary
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PhotoLibrary`
  DEFAULT CHARACTER SET utf8;
USE `PhotoLibrary`;

-- -----------------------------------------------------
-- Table `PhotoLibrary`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PhotoLibrary`.`Users` (
  `user_id` INT         NOT NULL AUTO_INCREMENT,
  `email`   VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`)
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoLibrary`.`Passwords`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PhotoLibrary`.`Passwords` (
  `user_id`  INT         NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_Passwords_1`
  FOREIGN KEY (`user_id`)
  REFERENCES `PhotoLibrary`.`Users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoLibrary`.`Photos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PhotoLibrary`.`Photos` (
  `photo_id` INT          NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(45)  NOT NULL,
  `source`   VARCHAR(250) NOT NULL,
  PRIMARY KEY (`photo_id`)
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `PhotoLibrary`.`Users_Roles`
-- -----------------------------------------------------

CREATE TABLE `Users_Roles` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`),
  CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `Roles` (`role_id`)
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `PhotoLibrary`.`Roles`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `PhotoLibrary`.`Roles` (
  `role_id` INT         NOT NULL AUTO_INCREMENT,
  `role`    VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`)
)
  ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `PhotoLibrary`.`Passwords`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PhotoLibrary`.`Comments` (
  `comment_id` INT          NOT NULL,
  `photo_id`   INT          NOT NULL,
  `comment`    VARCHAR(500) NOT NULL,
  PRIMARY KEY (`comment_id`),
  CONSTRAINT `fk_Comments_1`
  FOREIGN KEY (`photo_id`)
  REFERENCES `PhotoLibrary`.`Photos` (`photo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DELIMITER $$

DROP PROCEDURE IF EXISTS `PhotoLibrary`.`getEmail` $$
CREATE PROCEDURE `PhotoLibrary`.`getEmail`
  (IN USR_ID INT, OUT EM VARCHAR(255))
  BEGIN
    SELECT email INTO EM
    FROM Users
    WHERE user_id = USR_ID;
  END $$

DELIMITER ;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
