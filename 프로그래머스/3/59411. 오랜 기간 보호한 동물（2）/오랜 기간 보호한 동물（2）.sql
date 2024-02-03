-- 코드를 입력하세요
SELECT ai.animal_id, ai.name
from animal_ins as ai inner join animal_outs as ao
    on ai.animal_id = ao.animal_id
order by datediff(ao.datetime, ai.datetime) desc
limit 2