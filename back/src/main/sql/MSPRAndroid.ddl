DROP TABLE IF EXISTS Used_code;
DROP TABLE IF EXISTS QRrcode;
DROP TABLE IF EXISTS Utilisateur;

CREATE TABLE QRCode (
  ID      int(10) NOT NULL AUTO_INCREMENT, 
  libelle varchar(255) NOT NULL UNIQUE, 
  montant int(10) NOT NULL UNIQUE, 
  PRIMARY KEY (ID));
CREATE TABLE Utilisateur (
  id     int(10) NOT NULL AUTO_INCREMENT, 
  nom    varchar(255) NOT NULL, 
  prenom varchar(255) NOT NULL, 
  numero int(10) NOT NULL, 
  passwd varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (id));
CREATE TABLE Used_code (
  Utilisateurid int(10) NOT NULL, 
  QRCodeID      int(10) NOT NULL);
ALTER TABLE Used_code ADD CONSTRAINT FKUsed_code401939 FOREIGN KEY (Utilisateurid) REFERENCES Utilisateur (id);
ALTER TABLE Used_code ADD CONSTRAINT FKUsed_code334991 FOREIGN KEY (QRCodeID) REFERENCES QRCode (ID);

INSERT INTO Utilisateur(nom, prenom, numero, passwd)
VALUES ('toto', 'toto', '0600000000',
        '$argon2id$v=19$m=4096,t=3,p=1$ePm52avnsQrZFF7829LtEA$fCx59lKhjS9tMrQM/HgKJRxzVMQ0TNo0WGUxipYe4Yc');

INSERT INTO QRCode(libelle, montant)
VALUES ('reduc1', 15);

INSERT INTO Used_code(Utilisateurid, QRCodeID)
VALUES (1, 1);