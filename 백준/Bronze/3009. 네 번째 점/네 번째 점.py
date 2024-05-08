x_lst = []
y_lst = []

for _ in range(3):
    x, y = map(int, input().split())
    x_lst.append(x)
    y_lst.append(y)

for i in x_lst:
    if x_lst.count(i) == 1:
        x_dot = i

for j in y_lst:
    if y_lst.count(j) == 1:
        y_dot = j


print(x_dot, y_dot)