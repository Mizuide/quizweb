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