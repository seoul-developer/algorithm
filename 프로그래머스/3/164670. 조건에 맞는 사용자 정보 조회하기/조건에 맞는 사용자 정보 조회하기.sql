-- 코드를 입력하세요
SELECT 
    u.user_id, 
    u.nickname, 
    concat(u.city, " ", u.street_address1, " ", u.street_address2) as '전체주소', 
    concat(left(u.tlno, 3), "-", mid(u.tlno,4,4), "-", right(u.tlno, 4)) as '전화번호'
from used_goods_board as b
    inner join used_goods_user as u on b.writer_id = u.user_id
group by u.user_id
having count(*) >= 3
order by u.user_id desc