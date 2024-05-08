lst = []

for _ in range(1, 6):
    a, b, c, d = map(int, input().split())
    lst.append(a + b + c + d)

ptc_num = lst.index(max(lst)) + 1

print(ptc_num, max(lst))
