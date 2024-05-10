import sys
k = int(sys.stdin.readline())

for i in range(k):
    lst = list(map(int, sys.stdin.readline().split()))
    del lst[0]
    lst.sort()
    print("Class", i+1)
    diff = []
    for i in range(len(lst) - 1):
        diff.append(lst[i+1] - lst[i])
    print('Max', str(max(lst)) + ',', 'Min', str(min(lst)) + ',' , 'Largest gap', str(max(diff)))

