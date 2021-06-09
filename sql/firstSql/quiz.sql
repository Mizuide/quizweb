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

INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (1,1,"進撃の巨人クイズ",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (2,1,"進撃の巨人クイズ 中級",10,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (3,1,"ダミー",0,0.0,"study");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (4,1,"ダミー",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (5,1,"ダミー",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (6,1,"ダミー 中級",1000,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (7,1,"ダミー",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (8,1,"ダミー",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (9,1,"ダミー",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (10,1,"ダミー",0,0.0,"anime");
INSERT INTO quiz (id,create_userid,title,answerer_num,avarage_correct,category) VALUES (11,1,"ダミー",0,0.0,"other");