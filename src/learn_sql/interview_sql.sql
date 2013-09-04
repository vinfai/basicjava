-- Question 1:
/* 
现在有三个表student,score,course 
对应的建表语句如下： 
CREATE TABLE student( 
student_id NUMBER PRIMARY KEY, 
student_name,VARCHAR2(30) NOT NULL) 

CREATE TABLE score( 
score_id NUMBER PRIMARY KEY, 
student_id NUMBER, 
course_id NUMBER, 
score NUMBER) 

CREATE TABLE course( 
course_id NUMBER PRIMARY KEY, 
course_name VARCHAR2(30)) 

要求用基本SQL实现如下的两条查询要求： 
(1) 求出每门课程成绩排名前五名的同学的姓名，分数和课程名 
(2)求出每门课程成绩排名第三的同学的姓名，分数和课程名 
*/

--PS: 考察分组、计算取前几个或者第几个的问题;
--reference SQL BOOK :Recipe 11.9. Ranking Results
--(1):
-- A: MySQL:
select st.student_name,cs.course_name,t.score from student st,course cs ,
 (
  select * from score a where 
	(SELECT COUNT(1) from score b where b.course_id = a.course_id and b.score>=a.score)<=5
 	 order by a.course_id,a.score desc
 ) t where st.student_id = t.student_id and cs.course_id = t.course_id ;

-- ORACLE 

select st.student_name,cs.course_name,t.score from student st,course cs ,
(
  select * from (
  select a.* ,(rank() over(partition by a.course_id order by a.score desc)) rank
  from score a
  ) where rank<=5

) t where st.student_id = t.student_id and cs.course_id = t.course_id order by t.course_id ,t.score desc;

 --(2):  把<=5 改为 =3





-- Question 2:
/*
有两个表, t1, t2,
Table t1:
SELLER | NON_SELLER
----- -----
A B
A C
A D
B A
B C
B D
C A
C B
C D
D A
D B
D C


Table t2:
SELLER | COUPON | BAL
----- --------- ---------
A 9 100
B 9 200
C 9 300
D 9 400
A 9.5 100
B 9.5 20
A 10 80



要求用SELECT 语句列出如下结果:------如A的SUM(BAL)为B,C,D的和,B的SUM(BAL)为A,C,D的和.......
且用的方法不要增加数据库负担,如用临时表等.

NON-SELLER| COUPON | SUM(BAL) ------- --------
A 9 900
B 9 800
C 9 700
D 9 600 
A 9.5 20
B 9.5 100
C 9.5 120
D 9.5 120
A 10 0
B 10 80
C 10 80
D 10 80

*/
--PS: 结果要求按 NON-SELLER,COUPON分组 求和;
select t.seller,t.coupon,nvl((select sum(a.bal) from table2 a where a.seller in (select a1.non_seller from table1 a1 where a1.seller = t.seller)
 and a.coupon = t.coupon),0) from  --sum :根据分组信息，查询每个分组的和值 
 -- 获得所有分组信息
(select t1.seller,t2.coupon from table1 t1,table2 t2 group by t1.seller,t2.coupon) t;

--方式2：
select non_seller,coupon,sum([sum(BAL)])as [sum(BAL)] from
(
	select 
	*
	from 
	(
		select t1.non_seller,t2.coupon as coupon,sum(BAL) as [sum(BAL)] from t1  join t2 on T1.SELLER=t2.SELLER group by non_seller,coupon
		)x
		union
		select seller,coupon,0 from t2
	) y
group by non_seller,coupon


