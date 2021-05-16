CREATE TABLE question (id BIGINT PRIMARY KEY,
quiz_id BIGINT,
num int,
name varchar(1000),
content text);
INSERT INTO question (id,quiz_id,num,content) VALUES (1,1,1,"エレンが巨人になった時の身長は何m？");
INSERT INTO question (id,quiz_id,num,content) VALUES (2,1,2,"ミカサの巻いているマフラーの色は？");