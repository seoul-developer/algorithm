m = int(input())
n = int(input())

lst = []

for i in range(m ,n + 1):
    for j in range(1, 101):
        if i == j**2:
            lst.append(j**2)

if len(lst) == 0:
    print(-1)
else:
    print(sum(lst))
    print(min(lst))