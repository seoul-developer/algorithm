n = int(input())
num = []

for i in range(n + 1):
    if i == 0:
        num.append(0)
    elif i == 1:
        num.append(1)
    else:
        num.append(num[i-1] + num[i-2])

print(num[n])