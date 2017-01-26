CREATE TABLE persona

(persona_id int not null,
  first_name varchar(255) not null,
  sur_name varchar(255) not null,
  patronymic varchar(255) not null,
  date_of_birth date not null,
  sex char(1),
  auto_id int,
  primary key (persona_id)
)

insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (1, 'Вахтанг', 'Берзоев', 'Аркадьевич', '1978-01-01', 'M', 1);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (2, 'Александр', 'Хоботов', 'Аркадьевич', '1978-01-01', 'M', 1);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (3, 'Василий', 'Слонидзе', 'Аркадьевич', '1978-01-01', 'M', 3);
insert into persona(persona_id, first_name, sur_name, patronymic,  ddate_of_birth, sex, auto_id)
values (4, 'Иван', 'Чичваркин', 'Аркадьевич', '1978-01-01', 'M', 5);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (5, 'Семён', 'Арбузов', 'Аркадьевич', '1978-01-01', 'M', 6);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (6, 'Алексей', 'Слепаков', 'Аркадьевич', '1978-01-01', 'M', 4);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (7, 'Сергей', 'Масляков', 'Аркадьевич', '1978-01-01', 'M', 3);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (8, 'Станислав', 'Гущин', 'Аркадьевич', '1978-01-01', 'M', 7);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (9, 'Глеб', 'Пушкин', 'Аркадьевич', '1978-01-01', 'M', 3);
insert into persona(persona_id, first_name, sur_name, patronymic,  date_of_birth, sex, auto_id)
values (10, 'Игорь', 'Есенин', 'Аркадьевич', '1978-01-01', 'M', 5);