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

