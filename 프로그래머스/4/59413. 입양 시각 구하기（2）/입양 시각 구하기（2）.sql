-- 코드를 입력하세요
with recursive t as (
    select 0 as hour
    union all
    select hour + 1 from t where hour < 23
)

SELECT hour, count(animal_id) as count
from t left join animal_outs as o on t.hour = hour(o.datetime)
group by hour
order by hour;
