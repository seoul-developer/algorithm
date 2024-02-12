-- 코드를 입력하세요
with t as (
    select car_id, 1 as dy
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where (start_date <= "2022-11-30" and end_date >= "2022-11-01")
    group by car_id
), t2 as (
    select car_id, daily_fee * (1-(discount_rate/100)) * 30 as fee
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN inner join CAR_RENTAL_COMPANY_CAR using(car_type)
    where duration_type = "30일 이상" and car_type in ('세단', 'SUV')
)

    
SELECT car_id, car_type, truncate(fee, 0) as fee
from CAR_RENTAL_COMPANY_CAR as c 
    left join t using(car_id)
    left join t2 using(car_id)
where car_type in ('세단', 'SUV')
    and dy is null
    and fee >= 500000 and fee < 2000000
order by fee desc, car_type, car_id desc
