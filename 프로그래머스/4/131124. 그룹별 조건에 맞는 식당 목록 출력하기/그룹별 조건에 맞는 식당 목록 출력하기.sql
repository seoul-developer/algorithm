-- 코드를 입력하세요
SELECT member_name, review_text, date_format(review_date, "%Y-%m-%d") as review_date
from rest_review left join member_profile using(member_id)
where member_id in (select member_id from (
        select member_id, count(*)
        from rest_review left join member_profile using(member_id)
        group by member_id
        order by count(*) desc
        limit 1
    ) as s1)
order by review_date, review_text