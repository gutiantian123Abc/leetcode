/* 196. Delete Duplicate Emails
https://leetcode.com/problems/delete-duplicate-emails/

Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| Id          | int     |
| Email       | varchar |
+-------------+---------+
Id is the primary key column for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.
 

Write an SQL query to delete all the duplicate emails, keeping only one unique email with the smallest Id.

Return the result table in any order.

The query result format is in the following example.

 

Example 1:

Input: 
Person table:
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Output: 
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.

*/

-- Solution 1: Delete
# Write your MySQL query statement below
delete P1 from
Person P1, Person P2
where P1.Email = P2.Email and P1.id > P2.Id;