CREATE TABLE quiz (id BIGINT AUTO_INCREMENT PRIMARY KEY,
create_userid BIGINT,
title varchar(100),
description varchar(300),
thubnail varchar(300),
answerer_num int,
avarage_correct float,
category varchar(1000),
tag varchar(100)
) AUTO_INCREMENT = 20;
