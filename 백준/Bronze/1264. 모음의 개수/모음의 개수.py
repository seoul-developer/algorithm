while True:
    s = input()
    if s == '#':
        break

    count = 0

    for letter in s:
        if letter in 'aeiouAEIOU':
            count += 1
    print(count)