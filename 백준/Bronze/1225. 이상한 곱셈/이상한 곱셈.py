import sys

a = list(map(int, sys.stdin.readline().split()))
first = [int(k) for k in str(a[0])]
second = [int(k) for k in str(a[1])]

tot = 0

for i in range(len(first)):
    for j in range(len(second)):
        tot += first[i] * second[j]

print(tot)