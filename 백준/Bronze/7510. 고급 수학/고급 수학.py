for i in range(int(input())):
    lst = sorted(map(int, input().split()))
    if lst[0] ** 2 + lst[1] ** 2 == lst[2] ** 2:
        print(f'Scenario #{i+1}:')
        print("yes\n")

    else:
        print(f'Scenario #{i+1}:')
        print('no\n')