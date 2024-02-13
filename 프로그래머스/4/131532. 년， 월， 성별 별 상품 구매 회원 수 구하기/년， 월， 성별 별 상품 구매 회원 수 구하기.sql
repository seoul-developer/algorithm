-- 코드를 입력하세요
SELECT year(sales_date) as year, month(sales_date) as month, gender, count(distinct s.user_id) as users
from online_sale as s left join user_info as i on s.user_id = i.user_id
where i.gender is not null
group by year(sales_date), month(sales_date), gender
order by year(sales_date), month(sales_date), gender