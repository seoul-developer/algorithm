import sys
n = int(sys.stdin.readline())
lst = []

for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    lst.append((x,y))

for i in lst:
    rank = 1
    for j in lst:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1

    print(str(rank),  end = " ")