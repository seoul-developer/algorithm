num = int(input())
lst = []

for _ in range(num):
    name = str(input())
    lst.append(name)

for i in range(1, num+1):
    print(str(i) + '. ' + lst[i-1])