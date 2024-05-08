import sys
a, b = map(int, sys.stdin.readline().split())
max_val = max(a, b)
min_val = min(a, b)
print(int(((max_val * (max_val + 1)) // 2) - ((min_val * (min_val - 1)) // 2)))