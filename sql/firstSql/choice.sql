CREATE TABLE choice (id BIGINT PRIMARY KEY,
question_id BIGINT,
selection_no INT,
content TEXT,
correct_flg BOOLEAN);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (1,1,1,"10m",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (2,1,2,"60m",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (3,1,3,"16m",True);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (4,1,4,"23m",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (5,2,1,"赤",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (6,2,2,"黒",True);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (7,2,3,"紫",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (8,3,1,"答え",True);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (9,3,2,"不正解",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (10,3,3,"不正解",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (11,3,4,"不正解",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (12,4,1,"クレバー",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (13,4,2,"クサバー",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (14,4,3,"クレヴァー",False);
INSERT INTO choice (id,question_Id,selection_no,content,correct_flg) VALUES (15,4,4,"クサヴァー",True);