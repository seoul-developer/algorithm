n = int(input())

for _ in range(n):
    ox_list = list(input())
    score = 0
    final = 0

    for ox in ox_list:
        if ox == "O":
            score = score + 1
            final = final + score
        else:
            score = 0
    print(final)