-- 코드를 작성해주세요
select total_score as score, e.emp_no, emp_name, position, email
from hr_employees as e
    join (
        select
            emp_no, 
            sum(score) as total_score, 
            dense_rank() over(order by sum(score) desc) as ranking 
        from hr_grade group by emp_no
    ) as tmp 
    on e.emp_no = tmp.emp_no
where ranking = 1