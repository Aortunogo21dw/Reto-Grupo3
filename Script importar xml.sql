





LOAD XML INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml' INTO TABLE camion ROWS IDENTIFIED BY '<camion>' ;


LOAD XML INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml' IGNORE INTO TABLE coche ROWS IDENTIFIED BY '<coche>';



LOAD XML INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filecamion2.xml'IGNORE INTO TABLE serie ROWS IDENTIFIED BY '<tablaserie>';



-- Esto lo entregamos ya que probamos para importar también con sql y nos gustaría dejar constancia de que lo probamos.













