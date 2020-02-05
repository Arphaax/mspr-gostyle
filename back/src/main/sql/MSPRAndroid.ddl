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
