-- 코드를 작성해주세요
with tmp as (
    select *
    from skillcodes
    where category = "Front End"
)

select distinct id, email, first_name, last_name
from developers as d
    inner join tmp on d.skill_code & tmp.code
order by id