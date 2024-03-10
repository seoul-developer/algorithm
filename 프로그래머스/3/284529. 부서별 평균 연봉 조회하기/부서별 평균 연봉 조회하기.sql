-- 코드를 작성해주세요
select dept_id, dept_name_en, round(avg(sal), 0) as avg_sal
from hr_department as d
    join hr_employees as e using(dept_id)
group by dept_id
order by avg_sal desc