natural_num = set(range(1, 10001))
made_num = set()

for i in list(natural_num):
    for j in str(i):
        i = i + int(j)
    made_num.add(i)

self_num = sorted(natural_num - made_num)

for i in self_num:
    print(i)