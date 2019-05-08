-- Notes for lecture
Select * from film where title = 'Return of the Jedi';

Select count(*) from film; -- and then named
select count(*) as counter from film;

Select * from film where title = 'R%'; -- not going to work
Select * from film where title like 'R%';
Select * from film where popularity like '2_';

select film.year, film.title, actor.actor_name, actress.actress_name, director.director_name from film, actor, actress, director 
    where film.actor_id = actor.actor_id and film.actress_id = actress.actress_id and director.director_id = film.director_id and title = 'Dead Zone';
    
select film.year, film.title, actor.actor_name, actress.actress_name, director.director_name, film.director_id from film, actor, actress, director 
    where film.actor_id = actor.actor_id and film.actress_id = actress.actress_id and director.director_id = film.director_id and title = 'Return of the Jedi';
    
update director set director_name = 'Lucas, George' where director_id == 731;
    
-- SELECT [field names] FROM [table names] WHERE [conditions or expresions] LIMIT [max number of record] OFFSET [from record] ORDER BY [field name] ASC/DESC
--    Also allows certain funtions, embedded select statements, logic operators, and a whole lot more
