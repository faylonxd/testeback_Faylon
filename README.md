Programa realizado em java e banco de dados Mysql, abaixo segue o script do BD:


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



CREATE SCHEMA IF NOT EXISTS `dbclientes` DEFAULT CHARACTER SET utf8 ;
USE `dbclientes` ;

-- -----------------------------------------------------
-- Table `dbclientes`.`tb_clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbclientes`.`tb_clientes` (
  `id_customer` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf_cnpj` VARCHAR(45) NULL DEFAULT NULL,
  `nm_customer` VARCHAR(45) NULL DEFAULT NULL,
  `is_active` TINYINT(1) NULL DEFAULT NULL,
  `vl_total` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id_customer`))
ENGINE = InnoDB
AUTO_INCREMENT = 1509
DEFAULT CHARACTER SET = utf8
COMMENT = '	';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
