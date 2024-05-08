n = int(input())

stars = n

while True:
    print('*' * stars)
    stars -= 1
    if stars == 0:
        break


