/* 197. Rising Temperature

Table: Weather

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| Id            | int     |
| RecordDate    | date    |
| Temperature   | int     |
+---------------+---------+
Id is the primary key for this table.
This table contains information about the temperature on a certain day.
 

Write an SQL query to find all dates' Id with higher temperatures compared to its previous dates (yesterday).

Return the result table in any order.

The query result format is in the following example.

 

Example 1:

Input: 
Weather table:
+----+------------+-------------+
| Id | RecordDate | Temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
Output: 
+----+
| id |
+----+
| 2  |
| 4  |
+----+
Explanation: 
In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
*/

# Write your MySQL query statement below
select 
  W1.Id as id 
from 
  Weather as W1 
  join Weather as W2 on (
    DATEDIFF(W1.recordDate, W2.recordDate) = 1 
    and W1.Temperature > W2.Temperature
  );