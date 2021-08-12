CREATE DATABASE CAROUSER
USE CAROUSER
CREATE TABLE USERCARO
(
USERNAME VARCHAR(20)  NOT NULL PRIMARY KEY,--username
PASS VARCHAR(20) NOT NULL,--password
TENNGUOICHOI NVARCHAR(50),--name of player
SOLANCHOI INT DEFAULT(0), --times played
SOLANTHANG INT DEFAULT(0) --times win game
)
--default account
insert into usercaro VALUES
('test1','1123456','Nguoi choi 1',10,10),
('test2','1123456','Nguoi choi 2',100,10),
('test3','1123456','Nguoi choi 3',10,0);
