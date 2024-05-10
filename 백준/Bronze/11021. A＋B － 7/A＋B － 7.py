T = int(input())

sum = 0
for i in range(1, T+1):
    a, b = map(int, input().split())
    sum = a + b

    print("Case #" + str(i) + ":", sum) 