-- 코드를 입력하세요
with t as (SELECT 
        history_id,
        car_type,
        daily_fee * (datediff(end_date, start_date) + 1) as price,
        case when datediff(end_date, start_date) + 1 < 7 then null
            when datediff(end_date, start_date) + 1 >= 7 and datediff(end_date, start_date) + 1 < 30 then "7일 이상"
            when datediff(end_date, start_date) + 1 >= 30 and datediff(end_date, start_date) + 1 < 90 then "30일 이상"
            else "90일 이상"
        end as duration_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    left join CAR_RENTAL_COMPANY_CAR as c using(car_id)
where c.car_type = "트럭")

select
    history_id, 
    case when discount_rate is null then price
        else round(price * (1 - discount_rate/100), 0)
    end as fee
from t left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p using(car_type, duration_type)
order by fee desc, history_id desc
