m = int(input())
n = int(input())
sosu = []

for i in range(m, n + 1):
    error = 0
    if i > 1:
        for j in range(2, i):
            if i % j == 0:
                error += 1
                break

        if error == 0:     
            sosu.append(i)


if len(sosu) == 0:
    print(-1)
else:
    print(sum(sosu))
    print(min(sosu))

    
