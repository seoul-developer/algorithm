water = list(map(int, input().split()))

mid = sum(water) - max(water) - min(water)

print(min(water), mid, max(water))



