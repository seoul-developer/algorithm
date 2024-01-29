-- 코드를 입력하세요
SELECT product_code, sum(os.sales_amount * product.price) as sales 
from product inner join offline_sale as os on product.product_id = os.product_id
group by product_code
order by sales desc, product_code
