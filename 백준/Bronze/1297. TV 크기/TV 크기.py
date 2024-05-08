import math

d, h, w = map(int, input().split())

rate = (d / (math.sqrt(w**2 + h**2)))

print(math.trunc(h * rate), math.trunc(w * rate))