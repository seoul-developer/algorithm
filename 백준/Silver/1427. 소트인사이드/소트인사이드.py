import sys
n = int(sys.stdin.readline())

lst = [int(a) for a in str(n)]
lst.sort()
num = 0

for i in range(len(lst)):
    num += lst[i] * (10 ** i)

print(num)

