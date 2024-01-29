-- 코드를 입력하세요
SELECT ingredient_type, sum(fh.total_order) as total_order
from first_half as fh inner join icecream_info as ii on fh.flavor = ii.flavor
group by ingredient_type
order by total_order
