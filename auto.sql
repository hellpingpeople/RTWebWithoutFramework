CREATE TABLE auto

(aut_id int not null,
  first_name varchar(255) not null,
  sur_name varchar(255) not null,
  patronymic varchar(255) not null,
  date_of_birth date not null,
  sex char(1),
  primary key (persona_id)
)

insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (1, 'Вахтанг', 'Берзоев', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (2, 'Александр', 'Хоботов', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (3, 'Василий', 'Слонидзе', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (4, 'Иван', 'Чичваркин', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (5, 'Семён', 'Арбузов', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (6, 'Алексей', 'Слепаков', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (7, 'Сергей', 'Масляков', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (8, 'Станислав', 'Гущин', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (9, 'Глеб', 'Пушкин', 'Аркадьевич', '1978-01-01', 'M');
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex)
values (10, 'Игорь', 'Есенин', 'Аркадьевич', '1978-01-01', 'M');