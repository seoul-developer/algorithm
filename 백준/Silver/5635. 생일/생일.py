import sys
n = int(sys.stdin.readline())

lst = []

for _ in range(n):
    l, d, m, y = input().rstrip().split()
    d, m, y = map(int, (d, m, y))
    lst.append((y, m, d, l))

lst.sort()

print(lst[-1][3])
print(lst[0][3])