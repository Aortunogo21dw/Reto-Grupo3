


delimiter $$

create trigger insertar1 after insert on coche
for each row
begin
insert into historial (numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo)
values(new.numBastidor,new.matricula,new.color,new.numAsientos,new.numserie,new.precio,curdate(),'Compra','Coche');
END$$

delimiter ;

--

delimiter $$

create trigger insertar2 after insert on camion
for each row
begin
insert into historial (numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo)
values(new.numBastidor,new.matricula,new.color,new.numAsientos,new.numserie,new.precio,curdate(),'Compra','Camión');
END$$

delimiter ;

--

select * from historial;
truncate table historial;




delimiter $$

create trigger update1 after update on camion
for each row
begin
insert into historial (numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo)
values(old.numBastidor,new.matricula,new.color,new.numAsientos,new.numserie,new.precio,curdate(),'Modificacion','Camión');
END$$

delimiter ;

--


delimiter $$

create trigger update2 after update on coche
for each row
begin
insert into historial (numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo)
values(old.numBastidor,new.matricula,new.color,new.numAsientos,old.numserie,new.precio,curdate(),'Modificacion','Coche');
END$$

delimiter ;


--



delimiter $$

create trigger delete1 after delete on coche
for each row
begin
insert into historial (numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo)
values(old.numBastidor,old.matricula,old.color,old.numAsientos,old.numserie,old.precio,curdate(),'Vender','Coche');
END$$

delimiter ;


delimiter $$

create trigger delete2 after delete on camion
for each row
begin
insert into historial (numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo)
values(old.numBastidor,old.matricula,old.color,old.numAsientos,old.numserie,old.precio,curdate(),'Vender','Camion');
END$$

delimiter ;



drop trigger update1;
drop trigger update2;
drop trigger ai_data1;
truncate table camion;
truncate table coche;


select * from historial
group by numBastidor;

truncate table serie;
select * from coche  ;





delimiter //
create procedure colorCamion(in var varchar(20))
Begin
select camion.*,serie.modelo,serie.marca,serie.añoFabricacion from camion  inner join serie where camion.numSerie = serie.numSerie and camion.color = var;
end;
//

delimiter //
create procedure colorCoche(in var varchar(20))
Begin
select coche.*,serie.modelo,serie.marca,serie.añoFabricacion from coche inner join serie where coche.numSerie = serie.numSerie and coche.color = var;
end;
//

drop procedure colorCamion;
drop procedure colorCoche;

 


select * from camion;
select * from coche;
select * from serie;
select * from historial;
SET FOREIGN_KEY_CHECKS = 0;
truncate table historial;
truncate table serie;
truncate table coche;
truncate table camion;





select camion.*,serie.modelo,serie.marca,serie.añoFabricacion from camion  inner join serie where camion.numSerie = serie.numSerie;
select coche.*,serie.modelo,serie.marca,serie.añoFabricacion from coche inner join serie where coche.numSerie = serie.numSerie;













