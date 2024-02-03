-- 코드를 입력하세요
SELECT c.car_id
from car_rental_company_car as c
    inner join car_rental_company_rental_history as rh
        on c.car_id = rh.car_id
where c.car_type = "세단" and rh.start_date like "2022-10%"
group by c.car_id
order by c.car_id desc