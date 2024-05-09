import sys
n = int(sys.stdin.readline())
num = dict()

for i in range(n):
    x, y = map(str, sys.stdin.readline().split())

    if y == 'enter':
        num[x] = y
    else:
        del num[x]


num = sorted(num.keys(), reverse = True)

for i in num:
    print(i)