-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema escuela
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema escuela
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `escuela` DEFAULT CHARACTER SET utf8 ;
USE `escuela` ;

-- -----------------------------------------------------
-- Table `escuela`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `nombreCalle` VARCHAR(45) NOT NULL,
  `numeroCalle` INT NOT NULL,
  PRIMARY KEY (`idDireccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Grado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Grado` (
  `idGrado` INT NOT NULL AUTO_INCREMENT,
  `division` VARCHAR(45) NOT NULL,
  `anio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGrado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Estudiantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Estudiantes` (
  `idEstudiantes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(32) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `correo_electronico` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `dni` INT NOT NULL,
  `Nota_idNota` INT NOT NULL,
  `Direccion_idDireccion` INT NOT NULL,
  `Grado_idGrado` INT NOT NULL,
  PRIMARY KEY (`idEstudiantes`),
  INDEX `fk_Estudiantes_Direccion1_idx` (`Direccion_idDireccion` ASC) VISIBLE,
  INDEX `fk_Estudiantes_Grado1_idx` (`Grado_idGrado` ASC) VISIBLE,
  CONSTRAINT `fk_Estudiantes_Direccion1`
    FOREIGN KEY (`Direccion_idDireccion`)
    REFERENCES `escuela`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estudiantes_Grado1`
    FOREIGN KEY (`Grado_idGrado`)
    REFERENCES `escuela`.`Grado` (`idGrado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `escuela`.`Sueldo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Sueldo` (
  `idSueldo` INT NOT NULL AUTO_INCREMENT,
  `salario` FLOAT NOT NULL,
  PRIMARY KEY (`idSueldo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Profesores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Profesores` (
  `idProfesores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo_electronico` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `telefono` INT NOT NULL,
  `Sueldo_idSueldo` INT NOT NULL,
  `Direccion_idDireccion` INT NOT NULL,
  PRIMARY KEY (`idProfesores`),
  INDEX `fk_Profesores_Sueldo1_idx` (`Sueldo_idSueldo` ASC) VISIBLE,
  INDEX `fk_Profesores_Direccion1_idx` (`Direccion_idDireccion` ASC) VISIBLE,
  CONSTRAINT `fk_Profesores_Sueldo1`
    FOREIGN KEY (`Sueldo_idSueldo`)
    REFERENCES `escuela`.`Sueldo` (`idSueldo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesores_Direccion1`
    FOREIGN KEY (`Direccion_idDireccion`)
    REFERENCES `escuela`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Cargo` (
  `idCargo` INT NOT NULL AUTO_INCREMENT,
  `nombre_cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Personal` (
  `id_personal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo_electronico` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `Cargo_idCrago` INT NOT NULL,
  `Direccion_idDireccion` INT NOT NULL,
  `Sueldo_idSueldo` INT NOT NULL,
  PRIMARY KEY (`id_personal`),
  INDEX `fk_Empleado_administrativo_Cargo1_idx` (`Cargo_idCrago` ASC) VISIBLE,
  INDEX `fk_Empleado_administrativo_Direccion1_idx` (`Direccion_idDireccion` ASC) VISIBLE,
  INDEX `fk_Personal_Sueldo1_idx` (`Sueldo_idSueldo` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_administrativo_Cargo1`
    FOREIGN KEY (`Cargo_idCrago`)
    REFERENCES `escuela`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_administrativo_Direccion1`
    FOREIGN KEY (`Direccion_idDireccion`)
    REFERENCES `escuela`.`Direccion` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Personal_Sueldo1`
    FOREIGN KEY (`Sueldo_idSueldo`)
    REFERENCES `escuela`.`Sueldo` (`idSueldo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Aula` (
  `idAula` INT NOT NULL AUTO_INCREMENT,
  `capacidad` INT NOT NULL,
  PRIMARY KEY (`idAula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `Profesores_idProfesores` INT NOT NULL,
  `Grado_idGrado` INT NOT NULL,
  `Aula_id_Aula` INT NOT NULL,
  PRIMARY KEY (`idMateria`),
  INDEX `fk_Materia_Profesores1_idx` (`Profesores_idProfesores` ASC) VISIBLE,
  INDEX `fk_Materia_Grado1_idx` (`Grado_idGrado` ASC) VISIBLE,
  INDEX `fk_Materia_Aula1_idx` (`Aula_id_Aula` ASC) VISIBLE,
  CONSTRAINT `fk_Materia_Profesores1`
    FOREIGN KEY (`Profesores_idProfesores`)
    REFERENCES `escuela`.`Profesores` (`idProfesores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materia_Grado1`
    FOREIGN KEY (`Grado_idGrado`)
    REFERENCES `escuela`.`Grado` (`idGrado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materia_Aula1`
    FOREIGN KEY (`Aula_id_Aula`)
    REFERENCES `escuela`.`Aula` (`idAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Matricula` (
  `idMatricula` INT NOT NULL AUTO_INCREMENT,
  `estado_matricula` VARCHAR(45) NOT NULL,
  `Estudiantes_idEstudiantes` INT NOT NULL,
  PRIMARY KEY (`idMatricula`),
  INDEX `fk_Matricula_Estudiantes1_idx` (`Estudiantes_idEstudiantes` ASC) VISIBLE,
  CONSTRAINT `fk_Matricula_Estudiantes1`
    FOREIGN KEY (`Estudiantes_idEstudiantes`)
    REFERENCES `escuela`.`Estudiantes` (`idEstudiantes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escuela`.`Asistencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Asistencia` (
  `Materia_idMateria` INT NOT NULL,
  `idAsistencia` INT NOT NULL AUTO_INCREMENT,
  `cantidad_asistencias` VARCHAR(45) NOT NULL,
  `Estudiantes_idEstudiantes` INT NOT NULL,
  PRIMARY KEY (`idAsistencia`, `Estudiantes_idEstudiantes`, `Materia_idMateria`),
  INDEX `fk_Estudiantes_has_Materia_Materia1_idx` (`Materia_idMateria` ASC) VISIBLE,
  INDEX `fk_Asistencia_Estudiantes1_idx` (`Estudiantes_idEstudiantes` ASC) VISIBLE,
  CONSTRAINT `fk_Estudiantes_has_Materia_Materia1`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `escuela`.`Materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asistencia_Estudiantes1`
    FOREIGN KEY (`Estudiantes_idEstudiantes`)
    REFERENCES `escuela`.`Estudiantes` (`idEstudiantes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `escuela`.`Nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escuela`.`Nota` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
  `calificacion` INT NOT NULL,
  `Estudiantes_idEstudiantes` INT NOT NULL,
  `Materia_idMateria` INT NOT NULL,
  PRIMARY KEY (`idNota`, `Materia_idMateria`, `Estudiantes_idEstudiantes`),
  INDEX `fk_Nota_Estudiantes1_idx` (`Estudiantes_idEstudiantes` ASC) VISIBLE,
  INDEX `fk_Nota_Materia1_idx` (`Materia_idMateria` ASC) VISIBLE,
  CONSTRAINT `fk_Nota_Estudiantes1`
    FOREIGN KEY (`Estudiantes_idEstudiantes`)
    REFERENCES `escuela`.`Estudiantes` (`idEstudiantes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Nota_Materia1`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `escuela`.`Materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

