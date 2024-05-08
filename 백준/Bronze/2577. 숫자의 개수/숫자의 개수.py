a = int(input())
b = int(input())
c = int(input())

num = a * b * c

lst = list(map(int, str(num)))

for i in range(0, 10):
    print(lst.count(i))