a = list(map(int, input().split()))

front = a[1] - a[0] - 1
end = a[2] - a[1] - 1

if front > end:
    print(front)
elif front < end:
    print(end)
else:
    print(front)