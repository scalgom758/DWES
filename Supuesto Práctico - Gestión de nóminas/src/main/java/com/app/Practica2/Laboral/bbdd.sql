//Creación de tabla empleados
CREATE TABLE `empleados` (
	`nombre` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`dni` CHAR(9) NOT NULL COLLATE 'latin1_swedish_ci',
	`sexo` CHAR(1) NOT NULL COLLATE 'latin1_swedish_ci',
	`categoria` INT(11) NULL DEFAULT '1',
	`anyos` INT(11) NULL DEFAULT '0',
	`sueldo` INT(11) NULL DEFAULT '0',
	PRIMARY KEY (`dni`) USING BTREE,
	INDEX `FK_categoria` (`categoria`) USING BTREE,
	CONSTRAINT `FK_categoria` FOREIGN KEY (`categoria`) REFERENCES `nominas` (`categoria`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

insert into empleados values("James Cosling", "32000032G", 'M', 9, 7, 245000);
insert into empleados values("Ada Lovelace", "32000031R", 'F', 1, 1, 55000);


//Creación de tabla nóminas

CREATE TABLE `nominas` (
	`sueldo` INT(11) NOT NULL,
	`categoria` INT(11) NOT NULL,
	PRIMARY KEY (`categoria`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;


INSERT INTO nominas VALUES(50000, 1);
INSERT INTO nominas VALUES(70000, 2);
INSERT INTO nominas VALUES(90000, 3);
INSERT INTO nominas VALUES(110000, 4);
INSERT INTO nominas VALUES(130000, 5);
INSERT INTO nominas VALUES(150000, 6);
INSERT INTO nominas VALUES(170000, 7);
INSERT INTO nominas VALUES(190000, 8);
INSERT INTO nominas VALUES(210000, 9);
INSERT INTO nominas VALUES(230000, 10);