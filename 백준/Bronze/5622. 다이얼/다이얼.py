arr = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
str = input()
time = 0

for j in range(len(str)):
    for i in arr:
        if str[j] in i:
            time += arr.index(i) + 3

print(time)