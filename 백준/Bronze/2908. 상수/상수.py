a, b = map(int, input().split())

A = str(a) [::-1]
B = str(b) [::-1]

print(max([int(A), int(B)]))

