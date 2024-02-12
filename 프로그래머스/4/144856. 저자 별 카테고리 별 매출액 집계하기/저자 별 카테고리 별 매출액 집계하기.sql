-- 코드를 입력하세요
SELECT author_id, author_name, category, sum(sales * price) as total_sales
from book_sales as bs
    left join book as b using(book_id)
    left join author as a using(author_id)
where sales_date like "2022-01%"
group by author_id, category
order by author_id, category desc
    