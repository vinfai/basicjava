
--Question 2:

create table table1(
   SELLER VARCHAR2(20),
   NON_SELLER VARCHAR2(20)
);

create table table2(
   seller varchar2(20),
   coupon float,
   bal NUMBER
);
DROP TABLE table2;
UPDATE table2 SET BAL = BAL2 ;
COMMIT;
ALTER TABLE TABLE2 ADD BAL2 NUMBER;
ALTER TABLE TABLE2 DROP COLUMN BAL2;

insert into table1 values('A','B');
insert into table1 values('A','C');
insert into table1 values('A','D');
insert into table1 values('B','A');
insert into table1 values('B','C');
insert into table1 values('B','D');
insert into table1 values('C','A');
insert into table1 values('C','B');
insert into table1 values('C','D');

insert into table1 values('D','A');
insert into table1 values('D','B');
insert into table1 values('D','C');
COMMIT;

INSERT INTO TABLE2 VALUES('A',9,100);
INSERT INTO TABLE2 VALUES('B',9,200);
INSERT INTO TABLE2 VALUES('C',9,300);
INSERT INTO TABLE2 VALUES('D',9,400);
INSERT INTO TABLE2 VALUES('A',9.5,100);
INSERT INTO TABLE2 VALUES('B',9.5,20);
INSERT INTO TABLE2 VALUES('A',10,80);
COMMIT;

