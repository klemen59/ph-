CREATE SCHEMA `bdd` ;

CREATE TABLE `bdd`.`patient` (
  `pId` INT NOT NULL,
  `nom` VARCHAR(30) NOT NULL,
  `prenom` VARCHAR(30) NOT NULL,
  `date_naissance` DATE NOT NULL,
  `taille` INT NULL,
  PRIMARY KEY (`pId`));
  
  ALTER TABLE `bdd`.`fiche` 
CHANGE COLUMN `idfiche` `idfiche` INT(11) NOT NULL AUTO_INCREMENT ;
CHANGE COLUMN `pId` `pId` INT(11) NOT NULL ;



  CREATE TABLE `bdd`.`fiche` (
  `idfiche` INT NOT NULL,
  `pId` VARCHAR(45) NOT NULL,
  `date_rdv` DATE NOT NULL,
  `poids` INT NULL,
  `commentaire_sante` VARCHAR(400) NULL,
  `commentaire_activite` VARCHAR(400) NULL,
  `commentaire_general` VARCHAR(1200) NULL,
  PRIMARY KEY (`idfiche`));

  ALTER TABLE `bdd`.`patient` 
CHANGE COLUMN `pId` `pId` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `bdd`.`fiche` 
ADD INDEX `pId_idx` (`pId` ASC) VISIBLE;
;
ALTER TABLE `bdd`.`fiche` 
ADD CONSTRAINT `pId`
  FOREIGN KEY (`pId`)
  REFERENCES `bdd`.`patient` (`pId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
 ALTER TABLE `bdd`.`fiche` 
CHANGE COLUMN `commentaire_sante` `commentaire_sante` VARCHAR(400) NULL ,
CHANGE COLUMN `commentaire_activite` `commentaire_activite` VARCHAR(400) NULL ,
CHANGE COLUMN `commentaire_general` `commentaire_general` VARCHAR(1200) NULL ;


INSERT INTO `bdd`.`patient` (`pId`, `nom`, `prenom`, `date_naissance`, `taille`) VALUES ('1', 'Becuwe', 'Clement', '1994-06-01', '179');
INSERT INTO `bdd`.`patient` (`pId`, `nom`, `prenom`, `date_naissance`, `taille`) VALUES ('2', 'Machin', 'Truc', '1980-02-26', '169');
INSERT INTO `bdd`.`patient` (`pId`, `nom`, `prenom`, `date_naissance`, `taille`) VALUES ('3', 'Machin', 'Bidule', '1963-09-20', '191');

INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('1', '1', '2019-07-20', '97');
INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('2', '3', '2019-07-20', '116');
INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('3', '1', '2019-07-28', '98');
INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('4', '3', '2019-08-01', '114');
INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('5', '2', '2019-08-02', '80');
INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('6', '1', '2019-08-15', '95');
INSERT INTO `bdd`.`fiche` (`idfiche`, `pId`, `date_rdv`, `poids`) VALUES ('7', '2', '2019-08-20', '79');

/*
 * Selection des dernier rdv page d'acceuil
 * SELECT idfiche
, nom
, prenom
, date_rdv
 FROM bdd.fiche
 INNER JOIN (
 SELECT pId
 , MAX(date_rdv) as date_rdv
 FROM fiche group by pId
 ) as max USING (pId, date_rdv)
 join bdd.patient on bdd.patient.pId = bdd.fiche.pId
 order by date_rdv desc
 ;*/

/*
 * Selection de la page patient une fois le patient selectionné  dans la page acceuil
 * Select nom
,prenom 
,date_rdv
,poids
FROM bdd.patient 
INNER join bdd.fiche
on bdd.patient.pId = bdd.fiche.pId
where bdd.patient.pId = "1"
;*/

/*
 * Selection de la fiche suite à la sélection d'une date dans la page patient
 * Select *
FROM bdd.patient 
INNER join bdd.fiche
on bdd.patient.pId = bdd.fiche.pId
where bdd.fiche.date_rdv ="2019-07-28"
;*/
