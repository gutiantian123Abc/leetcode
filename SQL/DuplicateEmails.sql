/* 182. Duplicate Emails
SQL Schema
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| Id          | int     |
| Email       | varchar |
+-------------+---------+
Id is the primary key column for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.
 

Write an SQL query to report all the duplicate emails.

Return the result table in any order.

The query result format is in the following example.

 

Example 1:

Input: 
Person table:
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
Output: 
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Explanation: a@b.com is repeated two times.

*/

-- Solution 1: Using GROUP BY and a temporary table
# Write your MySQL query statement below

select Email
from 
(
    select Email, count(Email) as num
    from Person
    group by Email
) as Temp
where num > 1;



-- Solution 2: Using GROUP BY and HAVING condition
# Write your MySQL query statement below

select Email
from Person
group by Email
having count(Email) > 1;

