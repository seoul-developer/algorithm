x, y, w, h = map(int, input().split())

gap_x = w - x
gap_y = h - y

values = []

if gap_x < x:
    values.append(gap_x)
else:
    values.append(x)

if gap_y < y:
    values.append(gap_y)
else:
    values.append(y)

print(min(values))