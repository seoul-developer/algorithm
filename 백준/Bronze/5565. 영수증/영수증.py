total = int(input())

rest = []

for _ in range(9):
    a = int(input())
    rest.append(a)


print(total - sum(rest))
