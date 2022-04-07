





LOAD XML INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml' INTO TABLE camion ROWS IDENTIFIED BY '<camion>' ;


LOAD XML INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml' IGNORE INTO TABLE coche ROWS IDENTIFIED BY '<coche>';

LOAD XML INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml'IGNORE INTO TABLE serie ROWS IDENTIFIED BY '<tablaserie>';





drop trigger coso;



ALTER TABLE serie 
ADD UNIQUE KEY (`añoFabricacion` , `modelo`,`marca`) ;









select * from camion;
select * from coche;





SET FOREIGN_KEY_CHECKS = 0;


truncate table camion;
truncate table serie;
truncate table coche;