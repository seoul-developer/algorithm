-- 코드를 입력하세요
SELECT 
    year(sales_date) as year, 
    month(sales_date) as month,
    count(distinct user_id) as puchased_users,
    round(count(distinct user_id) / (select count(distinct user_id) from user_info where joined like "2021%"), 1) as puchased_ratio
from user_info as ui right join online_sale as os using(user_id)
where joined like "2021%"
group by year(sales_date), month(sales_date)
order by year, month