create table if not exists photos (
  id bigint auto_increment primary key,
  file_name varchar(255),
    content_type varchar(255),
    data blob
    );