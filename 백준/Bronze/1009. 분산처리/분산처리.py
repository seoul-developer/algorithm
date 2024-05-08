import sys
t = int(sys.stdin.readline())

for _ in range(t):
    a, b = map(int, input().split())
    rest_a = a % 10

    if rest_a == 0:
        print(10)
    
    elif rest_a in [1, 5, 6]:
        print(rest_a)
    
    elif rest_a in [4, 9]:
        rest_b = b % 2
        if rest_b == 0:
            print((rest_a**2) % 10)
        else:
            print(rest_a)
    
    elif rest_a in [2, 3, 7, 8]:
        rest_b = b % 4
        if rest_b == 0:
            print((rest_a**4) % 10)
        else:
            print((rest_a**rest_b) % 10)