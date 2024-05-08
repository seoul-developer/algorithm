word = input()
cr_alph = ["c=", 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']


for i in cr_alph:
    word = word.replace(i, "*")
    
print(len(word))