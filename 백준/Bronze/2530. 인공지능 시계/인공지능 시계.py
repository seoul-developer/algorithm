a, b, c = map(int, input().split())
d = int(input())

sec = c + (d % 60)
min = b + (d // 60)

while sec >= 60:
    min += 1
    sec -= 60
    if sec < 60:
        break

while min >= 60:
    a += 1
    min -= 60
    if min < 60:
        break

while a >= 24:
    a -= 24
    if a < 24:
        break

print(a, min, sec)