import sys
a, b = map(int, sys.stdin.readline().split())
lst = []

for i in range(1, b+1):
    for j in range(i):
        lst.append(i)

sum_lst = sum(lst[a- 1 : b])
print(sum_lst)