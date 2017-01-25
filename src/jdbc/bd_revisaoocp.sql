create database revisaoocp;
use revisaoocp;
create table pessoa(
    name character varying(100),
    age int
);
insert into pessoa (name,age) values("paulo",23);
insert into pessoa (name,age) values("luciana",20);
insert into pessoa (name,age) values("isaac",22);
insert into pessoa (name,age) values("rafaela",22);

--stored procedure
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtemPorRangeID`(OUT total int,IN inicio int,IN fim int)
BEGIN
	set total = (select count(*) from person);
	select * from person where id between inicio and fim;
	
END