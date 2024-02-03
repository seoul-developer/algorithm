-- 코드를 입력하세요
SELECT rest_info.food_type, rest_info.rest_id, rest_info.rest_name, rest_info.favorites
from rest_info 
    inner join (select food_type, max(favorites) as max_favorites from rest_info group by food_type) as j 
        on rest_info.food_type = j.food_type 
            and rest_info.favorites = j.max_favorites
group by rest_info.food_type
order by rest_info.food_type desc