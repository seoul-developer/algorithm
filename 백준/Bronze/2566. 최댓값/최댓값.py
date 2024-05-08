max_list = []
lists = []

for _ in range(9):
    a = list(map(int, input().split()))
    lists.append(a)
    max_list.append(max(a))

max_val = max(max_list)
max_row = max_list.index(max_val)

lists_column = lists[max_row]
max_column = lists_column.index(max_val)


print(max_val)
print(max_row + 1, max_column + 1)