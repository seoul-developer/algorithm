-- 코드를 작성해주세요
with tmp as (
    select *
    from skillcodes
    where category = "Front End"
)

select distinct id, email, first_name, last_name
from developers as d
    left join tmp on 1=1
where d.skill_code & tmp.code = tmp.code
order by id