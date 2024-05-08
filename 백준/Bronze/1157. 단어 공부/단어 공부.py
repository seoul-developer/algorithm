S = input().upper()
used = list(set(S))
count_list = [S.count(i) for i in used]

if count_list.count(max(count_list)) > 1:
    print("?")
else:
    print(used[count_list.index(max(count_list))])