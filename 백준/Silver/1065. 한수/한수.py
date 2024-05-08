N = int(input())
hans = 0

for i in range(1, N+1):
    hans_list = list(map(int, str(i)))
    if i < 100:
        hans = hans + 1
    elif hans_list[0] - hans_list[1] == hans_list[1] - hans_list[2]:
        hans = hans + 1



print(hans)
