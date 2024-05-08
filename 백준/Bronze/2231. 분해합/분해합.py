n = int(input())
result = 0

for i in range (1, n + 1):
    n_list = list(map(int, str(i)))
    s = i + sum(n_list)
    if n == s:
        result = i
        break


print(result)


