-- 코드를 입력하세요
SELECT ap.apnt_no, ap.pt_name, ap.pt_no, ap.mcdp_cd, d.dr_name, ap.apnt_ymd
from (
    select a.apnt_no, p.pt_name, a.pt_no, a.mcdp_cd, a.apnt_ymd, a.mddr_id
    from appointment as a inner join patient as p on a.pt_no = p.pt_no 
    where date_format(a.apnt_ymd, "%Y-%m-%d") = '2022-04-13' and a.apnt_cncl_ymd is null and a.mcdp_cd = "CS") as ap
    inner join doctor as d on ap.mddr_id = d.dr_id
order by ap.apnt_ymd
