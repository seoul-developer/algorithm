a, b = map(int, input().split())
max_val = []
min_val = 0

for i in range(1, min(a,b) + 1):
    if a % i == 0 and b % i == 0:
        max_val.append(i)

for i in range(max(a, b), (a*b) + 1):
    if i % a == 0 and i % b == 0:
        min_val = i
        break

print(max(max_val))
print(min_val)
