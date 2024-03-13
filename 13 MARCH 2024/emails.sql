WITH Activity_count as 
(
SELECT activity,count(*) as num from friends
group by activity
)
SELECT activity from Activity_count
where num not in(SELECT max(num) from Activity_count 
union
SELECT min(num) from Activity_count)