-- 코드를 작성해주세요
with tmp as (
    select *
    from skillcodes
    where name in ('Python', 'C#') or category = 'Front End'
)

select 
    case when max(case when category = 'Front End' then 1 else 0 end) = 1
            and max(case when name = 'Python' then 1 else 0 end) = 1 then 'A'
        when max(case when name = 'C#' then 1 else 0 end) = 1 then 'B'
        when max(case when category = 'Front End' then 1 else 0 end) = 1 then 'C'
    end as grade,
    d.id, 
    d.email
from developers as d left join tmp on 1=1
where d.skill_code & tmp.code = code
group by d.id, d.email
having grade is not null
order by grade, d.id