-- 코드를 입력하세요
SELECT 
    agb.title, 
    agb.board_id, 
    agr.reply_id, 
    agr.writer_id, 
    agr.contents, 
    date_format(agr.created_date, '%Y-%m-%d') as created_date
from used_goods_board as agb
inner join used_goods_reply as agr
    on agb.board_id = agr.board_id
where agb.created_date like '2022-10-%'
order by agr.created_date, agb.title