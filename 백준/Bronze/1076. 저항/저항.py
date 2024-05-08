color1 = input()
color2 = input()
color3 = input()

dict = {'black':0, 'brown':1, 'red':2,
'orange':3, 'yellow':4, 'green':5,
'blue':6, 'violet':7, 'grey':8, 'white':9}

resist = ((dict[color1] * 10) + dict[color2]) * (10**(dict[color3]))

print(resist)