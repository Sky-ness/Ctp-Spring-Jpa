insert into question(libquest,active) values ('Date de la bataille de Marignan ?',false),('Quel est le président de la république actuel ?',true), ('Qui a découvert la péniciline ?',false);

insert into choix(qno,libchoix,statut) values (1,'1313',false),(1,'1414',false),(1,'1515',true),(1,'1616',false);
insert into choix(qno,libchoix,statut) values (2,'Chirac',false),(2,'Sarkozy',false),(2,'Hollande',false),(2,'Macron',true);
insert into choix(qno,libchoix,statut) values (3,'Darwin',false),(3,'Pasteur',false),(3,'Fleming',true),(3,'Watson',false);
       
	
-- select * from question natural join choix;
-- select libquest, count(*) from question natural join choix group by libquest;
-- select * from question natural join choix where statut=true;


