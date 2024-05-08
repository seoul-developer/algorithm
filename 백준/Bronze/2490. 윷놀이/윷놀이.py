rst = []

for _ in range(3):
    a = list(map(int, input().split()))
    cal_one = a.count(1)
    cal_zero = a.count(0)

    if cal_zero == 1:
        rst.append('A')
    elif cal_zero == 2:
        rst.append('B')
    elif cal_zero == 3:
        rst.append('C')
    elif cal_zero == 4:
        rst.append('D')
    elif cal_one == 4:
        rst.append('E')

for i in range(len(rst)):
    print(rst[i])