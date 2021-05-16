CREATE TABLE quiz (id BIGINT PRIMARY KEY,
create_userid BIGINT,
title varchar(100),
description varchar(300),
thubnail varchar(300),
answerer_num int,
avarage_correct float,
category varchar(1000),
tag varchar(100)
);

INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (1,1,"進撃の巨人クイズ",0,0.0,"comic");