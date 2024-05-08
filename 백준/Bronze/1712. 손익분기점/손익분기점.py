fixed, b, c = map(int, input().split())
break_point = 0

while True:
    if c - b <= 0:
        print(-1)
        break
    else:
        num = (fixed/(c - b))
        print(int(num) + 1)
        break
