n = input()
f = int(input())

number = int(n[:-2] + '00')

while True:
    if number % f == 0:
        break
    else:
        number += 1

print(str(number)[-2:])

