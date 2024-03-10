-- 코드를 작성해주세요
with tmp as (
    select code
    from skillcodes
    where name = "Python" or name = "C#"
)

select distinct id, email, first_name, last_name
from developers as d left join tmp on 1=1
where skill_code & code = code 
order by id