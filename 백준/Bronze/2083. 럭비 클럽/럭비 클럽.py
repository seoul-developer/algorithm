name, age, weight = 'None', 0, 0
while True:
    name, age, weight = input().split()

    if int(age) > 17 or int(weight) >= 80:
        print(name, 'Senior')
    elif int(age) == 0 and int(weight) == 0 and name == '#':
        break
    else:
        print(name, 'Junior') 