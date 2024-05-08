lst = []

for i in range(1, 6):
    name = input()
    if 'FBI' in name:
        lst.append(i)
    
if len(lst) == 0:
    print('HE GOT AWAY!')
else:
    print(*lst)