n = int(input())

lst = []

for i in range(1, n + 1):
    if i == 1:
        lst.append(5)
    else:
        lst.append(3*i + 1)

print(sum(lst) % 45678)