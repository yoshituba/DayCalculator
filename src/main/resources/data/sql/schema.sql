drop table if exists date_calculate_master;

create table if not exists date_calculate_master (
  id int not null auto_increment,
  date_id varchar(124) not null,
  date_name varchar(124) not null,
  year int not null,
  month int not null,
  day int not null,
  primary key (id)
);